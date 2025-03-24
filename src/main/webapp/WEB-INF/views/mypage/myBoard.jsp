<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/mypage/myBoard.css"> 

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
 			  <button class="deleteMember" onclick="location.href='member/delete?memberId=${memberId }'">회원탈퇴</button>
              <button class="updateMember"  onclick="location.href='member/modify?memberId=${memberId }'">회원정보수정</button>
            </div>
        </nav>
        </section>

    <!--       마이 냉장고 기본틀 -->
        <div class="myDetail-container">
            <div class="myPageMenu">
            <button><a href="/mypage/mypage">마이냉장고</a></button>
            <button><a href="/mypage/myBoard">내가 쓴글</a></button>
            <button><a href="/mypage/myReply">나의 댓글</a></button>
            </div>
            
            <div class="search-container">
                <form class="search-form"  action="/board/search">
                    <select class="search-select"  name="searchCondition" >
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="writer">작성자</option>
                    </select>
                    <input class="search-input" type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
                    <button type="submit">검색</button>
                </form>
            </div>
    	<!-- 재료 등록 페이지 부분-->
        <!-- <div className="selectform"> -->

        <div>
            <section class="my-sources">
                <table>
                    <thead>
                        <tr>
                            <th class="num">글번호</th>
                            <th class="board-title">제목</th>
                            <th class="writer">작성자</th>
                            <th class="date">작성일</th>
                            <th class="count">조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- 일반게시판 --> 
                        <div class="board-Lists">
                            <tr  class="sources">
                                <td class="num">1</td>
                                <td class="board-title"><a href="#">오늘의 레시피 추천</a></td>
                                <td class="writer">회원10</td>
                                <td class="date">2025-05-30</td>
                                <td class="count">5</td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">2</td>
                                <td class="board-title"><a href="#">집에서 먹는 마라오이무침</a></td>
                                <td class="writer">회원10</td>
                                <td class="date">2025-05-30</td>
                                <td class="count">5</td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">3</td>
                                <td class="board-title"><a href="#">엽떡 따라잡기</a></td>
                                <td class="writer">회원10</td>
                                <td class="date">2025-05-30</td>
                                <td class="count">5</td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">4</td>
                                <td class="board-title"><a href="#">엄마 돈까스는 이제 그만!</a></td>
                                <td class="writer">회원10</td>
                                <td class="date">2025-05-30</td>
                                <td class="count">5</td>
                            </tr>
                            <tr  class="sources">
                                <td class="num">5</td>
                                <td class="board-title"><a href="#">생활 꿀팁</a></td>
                                <td class="writer">회원10</td>
                                <td class="date">2025-05-30</td>
                                <td class="count">5</td>
                            </tr>               
                          </tr>
                        </div>                    
                    </tbody>
                </table>
                
                <!-- 페이지네이션 --> 
                <div class="pagination">
                    <a href="#"> ◁◁ </a>
                    <a href="#"> ◀ </a>                        
                    <a href="#"> 1 </a>                        
                    <a href="#"> 2 </a>                        
                    <a href="#"> 3 </a>                        
                    <a href="#"> 4 </a>                        
                    <a href="#"> 5 </a>                        
                    <a href="#"> 6 </a>                        
                    <a href="#"> 7 </a>                        
                    <a href="#"> 8 </a>                        
                    <a href="#"> 9 </a>                        
                    <a href="#"> 10 </a>                        
                    <a href="#"> ▶ </a>                        
                    <a href="#"> ▷▷ </a>                    
                </div>
            </section>
        </div>
    </div>
        </div>
    </main>
 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 			    
</body>
</html>