<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>아이디찾기</title>
	</head>
	<body>
	<form action="/member/findid" method="get">
		    	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		
		<main>
	        <div class="login-box">
	            <h2>아이디 찾기</h2>
	            <input type="text" placeholder="이름">
	            <button class="findid-btn">아이디찾기</button>
	            <a href="/member/join" class="register-link">회원가입</a>
	        </div>
	    </main>
	    </form>
	    	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</body>
</html>