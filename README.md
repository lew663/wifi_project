# 개발 환경
1. IDE : IntelliJ IDEA Community
2. Spring Boot 3.3.0
3. JDK 17
4. mysql
5. Spring Data JPA
6. Thymeleaf

# 작업 순서도
1. 공공데이터 포탈 가입 및 API 검색
2. 공공데이터 포탈에서 오픈 API 데이터 확인 및 요청 결과 확인
3. API 요청을 JAVA로 호출 및 결과 내용 테스트
4. ERD를 통한 데이터 모델링 진행
5. mysql DB 구성 및 연결 테스트 진행
6. mysql DB에 테이블 구성
7. 과제에 대한 페이지 구성 및 로직 진행

# 필수 준수사항
[기능사항]
- 공공 와이파이 정보 가져오기 기능 구현
- 내 위치 정보를 입력하면 가까운 위치에 있는 와이파이 정보 20개 보여주는 기능 구현
- 내가 입력한 위치정보에 대해서 조회하는 시점에 DB에 히스토리를 저장 및 보여주는 기능 구현
- 데이터베이스는 SQLite 이용(SQLite를 이용하기가 힘들면, MySQL(or MariaDB) 이용