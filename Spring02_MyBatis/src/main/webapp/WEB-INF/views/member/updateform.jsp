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
		<form action="${pageContext.request.contextPath}/member/update" method="post">
			<div>
				<label for="num">번호</label>
				<input type="text" name="num" id="num" value="${dto.num}"/>
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" value="${dto.name}"/>
			</div>
			<div>
				<label for="addr">주소</label>
				<input type="text" name="addr" id="addr" value="${dto.addr}"/>
			</div>
			<button type="submit">수정</button>
			<button type="reset">취소</button>
		</form>
	</div>
</body>
</html>