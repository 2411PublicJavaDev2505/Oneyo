<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>레시피 상세 페이지</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/recipe/detail.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main class="main-container">
			<div class="recipe-card">
				<button class="edit-btn">수정</button>
				<div class="image-placeholder">
					<img src="" alt="등록된 사진이 없습니다."/>
				</div>
				<div class="recipe-info">
					<div class="text1">${recipe.recipeTitle }</div>
					<div class="text2">${recipe.memberNickName }</div>
					<div class="text2">조회수 : ${recipe.viewCount }</div>
				</div>
			</div>
			<div class="ingredient-container">
				<div class="ingredient-group">
					<h2>재료</h2>
					<c:forEach items="${sourceList }" var="source">
					<div class="ingredient-box">
						<span>${source.sourcesName }</span>
					</div>
					</c:forEach>
				</div>
			</div>
			<div class="recipe-step">
			    <c:forEach items="${recipe.stepList}" var="step">
			        <div class="step-container">
			            <div class="step-number">
			                <p>${step.stepNo }</p>
			            </div>
			            <div class="step-info">
			                <span>${step.stepContent }</span>
			            </div>
			            <div class="recipe-image">
			                <img src="" alt="등록된 사진이 없습니다.">
			            </div>
			        </div>
			    </c:forEach>
			</div>
		</main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</body>
</html>