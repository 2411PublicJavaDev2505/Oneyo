<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<link rel="stylesheet" href="../resources/css/index.css">
		</head>
	<body>	
	    	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	 <!-- 메인 컨텐츠 -->
    <main class="main-content">
        <div class="recipe-container">
            <h2>오늘의 추천 레시피</h2>
            <p>양송이 크림 파스타</p>
            <button class="before-btn"> ◁ </button>
            <img src="../resources/img/pasta.jpg" alt="양송이 크림 파스타" class="recipe-image" data-recipe="양송이 크림 파스타">
            
            <button class="next-btn">▷</button>
        </div>
    </main>
    	<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	<script> 
	    document.addEventListener('DOMContentLoaded', () => {
	        const recipeImage = document.querySelector('.recipe-image');
	        const beforeButton = document.querySelector('.before-btn');
	        const nextButton = document.querySelector('.next-btn');
	
	        const images = [
	            { src: '../resources/img/pasta.jpg', alt: '양송이 크림 파스타', recipe: '양송이 크림 파스타' },
	            { src: '../resources/img/salad.jpg', alt: '샐러드 파스타', recipe: '신선한 샐러드 파스타' },
	            { src: '../resources/img/steak.jpg', alt: '불고기 덮밥', recipe: '불고기 덮밥' }
	        ];
	
	        let currentImageIndex = 0;
	
	        function updateImage(index) {
	            const newImage = images[index];
	            recipeImage.src = newImage.src;
	            recipeImage.alt = newImage.alt;
	            recipeImage.dataset.recipe = newImage.recipe;
	        }
	
	        beforeButton.addEventListener('click', () => {
	            currentImageIndex = (currentImageIndex - 1 + images.length) % images.length;
	            updateImage(currentImageIndex);
	        });
	
	        nextButton.addEventListener('click', () => {
	            currentImageIndex = (currentImageIndex + 1) % images.length;
	            updateImage(currentImageIndex);
	        });
	    });
	</script>
</body>
</html>