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
               
                <button class="write-recipe"> <a href="/recipe/insert">레시피 작성하기 </a></button>
               
            </div>
            <section class="recipe-list">
	            <c:forEach items="${rList }" var="recipe">
	                <a href="/recipe/detail/${recipe.recipeNo }" class="recipe">
	                    <div class="recipe-style">
	                        <img src="/Oneyo/src/main/webapp/resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
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
				<a href="/board/list?currentPage=1"> ◁◁ </a>
				<c:if test= "${startNavi ne 1 }">
					<a href="/board/list?currentPage=${startNavi-1 }" class="prev">◀</a>
				</c:if>	
				<c:forEach begin="${startNavi }" end="${endNavi }" var="p">
					<a href="/board/list?currentPage=${p }">${p }</a>
				</c:forEach>					
				<c:if test="${endNavi ne maxPage }">
					<a href="/board/list?currentPage=${endNavi+1 }" class="next">▶</a>
				</c:if>    
	           	<a href="/board/list?currentPage=${maxPage }"> ▷▷ </a>
            </div>
		</main>
	</div>
	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
</body>
</html>