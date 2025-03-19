<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/mypage/mypage.css"> 
	<link rel="stylesheet" href="../resources/css/footer.css"> 
	<link rel="stylesheet" href="../resources/css/header.css"> 
</head>
<body>
 		<jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
    

    <main class="main">
		<div class="myPageMain">
      <section class="Info">
        <nav class="myInfomation">
          <div class="myPicture"></div>
            <div class="detailInformation">
              <div>이름 : 일용자</div>
              <div>닉네임 : 마셰코</div>
              <button class="deleteMember"><a href="/"></a></button>
              <button class="updateMember"><a href="/"></a></button>
            </div>
        </nav>
      </section>
<!--       마이 냉장고 기본틀 -->
      <div class="myDetail-container">
          <div class="myPageMenu">
            <button><a href="/">마이냉장고</a></button>
            <button><a href="/">내가 쓴글</a></button>
            <button><a href="/">나의 댓글</a></button>
          </div>

<!-- 		재료 등록 페이지 부분-->






      </div>
		</div>
    </main>
 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 		

</body>
</html>