<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/mypage/myRefridge.css"> 
</head>
<body>
		<!--  헤더-->
 		<jsp:include page ="/WEB-INF/views/include/header.jsp"></jsp:include> 
 		
   <main class="main">
        <div class="myPageMain">
        <section class="Info">
        <nav class="myInfomation">
            <div class="myPicture"></div>
            <div class="detailInformation">
                <div>이름 : 일용자</div>
                <div>닉네임 : 마셰코</div>
                <button class="deleteMember"><a href="/"></a></button>
                <button class="updateMember"><a href="/"></a></button>
            </div>
        </nav>
        </section>

    <!--       마이 냉장고 기본틀 -->
        <div class="myDetail-container">
            <div class="myPageMenu">
            <button><a href="/mypage/mypage">마이냉장고</a></button>
            <button><a href="/mypage/myBoard">내가 쓴글</a></button>
            <button><a href="/mypage/myReply">나의 댓글</a></button>
            </div>

    <!-- 		재료 등록 페이지 부분-->
        <div class="search-container">
	        <form class="search-form"  action="/#">
	            <input class="search-input" type="text" name="searchKeyword" placeholder="재료명을 입력하세요">
	            <button type="submit">검색</button>
	        </form>
    	</div>               
		
		<!-- 재료추가 모달 -->
		<div class="modal">
			<div class="modal_popup">
				<h3>재료 추가</h3>
<%-- 				수정 전
				<table>
					<tr>
						<th>카테고리</th>
						<th>재료명</th>
						<th>중량</th>
					</tr>
					<tr>
						<td>
							<select class="category">
							<c:forEach items= "${categoryList }" var="cateList">
								<option>"${cateList.firstCategory } >> ${cateList.secondCategory }"</option>
							</c:forEach>
							</select>
						</td>
						
						<td>
							<select >
								<option></option>
							</select>
						</td>			
								
						<td><input type="number">g</td>
					</tr>
				</table> --%>
				<table>
				    <tr>
				        <th>대분류</th>
				        <th>중분류</th>
				        <th>소분류</th>
				        <th>재료명</th>
				        <th>중량</th>
				        <th>유통기한</th>
				    </tr>
				    <tr>
				        <td>
				            <select id="firstCategory">
				                <option value="">-- 선택 --</option>
				                <c:forEach items="${categoryList}" var="cateList">
				                    <option value="${cateList.firstCategory}">${cateList.firstCategory}</option>
				                </c:forEach>
				            </select>
				        </td>
				
				        <td>
				            <select id="secondCategory">
				                <option value="">-- 선택 --</option>
				            </select>
				        </td>
				
				        <td>
				            <select id="thirdCategory">
				                <option value="">-- 선택 --</option>
				            </select>
				        </td>
				        
				        <td>
				            <select id="">
				                <option value="">-- 선택 --</option>
				            </select>
				        </td>
				        
				        <td>
							<input type="number">g
				        </td>
				        
				        <td>
							<input type="date">
				        </td>
				    </tr>
				</table>			

				<button type="button" class="insert_btn">저장</button>
				<button type="button" class="close_btn">닫기</button>
			</div>
		</div>
		
		
		<!-- 여기부터 메인 -->
		<main>
			<section>
				<button type="button" class="modal_btn">재료 추가</button>
			</section>
		</main>
		
        
        
        <div>
            <section class="my-sources" >
                <table>
                    <thead>
                        <tr>
                            <th class="num">보관</th>
                            <th class="source-name">재료명</th>
                            <th class="due-date">유통기한</th>
                            <th class="count">수량</th>
                            <th class="action">수정/삭제</th>
                        </tr>
                    </thead>
	                    <tbody>
	                        <div class="sources-Lists" id="coolStorage">
	                           	<c:forEach items= "${cList }" var="source">
		                            <tr  class="sources">
		                                <td class="num">
											<c:if test="${source.storageCode eq 'C' }">냉장</c:if>
										</td>
		                                <td class="source-name">${source.sourceName }</td>
		                                <td class="due-date">${source.dueDate }</td>
		                                <td class="count">${source.sourceCount }</td>
		                                <td class="action">
		                                    <button><a href="#">수정</a></button>
		                                    <button><a href="/mypage/delete?sourcesNo=${source.sourcesNo }&dueDate=${source.dueDate}&storageCode=C">삭제</a></button>
		                                </td>
		                             </tr>
	                           	 </c:forEach>
	                        </div>                        
	                    </tbody>           
                </table>
                
                <!-- 페이지네이션 --> 
                <div class="pagination">
						<c:if test="${startNavi ne 1 }">
							<a href="/mypage/myCoolStorage?page=${startNavi -1}" class="prev">&lt;</a>
						</c:if>
							<c:forEach begin="${startNavi }" end="${endNavi }" var="p" >
							<a href="/mypage/myCoolStorage?page=${p }">${p }</a>
							
							</c:forEach>	
						<c:if test="${endNavi ne maxPage}">
							<a href="/mypage/myCoolStorage?page=${endNavi +1 }" class="next">&gt;</a>
						</c:if>                    
                </div>
            </section>
        </div>
        </div>
        </div>
    </main>
 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	 		
 		
 	
    <script>
    
