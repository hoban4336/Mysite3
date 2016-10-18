<%@page import="com.yeon.Dao.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% UserVo userVo = (UserVo)request.getAttribute("userVo"); 
Long no = userVo.getNo();
String name = userVo.getName();
String email  = userVo.getEmail();
String password = userVo.getPassword();
String gender =  userVo.getGender();
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/Mysite3/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<div id="content">
			<div id="user">
				<form id="join-form" name="joinForm" method="post" action="/Mysite3/user">
				<input type="hidden" name="action"  value="Modify">
				<input type="hidden" name ="no"  value=" <%=no%>">
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="<%=name%>">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="<%=email%>" disabled>
					
					<label class="block-label">패스워드</label>
					<input name="password" type="text" value="<%=password%>">
					
					<fieldset>
						<legend>성별</legend>
						<%if("male".equals(gender)){ %>
							<label>여</label> <input type="radio" name="gender" value="female" >
							<label>남</label> <input type="radio" name="gender" value="male" checked="checked">
						<%}else{ %>
							<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
							<label>남</label> <input type="radio" name="gender" value="male">
						<%} %>
					</fieldset>
					
					<input type="submit" value="수정하기">
					
				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	</div>
</body>
</html>