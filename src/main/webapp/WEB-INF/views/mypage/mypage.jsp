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
 		<c:choose>
			    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
			        <jsp:include page="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
			    </c:when>
			    <c:otherwise>
			       <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			    </c:otherwise>
			</c:choose>
		    
    <main class="main">
		<div class="myPageMain">
      <section class="Info">
        <nav class="myInfomation">
          <div class="myPicture"></div>
            <div class="detailInformation">
              <div>이름 :${memberName}</div>
              <div>닉네임 : ${memberNickname}</div>
              <div>전화번호 : ${memberPhone}</div>
              <c:choose>
				    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
				        <button class="deleteMember" ><a href="/admin/member">회원관리</a></button>
				    </c:when>
				    <c:otherwise>
				        <button class="deleteMember" ><a href="/member/delete?memberId=${memberId }">회원탈퇴</a></button>
				    </c:otherwise>
				</c:choose>
              <button class="updateMember" ><a href="/member/modify?memberId=${memberId }">회원정보수정</a></button>
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