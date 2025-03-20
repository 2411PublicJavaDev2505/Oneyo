<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>레시피 페이지-상세</title>
		<link rel="stylesheet" href="../ONEYO/css/detail.css">
	    <link rel="stylesheet" href="../ONEYO/css/header.css">
	    <link rel="stylesheet" href="../ONEYO/css/footer.css">
	</head>
	<body>
	  
	   <jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
	    <main>
	        <div class="recipe-card">
	            <button class="edit-btn">수정</button>
	            <div class="image-placeholder">image</div>
	            <div class="recipe-info">
	                <div class="text1">레시피 명</div>
	                <div class="text2">작성자</div>
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
	            <div class="recipe-number">1</div>
	            <div class="recipe-info">
	                <h2>레시피 상세 내용</h2>
	            </div>
	            <div class="recipe-image">image</div>
	        </div>
	    
	        <div class="recipe">
	            <div class="recipe-number">2</div>
	            <div class="recipe-info">
	                <h2>레시피 상세 내용</h2>
	            </div>
	            <div class="recipe-image">image</div>
	        </div>
	    
	        <div class="recommend">
	            <button class="star">⭐</button>
	            <p>추천해요!</p>
	        </div>
	        <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
	</body>
</html>