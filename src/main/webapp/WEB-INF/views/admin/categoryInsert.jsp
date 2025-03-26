<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>관리자-회원관리</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mypage/myReply.css"> 
	<link rel ="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
	<link rel ="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/headeradmin.css">
</head>
<body>
	<!-- 헤더 -->
	<jsp:include page ="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
	<main class="main">
	    <div class="myPageMain">
		    <section class="Info"> <!-- 왼쪽 -->
		    <nav class="myInfomation">
		        <div class="myPicture"></div>
		        <div class="detailInformation">
		            <div>이름 : ${memberName }</div>
		            <div>닉네임 : ${memberNickname }</div>
					<button class="deleteMember" onclick="location.href='member/delete?memberId=${memberId }'">회원탈퇴</button>
	              <button class="updateMember"  onclick="location.href='member/modify'">회원정보수정</button>
		        </div>
		    </nav>
		    </section>
	
			<!-- 마이 페이지 기본틀 -->
		    <div class="myDetail-container">
		        <div class="adminMenu">
			        <button><a href="/admin/member">전체 회원 정보</a></button>
			        <button><a href="/category/insert">재료 관리</a></button>
		        </div>			        

	
			    <div>
			        <section class="my-sources">
			        	<div class="category-controller">
			            <table> <!-- 회원 목록 --> 
			            
			            	<!-- 카테고리추가 -->
							<select id="choiceCategory">
							    <option value="">-- 카테고리 선택 --</option>
							    <c:forEach items="${cList}" var="cate">
							        <option value="${cate.categoryNo},${cate.firstCategory},${cate.secondCategory},${cate.thirdCategory}">
							            ${cate.firstCategory} >> ${cate.secondCategory} >> ${cate.thirdCategory}
							        </option>
							    </c:forEach>
							</select>
							
							<table>
							    <thead>
							        <tr>
							            <th>1차 카테고리</th>
							            <th>2차 카테고리</th>
							            <th>3차 카테고리</th>
							            <th>처리</th>
							        </tr>
							    </thead>
							    <tbody>
							        <tr>
							            <td><input type="text" id="firstCategory" name="firstCategory"></td>
							            <td><input type="text" id="secondCategory" name="secondCategory"></td>
							            <td><input type="text" id="thirdCategory" name="thirdCategory"></td>
							            <td>
							                <button type="button" id="registerBtn">등록</button>
							                <button type="button" id="updateBtn">수정</button>
							            </td>
							        </tr>
							    </tbody>
							</table>
							
							<form id="categoryForm" action="/admin/category/insertOrUpdate" method="post">
							    <input type="hidden" id="actionType" name="actionType">
							    <input type="hidden" id="hiddenCategoryNo" name="categoryNo">
							    <input type="hidden" id="hiddenFirstCategory" name="hiddenFirstCategory">
							    <input type="hidden" id="hiddenSecondCategory" name="hiddenSecondCategory">
							    <input type="hidden" id="hiddenThirdCategory" name="hiddenThirdCategory">
							</form>





			            </table>
			            </div>
			        </section>
			    </div>
			</div>
	    </div>		
	</main>
	<!-- 푸터 -->
	<jsp:include page ="/WEB-INF/views/include/footer.jsp"></jsp:include>
	
	
	
	
	
	<script>
	
		document.addEventListener("DOMContentLoaded", function () {
	    const categorySelect = document.getElementById("choiceCategory");
	    const firstCategory = document.getElementById("firstCategory");
	    const secondCategory = document.getElementById("secondCategory");
	    const thirdCategory = document.getElementById("thirdCategory");
	    const registerBtn = document.getElementById("registerBtn");
	    const updateBtn = document.getElementById("updateBtn");
	    const actionType = document.getElementById("actionType");
	    const categoryForm = document.getElementById("categoryForm");

	    const hiddenCategoryNo = document.getElementById("hiddenCategoryNo");
	    const hiddenFirstCategory = document.getElementById("hiddenFirstCategory");
	    const hiddenSecondCategory = document.getElementById("hiddenSecondCategory");
	    const hiddenThirdCategory = document.getElementById("hiddenThirdCategory");

	    // 카테고리 선택 시 input 태그에 값 넣기
	    categorySelect.addEventListener("change", function () {
	        const selectedValue = this.value;
	        if (selectedValue) {
	            const [categoryNo, first, second, third] = selectedValue.split(",");
	            hiddenCategoryNo.value = categoryNo.trim();
	            firstCategory.value = first.trim();
	            secondCategory.value = second.trim();
	            thirdCategory.value = third ? third.trim() : "";
	        } else {
	            hiddenCategoryNo.value = "";
	            firstCategory.value = "";
	            secondCategory.value = "";
	            thirdCategory.value = "";
	        }
	    });

	    // 등록 버튼 클릭 시
	    registerBtn.addEventListener("click", function () {
	        if (!firstCategory.value.trim() || !secondCategory.value.trim()) {
	            alert("1차, 2차 카테고리는 필수 입력 항목입니다.");
	            return;
	        }

	        actionType.value = "insert";
	        hiddenFirstCategory.value = firstCategory.value.trim();
	        hiddenSecondCategory.value = secondCategory.value.trim();
	        hiddenThirdCategory.value = thirdCategory.value.trim();

	        categoryForm.submit();
	    });

	    // 수정 버튼 클릭 시
	    updateBtn.addEventListener("click", function () {
	        if (!categorySelect.value) {
	            alert("수정할 카테고리를 먼저 선택해주세요.");
	            return;
	        }

	        actionType.value = "update";
	        hiddenFirstCategory.value = firstCategory.value.trim();
	        hiddenSecondCategory.value = secondCategory.value.trim();
	        hiddenThirdCategory.value = thirdCategory.value.trim();

	        categoryForm.submit();
	    });
	});	
	</script>
	
</body>



</html>