<%--         function insertPop() {
		window.open("<%=request.getContextPath()%>/insertSource.jsp", "insertSource",  "width=640, height=400")
        } --%>
        
        const modal = document.querySelector('.modal');
        const modalOpen = document.querySelector('.modal_btn');
        const modalClose = document.querySelector('.close_btn');
        
      //열기 버튼을 눌렀을 때 모달팝업이 열림
        modalOpen.addEventListener('click',function(){
          	//'on' class 추가
            modal.classList.add('on');
        });
        //닫기 버튼을 눌렀을 때 모달팝업이 닫힘
        modalClose.addEventListener('click',function(){
            //'on' class 제거
            modal.classList.remove('on');
        });        
       
        
        // gpt 꺼임
        // categoryList 데이터를 JS 객체로 변환
        const categoryData = [
            <c:forEach items="${categoryList}" var="cateList">
                {
                    firstCategory: "${cateList.firstCategory}",
                    secondCategory: "${cateList.secondCategory}",
                    thirdCategory: "${cateList.thirdCategory}"
                },
            </c:forEach>
        ];

        // DOM 요소 가져오기
        const firstSelect = document.getElementById("firstCategory");
        const secondSelect = document.getElementById("secondCategory");
        const thirdSelect = document.getElementById("thirdCategory");

        // 첫 번째 카테고리 변경 시
        firstSelect.addEventListener("change", function () {
            const selectedFirst = this.value;
            secondSelect.innerHTML = '<option value="">-- 선택 --</option>'; // 초기화
            thirdSelect.innerHTML = '<option value="">-- 선택 --</option>'; // 초기화

            // 선택된 firstCategory에 해당하는 secondCategory 추가
            const secondCategories = [...new Set(categoryData
                .filter(item => item.firstCategory === selectedFirst)
                .map(item => item.secondCategory))];

            secondCategories.forEach(category => {
                const option = document.createElement("option");
                option.value = category;
                option.textContent = category;
                secondSelect.appendChild(option);
            });
        });

        // 두 번째 카테고리 변경 시
        secondSelect.addEventListener("change", function () {
            const selectedFirst = firstSelect.value;
            const selectedSecond = this.value;
            thirdSelect.innerHTML = '<option value="">-- 선택 --</option>'; // 초기화

            // 선택된 firstCategory + secondCategory에 해당하는 thirdCategory 추가
            const thirdCategories = [...new Set(categoryData
                .filter(item => item.firstCategory === selectedFirst && item.secondCategory === selectedSecond)
                .map(item => item.thirdCategory))];

            thirdCategories.forEach(category => {
                const option = document.createElement("option");
                option.value = category;
                option.textContent = category;
                thirdSelect.appendChild(option);
            });
        });        
        
        

        
    </script> 		
 		
 
</html>