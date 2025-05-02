# 요리 레시피 추천 사이트
![Image](https://github.com/user-attachments/assets/df3175f3-8ee2-4eea-9679-c8249d6695a5)
----------------------------------------------------
# 냉장고 속 재료 기반 맞춤형 레시피 제공
## 팀 프로젝트 소개
![프로젝트소개](https://github.com/user-attachments/assets/8b0bc40c-2505-4432-9268-5de467d17d64)
## 역할 분담
![역할분담](https://github.com/user-attachments/assets/ad960004-05c1-447a-973d-953805e883dd)
## 차별성
![차별성](https://github.com/user-attachments/assets/067ad8df-2ff8-4ddc-b152-36a5a9c2471c)

## 프로젝트 개발환경
- DB : Oracle 11g xe 버전 이용
- Intellij IDEA 이용
## 프로젝트 실행 환경 구축(로컬)
1. 오라클 11g 설치 및 application.properties의
```properties
# Oracle Connection Setting
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username
spring.datasource.password
```
를 참고하여 로컬에 db 계정 생성
계정 생성 후 권한 부여 및 테이블 생성
테이블, 시퀀스 생성 및 데이터 삽입 스크립트

[ADD] db 스크립트 추가
- [A.ONEYO.sql](https://drive.google.com/file/d/1cSPpFyTk-KAC-y55RQNaak4GEStNA7by/view?usp=sharing)
# 1. 기술스택
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)<br>
![html5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/css3-%231572B6.svg?style=for-the-badge&logo=css3&logoColor=white)
![java  Script](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)<br>
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-FE7A16.svg?style=for-the-badge&logo=Eclipse&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)

# 2. 브랜치 전략
## Git Flow 방식
- 팀원 각자의 브랜치를 만들어 개발 진행
- 기능 구현이 완료되면 Main 브랜치에 병합
  ![git_flow](https://github.com/2405PublicJavaDev/sulgilddara/blob/main/img/github_flow.png?raw=true)
# 3. 프로젝트 구조
[프로젝트.PDF](https://drive.google.com/file/d/1arzy92_JuM-9a01Ubx2IDwtzkzLpSCXK/view?usp=sharing)
# 4. 주요기능 
### 회원관리 : 이솔
|기능명|상세|
|--|--|
|회원 가입|아이디, 비밀번호, 이름, 닉네임, 전화번호를 입력 후 가입하며 자신의 계정을 생성합니다. 회원가입 폼에는 일정한 형식을 지켜야 하며 만약 지키지 않을 시 오류가 납니다. |
|회원 정보 수정| 필요시 계정 정보를 수정할 수 있습니다. 아이디, 생년월일, 성별을 제외한 나머지 정보를 수정할 수 있습니다.|
|로그인 및 로그아웃|로그인하여 사이트의 레시피 등록, 나의 냉장고 속 재료 등록 및 삭제 게시판 글 작성 및 댓글 작성등의 기능을 사용할 수 있으며, 비회원은 레시피 열람 및 게시판 열람 등 기본적인 기능만 제한적으로 사용할 수 있습니다. 사용 후에는 로그아웃을 통해 계정을 안전하게 보호할 수 있습니다.|
|회원탈퇴|로그인한 상태에서 회원 탈퇴를 진행할 수 있습니다.|
|회원 정보 조회| 회원의 닉네임, 아이디, 이메일, 휴대전화 번호를 조회할 수 있습니다.|
|마이냉장고|현재 등록되어있는 재료명, 수량, 유통기한 등을 확인할 수 있습니다.|
|내가쓴글|마이페이지 내에서 내가 쓴글 버튼을 클릭하면 게시판에 내가 작성한 글을 확인할수 있습니다|
|나의 댓글| 마이페이지 내에서 나의 댓글 버튼을 클릭하면 내가 작성한 글을 확인 할수 있습니다|

### 레시피 : 김지용, 강우혁
|기능명|상세|
|--|--|
|레시피 등록|관리자 또는 사용자가 레시피를 등록하는 페이지입니다. 최소 1개이상의 주재료를 선택해야하며, 부재료, 사진은 생략가능합니다. |
|레시피 수정| 자신이 작성한 레시피를 수정 합니다. 제목, 재료, 펌부파일, 내용을 수정가능합니다.|
|레시피 검색|레시피는 제목, 요리명, 작성자로 검색하고, 검색시엔 레시피들이 조회순으로 보여줍니다. 작성자로 검색 시 작성자의 레시피가 조회순으로 보여줍니다.|
|레시피 추천(비회원)|비회원은 메인페이지에 보여지는 추천 레시피 외에 자신의 재료로 레시피 추천 받는것이 불가하며, 레시피 검색만 가능합니다.|
|레시피 추천(회원)| 로그인한 회원의 경우 등록된 마이냉장고의 재료를 활용하여 만들 수 있는 레시피를 레시피 전체 리스트 조회시 추천받을수 있습니다|

### 마이냉장고 : 이성수
|기능명|상세|
|--|--|
|냉장고 칸 분리 조회|마이페이지 내에 등록한 마이냉장고의 칸을 (냉동실, 냉장실) 분리하여 관리가 가능합니다. |
|재료 리스트 출력| 냉장고내에 등록된 재료의 리스트 전체를 볼 수 있습니다.|
|재료 리스트 검색|검색을 희망하는 재료의 등록된 상세정보(이름, 수량, 유통기한 등) 를 검색할 수 있습니다.|
|냉장고 재료 등록|새로운 재료나 이미 냉장고에 있더라도 소비기한 및 등록일이 다른 재료들을 등록할 수 있습니다.|
|냉장고 재료 삭제| 마이 냉장고내에 등록된 재료를 삭제 할 수 있다.|

### 게시판 : 배미애
|기능명|상세|
|--|--|
|게시글 작성|로그인한 사용자 및 관리자만 게시글을 등록할 수 있습니다. |
|게시글 조회| 게시글을 제목 및 내용으로 검색하고 등록순으로 출력할 수 있습니다.|
|게시글 수정|로그인 한 사용자 및 관리자는 자신이 작성한 게시글을 수정 할 수 있습니다.|
|게시글 삭제|새로운 재료나 이미 냉장고에 있더라도 소비기한 및 등록일이 다른 재료들을 등록할 수 있습니다.|
|댓글 등록| 사용자는 게시글에 댓글을 등록할 수 있습니다.|
|댓글 삭제| 사용자는 자신이 작성한 댓글을 삭제 할 수 있습니다.|

### 전체 회원관리 : 배미애
|기능명|상세|
|--|--|
|회원탈퇴| 관리자는 회원의 탈퇴요청 또는 내부규정에 의거하여 탈퇴시킬 수 있습니다. |
|회원조회| 관리자는 회원 아이디, 닉네임, 이름 등으로 조회하여 출력할 수 있다.|

# 5.개발일정
![개발일정](https://github.com/user-attachments/assets/9c867c03-307b-4882-a4f3-ab1c268a6db6)

# 6.화면 구현
### 메인페이지
![index.jsp](https://github.com/user-attachments/assets/d7b9f317-73bf-4ba7-b526-91245e2f3cc3)
##회원관리
### 비회원 로그인시 레시피 페이지
![recipeList.jsp](https://github.com/user-attachments/assets/8c709fb8-ea0c-4941-aeb8-f07d706b3fe2)
### 회원 로그인시 레시피 페이지
![recipeList.jsp](https://github.com/user-attachments/assets/8c709fb8-ea0c-4941-aeb8-f07d706b3fe2)
### 레시피 등록 페이지
![recipeList.jsp](https://github.com/user-attachments/assets/267e770e-c232-4dc9-ae30-aa53650352d4)
### 레시피 상세 페이지
![레시피 상세 페이지](https://github.com/user-attachments/assets/e7996bd7-a973-4e53-a7a6-239af1886989)
### 레시피 검색 페이지
![레시피 검색 페이지](https://github.com/user-attachments/assets/5747bf29-1b22-4d09-9495-d1a8534f45ed)
### 로그인
![login.jsp](https://github.com/user-attachments/assets/8d681cd7-ebff-4b63-89a6-958611a702e9)
### 회원가입
![memberjoin.jsp](https://github.com/user-attachments/assets/d3d37ceb-64f9-4df5-8b3b-d07d12c416c5)
### 아이디 찾기
![getid.jsp](https://github.com/user-attachments/assets/8fc9d98c-ef30-459a-a726-da380ffe155b)
### 비밀번호 찾기
![getpw.jsp](https://github.com/user-attachments/assets/472f27a2-fbb0-4585-906d-2ae0af8b8991)
### 회원정보수정
![updatemember.jsp](https://github.com/user-attachments/assets/3da72ada-3621-4074-b527-937dc51d9123)

## 마이페이지(나의냉장고)
### 마이페이지 / 나의 냉장고(냉동/냉장)
![mypage.jsp](https://github.com/user-attachments/assets/2a8df011-5b4c-441b-ba9e-db5a8f8b3660)
### 마이페이지 / 나의 냉장고/ 재료 선택
![myIceStorage.jsp](https://github.com/user-attachments/assets/68388d14-2a86-45ba-a50a-fcd454472e3d)
### 마이페이지 / 나의 냉장고/ 재료 수정
![myIceStorage.jsp](https://github.com/user-attachments/assets/36734b73-c3ba-426b-857c-84dd74e6dfac)
### 마이페이지 / 나의 냉장고/ 재료 추가
![updateStorage.jsp](https://github.com/user-attachments/assets/0c097667-1ad9-478e-9e1d-5bcd6459e33c)
### 마이페이지 / 나의 냉장고/ 재료 삭제
![deleteStorage.jsp](https://github.com/user-attachments/assets/2e3e045d-f6a4-4398-a957-e94e15d183c5)
### 마이페이지/ 내가쓴글 
![myBoard.jsp](https://github.com/user-attachments/assets/54abd17e-6f89-48f3-b367-c732c2fe0ca6)
### 마이페이지/나의 댓글
![myReply.jsp](https://github.com/user-attachments/assets/8b80fea4-63c5-49fe-91fc-e488b02cae44)

## 게시판






### 게시판 / 목록
![boardlist.jsp](https://github.com/user-attachments/assets/e319cc82-936e-4acb-932f-ae51d67c0eb0)
![boardlist2.jsp](https://github.com/user-attachments/assets/62711142-d48b-4736-83f1-9e76c0cb9fa6)
### 게시판 / 글쓰기
![boardinsert.jsp](https://github.com/user-attachments/assets/411d3f2a-bb4f-4670-98b8-f7d4eca84b13)
### 게시판 / 상세 페이지
![boarddetail.jsp](https://github.com/user-attachments/assets/e80f3e8f-439c-4bb6-aa02-ca2df8559996)
### 게시판 / 수정 페이지
![boardupdate.jsp](https://github.com/user-attachments/assets/f795ad37-65b8-44c7-bb17-63e06d37ef32)
![boardupdate2.jsp](https://github.com/user-attachments/assets/87757d3f-8d11-4899-b5cc-6cbd15dddfe7)
### 게시판 / 삭제 팝업
![boarddelete.jsp](https://github.com/user-attachments/assets/82d83ba2-2f7c-43dc-b0c7-668f035ff04b)
### 게시판 / 검색
![boardsearch.jsp](https://github.com/user-attachments/assets/a6a37784-f5b7-4d72-9101-93dab38bab45)


# 7. 프로젝트 후기
### 이솔: 사실, 구현을 과연 할 수 있을까 하는 걱정으로 설계를 시작했었지만 팀원분들 한분한분 각자 맡으신 부분을 잘 수행해주셔서 감사했습니다. 꼼꼼하게 하는 설계의 중요성을 많이 느끼게 되었습니다. 
### 이성수: 스스로 부족함과 성취감, 섬세한 설계의 중요성을 동시에 많이 느꼈고 착하고 소통이 잘되는 팀원들의 소중함이 좋았습니다. 
### 배미애: 처음에는 자신감이 많이 없었고 1인분만이라도 잘하자는 마음으로 시작했습니다. 그러나 팀원들과 함께 고민하고 서로 도와가며 조금이나마 성장했던 계기가 된것 같습니다. 시간이 조금더 있었다면 하는 아쉬움이 있지만 MVC 흐름에 대해서 더 이해하고 개발에 더 흥미를 느끼게 된 시간들이였습니다. 함께해준 팀원들과 강사님께 감사를 표합니다. 
### 강우혁: 우선 저와 함께 해준 팀원분들께 감사드립니다. 저의 아이디어로 프로젝트를 진행하면서 제가 부족한 점이 많았는데 다들 끝까지 함께 완성해주셔서 기쁩니다. 
### 김지용: 프로젝트를 진행하면서 우선순위를 정하고 팀원과의 소통을 통하여 진행하는것이 굉장히 중요하다는 것을 꺠닫게 되었고 자신의 부족한 점에 대해서 깨닫고 성장할 수 있는 기회가 된 것 같습니다. 막히는 부분이 있을때 도움을 주셨던 팀원 및 강사님께 감사드립니다.



# 프로젝트 산출문서
- [기획보고서](https://drive.google.com/file/d/1Y3C14sBiMuAqhevhRxZlfjbmgGT4GhmF/view?usp=sharing)
- [요구사항정의서](https://drive.google.com/file/d/1RgoGpFdt7A6zdXNJZFLO3oyVxlTvvoMP/view?usp=sharing)
- [와이어프레임](https://drive.google.com/file/d/1drb5eNbOQtC9XqX8JaLTMBPpR8I4RiNi/view?usp=sharing)
- [DB설계](https://drive.google.com/file/d/1SE5tLfgGzGzj8OrBYAIF9nInZ62CDEUw/view?usp=sharing)
- [시퀀스 다이어그램](https://drive.google.com/file/d/1irW7kdzmYZ89WgiY9pEnN1GOeHFss63n/view?usp=sharing)
- [최종보고서](https://drive.google.com/file/d/15LTXkWCVk_EyxEJraH7CNYtN0ssnEkft/view?usp=sharing)
- [프로젝스 소스 DB](https://drive.google.com/file/d/1cSPpFyTk-KAC-y55RQNaak4GEStNA7by/view?usp=sharing)
- [시연영상](https://drive.google.com/file/d/1DTl3d_0OV_ZmpOyd2yzz-2jdzmypbnID/view?usp=sharing)
