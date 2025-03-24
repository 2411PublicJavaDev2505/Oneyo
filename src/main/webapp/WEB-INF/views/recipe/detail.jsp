<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>레시피 페이지-상세</title>
		<link rel="stylesheet" href="../resources/css/detail.css">
	    <link rel="stylesheet" href="../resources/css/header.css">
	    <link rel="stylesheet" href="../resources/css/footer.css">
	</head>
	<body>
	  
	   <jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
	    <main>
	        <div class="recipe-card">
	            <button class="edit-btn">.</button>
	            <div class="image-placeholder">image</div>
	            <div class="recipe-info">
	                <div class="text1">.</div>
	                <div class="text2">.</div>
	                <div class="text2"></div>
	            </div>
	        </div>
	    </main>
	       
	       <div class="recipe-card">
	            <button class="edit-btn">수정</button>
	            <div class="image-placeholder">image</div>
	            <div class="recipe-info">
					<div class="text1">${recipe.recipeTitle }</div>
	                <div class="text2">${recipe.memberNickName }</div>
	                <div class="text2">조회수 : ${recipe.viewCount }</div>       
	           </div>
	        </div>
	        <div class="ingredient-container">
	            <div class="ingredient-group">
	                <h2>재료</h2>
	                <c:forEach items="${rList }" var="recipe">
	                <div class="ingredient-box">
	                    <span class="ingredient_name"></span>
	                	<span class="ingredient-amount"></span>
	                </div>
	                </c:forEach>
	            </div>
	        </div>
	        <div class="recipe">   
	            <div class="ingredient-group">
	            	<h2>레시피 상세 내용</h2>
	                <c:forEach items="${rList }" var="recipe">
	                <div class="ingredient-box">
	                	<p>${recipe.stepNo }</p>
	                    
	                </div>
	                </c:forEach>
	            </div>
	        </div>
	        <jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	
	</body>
</html>