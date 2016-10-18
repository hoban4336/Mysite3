<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c"  %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt"  prefix= "fmt" %> 
<%@ taglib uri= "http://java.sun.com/jsp/jstl/functions"  prefix = "fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="myContextPath" value="${pageContext.request.contextPath}" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${myContextPath }</title>
</head>
<body>
		<div id="navigation">
			<ul>
			<c:choose>
				<c:when test = "${param.menu == 'main'}">
					<li class="selected"><a href="${myContextPath }/mysite">안대혁</a></li>
					<li><a href="${myContextPath }/guestbook">방명록</a></li>
					<li><a href="${myContextPath }/board">게시판</a></li>
				</c:when>
				<c:when test = "${param.menu == 'guestbook'}">
					<li ><a href="${myContextPath }/mysite">안대혁</a></li>
					<li class="selected" ><a href="${myContextPath }/guestbook">방명록</a></li>
					<li><a href="${myContextPath }/board">게시판</a></li>
				</c:when>
				<c:when test = "${param.menu == 'board'}">
					<li ><a href="${myContextPath }/mysite">안대혁</a></li>
					<li ><a href="${myContextPath }/guestbook">방명록</a></li>
					<li class="selected" ><a href="${myContextPath }/board">게시판</a></li>
				</c:when>
				<c:otherwise>
					<li ><a href="${myContextPath }/mysite">안대혁</a></li>
					<li ><a href="${myContextPath }/guestbook">방명록</a></li>
					<li ><a href="${myContextPath }/board">게시판</a></li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
</body>
</html>