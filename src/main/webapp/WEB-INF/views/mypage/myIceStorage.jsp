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
 		<c:choose>
			    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
			        <jsp:include page="/WEB-INF/views/include/headeradmin.jsp"></jsp:include>
			    </c:when>
			    <c:otherwise>
			       <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			    </c:otherwise>
			</c:choose>
		    
   <main class="main">
        <div class="myPageMain">
        <section class="Info">
        <nav class="myInfomation">
            <div class="myPicture"></div>
            <div class="detailInformation">
                <div>이름 : ${memberName}</div>
                <div>닉네임 : ${memberNickname}</div>
                <c:choose>
				    <c:when test="${sessionScope.member1.memberId eq 'ADMIN01'}">
				        <button class="deleteMember" ><a href="/admin/member">회원관리</a></button>
				    </c:when>
				    <c:otherwise>
				        <button class="deleteMember" ><a href="/member/delete?memberId=${memberId }">회원탈퇴</a></button>
				    </c:otherwise>
				</c:choose>
              <button class="updateMember" ><a href="/member/modify?memberId=${memberId }">회원정보수정</a></button>
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

    <!-- 		재료 검색 페이지 부분-->
        <div class="search-container">
	        <form class="search-form"  action="/mypage/search" method="post">
	            <input class="search-input" type="text" name="searchKeyword" placeholder="재료명을 입력하세요">
	            <button type="submit">검색</button>
	        </form>
    	</div>               
		
		<!-- 재료추가 모달 -->
		<div class="modal">
			<div class="modal_popup">
				<h3>재료 추가</h3>
				<form action="/mypage/myIceStorage" method="post">
						<input type="hidden" id="firstChoice" name="firstCategory" value="">
						<input type="hidden" id="secondChoice" name="secondCategory" value="">
						<input type="hidden" id="thirdChoice" name="thirdCategory" value="">
						<input type="hidden" id="sourceChoice" name="sourceName" value="">
						<input type="hidden" id="countChoice" name="sourceCount" value="">
						<input type="hidden" id="dueDateChoice" name="dueDate" value="">
							<table>
							    <tr>
							        <th>대분류</th>
							        <th>중분류</th>
							        <th>소분류</th>
							        <th>재료명</th>
							        <th>중량 (100g 단위)</th>
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
							            <select id="thirdCategory" >
							                <option value="">-- 선택 --</option>
							            </select>
							        </td>
							        
							        <td>
							            <select id="sourceName">
							                <option value="">-- 선택 --</option>
							            </select>
							        </td>
							        
							        <td>
										<input id="sourceCount" type="number" value="">g
							        </td>
							        
							        <td>
										<input id="dueDate" type="date" value="">
							        </td>
							    </tr>
							</table>			
						<!-- form 태그로 감싸서 카테고리 값 가져오기 input hidden -->
						<button type="submit" class="insert_btn">저장</button>
					</form>
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
                            <th class="count">중량</th>
                            <th class="action">수정/삭제</th>
                        </tr>
                    </thead>
	                    <tbody>
	                        <div class="sources-Lists" id="iceStorage">
	                           	<c:forEach items= "${iList }" var="source">
		                            <tr  class="sources">
		                                <td class="num">
		                                	<c:if test="${source.storageCode eq 'I' }">냉동</c:if>
		                                	</td>
		                                <td class="source-name">${source.sourceName }</td>
		                                <td class="due-date" value="${source.dueDate }">${source.dueDate }</td>
		                                <td class="count">${source.sourceCount }</td>
		                                <td class="action">
		                                	<form action="/mypage/myIceStorage" method="post">
		                                        <button type="button" class="edit-btn"
											        data-source-no="${source.sourcesNo}"
											        data-source-name="${source.sourceName}"
											        data-source-count="${source.sourceCount}"
											        data-due-date="${source.dueDate}">
											        수정
											    </button>
											    </form>
		                                    <form action="/mypage/delete" id="deleteForm" method="get">
		                                    	<input type="hidden" name="sourcesNo" value="${source.sourcesNo}">
		                                    	<input type="hidden" name="dueDate" value="${source.dueDate }">
		                                    	<input type="hidden" name="storageCode" value="${source.storageCode }">
		                                    <button type="button" onclick="deleteConfirm(${source.sourcesNo},${source.dueDate});">삭제</button>
		                                    </form>
		                                </td>
		                             </tr>
	                           	 </c:forEach>
	                        </div>                        
	                    </tbody>           
                </table>
                
                <!-- 페이지네이션 --> 
                <div class="pagination">
						<c:if test="${startNavi ne 1 }">
							<a href="/mypage/myIceStorage?page=${startNavi -1}" class="prev">&lt;</a>
						</c:if>
							<c:forEach begin="${startNavi }" end="${endNavi }" var="p" >
							<a href="/mypage/myIceStorage?page=${p }">${p }</a>
							
							</c:forEach>	
						<c:if test="${endNavi ne maxPage}">
							<a href="/mypage/myIceStorage?page=${endNavi +1 }" class="next">&gt;</a>
						</c:if>              
                </div>
            </section>
        </div>
        </div>
        </div>
    </main>
 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	 		

 	
      <script>
    	function deleteConfirm(sourcesNo, dueDate, storageCode) {
    		var result = confirm("삭제할거임?");
    		if(result) {
    			document.getElementById('deleteForm').submit();
    		}
    	}
      
        
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
                    thirdCategory: "${cateList.thirdCategory}",
                    sourceName: "${cateList.sourceName}"
                },
            </c:forEach>
        ];

        // DOM 요소 가져오기
        const firstSelect = document.getElementById("firstCategory");
        const secondSelect = document.getElementById("secondCategory");
        const thirdSelect = document.getElementById("thirdCategory");
        const sourceSelect = document.getElementById("sourceName");
        const countInsert = document.getElementById("sourceCount");
        const dueDateInsert = document.getElementById("dueDate");

	    // hidden input 요소 가져오기
	    const firstChoice = document.getElementById("firstChoice");
	    const secondChoice = document.getElementById("secondChoice");
	    const thirdChoice = document.getElementById("thirdChoice");
	    const sourceChoice = document.getElementById("sourceChoice");
	    const sourceCount = document.getElementById("countChoice");
	    const dueDate = document.getElementById("dueDateChoice");
        

	    
	    
	    
	    
	 // 첫 번째 카테고리 선택 시
	    firstSelect.addEventListener("change", function () {
	        const selectedFirst = this.value;
	        firstChoice.value = selectedFirst; // hidden input에 값 설정

	        secondSelect.innerHTML = '<option value="">-- 선택 --</option>';
	        thirdSelect.innerHTML = '<option value="">-- 선택 --</option>';

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

	 // 두 번째 카테고리 선택 시
	    secondSelect.addEventListener("change", function () {
	        const selectedFirst = firstSelect.value;
	        const selectedSecond = this.value;
	        secondChoice.value = selectedSecond; // hidden input에 값 설정
	        

	        thirdSelect.innerHTML = '<option value="">-- 선택 --</option>';

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
        
	 // 세 번째 카테고리 선택 시
	    thirdSelect.addEventListener("change", function () {
	        const selectedFirst = firstSelect.value;
	        const selectedSecond = secondSelect.value;
	        const selectedThird = this.value; 
	        thirdChoice.value = selectedThird;// hidden input에 값 설정
	        
	        // sourceName(재료명) 초기화
	        sourceSelect.innerHTML = '<option value="">-- 선택 --</option>';
	        
	        const sources = [...new Set(categoryData
	                .filter(item => item.firstCategory === selectedFirst && item.secondCategory === selectedSecond && item.thirdCategory === selectedThird)
	                .map(item => item.sourceName))];

	            sources.forEach(source => {
	                const option = document.createElement("option");
	                option.value = source;
	                option.textContent = source;
	                sourceSelect.appendChild(option);
	            }); 	        
	    });
	 
	 
	    sourceSelect.addEventListener("change", function () {
	        sourceChoice.value = this.value; // hidden input에 값 설정
	    });
	    
	    
        
	    // 재료 수량 입력하는거 나중에 변동 제한 둘거임 100g으로
	    countInsert.addEventListener("change", function () {
	    	const countSource = this.value;
	    	sourceCount.value = countSource;
	    })
	    // 유통기한 선택
	    dueDateInsert.addEventListener("change", function () {
	    	const insertDueDate = this.value;
	    	dueDate.value = insertDueDate;
	    })

	    
	    
	    // 수정 버튼 클릭 이벤트
			document.querySelectorAll(".edit-btn").forEach(btn => {
	    	btn.addEventListener("click", function () {
        // 현재 선택한 데이터 가져오기
		        const sourceNo = this.getAttribute("data-source-no");
		        const sourceName = this.getAttribute("data-source-name");
		        const sourceCount = this.getAttribute("data-source-count");
		        const dueDate = this.getAttribute("data-due-date");

        // 모달 열기
        document.querySelector(".modal").style.display = "block";

        	// 기존 데이터 입력
	        document.getElementById("sourceChoice").value = sourceName; // 숨김 input
	        document.getElementById("countChoice").value = sourceCount; 
	        document.getElementById("dueDateChoice").value = dueDate; 

	        // 입력 필드 채우기
	        document.getElementById("sourceName").innerHTML = `<option value="${sourceName}" selected>${sourceName}</option>`;
	        document.getElementById("sourceCount").value = sourceCount;
	        document.getElementById("dueDate").value = dueDate;

	        // 카테고리 선택 비활성화
	        document.getElementById("firstCategory").setAttribute("disabled", true);
	        document.getElementById("secondCategory").setAttribute("disabled", true);
	        document.getElementById("thirdCategory").setAttribute("disabled", true);
	        document.getElementById("sourceName").setAttribute("disabled", true);
	
	        // form의 action 변경 (수정 API 호출)
	        document.querySelector(".modal form").setAttribute("action", "/mypage/updateSource?sourcesNo=" + sourceNo);
	    });
	});

	// 모달 닫기 버튼
		document.querySelector(".close_btn").addEventListener("click", function () {
	    document.querySelector(".modal").style.display = "none";
	
	    // 폼 리셋 및 비활성화 해제
	    document.querySelector(".modal form").reset();
	    document.getElementById("firstCategory").removeAttribute("readonly");
	    document.getElementById("secondCategory").removeAttribute("disabled");
	    document.getElementById("thirdCategory").removeAttribute("disabled");
	    document.getElementById("sourceName").removeAttribute("disabled");
	});
	    
	    

		</script>
	
 	</body>
 
</html>