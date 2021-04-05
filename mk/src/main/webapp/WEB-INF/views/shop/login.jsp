<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
  <div class="container">
  <h2> 로 그 인 </h2>
 <form class="form-horizontal container" action="login_ok" method="post">
  <div>
    <label for="email">Email:</label>
    <div>
      <input type="text" name="userId" placeholder="Enter email">
    </div>
  </div>
  <div>
    <label for="pwd">Password:</label>
    <div>
      <input type="password" name="userPass" placeholder="Enter password">
    </div>
  </div>
  <div>
  <c:if test="${param.chk==1}">
    <div>
    	비밀번호가 틀렸습니다.
    </div>
   </c:if>
  </div>
  <div>
    <div>
      <button type="submit" class="btn btn-default">Submit</button>
    </div>
  </div>
</form>
</div>
