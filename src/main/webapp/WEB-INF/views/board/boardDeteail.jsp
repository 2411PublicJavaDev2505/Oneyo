<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>게시판 상세</title>
    <link rel="stylesheet" href="../resources/css/board/boardDetail.css">   
</head>
<body>
    <!-- 헤더 -->
    <jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include>
    <main>
        <section class="title">
            <h3 >게시판</h3>
        </section>
        <article>
            <div class="board-top">
                <h3 class="board-title">${board.boardTitle }</h3>
                <div class="board-info">
                    <span>${board.memberId }</span>
                    <span>${board.boardDate }</span>
                    <span>조회 ${board.boardCount }</span>
                </div>
            </div>
            <div class="board-main">
                <div class="modify-button"> 
                    <a href="#">수정</a>
                    <a href="#">삭제</a>
                </div>
                <div class="board-content">
                     ${board.boardContent }
                </div>                
                <div class="image-box">
                    <img src="/upload/sample1.jpg" alt="이미지1">
                    <img src="/upload/sample2.jpg" alt="이미지2">
                    <img src="/upload/sample3.jpg" alt="이미지3">
                    <img src="/upload/sample4.jpg" alt="이미지4">
                </div>                
                <div class="board-file">
                    <h4>첨부파일</h4>
                    <a href="#"></a>
                </div>
            </div>
        </article>
        <div class="reply-area">
            <div class="reply-road">
                <div class="reply-info">
                    <span class="reply-nickname">user01</span>
                    <span class="reply-date">2025-03-18 19:05</span>
                    <a class="reply-del"href="#">삭제</a>
                </div>
                <span class="reply-content">없으면 제가 다 먹을게요 ㅎㅎ</span>
            </div>
            <div class="reply-insert">
                <textarea placeholder="댓글 입력"></textarea>
                <a href="#">댓글 등록</a>
            </div>
        </div>
    </main>
    <!-- 푸터 -->
	<jsp:include page ="/WEB-INF/views/include/footer.jsp"></jsp:include>    
</body>
</html>