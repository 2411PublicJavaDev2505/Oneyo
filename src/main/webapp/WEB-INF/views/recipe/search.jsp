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
	<c:choose>
		    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
		        <jsp:include page="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
		    </c:when>
		    <c:otherwise>
		       <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		    </c:otherwise>
		</c:choose>
	<div class="recipe-container">
		<main class="recipe-main">
            <div class="button-container">
               
                <button class="write-recipe"> <a href="/recipe/insert">레시피 작성하기 </a></button>
               
            </div>
            <section class="recipe-list">
	            <c:forEach items="${searchList}" var="recipe">
	                <a href="/recipe/detail/${recipe.recipeNo }" class="recipe">
	                    <div class="recipe-style">
	                        <img src="${pageContext.request.contextPath}/resources/img/${recipe.fileName }" alt="요리 썸네일">
	                        <section class="recipe-inf">
	                            <p class="recipe-name">${recipe.recipeTitle }</p>
								<span class="recipe-writer">${recipe.memberNickName }</span>
	                            <span class="views">조회수 : ${recipe.viewCount }</span>
	                        </section>
	                    </div>
	                </a>
	            </c:forEach>
			</section>
			
		</main>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>