<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>회원정보수정페이지</title>
		<link rel="stylesheet" href=".../resources/css/member/modifyMember.css">
		</head>
		<body>
			 <main>
        <form action="/member/modify" method="post">

            <div class="modifymain">

                <div class="mypagemain">
                    <section class="info">
                        <nav class="myinformation">
                        <div class="mypicture"></div>
                            <div class="detailinformation">
                            <h4>이름 : 일용자</h4>
                            <h4>닉네임 : 마셰코</h4>
                            <button class="deleteMember">정보수정<a href="/"></a></button><button class="updateMember">회원탈퇴<a href="/"></a></button>
                            </div>
                        </nav>
                    </section>
    
                </div>
    
                <div class="modify-container">
                    <div class="modifyMember">
                        <h3>회원정보</h3>
                        <label>아이디 (이메일)</label>
                        <input type="email" placeholder="아이디(이메일) 입력" class="id-input"> 
                        <button class="check-button">중복확인</button>
                        <label>닉네임</label>
                        <input type="text" placeholder="닉네임 입력" class="nickname-input"> 
                        <button class="check-button">중복확인</button>
                        <label>이름</label>
                        <input type="text" placeholder="이름 입력">
                        <label>휴대폰 번호</label>
                        <input type="text" placeholder="휴대폰 번호 입력">
                        <button class="modify-button">저장</button>
                    </div>
        
                    <div class="modifypw">
                        <h3>비밀번호설정</h3>
                        <label>비밀번호</label>
                        <input type="password" placeholder="비밀번호 입력">
                        <label>비밀번호(확인)</label>
                        <input type="password" placeholder="비밀번호 확인">
                        <button class="password-button">비밀번호 설정</button>
                    </div>
                </div>
            </div>

            
        </form>
    </main>
    <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
		</body>
	</html>