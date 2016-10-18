<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c"  %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix= "fmt" %> 
<%@ taglib uri= "http://java.sun.com/jsp/jstl/functions"  prefix= "fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<c:set var="myContextPath" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${myContextPath}</title>
</head>
<body>
		<div id="header">
			<h1><a href = "${myContextPath}/mysite">MySite</a></h1>
			<ul>
			<c:choose >
			<c:when test = "${empty authUser }">
				<li><a href="${myContextPath}/user?action=loginForm">로그인</a><li>
				<li><a href="${myContextPath}/user?action=JoinForm">회원가입</a><li>
			</c:when>
			<c:otherwise>
				<li><a href="${myContextPath}/user?action=ModifyForm">회원정보수정</a><li>
				<li><a href="${myContextPath}/user?action=logout">로그아웃</a><li>
				<li>${authUser.name}님 안녕하세요 ^^;</li>
			</c:otherwise>
			</c:choose>
			</ul>
		</div>
	
</body>
</html>