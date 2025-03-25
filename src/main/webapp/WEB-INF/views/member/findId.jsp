<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>아이디찾기</title>
		<link rel="stylesheet" href="../resources/css/member/findid.css">
	</head>
	<body>
	<form action="/member/findid" method="get">
		    	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		
		<main>
	        <div class="login-box">
	            <h2>아이디 찾기</h2>
	            <input type="text" placeholder="이름">
	            <input type="number" placeholder="전화번호를 입력하세요">
	            <button class="findid-btn" >아이디찾기</button>
	            <button class="register-link"><a href="/member/join" >회원가입</a></button>
	        </div>
	    </main>
	    </form>
	    	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</body>
</html>