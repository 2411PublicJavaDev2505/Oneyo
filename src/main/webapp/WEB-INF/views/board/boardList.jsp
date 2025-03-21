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
    <jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include>         
	
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
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="writer">작성자</option>
                    </select>
                    <input class="board-search-input" type="text" name="searchKeyword" placeholder="검색어를 입력하세요">
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
                    <!-- 공지사항 --> 
                    <div class="notice-row">
                    <c:forEach items="${bList }" var="board" varStatus="i">
                        <tr class="notice">
                            <td class="num">${board.boardNo }</td>
                            <td class="title"><a href="/board/detail/${board.boardNo}"> ${board.boardTitle }</a></td>
                            <td class="writer">${board.memberId }</td>
                            <td class="date">${board.boardDate }</td>
                            <td class="views">${board.boardCount }</td>
                        </tr>
                     </c:forEach>                                                
                    <!-- 더보기 버튼 --> 
                    <tr class="toggle-btn">
                        <td colspan="5" onclick="toggleNotices()">+ 더보기</td>
                    </tr> 
                    <!-- 일반게시판 --> 
                    <div class="free-board">
                    	<c:forEach items="${bList }" var="board" varStatus="i">
                        <tr  class="free-board">
                            <td class="num">${board.boardNo }</td>
                            <td class="title"><a href="/board/detail/${board.boardNo}"> ${board.boardTitle }</a></td>
                            <td class="writer">${board.memberId }</td>
                            <td class="date">${board.boardDate }</td>
                            <td class="views">${board.boardCount }</td>
                        </tr>
						</c:forEach>
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
                <a href="#"> ▶ </a>                        
                <a href="#"> ▷▷ </a>                    
            </div>
        </section>
    </main>
    <!-- 푸터 -->        
	<jsp:include page ="/WEB-INF/views/include/footer.jsp"></jsp:include> 

    <script>
        function toggleNotices() {
            let hiddenRows = document.querySelectorAll('.notice-row.hidden');
            let btn = document.querySelector('.toggle-btn');
    
            if (hiddenRows.length > 0) {
                hiddenRows.forEach(row => row.classList.remove('hidden'));
                btn.innerHTML = "<td colspan='5'>- 접기</td>";
            } else {
                document.querySelectorAll('.notice-row').forEach((row, index) => {
                    if (index >= 2) row.classList.add('hidden');
                });
                btn.innerHTML = "<td colspan='5'>+ 더보기</td>";
            }
        }
    </script>
</body>
</html>