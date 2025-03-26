<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	    	<form action="/mypage/myboard" method="get">
	        <div class="myPageMain">
			        <section class="Info">
			        <nav class="myInfomation">
			            <div class="myPicture"></div>
			            <div class="detailInformation">
			                <div>이름 :  ${memberName}</div>
			                <div>닉네임 : ${memberNickname}</div>
			 			  <button class="deleteMember" ><a href="member/delete?memberId=${memberId }">회원탈퇴</a></button>
		              	  <button class="updateMember" ><a href="member/modify?memberId=${memberId }">회원정보수정</a></button>
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
					                        <c:forEach items="${mList }" var="board" varStatus="i">
						                        <div class="board-Lists">
						                            <tr class="sources">
						                                <td class="num">${i.count }</td>
						                                <td class="board-title"><a href="/board/detail?boardTitle=${board.boardTitle}">${board.boardTitle }</a></td>
						                                <td class="writer">${board.memberNickname}</td>
						                                <td class="date">${board.boardDate}</td>
						                                <td class="count">${board.boardCount}</td>
						                            </tr>
						                        </div>
					                        </c:forEach>                    
					                    </tbody>
					                </table>
					                
					                <!-- 페이지네이션 --> 
					        <div class="pagination">
								<a href="/mypage/myboard?currentPage=1"> ◁◁ </a>
								<c:if test= "${startNavi ne 1 }">
									<a href="/mypage/myboard?currentPage=${startNavi-1 }" class="prev">◀</a>
								</c:if>	
								<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
									<a href="/mypage/myboard?currentPage=${p }">${p }</a>
								</c:forEach>					
								<c:if test="${endNavi ne maxPage }">
									<a href="/mypage/myboard?currentPage=${endNavi+1 }" class="next">▶</a>
								</c:if>    
					           	<a href="/mypage/myboard?currentPage=${maxPage }"> ▷▷ </a>
				            </div>
					    </section>
			        </div>
			    </div>
		    </div>
	       </form>
	    </main>
	 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 			    
	</body>
</html>