<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>레시피 페이지</title>
		<link rel="stylesheet" href="../ONEYO/css/modify.css">
	    <link rel="stylesheet" href="../ONEYO/css/header.css">
	    <link rel="stylesheet" href="../ONEYO/css/footer.css">
	</head>
	<body>
	
		<jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
	    <main>
	        <div class="recipe-card">
	            <div class="image-placeholder">image</div>
	            <div class="recipe-info">
	                <div class="recipe-title-box">
	                    <input type="text" placeholder="레시피 명을 입력해주세요">
	                </div>
	                <span>작성자: user1</span>
	            </div>
	        </div>
	    </main>
	
	    <div class="ingredient-container1">
	        <div class="ingredient-group1">
	            <h2>재료</h2>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	        </div>
	        <div class="ingredient-group">
	            <h2>양념</h2>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">               
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	            <div class="ingredient-box1">
	                <input type="text" placeholder="대분류">
	                <input type="text" placeholder="중분류">
	                <input type="text" placeholder="소분류">
	                <input type="text" placeholder="재료명">
	                <input type="text" placeholder="수량">
	            </div>
	        </div>
	    </div>
	    <div class="recipe1">
	        <div class="recipe-number1">1</div>
	        <div class="recipe-info1">
	            <h2>레시피 상세 내용</h2>
	        </div>
	        <div class="recipe-image1">image</div>
	    </div>
	
	    <div class="recipe1">
	        <div class="recipe-number1">2</div>
	        <div class="recipe-info1">
	            <h2>레시피 상세 내용</h2>
	        </div>
	        <div class="recipe-image1">image</div>
	    </div>
	
	    <div class="update">
	        <button class="edit-btn1">단계 추가하기</button>
	        <button class="edit-btn2">수정완료</button>
	        <button class="edit-btn2">삭제</button>
	    </div>
	   <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
	</body>
</html>