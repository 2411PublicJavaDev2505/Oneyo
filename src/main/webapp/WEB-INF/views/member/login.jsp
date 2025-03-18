<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 페이지</title>
		<link rel="stylesheet" href="/webapp/resources/css/member/login.css">
		</head>
	<body>	
			<form action="/member/login" method="get">
	    	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	
	<main>
        <div class="login-box">
            <h2>로그인</h2>
            <input type="text" placeholder="아이디 또는 이메일 주소">
            <input type="password" placeholder="비밀번호">
            <button class="login-btn">로그인</button>
            <a href="#" class="register-link">회원가입</a>
        </div>
    </main>
    </form>
    	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	
</body>
</html>