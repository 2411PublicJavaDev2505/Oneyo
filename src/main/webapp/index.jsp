<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<link rel="stylesheet" href="../resources/css/index.css">
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
	 <!-- 메인 컨텐츠 -->
    <main class="main-content">
        <div class="recipe-container">
            <h2>오늘의 추천 레시피</h2>
            <p>양송이 크림 파스타</p>
            <button class="before-btn"> ◁ </button>
            <a href="/recipe/detail/10">
            <img src="../resources/img/pasta.jpg" alt="양송이 크림 파스타" class="recipe-image" data-recipe="양송이 크림 파스타">
            </a>
            <button class="next-btn">▷</button>
        </div>
    </main>
    	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	<script> 
	document.addEventListener('DOMContentLoaded', () => {
	    const recipeImage = document.querySelector('.recipe-image');
	    const recipeText = document.querySelector('.recipe-container p');
	    const beforeButton = document.querySelector('.before-btn');
	    const nextButton = document.querySelector('.next-btn');

	    const images = [
	        '../resources/img/양송이 크림 파스타.jpg',
	        '../resources/img/새우라멘.jpg',
	        '../resources/img/불고기덮밥.jpg'
	    ];

	    let currentImageIndex = 0;

	    function extractRecipeName(src) {
	        return src.split('/').pop().split('.')[0];
	    }

	    function updateImage(index) {
	        const newImageSrc = images[index];
	        recipeImage.src = newImageSrc;
	        recipeImage.alt = extractRecipeName(newImageSrc);
	        recipeImage.dataset.recipe = extractRecipeName(newImageSrc);
	        recipeText.textContent = extractRecipeName(newImageSrc);
	    }

	    beforeButton.addEventListener('click', () => {
	        currentImageIndex = (currentImageIndex - 1 + images.length) % images.length;
	        updateImage(currentImageIndex);
	    });

	    nextButton.addEventListener('click', () => {
	        currentImageIndex = (currentImageIndex + 1) % images.length;
	        updateImage(currentImageIndex);
	    });

	    updateImage(currentImageIndex);
	});


	</script>
</body>
</html>