<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>게시판 상세</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board/boardDetail.css">   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">   
</head>
<body>
    <!-- 헤더 -->
    <jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include>
    <main>
        <section class="title">
            <h3><a href="/board/list">게시판</a> </h3>
        </section>
        <article>
            <div class="board-top">
                <h3 class="board-title">${board.boardTitle }</h3>
                <div class="modify-button"> 
                
                    <button type="button" onclick="showUpdateForm(${board.boardNo});">수정</button>
                    <form action="/board/delete" id="deleteForm" method="get">
                    	<input type="hidden" name="boardNo" value="${board.boardNo }">
	                    <button type="button" onclick="deleteConfirm(${board.boardNo});">삭제</button>
                    </form>
                    
                </div>
            </div>
            <div class="board-main">
                <div class="board-info">
                    <span>${board.memberNickname }</span>
                    <span>${board.boardDate }</span>
                    <span>조회 ${board.boardCount }</span>
                </div>
                <div class="board-content">
                     ${board.boardContent }
                </div> 
                <div class="board-file">
                    <h4>첨부파일</h4>
                    <a href="../..${board.boardFilepath }" download>${board.boardFilename }</a>
                </div> 
            </div>
        </article>
	<!-- 댓글 영역 -->      
        <div class="reply-area">
            <div class="reply-road" > <!-- 댓글 조회 -->
            <c:forEach var="reply" items="${reply }">
                <div class="reply-info">
                    <span class="reply-nickname">${reply.memberNickname }</span>
                    <span class="reply-date">${reply.replyDate }</span>
                    <form action="/replyDelete" method="get">
	                    <input type="hidden" name="boardNo" value="${board.boardNo}">
	                    <input type="hidden" name="replyNo" value="${reply.replyNo }">
	                    <button class="reply-del" type="submit">삭제</button>
                    </form>
                </div>
                <span class="reply-content">${reply.replyContent }</span>
            </c:forEach>
            </div> 
            <!-- 댓글 입력 -->
            <form class="reply-insert" action="${pageContext.request.contextPath}/replyInsert" method="post">
            	<input type="hidden" name="boardNo"  value="${board.boardNo }">
            	<input type="hidden" name="memberId"  value="${sessionScope.memberId }">
                <textarea name="replyContent"  placeholder="댓글 입력"></textarea>
                <button type="submit">댓글 등록</button>
            </form>
        </div>
    </main>
    <!-- 푸터 -->
	<jsp:include page ="/WEB-INF/views/include/footer.jsp"></jsp:include>
	<script>
		// 게시글 삭제
		function deleteConfirm(boardNo) {
			var result = confirm("정말로 삭제하시겠습니까?");
			if(result) {
				document.getElementById('deleteForm').submit();
			}
		}
		// 게시글 수정
		function showUpdateForm(boardNo){
			location.href="/board/update?boardNo="+boardNo;
		}
	</script>    
</body>
</html>