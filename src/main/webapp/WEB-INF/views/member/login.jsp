<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 페이지</title>
		<link rel="stylesheet" href="../resources/css/member/login.css">
		</head>
	<body>	
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			
	<main>
        <div class="login-box">
            <h2>로그인</h2>
                <form action="/member/login" method="post">
                    <label>아이디 (이메일)</label>
                    <input type="text" name="memberId" placeholder="아이디 또는 이메일 주소">
                    <label>비밀번호</label>
                    <input type="password" name="memberPw" placeholder="비밀번호">
                    <button class="login-btn">로그인</button>
                    
                    <div class="linkButtons">
                        <a href="/member/join" class="register-link">회원가입</a>
                        <a href="/member/findid" class="findid-link">| 아이디 찾기</a>
                        <a href="/member/findpw" class="findpw-link">| 비밀번호 찾기</a>
                        
                    </div>


                </form>
        </div>
    </main>
    	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	
</body>
</html>