<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myReply</title>
	<link rel="stylesheet" href="../resources/css/mypage/myReply.css"> 
</head>
<body>
    <c:choose>
	    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
	        <jsp:include page="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
	    </c:when>
	    <c:otherwise>
	       <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	    </c:otherwise>
	</c:choose>
		    
	<main class="main">
		<form action="/mypage/myreply" method="get">
	    <div class="myPageMain">
	    <section class="Info">
	    <nav class="myInfomation">
	        <div class="myPicture"></div>
	        <div class="detailInformation">
	            <div>이름 : ${memberName }</div>
	            <div>닉네임 :${memberNickname }</div>
				<c:choose>
				    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
				        <button class="deleteMember" ><a href="/admin/member">회원관리</a></button>
				    </c:when>
				    <c:otherwise>
			        <button class="deleteMember" onclick="confirmDeleteMember('${memberId}')"><a href="/member/delete?memberId=${memberId }">회원탈퇴</a></button>
			    </c:otherwise>
			  </c:choose>
             	  <button class="updateMember" ><a href="/member/modify?memberId=${memberId }">회원정보수정</a></button>
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
			                    <option value="title">댓글 번호</option>
			                    <option value="content">내용</option>
			                </select>
			                <input class="search-input" type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
			                <button type="submit" class="search-reply">검색</button>
			            </form>
			        </div>			
			<!-- 재료 등록 페이지 부분-->
			<!-- <div className="selectform"> -->

			    <div>
			        <section class="my-sources">
			            <table>
			                <thead>
			                    <tr>
			                        <th class="num">댓글 번호</th>
			                        <th class="board-title">댓글 내용</th>
			                        <th class="writer">작성자</th>
			                        <th class="date">작성일</th>
			                        <th class="count">삭제</th>
			
			                    </tr>
			                </thead>
			                <div class="board-Lists">
			                <tbody>
			                    <!-- 일반게시판 --> 
			                    <c:forEach items="${rList }" var="reply" varStatus="i">
			                        <tr class="sources">
			                            <td class="num">${i.count }</td>
			                            <td class="board-title"><a href="<c:url value='/board/detail/${board.boardNo}'/>">${reply.replyContent}</a></td>
			                            <td class="writer">${memberNickname}</td>
			                            <td class="date">${reply.replyDate}</td>
			                            <td class="delete"><button class="delete-myReply" onclick="confirmDeleteReply(${reply.replyNo}, ${board.boardNo})">
			                            		DEL</button></td>
			                        </tr>
			                    
			                    </c:forEach> 		                    
			                </tbody>
			                </div>
			            </table>
			            <!-- 페이지네이션 --> 
			            <div class="pagination">
			                <a href="/mypage/myreply?currentPage=1"> ◁◁ </a>
								<c:if test= "${startNavi ne 1 }">
									<a href="/mypage/myReply?currentPage=${startNavi-1 }" class="prev">◀</a>
								</c:if>	
								<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
									<a href="/mypage/myReply?currentPage=${p }">${p }</a>
								</c:forEach>					
								<c:if test="${endNavi ne maxPage }">
									<a href="/mypage/myReply?currentPage=${endNavi+1 }" class="next">▶</a>
								</c:if>    
					           	<a href="/mypage/myReply?currentPage=${maxPage }"> ▷▷ </a>              
			            </div>
			        </section>
			    </div>
			</div>
	    </div>
	    </form>
	</main>
 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include>
 	<script>
 	function confirmDeleteReply(replyNo, boardNo) {
 	    if (confirm("정말 이 댓글을 삭제하시겠습니까?")) {
 	        window.location.href = "/mypage/deletemyReply?replyNo=" + replyNo + "&boardNo=" + boardNo;
 	    }else {
	        return false;
	    }
 	}
 	
 	function confirmDeleteMember(memberId) {
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