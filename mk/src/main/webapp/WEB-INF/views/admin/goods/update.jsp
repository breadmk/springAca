<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script>
$(function () {
	
	$("#back_Btn").click(function(){
		var no = "${goods.gdsNum}";
		location.href= 'view?no='+no;
	});

 var jsonData = JSON.parse('${category}');
 console.log(jsonData);
 
 var cate1Arr = new Array();
 var cate10bj = new Object();
 
 for(var i=0; i< jsonData.length; i++){
	 
	 if(jsonData[i].level=="1"){
		 cate10bj = new Object();
		 cate10bj.cateCode = jsonData[i].cateCode;
		 cate10bj.cateName = jsonData[i].cateName;
		 cate1Arr.push(cate10bj);
	 }
 }
 	 var cate1select = $('select.category1');
    for(var i=0; i<cate1Arr.length; i++){
	  cate1select.append("<option value='" + cate1Arr[i].cateCode + "'>"
		      + cate1Arr[i].cateName + "</option>"); 
  }
  
    $(document).on("change", "select.category1", function(){
    	  var cate2Arr = new Array();
    	    var cate20bj = new Object();
    	    for(var i=0; i< jsonData.length; i++){
    	    	
    	    	if(jsonData[i].level=="2"){
    	    		cate20bj = new Object();
    	    		cate20bj.cateCode = jsonData[i].cateCode;
    	    		cate20bj.cateName = jsonData[i].cateName;
    	    		cate20bj.cateCodeRef = jsonData[i].cateCodeRef;
    	    		cate2Arr.push(cate20bj);
    	    	}
    	    }
    	    
    	    var cate2select = $("select.category2");
    	    cate2select.children().remove();
    	    $("option:selected",this).each(function () {
    	    	 var selectVal = $(this).val();  
   	    	  cate2select.append("<option value='"+selectVal+"'>전체</option>");
   	    	  for(var i = 0; i < cate2Arr.length; i++) {
   	    		   if(selectVal == cate2Arr[i].cateCodeRef) {
   	    			cate2select.append("<option value='" + cate2Arr[i].cateCode + "'>"
   	    		         + cate2Arr[i].cateName + "</option>");
   	    		   	}
   	    		  }
    	    });
    });
    
    var select_cateCode = "${goods.cateCode}"
    var select_cateCodeRef = "${goods.cateCodeRef}"
    var select_cateName = "${goods.cateName}"
//     alert(select_cateName);
    if(select_cateCodeRef != null && select_cateCodeRef!=""){
    	$(".category1").val(select_cateCodeRef);
    	$(".category2").val(select_cateCode);
    	$(".category2").children().remove();
    	$(".category2").append("<option value='"+select_cateCode+"'>"+select_cateName+"</option>");
    }else{
    	$(".category1").val(select_cateCode);
    	$(".category2").val(select_cateCode);
    	$(".category2").append("<option value='"+select_cateCode+"'>전체</option>");
    }
    
    $("#gdsImg").change(function(){
    	if(this.files && this.files[0]){
    		var reader = new FileReader;
    		reader.onload = function(data){
    			$(".select_img img").attr("src",data.target.result).width(500);
    		}
    		reader.readAsDataURL(this.files[0]);
    	} 
    });
    
  var regExp = /[^0-9]/gi;
 	
 	$("#gdsPrice").keyup(function(){ numCheck($(this)); });
 	$("#gdsStock").keyup(function(){ numCheck($(this)); });
 	
 	function numCheck(selector) {
 	 	var tempVal = selector.val();
 	 	selector.val(tempVal.replace(regExp, ""));
 	}
});

	
</script>
<style>
	.form-group{
		margin: auto;
	}
</style>
   
<form role="form" method="post" autocomplete="off" action="update_ok" enctype="multipart/form-data">
<input type="hidden" name="gdsNum" value="${goods.gdsNum}"> 
<div class="form-group">
<h3> 상품등록 </h3>
 <label>1차 분류</label>
 <select class="category1">
  <option value="">전체</option>
 </select>
 <label>2차 분류</label>
 <select class="category2" name="cateCode">
  <option value="">전체</option>
 </select>
</div>

<div class="form-group">
 <label for="gdsName">상품명</label>
 <input type="text" id="gdsName" name="gdsName" class="form-control" value="${goods.gdsName}"/>
</div>

<div class="form-group">
 <label for="gdsPrice">상품가격</label>
 <input type="text" id="gdsPrice" name="gdsPrice" class="form-control" value="${goods.gdsPrice}"/>
</div>

<div class="form-group">
 <label for="gdsStock">상품수량</label>
 <input type="text" id="gdsStock" name="gdsStock" class="form-control" value="${goods.gdsStock}"/>
</div>

<div class="form-group1">
 <label for="gdsDes">상품소개</label>
 <textarea rows="5" cols="50" id="gdsDes" name="gdsDes" class="form-control">${goods.gdsDes}</textarea>
 <script> 
 var ckeditor_config = {
   resize_enaleb : false,
   enterMode : CKEDITOR.ENTER_BR,
   shiftEnterMode : CKEDITOR.ENTER_P,
   filebrowserUploadUrl : "/admin/goods/ckUpload"
  };
 
  CKEDITOR.replace("gdsDes", ckeditor_config);
</script> 
</div>

<div class="form-group">
 <label for="gdsImg">이미지</label>
 <input type="file" id="gdsImg" name="file">
 <div class="select_img"><img src="${goods.gdsImg}">
 <input type="hidden" name="gdsImg" value="${goods.gdsImg}">
 <input type="hidden" name="gdsThumbImg" value="${goods.gdsThumbImg}">
 </div>
</div>

<div class="form-group">
 <button type="submit" id="update_Btn" class="btn btn-primary">수정</button>
 <button type="button" id="back_Btn" class="btn btn-primary">취소</button>
</div>
</form>
	
