<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<link rel="stylesheet" href="../resources/css/board/boardList.css">
</head>
<body>

    <!-- 헤더 -->
    <c:choose>
		    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
		        <jsp:include page="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
		    </c:when>
		    <c:otherwise>
		       <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		    </c:otherwise>
		</c:choose>         
	
    <main class="board-container">
        <div class="main-top">
            <section class="title">
                <h3 >게시판</h3>
            </section>
            <!-- 검색 -->
            <div class="board-search-group">
            	<form class="write-button" action="/board/insert" method="get">
	                <button type="submit">글쓰기</button>                
            	</form>
                <form class="board-search-form"  action="/board/search" method="get">
                    <select class="board-search-select"  name="searchCondition" >
                        <option value="all"<c:if test="${search.searchCondition eq 'all' }">selected</c:if>>전체</option>
                        <option value="title"<c:if test="${search.searchCondition eq 'title' }">selected</c:if>>제목</option>
                        <option value="content"<c:if test="${search.searchCondition eq 'content' }">selected</c:if>>내용</option>
                        <option value="writer"<c:if test="${search.searchCondition eq 'writer' }">selected</c:if>>작성자</option>
                    </select>
                    <input class="board-search-input" type="text" name="searchKeyword" value="${search.searchKeyword }" placeholder="검색어를 입력하세요">
                    <button type="submit">검색</button>
                </form>
            </div>
        </div>

        <section class="board-content">
            <table>
                <thead>
                    <tr>
                        <th class="num">글번호</th>
                        <th class="title">제목</th>
                        <th class="writer">작성자</th>
                        <th class="date">작성일</th>
                        <th class="views">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- 게시판  --> 
                   	<c:forEach items="${searchBList }" var="board" varStatus="i">
                        <tr  class="free-board">
                        <c:if test="${board.adminYn eq 'Y'}">
                        	<td class="num">공지</td>
                        </c:if>
                        <c:if test="${board.adminYn eq 'N'}">
                        	<td class="num">${board.boardNo }</td>
                        </c:if>
                            <td class="title"><a href="/board/detail/${board.boardNo}"> ${board.boardTitle }</a></td>
                            <td class="writer">${board.memberNickname }</td>
                            <td class="date">${board.boardDate }</td>
                            <td class="views">${board.boardCount }</td>
                        </tr>
					</c:forEach> 
                </tbody>
            </table>
            <!-- 페이지네이션 --> 
            <div class="pagination">
				<a href="/board/search?searchCondition=${search.searchCondition }&searchKeyword=${search.searchKeyword }&currentPage=1"> ◁◁ </a>
				<c:if test= "${startNavi ne 1 }">
					<a href="/board/search?searchCondition=${search.searchCondition }&searchKeyword=${search.searchKeyword }&currentPage=${startNavi-1 }" class="prev">◀</a>
				</c:if>	
				<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
					<a href="/board/search?searchCondition=${search.searchCondition }&searchKeyword=${search.searchKeyword }&currentPage=${p }">${p }</a>
				</c:forEach>					
				<c:if test="${endNavi ne maxPage }">
					<a href="/board/search?searchCondition=${search.searchCondition }&searchKeyword=${search.searchKeyword }&currentPage=${endNavi+1 }" class="next">▶</a>
				</c:if>    
	           	<a href="/board/search?searchCondition=${search.searchCondition }&searchKeyword=${search.searchKeyword }&currentPage=${maxPage }"> ▷▷ </a>
            </div>
        </section>
    </main>
    <!-- 푸터 -->        
	<jsp:include page ="/WEB-INF/views/include/footer.jsp"></jsp:include> 

    <script>
        function toggleNotices() {
            let hiddenRows = document.querySelectorAll('.notice.hidden');
            let allNotices = document.querySelectorAll('.notice');
            let btn = document.querySelector('.toggle-btn td');
    
            if (hiddenRows.length > 0) {
                hiddenRows.forEach(row => row.classList.remove('hidden'));
                btn.innerText = "- 접기";
            } else {
            	allNotices.forEach((row, index)=>{
           			 if (index >= 2) row.classList.add('hidden');            			
            	});
                btn.innerText = "+ 더보기";
            }
        }
    </script>
</body>
</html>