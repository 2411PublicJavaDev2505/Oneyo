<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
<link rel="stylesheet" href="../resources/css/member/findid.css">
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	 <main>
        <div class="login-box">
            <h2>비밀번호 찾기</h2>
                <form action="/member/login" method="get">
                    <label>이름</label>
                    <input type="text" placeholder="이름">
                    <label>전화번호</label>
                    <input type="number" placeholder="전화번호를 입력해주세요">
                    <button class="getid-link"><a href="/member/modify">비밀번호확인</a></button>
                    <div class="linkButtons">
                        <a href="/member/join" class="register-link">회원가입</a>                        
                    </div>
                </form>
        </div>
    </main>
    <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
</body>
</html>