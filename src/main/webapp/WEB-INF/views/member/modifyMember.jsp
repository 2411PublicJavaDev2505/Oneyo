<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보수정</title>
    <link rel="stylesheet" href="../resources/css/member/modifyMember.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
    <main>
        <form action="/member/modify" method="post">

            <div class="modifymain">

                <div class="mypagemain">
                    <section class="info">
                        <nav class="myinformation">
                        <div class="mypicture"></div>
                            <div class="detailinformation">
                            <h4>이름 : ${member.memberName}</h4>
                            <h4>닉네임 : ${member.memberNickname}</h4>
				        <button class="deleteMember" onclick="confirmDelete('${memberId}')"><a href="/member/delete?memberId=${memberId }">회원탈퇴</a></button>
                            </div>
                        </nav>
                    </section>
    
                </div>
    
                <div class="modify-container">
                    <div class="modifyMember">
                        <h3>회원정보</h3>
                        <label>닉네임</label>
                        <input type="text" placeholder="닉네임 입력" class="nickname-input" name="memberNickname"> 
                        <button class="check-button" onclick="location.href='/member/checkDuplicateNickname'">중복확인</button>
                        <label>이름</label>
                        <input type="text" placeholder="이름 입력" name="memberName">
                        <label>휴대폰 번호</label>
                        <input type="text" placeholder="휴대폰 번호 입력" name="memberPhone">
                        <button class="modify-button">저장</button>
                    </div>
         			</form>
   			<form action="/member/modifypw" method="post">
               <div class="modifypw">
                   <h3>비밀번호설정</h3>
                   <label>새로운 비밀번호</label>
                   <input type="password" placeholder="새 비밀번호 입력" name="memberPw" id="MEMBER_PW">
                   <label>새 비밀번호 확인</label>
                   <input type="password" placeholder="새 비밀번호 확인"  id="MEMBER_PW_RE">
                   <button class="password-button" id="signup-button">비밀번호 설정</button>
               </div>
           </div>
          </div>
            </form>
      			
       
    </main>
    <script>
		document.addEventListener("DOMContentLoaded", function(){
		    var pwTag = document.querySelector("#MEMBER_PW");
		    var pwReTag = document.querySelector("#MEMBER_PW_RE");
	
		    if (!pwTag) {
		        console.error("비밀번호 입력 필드를 찾을 수 없습니다. id='MEMBER_PW'가 있는지 확인하세요.");
		        return;
		    }
	
		    var msgTag = document.createElement("div");
		    pwReTag.parentNode.insertBefore(msgTag, pwReTag.nextSibling);
	
		    document.querySelector("#signup-button").addEventListener("click", function(event){
		        if (pwTag.value.trim() !== pwReTag.value.trim()) {
		            msgTag.innerText = "비밀번호가 일치하지 않습니다";
		            msgTag.style.color = "red";
		            event.preventDefault(); // 폼 제출 방지
		        }
		    });
		});
		function confirmDelete(memberId) {
		    if (confirm("정말 탈퇴하시겠습니까?")) {
		        window.location.href = "/member/delete?memberId=" + memberId;
		    }else {
		        // 취소를 누르면 아무 작업도 하지 않음 (기존 화면 유지)
		        return false;
		    }
		}
	</script>
	</body>
	
</html>