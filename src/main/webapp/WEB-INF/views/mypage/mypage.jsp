<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/mypage.css"> 
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
      
      <div class="myDetail-container">
          <div class="myPageMenu">
            <button><a href="/">마이냉장고</a></button>
            <button><a href="/">내가 쓴글</a></button>
            <button><a href="/">나의 댓글</a></button>
          </div>
          <div class="refrigerator-container">
            <div class="refrige-storage">
              <div class="list">      
              <div class="freeze">냉동실</div>   
              <div class="sources">
                <button><a href="/">재료1</a></button>
                <button><a href="/">재료2</a></button>
                <button><a href="/">재료3</a></button>
                <button><a href="/">....</a></button>
                <button><a href="/">등록/수정</a></button>
                </div>
              </div>
            </div>
            <div class="refrige-storage"><img src="/../resources/image/냉장고.jpg" alt="냉장고 사진" width="100%" height="100%" /></div>
            <div class="refrige-storage">
              <div class="list">
              <div class="cooler">냉장실</div>
              <div class="sources">
                <button><a href="/">재료1</a></button>
                <button><a href="/">재료2</a></button>
                <button><a href="/">재료3</a></button>
                <button><a href="/">....</a></button>
                <button><a href="/">등록/수정</a></button>
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