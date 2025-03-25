<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>레시피 페이지-등록</title>
		<link rel="stylesheet" href="../resources/css/recipe/insert.css">
	</head>
	<body>
	  
	   <jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
	    <main>
	        <div class="recipe-card">
	            <button class="edit-btn">등록</button>
	            <div class="image-placeholder">
	            	<image src="" alt="레시피 사진"/>
	            </div>
	            <div class="recipe-info">
	                <div class="text1">레시피 명: {recipeTitle}</div>
	                <div class="text2">작성자: {recipeWriter}</div>
	                <div class="text2">조회수:0</div>
	            </div>
	        </div>
	    </main>
	    
	        <div class="ingredient-container">
	            <div class="ingredient-group">
	                <h2>재료</h2>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	            </div>
	            <div class="ingredient-group">
	                <h2>양념</h2>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	                <div class="ingredient-box">
	                    <input type="text" placeholder="재료명">
	                    <input type="text" placeholder="수량">
	                </div>
	            </div>
	        </div>
	        <div class="recipe">
	            <div class="recipe-number"></div>
	            <div class="recipe-info">
	                <textarea class="recipe-content" placeholder="레시피 내용을 단계별로 입력해주세요">
	                </textarea>
	            </div>
	            <div class="recipe-image">
	            	<img src="" alt="레시피 사진"/>
	            </div>
	        </div>
	        <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
	</body>
</html>