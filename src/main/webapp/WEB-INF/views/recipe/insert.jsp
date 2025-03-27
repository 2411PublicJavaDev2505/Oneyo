<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>레시피 등록 페이지</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/recipe/detail.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
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
		<main class="main-container">
			<div class="recipe-card">
				<form action="/recipe/insert" method="post">
					<div class="image-placeholder">
						<img src="" alt="등록된 사진이 없습니다."/>
					</div>
						<div class="recipe-info">
							<input type="text" name="recipeTitle" placeholder="제목을 입력하세요"><br>
							<div class="text2">작성자 : ${memberId}</div>
						</div>
					</div>
					<div class="ingredient-container">
						<div class="ingredient-group">
							<h2>재료 (3가지 필수 선택)</h2>
								<div class="ingredient-box">
									<select name="firstSource">
										<c:forEach items="${sList}" var="source">
											<option >${source.sourcesName }</option>
										</c:forEach>
											</select><br>
									<select name="secondSource">
										<c:forEach items="${sList}" var="source">
											<option>${source.sourcesName }</option>
										</c:forEach>
									</select><br>
									<select name="thirdSource">
										<c:forEach items="${sList}" var="source">
											<option>${source.sourcesName }</option>
										</c:forEach>
									</select><br>
								</div>
							</div>
<<<<<<< HEAD

							
						</div>
						<input type="hidden" id="firstChoice" name="firstSource" value="">
						<input type="hidden" id="secondChoice" name="secondSource" value="">
						<input type="hidden" id="thirdChoice" name="thirdSource" value="">						
						<div class="recipe-step">
					        <div class="step-container">
					            <div class="step-number">
					                <p>1</p>
					            </div>
					            <div class="step-info">
					                <input type="text" name="stepInfo1" placeholder="레시피를 입력하세요" ></input>
					                <input type="text" name="stepAmount1" placeholder="수량" >g</input>
					            </div>
					            <div class="recipe-image">
					                <img src="" alt="등록된 사진이 없습니다.">
					            </div>
					        </div>
					        <div class="step-container">
					            <div class="step-number">
					                <p>2</p>
					            </div>
					            <div class="step-info">
					                <input type="text" name="stepInfo2" placeholder="레시피를 입력하세요" ></input>
					                <input type="text" name="stepAmount2" placeholder="수량">g</input>
					            </div>
					            <div class="recipe-image">
					                <img src="" alt="등록된 사진이 없습니다.">
					            </div>
					        </div>
					        <div class="step-container">
					            <div class="step-number">
					                <p>3</p>
					            </div>
					            <div class="step-info">
					                <input type="text" name="stepInfo3" placeholder="레시피를 입력하세요" ></input>
					                <input type="text" name="stepAmount3" placeholder="수량" >g</input>
=======
						</div>
						<input type="hidden" id="firstChoice" name="firstSource" value="">
						<input type="hidden" id="secondChoice" name="secondSource" value="">
						<input type="hidden" id="thirdChoice" name="thirdSource" value="">						
						<div class="recipe-step">
					        <div class="step-container">
					            <div class="step-number">
					                <p>1</p>
					            </div>
					            <div class="step-info">
					                <input type="text" name="stepInfo1" placeholder="레시피를 입력하세요" ></input>
					            </div>
					            <div class="recipe-image">
					                <img src="" alt="등록된 사진이 없습니다.">
					            </div>
					        </div>
					        <div class="step-container">
					            <div class="step-number">
					                <p>2</p>
					            </div>
					            <div class="step-info">
					                <input type="text" name="stepInfo2" placeholder="레시피를 입력하세요" ></input>
					            </div>
					            <div class="recipe-image">
					                <img src="" alt="등록된 사진이 없습니다.">
					            </div>
					        </div>
					        <div class="step-container">
					            <div class="step-number">
					                <p>3</p>
					            </div>
					            <div class="step-info">
					                <input type="text" name="stepInfo3" placeholder="레시피를 입력하세요" ></input>
>>>>>>> refs/remotes/origin/kangu
					            </div>
					            <div class="recipe-image">
					                <img src="" alt="등록된 사진이 없습니다.">
					            </div>
					        </div>
					    <button class="insert-btn">등록</button>					
				</form>
				</div>
			</main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		
		
		<script>
		const firstSelect = document.querySelector("firstSource");
		const secondSelect = document.querySelector("secondSource");
		const thirdSelect = document.querySelector("thirdSource");
			
		const firstChoice = document.querySelector("firstChoice");
		const secondChoice = document.querySelector("secondChoice");
		const thirdChoice = document.querySelector("thirdChoice");
		
		
		firstSelect.addEventListener("change", function() {
		const selectFirst = this.value;
		firstChoice.value = selectedFirst;
		)};
		
		secondSelect.addEventListener("change", function() {
		const selectSecond = this.value;
		secondChoice.value = selectedSecond;
		)};
		
		thirdSelect.addEventListener("change", function() {
		const selectThird = this. value;
		thirdChoice.value = selectedThird;
		)};

		
		
		
		</script>
		
	</body>
</html>