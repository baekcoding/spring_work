<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<h1>회원 추가 폼입니다.</h1>
		<form action="${pageContext.request.contextPath}/member/insert" method="post">
			<div>
				<label class="form-label" for="name">이름</label>
				<input class="form-control" type="text" name="name" id="name"/>
			</div>
			<div>
				<label class="form-label" for="addr">주소</label>
				<input class="form-control" type="text" name="addr" id="addr"/>
			</div>
			<button type="submit">추가</button>
		</form>
	</div>
</body>
</html>