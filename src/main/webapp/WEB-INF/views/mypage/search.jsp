<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>냉장고에서 정보찾기~~</title>
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
				                <div>이름 :${memberName}</div>
				                <div>닉네임 : ${memberNickname}</div>
				                <div>전화번호 : ${memberPhone}</div>
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
			    <!-- 마이 냉장고 기본틀 -->
			        <div class="myDetail-container">
			            	<div class="myPageMenu">
					            <button><a href="/mypage/mypage">마이냉장고</a></button>
					            <button><a href="/mypage/myBoard">내가 쓴글</a></button>
					            <button><a href="/mypage/myReply">나의 댓글</a></button>
			            	</div>			
			    <!-- 재료 검색 페이지 부분-->
			        <div class="search-container">
				        <form class="search-form"  action="/mypage/search" method="post">
				            <input class="search-input" type="text" name="searchKeyword" placeholder="재료명을 입력하세요" value="${searchKeyword }">
				            <button type="submit">검색</button>
				        </form>
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
		                           	<c:forEach items= "${sList}" var="source">
				                            <tr  class="sources">
				                            	<c:if test="${source.storageCode eq 'I' }"><td class="num">냉동 </td></c:if>
				                            	<c:if test="${source.storageCode eq 'C' }"><td class="num">냉장 </td></c:if>
				                                <td class="source-name">${source.sourceName }</td>
				                                <td class="due-date" value="${source.dueDate }">${source.dueDate }</td>
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
										<a href="/mypage/search?page=${startNavi -1}" class="prev">&lt;</a>
									</c:if>
									
										<c:forEach begin="${startNavi }" end="${endNavi }" var="p" >
										<a href="/mypage/searchStorage?page=${p }">${p }</a>
										</c:forEach>	
										
									<c:if test="${endNavi ne maxPage}">
										<a href="/mypage/searchStorage?page=${endNavi +1 }" class="next">&gt;</a>
									</c:if>              
			                </div>
			            </section>
			        </div>
			        </div>
			        </div>
			    </main>
 		<jsp:include page = "/WEB-INF/views/include/footer.jsp"></jsp:include> 	 		
</body>
</html>