<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="myContextPath" value="${pageContext.request.contextPath}" />
<%
	pageContext.setAttribute( "newLine", "\n" );
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>방명록</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${myContextPath}/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="content">
			<div id="guestbook">
				<form method="post" action="${myContextPath}/guestbook">
					<input type="hidden" name="action" value="add">
					<table >
						<tr>
									<td>이름</td> <td><input type="text" name="name"></td>
									<td>비밀번호</td> <td><input type="password" name="pass"></td>
						</tr>
						<tr>
									<td colspan=4><textarea name="content"  cols=60 rows=5></textarea></td>
						</tr>
						<tr>
									<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<br>
				<ul>
					<c:set var="size" value="${fn:length(list)}"/>
					<c:forEach items="${list }" var = "vo"  varStatus ="status">
					<li>
						<table  width=510  border=1>
							<tr>
								<td>${ size - status.index }</td>
								<td>${ vo.name }</td>
								<td>${ vo.reg_date }</td>
								<td><a href="${myContextPath}/guestbook?action=deleteform&no=${vo.no}">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>${fn:replace(vo.content, newLine ,"<br>")}</td>
							</tr>
						</table> <br /> 
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="mennu" value="guestbook"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
</html>