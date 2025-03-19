<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../resources/css/member/memberJoin.css">
</head>
	<body>
		<main>
        <div class="container">
            <form action="/member/join" method="post">
                <h2 >기본정보</h2>
                <label>아이디 (이메일)</label>
                <input type="email" placeholder="아이디(이메일) 입력" class="id-input"> <button class="check-button">중복확인</button>
                <label>닉네임</label>
                <input type="text" placeholder="닉네임 입력" class="nickname-input"> <button class="check-button">중복확인</button>
                <label>비밀번호</label>
                <input type="password" placeholder="비밀번호 입력">
                <label>비밀번호(확인)</label>
                <input type="password" placeholder="비밀번호 확인">
                <label>이름</label>
                <input type="text" placeholder="이름 입력">
                <label>휴대폰 번호</label>
                <input type="text" placeholder="휴대폰 번호 입력">
                <label>생년 월일</label>
                <input type="date">
                <button class="signup-button">회원가입</button>
            </form>
        </div>

    </main>
	</body>
</html>