<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>레시피 입력</title>
		<link rel="stylesheet" href="../resources/css/header.css">
		<link rel="stylesheet" href="../resources/css/recipe/insert.css">
		<link rel="stylesheet" href="../resources/css/footer.css">
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<main class="main-container">
			<div class="recipe-card">
				<div class="image-placeholder">
				</div>
				<div class="recipe-info">
					<div class="text1">
						<input type="text">
					</div>
					<div class="text2">${recipe.memberNickName }</div>
				</div>
			</div>
			<div class="ingredient-container">
				<div class="ingredient-group">
					<h2>재료</h2>
					<div class="ingredient-box">
						<input type="text" />
					</div>
				</div>
			</div>
			<div class="recipe-step">
				<div class="step-container">
					<div class="step-number">
				     	<p>${step.stepNo }</p>
				    </div>
				    <div class="step-info">
				       <input type="text" class="input-step-content"/>
				   	</div>
				   		<div class="recipe-image">
				    </div>
				</div>
			</div>
		</main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</body>
</html>