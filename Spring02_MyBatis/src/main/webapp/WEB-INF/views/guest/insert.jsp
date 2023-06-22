<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p class="form-floating"><strong>${param.writer}</strong> 님의 방명록이 추가되었습니다.</p>
	<a href="${pageContext.request.contextPath}/guest/list">리스트로 가기</a>
</body>
</html>