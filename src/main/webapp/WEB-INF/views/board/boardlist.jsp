<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
    <!-- 헤더자리 -->        
	<link >
    <main>
        <div class="main-top">
            <section class="title">
                <h3 >게시판</h3>
            </section>
            <div class="search-container">
                <button class="write-button">글쓰기</button>
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
                        <tr class="notice">
                            <td class="num">공지</td>
                            <td class="title">공지사항입니다</td>
                            <td class="writer">관리자</td>
                            <td class="date">2025-03-18</td>
                            <td class="views">조회수</td>
                        </tr>
                        <tr class="notice-row">
                            <td class="num">공지</td>
                            <td class="title">공지사항입니다</td>
                            <td class="writer">관리자</td>
                            <td class="date">2025-03-18</td>
                            <td class="views">조회수</td>
                        </tr>                                                                                   
                        <tr class="notice-row">
                            <td>공지</td>
                            <td>새해 복 많이 받으세요!!!</td>
                            <td>관리자</td>
                            <td>2025-01-02</td>
                            <td>15</td>
                        </tr>
                        <tr class="notice-row">
                            <td>공지</td>
                            <td>오내요에서 알려드립니다</td>
                            <td>관리자</td>
                            <td>2024-11-10</td>
                            <td>10</td>
                        </tr>
                        <tr class="notice-row">
                            <td>공지</td>
                            <td>긴급 서버 점검 안내</td>
                            <td>관리자</td>
                            <td>2024-11-05</td>
                            <td>5</td>
                    </div>
                    <!-- 더보기 버튼 --> 
                    <tr class="toggle-btn">
                        <td colspan="5" onclick="toggleNotices()">+ 더보기</td>
                    </tr> 
                    <!-- 일반게시판 --> 
                    <div class="free-board">
                        <tr  class="free-board">
                            <td class="num">1</td>
                            <td class="title">안녕하세요 처음뵙겠습니다</td>
                            <td class="writer">user01</td>
                            <td class="date">2025-03-18</td>
                            <td class="views">0</td>
                        </tr>
                        <tr class="free-board">
                            <td class="num">2</td>
                            <td class="title">title</td>
                            <td class="writer">user01</td>
                            <td class="date">2025-03-18</td>
                            <td class="views">0</td>
                        </tr>
                        <tr class="free-board">
                            <td class="num">3</td>
                            <td class="title">title</td>
                            <td class="writer">user01</td>
                            <td class="date">2025-03-18</td>
                            <td class="views">0</td>
                        </tr>
                        <tr class="free-board">
                            <td class="num">4</td>
                            <td class="title">title</td>
                            <td class="writer">user01</td>
                            <td class="date">2025-03-18</td>
                            <td class="views">0</td>
                        </tr>
                        <tr class="free-board">
                            <td class="num">5</td>
                            <td class="title">title</td>
                            <td class="writer">user01</td>
                            <td class="date">2025-03-18</td>
                            <td class="views">0</td>
                        </tr>
                        <tr class="free-board">
                            <td class="num">6</td>
                            <td class="title">title</td>
                            <td class="writer">user01</td>
                            <td class="date">2025-03-18</td>
                            <td class="views">0</td>
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
    </main>
    <!-- 푸터자리 -->        

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