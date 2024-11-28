# 04 ~ 06강 Spring Framework 환경 구축

# JDK 11버전 설치 & 환경 구축

- [개발 환경 구축하러 가기](https://blog.naver.com/coding_music/223457414418)

# STS3 다운

[STS3 설치하러 가기](https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3)

- OS에 맞는 버전을 찾아서 다운

![image](https://github.com/user-attachments/assets/dd5828a7-f633-4342-af90-f51cb52b1841)

- STS 실행 파일

![image 1](https://github.com/user-attachments/assets/88a01d31-851f-4890-944c-0d69e0037be4)

# STS3 환경 구축

- windows → preferences → 검색창 encoding 검색 → encodingType을 ‘UTF-8’로 바꿔준다.

![image 2](https://github.com/user-attachments/assets/91370ef3-75d1-45bf-b7a3-4bfe599170f4)

- Limit console output 해체

![image 3](https://github.com/user-attachments/assets/d195ae0b-8542-40b1-815b-4ce53634cdfd)

- 내장 서버를 지워준다.

![image 4](https://github.com/user-attachments/assets/bd5dd3d3-f2d3-431e-b21e-23142e5b9b05)

# TOMCAT 설치

- [톰캣 설치하러 가기](https://tomcat.apache.org/)
- 내장 서버를 지워준 곳을 클릭 후 설치한 톰캣의 위치를 등록시켜준다.

![image 5](https://github.com/user-attachments/assets/d35801f3-2fa6-4461-a8a4-283268fe0d48)

- 톰캣을 더블 클릭하여 overview로 이동한 뒤 포트번호를 ‘10000’으로 변경해준다.

![image 6](https://github.com/user-attachments/assets/12a4b9d5-aafe-4b8e-95f0-85687bc175b6)

- 표시한 곳을 체크해 놓으면 속도가 더 빨라진다.

![image 7](https://github.com/user-attachments/assets/f55c22eb-4a36-4752-a7e6-61dcf3d46863)

# STS3 환경 구축 정리

1. 기존 서버 삭제
2. 톰캣 서버 등록
3. encodingType을 UTF-8로 설정
4. Run/Debug/Console 설정에서 Limit console output 체크 해체

# 프로젝트 생성

- Spring Legacy Project를 선택해준다.

![image 8](https://github.com/user-attachments/assets/14d845b1-b3eb-43bf-8599-e254cfe0e758)


- Spring MVC Project 선택

![image 9](https://github.com/user-attachments/assets/36b5c208-0ea1-4c4b-92b2-3666619a68cd)

- controller를 설정해준다.

![image 10](https://github.com/user-attachments/assets/7984997a-3aa8-4411-98b9-c40c56e668f8)

- .controller까지 있어야 하는데 없을 때 Rename 을 눌려 패키지 이름을 재설정 해준다.
    
![image 11](https://github.com/user-attachments/assets/63001cdd-80ff-46e0-9071-2294f53dd627)

- 필요한 파일이 다운받아지고 패키지명을 controller까지 붙여준다.

![image 12](https://github.com/user-attachments/assets/23cf427d-b4d1-4ad1-8690-9942c0abfeb3)

# Spring MVC가 안보일 때

1. sts3 종료 후 워크스페이스 이동
2. 다음 경로로 이동 D:\DDAZUA\SpringFramework\work\.metadata\.plugins\org.springsource.ide.eclipse.commons.content.core

![image 13](https://github.com/user-attachments/assets/42fc138f-6bc6-409a-b53d-575711c8c4e8)

3. 해당 폴더에 다음 파일 붙여넣기
   
[https-content.zip](https://github.com/user-attachments/files/17945784/https-content.zip)

# STS3 프로젝트 설정

- 프로젝트의 porm.xml을 클릭 후 프로젝트를 구축한 환경과 맞게 소스 코드를 변경해준다.

![image 14](https://github.com/user-attachments/assets/f7edda2d-2fa4-4a32-82a4-a2dbba749c75)

- prom.xml을 수정 후 프로젝트를 업데이트 해준다.

![image 15](https://github.com/user-attachments/assets/cca6fa6a-6a98-464c-8e69-832b2ec0eafa)

- Force Update를 체크해서 강제로 업데이트

![image 16](https://github.com/user-attachments/assets/180bf430-e3ac-44ec-a62f-72dc0c24e978)

# Lombok(롬복) 라이브러리란?

- Lombok을 이용하면 JAVA 개발 시 getter/setter, toString(), 생성자 등을 @Data등의 어노테이션을 통해 자동으로 생성해준다.
- 즉 코드의 양을 줄여주고 간단하게 해준다.
- [롬복 설치하러 가기](https://projectlombok.org/download)

# Lombok 설치

- 롬복의 확장자가 실행이 안될거 같으면 롬복의 파일 주소 클릭 후 ‘cmd’를 입력하여 cmd 창에서 실행시켜준다.

![image 17](https://github.com/user-attachments/assets/8184600d-d2a5-412b-92ce-15fc894e1c3c)

- 주소에 cmd 입력 후 엔터 입력
    
![image 18](https://github.com/user-attachments/assets/301a9677-351c-46e1-afb8-99f2fd251f67)
    
- ‘cmd 창에서 java -jar lombok.jar’입력

![image 19](https://github.com/user-attachments/assets/7f320faf-3625-41d5-8f5c-52bbff5c0dc0)

- 표시한 곳 클릭 후 설치한 STS3 의 위치를 잡아준다.

![image 20](https://github.com/user-attachments/assets/6a1352f9-787b-4936-895d-c4097fbdcad8)

- 경로를 잡아준 후 install/update를 눌려준다.

![image 21](https://github.com/user-attachments/assets/2db17f1f-aec2-4249-89a8-7340619ae587)

- 설치 후 STS3.exe 위치에 Lombok이 있으면 성공

![image 22](https://github.com/user-attachments/assets/90ef7492-baf6-4c80-ad7e-dedca1c9c773)

# Lombok 설치 정리

1. google에 lombok 검색
2. Download - Project Lombok
3. 실행(롬복 설치된 경로 주소에 cmd 입력 후 ‘java -jar lombok.jar’으로 실행)
4. Specify location 클릭
5. STS.exe 경로 선택
6. install 클릭
7. STS.exe 경로에 lombok 유무 확인

# 프로젝트 기본 경로

1. src/main/java
    - 서버단 JAVA 파일
2. src/test/java
    - 단위 테스트를 위한 JAVA 파일
3. src/main/resources
    - src/main/java 관련 설정 파일
4. src/test/resources
    - src/main/test 관련 설정 파일
5. src/main/webapp/WEB-INF/views
    - jsp, HTML 파일 경로
6. prom.xml
    - 라이브러리 의존성 관리
7. src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
    - 웹과 관련된 스프링 설정 파일
8. src/main/webapp/WEB-INF/spring/root-context.xml
    - 스프링 객체 관련 설정 파일

# JSTL 인식이 안될 때

- 아래의 경로에서 zip 파일 설치 후
- [https://archive.apache.org/dist/jakarta/taglibs/standard/binaries/](https://archive.apache.org/dist/jakarta/taglibs/standard/binaries/)

![image 23](https://github.com/user-attachments/assets/55c2a1db-1364-4229-9de7-9d023011eaa4)

- WEB-INF 폴더에 lib폴더 생성 후 다운 받은 두 개의 파일을 넣어준다.
  
![image 24](https://github.com/user-attachments/assets/695f3cf7-1de3-4415-9649-f577ca2eb575)

  
