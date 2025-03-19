<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <button class="write-recipe">레시피 작성하기</button>
            </div>
            <section class="recipe-list">
                <a href="#" class="recipe">
                    <div class="recipe-style">
                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
                        <section class="recipe-inf">
                            <p class="recipe-name">요리 이름</p>
                            <span class="recipe-writer">작성자</span>
                            <span class="views">조회수 : </span>
                        </section>
                    </div>
                </a>
                <a href="#" class="recipe">
                    <div class="recipe-style">
                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
                        <section class="recipe-inf">
                            <p class="recipe-name">요리 이름</p>
                            <span class="recipe-writer">작성자</span>
                            <span class="views">조회수 : </span>
                        </section>
                    </div>
                </a>
                <a href="#" class="recipe">
                    <div class="recipe-style">
                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
                        <section class="recipe-inf">
                            <p class="recipe-name">요리 이름</p>
                            <span class="recipe-writer">작성자</span>
                            <span class="views">조회수 : </span>
                        </section>
                    </div>
                </a>
                <a href="#" class="recipe">
                    <div class="recipe-style">
                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
                        <section class="recipe-inf">
                            <p class="recipe-name">요리 이름</p>
                            <span class="recipe-writer">작성자</span>
                            <span class="views">조회수 : </span>
                        </section>
                    </div>
                </a>
                <a href="#" class="recipe">
                    <div class="recipe-style">
                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
                        <section class="recipe-inf">
                            <p class="recipe-name">요리 이름</p>
                            <span class="recipe-writer">작성자</span>
                            <span class="views">조회수 : </span>
                        </section>
                    </div>
                </a>
                <a href="#" class="recipe">
                    <div class="recipe-style">
                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
                        <section class="recipe-inf">
                            <p class="recipe-name">요리 이름</p>
                            <span class="recipe-writer">작성자</span>
                            <span class="views">조회수 : </span>
                        </section>
                    </div>
                </a>
                <a href="#" class="recipe">
                    <div class="recipe-style">
                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
                        <section class="recipe-inf">
                            <p class="recipe-name">요리 이름</p>
                            <span class="recipe-writer">작성자</span>
                            <span class="views">조회수 : </span>
                        </section>
                    </div>
                </a>
                <a href="#" class="recipe">
                    <div class="recipe-style">
                        <img src="../resources/img/김치찌개냠냠굿.jpg" alt="요리 썸네일">
                        <section class="recipe-inf">
                            <p class="recipe-name">요리 이름</p>
                            <span class="recipe-writer">작성자</span>
                            <span class="views">조회수 : </span>
                        </section>
                    </div>
                </a>
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