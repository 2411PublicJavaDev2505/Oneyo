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
6 months ago

[ADD] db 스크립트 추가
- [CineMates.sql](https://drive.google.com/file/d/1Xm6fRjywto54dU5G0n4-KvlnRUqk8l3q/view?usp=drive_link)
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
[프로젝트 구조.pdf]
# 4. 주요기능 
### 회원관리

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

# 5.개발일정
## 화면 구현
### 메인페이지
### 비회원시 레시피 페이지
### 로그인
### 회원가입
### 아이디 찾기
### 비밀번호 찾기
### 마이페이지 / 나의 냉장고
### 마이페이지 / 나의 냉장고/ 재료 선택

# 7. 프로젝트 후기

## 이솔:
## 이성수:
## 배미애:
## 강우혁:
## 김지용:


# 프로젝트 산출문서
- [기획보고서]
- [요구사항정의서] 
- [와이어프레임]
- [DB설계]
- [시퀀스 다이어그램]
- [클래스 다이어그램]
- [최종보고서]
- [프로젝스 소스 DB]
- [시연영상] 
