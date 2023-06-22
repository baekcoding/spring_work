<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="container">
		<h1>인덱스 페이지입니다.</h1>
		<ul>
			<li><a href="member/list">회원목록 보기</a></li>
			<li><a href="guest/list">방명록 보기</a></li>
		</ul>
		<img src="${pageContext.request.contextPath}/resources/images/b0.png"/>
		<h2>공지사항</h2>
		<ul>
			<c:forEach var="tmp" items="${requestScope.noticeList}">
				<li>${tmp}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
