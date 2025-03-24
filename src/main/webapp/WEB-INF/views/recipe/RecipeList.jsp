<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Recipe List</title>
	<link rel="stylesheet" href="../resources/css/header.css">
	<link rel="stylesheet" href="../resources/css/recipe-list/recipeList.css">
	<link rel="stylesheet" href="../resources/css/footer.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<div class="recipe-container">
		<main class="recipe-main">
            <div class="button-container">
                <a href="/recipe/insert">
                	<button class="write-recipe">레시피 작성하기</button>
                </a>
            </div>
            <section class="recipe-list">
	            <c:forEach items="${rList }" var="recipe">
	                <a href="/recipe/detail?recipeNo=${recipe.recipeNo }" class="recipe">
	                    <div class="recipe-style">
	                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
	                        <section class="recipe-inf">
	                            <p class="recipe-name">${recipe.recipeTitle }</p>
								<span class="recipe-writer">${recipe.memberNickName }</span>
	                            <span class="views">조회수 : ${recipe.viewCount }</span>
	                        </section>
	                    </div>
	                </a>
	            </c:forEach>
			</section>
			<div class="pagination">
                <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
            </div>
		</main>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>