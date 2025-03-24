<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/mypage/mypage.css"> 
</head>
<body>
		<!--  헤더-->
 		<jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
 		
    <main class="main">
		<div class="myPageMain">
      <section class="Info">
        <nav class="myInfomation">
          <div class="myPicture"></div>
            <div class="detailInformation">
              <div>이름 : </div>
              <div>닉네임 : 마셰코</div>
             <button class="deleteMember" onclick="location.href='member/delete?memberId=${member.memberId }'">회원탈퇴</button>
              <button class="updateMember"  onclick="location.href='member/modify?memberId=${member.memberId }'">회원정보수정</button>
            </div>
        </nav>
      </section> 		

		<!--  마이페이지 메인화면-->
 		<div class="myDetail-container">
          <div class="myPageMenu">
            <button><a href="/mypage/mypage">마이냉장고</a></button>
            <button><a href="/mypage/myBoard">내가 쓴글</a></button>
            <button><a href="/mypage/myReply">나의 댓글</a></button>
          </div>
          <div class="refrigerator-container">
            <div class="refrige-storage">
              <div class="list">      
              <div class="freeze">냉동실</div>   
              <div class="sources">
              	<c:forEach items= "${iList }" var="iceSource">
                <button><a href="/">${iceSource.sourceName }</a></button>
                </c:forEach>
              	<button><a href="/mypage/myIceStorage">....</a></button>
                <button><a href="/mypage/myIceStorage">등록/수정</a></button>
                </div>
              </div>
            </div>
            <div class="refrige-storage"><img src="../resources/img/냉장고.jpg" alt="냉장고 사진" width="100%" height="100%" /></div>
            <div class="refrige-storage">
              <div class="list">
              <div class="cooler">냉장실</div>
              <div class="sources">
              	<c:forEach items= "${cList }" var="coolSource">
                <button><a href="/">${coolSource.sourceName }</a></button>
                </c:forEach>
                <button><a href="/mypage/myCoolStorage">....</a></button>
                <button><a href="/mypage/myCoolStorage">등록/수정</a></button>
                </div>
                </div>
            </div>
          </div>
      </div>
		</div>
    </main>
 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	 		
 		
 		
 		
 		
</body>
</html>