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
	<p>파일을 업로드 했습니다.</p>
	<a href="${pageContext.request.contextPath}/">인덱스로 가기</a><br />
	<a href="${pageContext.request.contextPath}/file/insertform">다시 테스트</a>
</body>
</html>