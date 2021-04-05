package kr.co.mk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.mk.dao.AdminDAO;
import kr.co.mk.utils.UploadFileUtils;
import kr.co.mk.vo.CategoryVo;
import kr.co.mk.vo.GoodsViewVo;
import kr.co.mk.vo.GoodsVo;
import net.sf.json.JSONArray;
import net.webjjang.util.PageObject;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
//	private final String MODULE  = "admin";
	
	@Autowired
	public SqlSession sqlSession;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping("/index")
	public String index() {
		
		return "/admin/index";
	}
	
	@RequestMapping("/goods/list")
	public String list(Model model,PageObject pageObject) {
		AdminDAO dao = sqlSession.getMapper(AdminDAO.class);
		pageObject.setTotalRow(dao.getRow(pageObject));
		List<GoodsViewVo> list = dao.goodsList(pageObject);
		model.addAttribute("pageObject",pageObject);
		System.out.println(pageObject);
		System.out.println(list);
		model.addAttribute("list",list);
		return "/admin/goods/list";
	}
	
	@RequestMapping("/goods/view")
	public String view(int no,Model model) {
		AdminDAO dao = sqlSession.getMapper(AdminDAO.class);
		GoodsViewVo vo = dao.goodsView(no);
		model.addAttribute("vo",vo);
		return "/admin/goods/view";
	}
	
	// 상품등록
	@RequestMapping("/goods/register")
	public String goodsRegister(Model model) {
		
		AdminDAO dao = sqlSession.getMapper(AdminDAO.class);
		List<CategoryVo> category = null;
		category = dao.category();
		model.addAttribute("category",JSONArray.fromObject(category));
		return "/admin/goods/register";
	}
	// 상품등록 mapper
	@RequestMapping("/goods/register_ok")
	public String goodsRegister_ok(GoodsVo vo,MultipartFile file) throws IOException, Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		 vo.setGdsImg("/resources"+File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		 vo.setGdsThumbImg("/resources"+File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		   vo.setGdsImg(fileName);
		   vo.setGdsThumbImg(fileName);
		}
		
		
		
		//--------------------------------------------------------
		AdminDAO dao = sqlSession.getMapper(AdminDAO.class);
		dao.register(vo);
		
		return "redirect:/admin/goods/list?ch=1";
	}
	
	@RequestMapping("/goods/update")
	public String update(int no, Model model) {
		
		AdminDAO dao = sqlSession.getMapper(AdminDAO.class);
		GoodsViewVo goods = dao.goodsView(no);
		model.addAttribute("goods",goods);
		System.out.println(goods);
		
		List<CategoryVo> category = null;
		category = dao.category();
		model.addAttribute("category",JSONArray.fromObject(category));
		return "/admin/goods/update";
	}
	
	@RequestMapping("/goods/update_ok")
	public String update_ok(GoodsVo vo,MultipartFile file,HttpServletRequest req) throws IOException, Exception {
		AdminDAO dao = sqlSession.getMapper(AdminDAO.class);
		
		 // 새로운 파일이 등록되었는지 확인
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 기존 파일을 삭제
		  new File(uploadPath + req.getParameter("gdsImg")).delete();
		  new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
		  
		  // 새로 첨부한 파일을 등록
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  vo.setGdsImg("/resources"+File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  vo.setGdsThumbImg("/resources"+File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 새로운 파일이 등록되지 않았다면
		  // 기존 이미지를 그대로 사용
		  vo.setGdsImg(req.getParameter("gdsImg"));
		  vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		  
		 }
		
		dao.update_ok(vo);
		return "redirect:/admin/goods/view?no="+vo.getGdsNum();
	}
	
	
	@RequestMapping("goods/delete")
	public String delete(int no) {
		AdminDAO dao = sqlSession.getMapper(AdminDAO.class);
		dao.delete(no);
		return "redirect:/admin/goods/list?ch=1";
	}
	
	// ck 에디터에서 파일 업로드
	@RequestMapping(value = "/goods/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
	 
	 // 랜덤 문자 생성
	 UUID uid = UUID.randomUUID();
	 
	 OutputStream out = null;
	 PrintWriter printWriter = null;
	   
	 // 인코딩
	 res.setCharacterEncoding("utf-8");
	 res.setContentType("text/html;charset=utf-8");
	 
	 try {
	  
	  String fileName = upload.getOriginalFilename(); // 파일 이름 가져오기
	  byte[] bytes = upload.getBytes();
	  
	  // 업로드 경로
	  String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
	  
	  out = new FileOutputStream(new File(ckUploadPath));
	  out.write(bytes);
	  out.flush(); // out에 저장된 데이터를 전송하고 초기화
	  
	  String callback = req.getParameter("CKEditorFuncNum");
	  printWriter = res.getWriter();
	  String fileUrl = "/resources/ckUpload/" + uid + "_" + fileName;  // 작성화면
	  
	  // 업로드시 메시지 출력
	  printWriter.println("<script type='text/javascript'>"
	     + "window.parent.CKEDITOR.tools.callFunction("
	     + callback+",'"+ fileUrl+"','이미지를 업로드하였습니다.')"
	     +"</script>");
	  
	  printWriter.flush();
	  
	 } catch (IOException e) { e.printStackTrace();
	 } finally {
	  try {
	   if(out != null) { out.close(); }
	   if(printWriter != null) { printWriter.close(); }
	  } catch(IOException e) { e.printStackTrace(); }
	 }
	 
	 return; 
	}
}







