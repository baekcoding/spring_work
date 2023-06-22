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
	<div class="container">
		<h1>방명록 수정</h1>
		<form action="${pageContext.request.contextPath}/guest/update" method="post">
			<div class="mb-2">
				<label class="form-label" for="num">번호</label>
				<input class="form-control" type="text" name="num" id="num" value="${dto.num}" readonly/>
			</div>
			<div class="mb-2">
				<label class="form-label" for="writer">작성자</label>
				<input class="form-control" type="text" name="writer" id="writer" value="${dto.writer}"/>
			</div>
			<div class="mb-2">
				<label class="form-label" for="content">내용</label>
				<textarea class="form-control" name="content" id="content" rows="5">${dto.content}</textarea>
			</div>
			<div class="mb-2">
				<label class="form-label" for="pwd">비밀번호</label>
				<input class="form-control" type="password" name="pwd" id="pwd" value="${dto.pwd}"/>
			</div>
			<button type="submit">수정제출</button>
			<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>