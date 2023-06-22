<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>방명록 추가 페이지</h1>
		<form action="${pageContext.request.contextPath}/guest/insert" method="post">
			<div>
				<label for="writer">작성자</label>
				<input type="text" name="writer" id="writer"/>
			</div>
			<div>
				<label for="content">내용</label>
				<textarea name="content" id="content" rows="10"></textarea>
			</div>
			<div>
				<label for="pwd">비밀번호</label>
				<input type="text" name="pwd" id="pwd"/>
			</div>
			<button type="submit">추가</button>
			<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>