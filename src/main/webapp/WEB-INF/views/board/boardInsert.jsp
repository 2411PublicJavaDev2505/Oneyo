<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시판 등록</title>
    <link rel="stylesheet" href="../resources/css/board/boardInsert.css">
</head>
<body>

    <!-- 헤더자리 -->
    <c:choose>
		    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
		        <jsp:include page="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
		    </c:when>
		    <c:otherwise>
		       <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		    </c:otherwise>
		</c:choose>    
    <main>
    
        <section class="title">
            <h3 >게시글 등록</h3>
        </section>
        <form action="/board/insert" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label>작성자</label>
                <input class="writer" type="text" value="${sessionScope.memberNickname }"  readonly>
            </div>
            <div class="form-group">
                <label>게시글 제목</label>
                <input class="content" type="text" name="boardTitle" placeholder="제목을 입력해주세요">    
            </div>
            <div class="form-group">
                <label>내용</label>
                <textarea class="content" name="boardContent"  placeholder="내용을 입력해주세요" rows="5"></textarea>    
                <span>공백포함 최대 1,330자까지 입력가능합니다.</span>
            </div>
            <div class="file-group">
                <label>첨부파일</label>
                <div class="file-upload">
                    <input class="content" type="file" name="uploadFile" id="fileup" />                
                    <button class="cancel" type="reset">Ｘ</button>
                </div>
        
                <div class="buttons">
                    <button class="insert">등록</button>
                    <button class="not-insert" type="reset">취소</button>
                </div>  
            </div>            
        </form>
        
    </main>
    <!-- 푸터자리 -->
	<jsp:include page ="/WEB-INF/views/include/footer.jsp"></jsp:include>
           
</body>
</html>