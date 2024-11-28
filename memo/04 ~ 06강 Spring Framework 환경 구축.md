# 04 ~ 06강 Spring Framework 환경 구축

# JDK 11버전 설치 & 환경 구축

- [개발 환경 구축하러 가기](https://blog.naver.com/coding_music/223457414418)

# STS3 다운

[STS3 설치하러 가기](https://github.com/spring-attic/toolsuite-distribution/wiki/Spring-Tool-Suite-3)

- OS에 맞는 버전을 찾아서 다운

![image.png](image.png)

- STS 실행 파일

![image.png](image%201.png)

# STS3 환경 구축

- windows → preferences → 검색창 encoding 검색 → encodingType을 ‘UTF-8’로 바꿔준다.

![image.png](image%202.png)

- Limit console output 해체

![image.png](image%203.png)

- 내장 서버를 지워준다.

![image.png](image%204.png)

# TOMCAT 설치

- [톰캣 설치하러 가기](https://tomcat.apache.org/)
- 내장 서버를 지워준 곳을 클릭 후 설치한 톰캣의 위치를 등록시켜준다.

![image.png](image%205.png)

- 톰캣을 더블 클릭하여 overview로 이동한 뒤 포트번호를 ‘10000’으로 변경해준다.

![image.png](image%206.png)

- 표시한 곳을 체크해 놓으면 속도가 더 빨라진다.

![image.png](image%207.png)

# STS3 환경 구축 정리

1. 기존 서버 삭제
2. 톰캣 서버 등록
3. encodingType을 UTF-8로 설정
4. Run/Debug/Console 설정에서 Limit console output 체크 해체

# 프로젝트 생성

- Spring Legacy Project를 선택해준다.

![image.png](image%208.png)

- Spring MVC Project 선택

![image.png](image%209.png)

- controller를 설정해준다.

![image.png](image%2010.png)

- .controller까지 있어야 하는데 없을 때 Rename 을 눌려 패키지 이름을 재설정 해준다.
    
    ![image.png](image%2011.png)
    
- 필요한 파일이 다운받아지고 패키지명을 controller까지 붙여준다.

![image.png](image%2012.png)

# Spring MVC가 안보일 때

1. sts3 종료 후 워크스페이스 이동
2. 다음 경로로 이동 D:\DDAZUA\SpringFramework\work\.metadata\.plugins\org.springsource.ide.eclipse.commons.content.core

![image.png](image%2013.png)

1. 해당 폴더에 다음 파일 붙여넣기

[https-content.xml](https-content.xml)

# STS3 프로젝트 설정

- 프로젝트의 porm.xml을 클릭 후 프로젝트를 구축한 환경과 맞게 소스 코드를 변경해준다.

![image.png](image%2014.png)

- prom.xml을 수정 후 프로젝트를 업데이트 해준다.

![image.png](image%2015.png)

- Force Update를 체크해서 강제로 업데이트

![image.png](image%2016.png)

# Lombok(롬복) 라이브러리란?

- Lombok을 이용하면 JAVA 개발 시 getter/setter, toString(), 생성자 등을 @Data등의 어노테이션을 통해 자동으로 생성해준다.
- 즉 코드의 양을 줄여주고 간단하게 해준다.
- [롬복 설치하러 가기](https://projectlombok.org/download)

# Lombok 설치

- 롬복의 확장자가 실행이 안될거 같으면 롬복의 파일 주소 클릭 후 ‘cmd’를 입력하여 cmd 창에서 실행시켜준다.

![image.png](image%2017.png)

- 주소에 cmd 입력 후 엔터 입력
    
    ![image.png](image%2018.png)
    
- ‘cmd 창에서 java -jar lombok.jar’입력

![image.png](image%2019.png)

- 표시한 곳 클릭 후 설치한 STS3 의 위치를 잡아준다.

![image.png](image%2020.png)

- 경로를 잡아준 후 install/update를 눌려준다.

![image.png](image%2021.png)

- 설치 후 STS3.exe 위치에 Lombok이 있으면 성공

![image.png](image%2022.png)

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

![image.png](image%2023.png)

![image.png](image%2024.png)

- WEB-INF 폴더에 lib폴더 생성 후 다운 받은 두 개의 파일을 넣어준다.