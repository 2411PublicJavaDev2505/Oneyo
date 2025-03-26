<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 수정</title>
    <link rel="stylesheet" href="../resources/css/board/boardInsert.css">
</head>
<body>

    <!-- 헤더자리 -->
    <jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include>    
    <main>
    
        <section class="title">
            <h3 >게시글 등록</h3>
        </section>
        <form action="/board/update" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="boardNo" value="${board.boardNo }">
        	<input type="hidden" name="memberId" value="${board.memberId }">
            <div class="form-group">
                <label>작성자</label>
                <input class="writer" type="text" value="${board.memberNickname }"  readonly>
            </div>
            <div class="form-group">
                <label>게시글 제목</label>
                <input class="content" type="text" name="boardTitle" value="${board.boardTitle }">    
            </div>
            <div class="form-group">
                <label>내용</label>
                <textarea class="content" name="boardContent" " rows="5">${board.boardContent }</textarea>    
                <span>공백포함 최대 1,330자까지 입력가능합니다.</span>
            </div>
            <div class="board-file">
                <h4>첨부파일</h4>
				<input type="hidden" name="boardFilename" value="${board.boardFilename }">
				<input type="hidden" name="boardFileRename" value="${board.boardFileRename }">					
				<input type="hidden" name="boardFilepath" value="${board.boardFilepath }">                
                <a href="../..${board.boardFilepath }" download>${board.boardFilename }</a>
            </div>             
            <div class="file-group">
                <label>첨부파일</label>
                <div class="file-upload">
                    <input class="content" type="file" name="reloadFile" id="fileup" readonly>
                    <button class="cancel">Ｘ</button>
                </div>
 <!--                  <div class="file-upload">
                    <label></label>
                    <input class="content" type="text" value="10MB 미만의 파일을 업로드 해주세요" readonly>
                    <button class="cancel">Ｘ</button>
                    <button class="select">파일 선택</button>
                </div>
                <div class="file-upload">
                    <label></label>
                    <input class="content" type="text" value="10MB 미만의 파일을 업로드 해주세요" readonly>
                    <button class="cancel">Ｘ</button>
                    <button class="select">파일 선택</button>
                </div>
                <div class="file-upload">
                    <label></label>
                    <input class="content" type="text" value="10MB 미만의 파일을 업로드 해주세요" readonly>
                    <button class="cancel">Ｘ</button>
                    <button class="select">파일 선택</button>
                </div>  -->
        
                <div class="buttons">
                    <button class="insert">수정완료</button>
                    <button class="not-insert"><a href="/board/detail/${board.boardNo }">취소</a></button>
                </div>
            </div>            
        </form>
        
    </main>
    <!-- 푸터자리 -->
	<jsp:include page ="/WEB-INF/views/include/footer.jsp"></jsp:include>
           
</body>
</html>