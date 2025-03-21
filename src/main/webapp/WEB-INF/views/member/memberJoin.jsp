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
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main>
        <div class="container">
            <form action="/member/join" method="post">
                <h2 >기본정보</h2>
                <label>아이디 (이메일)</label>
                <input type="email" placeholder="아이디(이메일) 입력" class="id-input" name="memberId" > <button class="check-button">중복확인</button>
                <label>닉네임</label>
                <input type="text" placeholder="닉네임 입력" class="nickname-input" name="memberNickname" > <button class="check-button">중복확인</button>
                <label>비밀번호</label>
                <input type="password" placeholder="비밀번호 입력" name="memberPw">
                <label>비밀번호(확인)</label>
                <input type="password" placeholder="비밀번호 확인" id="MEMBER_PW_RE">
                <label>이름</label>
                <input type="text" placeholder="이름 입력" name="memberName">
                <label>휴대폰 번호</label>
                <input type="text" placeholder="휴대폰 번호 입력" name="memberPhone">
                <label>생년 월일</label>
                <input type="date" name="memberBirth">
                <button type="submit" class="signup-button" id="signup-button">회원가입</button>
            </form>
        </div>

    </main>
    <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
	</body>
	<script>
		document.addEventListener("DOMContentLoaded", function(){
	        var pwTag = document.querySelector("#MEMBER_PW");
	        var pwReTag = document.querySelector("#MEMBER_PW_RE");
	        var msgTag = document.createElement("div");
	        pwReTag.parentNode.insertBefore(msgTag, pwReTag.nextSibling);
        
		document.querySelector("#signup-button").addEventListener("click", function(event){
			if(pwTag.value.trim() !== pwReTag.value.trim()){
                msgTag.innerText = "비밀번호가 일치하지 않습니다";
                event.preventDefault();
                return false;
	            }
	        });
		});
		
	</script>
</html>