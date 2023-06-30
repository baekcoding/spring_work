<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#profileForm{
		display: none;
	}
	#profileLink img{
		width: 200px;
		height: 200px;
		border: 1px solid red;
		border-radius: 50%;
	}
</style>
</head>
<body>
	<div class="container">
		<h3>파일 업로드 폼1</h3>
		<form action="${pageContext.request.contextPath}/file/upload" method="post"
			enctype="multipart/form-data">
			제목 <input type="text" name="title"/><br />
			첨부파일 <input type="file" name="myFile"/><br />
			<button type="submit">업로드</button>			
		</form>
		
		<h3>파일 업로드 폼2</h3>
		<form action="${pageContext.request.contextPath}/file/upload2" method="post"
			enctype="multipart/form-data">
			제목 <input type="text" name="title"/><br />
			첨부파일 <input type="file" name="myFile"/><br />
			<button type="submit">업로드</button>	
		</form>
		
		<!-- 
			이미지를 선택해서 업로드 버튼을 누르면 페이지 전환없이 이미지를 업로드 하고
		 	업로드 된 파일의 정보를 응답(json) 받아서 id가 imageWrapper인
		 	div의 자식 요소에 img 요소를 추가해서 업로드 된 이미지가 바로 보이도록 프로그래밍
		 	
		 	- webapp/resources/upload 폴더에 이미지 저장하기
		 	- gura_util.js 를 webapp/resource/js 폴더에 넣어놓고 로딩해서 쓰면 된다.
		 	- /image/upload 요청 처리는 FileController에서 하면 된다.
		  -->
		<h3>이미지 업로드 폼</h3>
		<form action="${pageContext.request.contextPath}/image/upload" method="post" enctype="multipart/form-data" id="uploadForm">
			이미지<input type="file" name="image" accept=".jpg, .jpeg, .JPG, .JPEG, .gif, .png, .PNG">
			<br />
			<button type="submit" id="imgBtn">업로드</button>
		</form>
		<br />
		<div id="imageWrapper"></div>
		<div>
			<a href="javascript:" id="profileLink">
				프로필
			</a>
		</div>
		<form action="${pageContext.request.contextPath}/image/upload"
			method="post" enctype="multipart/form-data" id="profileForm">
			이미지 <input type="file" id="file" name="image" accept="jpg, jpeg, JPG, JPEG, png, PNG, gif" />
		</form>
	</div>
	<script src="${pageContext.request.contextPath }/resources/js/gura_util.js"></script>
	<script>
	
		document.querySelector("#profileLink").addEventListener("click", ()=>{
			
			document.querySelector("#file").click();
			
		});
		
		document.querySelector("#file").addEventListener("change", (e)=>{
			const form = document.querySelector("#profileForm");
			
			fetch(form.action, {
				method:"post",
				body:new FormData(form)
			})
			.then(res=>res.json())
			.then(data=>{
				const imgString = `<img src="${pageContext.request.contextPath}\${data.imagePath}">`;
				document.querySelector("#imageWrapper").innerHTML = imgString;
			});
		});
	
		document.querySelector("#uploadForm").addEventListener("submit", (e)=>{
			//폼 전송 막기
			e.preventDefault();
			/*
			//gura_util
			ajaxFormPromise(e.target)
			.then(res=>res.json())
			.then(data=>{
				
			}); */
			
			//gura_util.js를 사용하지 않는 경우
			
			console.log(e.target);
			
			//서버에 전송할 data를 구성한다.
			let data = new FormData(e.target);
			//fetch() 함수가 리턴하는 Promise 객체를
			fetch("${pageContext.request.contextPath}/image/upload", {
				method:"post",
				body:data
			})
			.then(res=>res.json())
			.then(data=>{
				console.log(data);
				//data는  {imagePath:"/resources/upload/xxx"} 형식의 object 이다.
				const imgString = `<img src="${pageContext.request.contextPath}\${data.imagePath}">`;
				//img 요소를 표현하고 있는 문자열을 HTML 형식으로 해석이 되도록 대입해 준다.
				document.querySelector("#imageWrapper").innerHTML=imgString;
			});
		});
	</script>
</body>
</html>