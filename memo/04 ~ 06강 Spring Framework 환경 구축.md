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

[Uploading https-content.xml…]()<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<descriptors>
    <descriptor id="org.springframework.templates.mvc" kind="template" local="true" name="Spring MVC Project" requiresbundle="org.eclipse.m2e.core" size="0" version="3.2.2">
        <description>A new Spring MVC web application development project</description>
    </descriptor>
    <descriptor category="GemFire" id="org.springframework.data.gemfire.template.standalone" kind="template" local="false" name="Spring Data GemFire Project (Standalone)" requires="[3.0.0,4.0)" size="7467" url="https://raw.github.com/SpringSource/spring-data-gemfire-sts-templates/master/builds/gemfire-standalone-sts-template-1.0.1.RELEASE.zip" version="1.0.1.RELEASE">
        <description>Creates a Spring Data GemFire project with an embedded cache and one region that runs as a standalone Java application.</description>
    </descriptor>
    <descriptor category="GemFire" id="org.springframework.data.gemfire.template.server.standalone" kind="template" local="false" name="Spring Data GemFire Cache Server Project (Standalone)" requires="[3.0.0,4.0)" size="7582" url="https://raw.github.com/SpringSource/spring-data-gemfire-sts-templates/master/builds/gemfire-server-sts-template-1.0.1.RELEASE.zip" version="1.0.1.RELEASE">
        <description>Creates a GemFire Cache Server project with a cache server, embedded cache and one region that runs as a standalone Java application.</description>
    </descriptor>
    <descriptor category="GemFire" id="org.springframework.data.gemfire.template.server.war" kind="template" local="false" name="Spring Data GemFire Cache Server Project (WAR)" requires="[3.0.0,4.0)" size="7543" url="https://raw.github.com/SpringSource/spring-data-gemfire-sts-templates/master/builds/gemfire-server-war-sts-template-1.0.1.RELEASE.zip" version="1.0.1.RELEASE">
        <description>Creates a GemFire Cache Server project with a cache server, embedded cache and one region that runs as a web application.</description>
    </descriptor>
    <descriptor category="GemFire" id="org.springframework.data.gemfire.template.client" kind="template" local="false" name="Spring Data GemFire Client Project" requires="[3.0.0,4.0)" size="7881" url="https://raw.github.com/SpringSource/spring-data-gemfire-sts-templates/master/builds/gemfire-client-sts-template-1.0.1.RELEASE.zip" version="1.0.1.RELEASE">
        <description>Creates a Spring Data GemFire project with a client cache and client region that runs as a standalone Java application.</description>
    </descriptor>
    <descriptor id="com.springsource.sts.org.apache.tomcat" kind="server" local="false" name="Apache Tomcat 6.0.20" size="6282517" url="https://dist.springsource.com/release/STS/help/com.springsource.sts.org.apache.tomcat-6.0.20.20090615-0000.zip" version="6.0.20.20090615-0000">
        <description/>
    </descriptor>
    <descriptor category="Batch" id="org.springframework.samples.batch.admin.web" kind="template" local="false" name="Spring Batch Admin Webapp" requiresbundle="org.eclipse.m2e.core" size="21532" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.batch.admin.web-2.3.3.zip" version="2.3.3">
        <description>A WAR project for a Spring Batch Admin web application with simple custom job</description>
    </descriptor>
    <descriptor id="org.springframework.samples.batch.simple" kind="template" local="false" name="Simple Spring Batch Project" requires="[0.0.0,2.8.0)" size="14198" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.batch.simple-2.3.5.zip" version="2.3.5">
        <description>A simple project that shows how to use Spring Batch with a reader and a writer in a single step job</description>
    </descriptor>
    <descriptor category="Batch" id="org.springframework.samples.batch.simple" kind="template" local="false" name="Simple Spring Batch Project" requires="2.8.0" requiresbundle="org.eclipse.m2e.core" size="13698" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.batch.simple-2.4.2.zip" version="2.4.2">
        <description>A simple project that shows how to use Spring Batch with a reader and a writer in a single step job</description>
    </descriptor>
    <descriptor id="org.springframework.templates.mvc" kind="template" local="false" name="Spring MVC Project" requires="[0.0.0,2.8.0)" size="17198" url="https://dist.springsource.com/release/STS/help/org.springframework.templates.mvc-3.0.18.zip" version="3.0.18">
        <description>A new Spring MVC web application development project</description>
    </descriptor>
    <descriptor id="org.springframework.templates.mvc" kind="template" local="false" name="Spring MVC Project" requires="2.8.0" requiresbundle="org.eclipse.m2e.core" size="16608" url="http://wisejia.iptime.org:8088/org.springframework.templates.mvc-3.2.2.zip" version="3.2.2">
        <description>A new Spring MVC web application development project</description>
    </descriptor>
    <descriptor id="org.springframework.samples.spring.hibernate" kind="template" local="false" name="Simple Spring Hibernate Utility Project" requires="[0.0.0,2.8.0)" size="14052" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.spring.hibernate-2.5.1.zip" version="2.5.1">
        <description>A simple jar project that has some Spring and Hibernate configuration and an integration test</description>
    </descriptor>
    <descriptor category="Persistence" id="org.springframework.samples.spring.hibernate" kind="template" local="false" name="Simple Spring Hibernate Utility Project" requires="2.8.0" requiresbundle="org.eclipse.m2e.core" size="14081" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.spring.hibernate-2.6.2.zip" version="2.6.2">
        <description>A simple jar project that has some Spring and Hibernate configuration and an integration test</description>
    </descriptor>
    <descriptor id="org.springframework.samples.spring.jpa" kind="template" local="false" name="Simple Spring JPA Utility Project" requires="[0.0.0,2.8.0)" size="15587" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.spring.jpa-2.3.3.zip" version="2.3.3">
        <description>A simple jar project that has some Spring and JPA configuration and an integration test.</description>
    </descriptor>
    <descriptor category="Persistence" id="org.springframework.samples.spring.jpa" kind="template" local="false" name="Simple Spring JPA Utility Project" requires="2.8.0" requiresbundle="org.eclipse.m2e.core" size="15075" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.spring.jpa-2.4.2.zip" version="2.4.2">
        <description>A simple jar project that has some Spring and JPA configuration and an integration test.</description>
    </descriptor>
    <descriptor id="org.springframework.samples.spring.utility" kind="template" local="false" name="Simple Spring Utility Project" requires="[0.0.0,2.8.0)" size="12666" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.spring.utility-2.5.1.zip" version="2.5.1">
        <description>A simple jar project that has some Spring configuration and an integration test</description>
    </descriptor>
    <descriptor id="org.springframework.samples.spring.utility" kind="template" local="false" name="Simple Spring Utility Project" requires="2.8.0" requiresbundle="org.eclipse.m2e.core" size="12684" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.spring.utility-2.6.1.zip" version="2.6.1">
        <description>A simple jar project that has some Spring configuration and an integration test</description>
    </descriptor>
    <descriptor id="org.springframework.samples.petclinic" kind="sample" local="false" name="PetClinic" size="21722686" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.petclinic-2.5.0.20080208-1600.zip" version="2.5.0.20080208-1600">
        <description/>
    </descriptor>
    <descriptor id="org.springframework.samples.springtravel" kind="sample" local="false" name="SpringTravel" size="4409712" url="https://dist.springsource.com/release/STS/help/org.springframework.samples.springtravel-2.5.2.20000702-1000.zip" version="2.5.2.20000702-1000">
        <description/>
    </descriptor>
    <descriptor category="Spring Security" id="org.springframework.security.tutorials.basicsecurity" kind="tutorial" local="false" name="Securing your web application with Spring Security" size="4759272" url="https://dist.springsource.com/release/STS/help/org.springframework.security.tutorials.basicsecurity-1.0.0.zip" version="1.0.0">
        <description>This tutorial shows how to configure simple role-based security for a standard web application.</description>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorial.WhatsNewIn25" kind="tutorial" local="false" name="What's new in Spring 2.5" size="13310" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorial.WhatsNewIn25-1.0.0.zip" version="1.0.0">
        <description>This cheat sheet demonstrates key concepts that are new in Spring 2.5.</description>
        <dependency id="org.springframework.samples.petclinic"/>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorials.addingManagementToYourSpringApplications" kind="tutorial" local="false" name="Adding Management to Your Spring Applications" size="15440" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorials.addingManagementToYourSpringApplications-1.0.0.zip" version="1.0.0">
        <description>This tutorial demonstrates how to instrument your Spring applications for management using Spring, JMX and AOP.</description>
        <dependency id="org.springframework.samples.petclinic"/>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorials.gettingstartedwithspringjdbc" kind="tutorial" local="false" name="Getting Started with Spring JDBC" size="8568468" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorials.gettingstartedwithspringjdbc-1.0.1.zip" version="1.0.1">
        <description>This tutorial shows how to get started using Spring JDBC for simple data access.</description>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorials.jms.creatingmdb" kind="tutorial" local="false" name="Creating JMS-enabled Spring application" size="3675267" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorials.jms.creatingmdb-1.0.0.zip" version="1.0.0">
        <description>This tutorial provides an overview of JMS features with the Spring Framework.</description>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorials.junit.integrationtestingwithjunit4" kind="tutorial" local="false" name="Integration Testing with JUnit 4" size="7429423" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorials.junit.integrationtestingwithjunit4-1.0.0.zip" version="1.0.0">
        <description>This tutorial will walk developers through the process of creating a JUnit 4 integration test.</description>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorials.testing.junit3-legacy" kind="tutorial" local="false" name="Integration Testing with JUnit 3 and Spring" size="7438660" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorials.testing.junit3-legacy-1.0.0.zip" version="1.0.0">
        <description>This tutorial will show you how to implement integration tests using the Spring JUnit 3.8 testing framework.</description>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorials.testing.junit3" kind="tutorial" local="false" name="Integration Testing with JUnit 3 and the Spring TestContext Framework" size="7432757" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorials.testing.junit3-1.0.0.zip" version="1.0.0">
        <description>This tutorial will show you how to implement integration tests using the Spring 2.5+ TestContext framework and JUnit 3.</description>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorials.txmgmt.addingtxmangagement" kind="tutorial" local="false" name="Adding Declarative Transaction Management to Your Spring Applications" size="3939660" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorials.txmgmt.addingtxmangagement-1.0.0.zip" version="1.0.0">
        <description>his tutorial demonstrates how to apply Spring's support for declarative transaction management.</description>
    </descriptor>
    <descriptor category="Spring Framework" id="org.springframework.tutorials.usingstoredprocedures" kind="tutorial" local="false" name="Using Stored Procedures" size="6387472" url="https://dist.springsource.com/release/STS/help/org.springframework.tutorials.usingstoredprocedures-1.0.0.zip" version="1.0.0">
        <description>A tutorial for getting started using stored procedures.</description>
    </descriptor>
    <descriptor category="Spring Web" id="org.springframework.web.tutorials.creatingcontroller" kind="tutorial" local="false" name="Creating a Controller" size="26558" url="https://dist.springsource.com/release/STS/help/org.springframework.web.tutorials.creatingcontroller-1.0.0.zip" version="1.0.0">
        <description>This tutorial will walk developers through the process of creating a @Controller to implement a basic use case end-to-end.</description>
        <dependency id="org.springframework.samples.springtravel"/>
    </descriptor>
    <descriptor category="Spring Web" id="org.springframework.web.tutorials.webprojectoverview" kind="tutorial" local="false" name="Spring Web Development Overview" size="27161" url="https://dist.springsource.com/release/STS/help/org.springframework.web.tutorials.webprojectoverview-1.0.0.zip" version="1.0.0">
        <description>This tutorial provides an overview of web development with the Spring Framework.</description>
        <dependency id="org.springframework.samples.springtravel"/>
    </descriptor>
    <descriptor id="org.springframework.webflow.samples.booking.jsf" kind="sample" local="false" name="Hotel Booking Reference App (Spring MVC + Web Flow + JavaServerFaces version)" size="13644612" url="https://dist.springsource.com/release/STS/help/org.springframework.webflow.samples.booking.jsf-2.0.7.20090423-1700.zip" version="2.0.7.20090423-1700">
        <description/>
    </descriptor>
    <descriptor category="Spring Web Flow" id="org.springframework.webflow.tutorial.GetStarted" kind="tutorial" local="false" name="Get Started with Spring Web Flow" size="8709" url="https://dist.springsource.com/release/STS/help/org.springframework.webflow.tutorial.GetStarted-1.0.0.zip" version="1.0.0">
        <description>Learn how to use the Web Flow framework in your Spring application.</description>
        <dependency id="org.springframework.webflow.samples.booking.jsf"/>
        <dependency id="com.springsource.sts.org.apache.tomcat"/>
    </descriptor>
    <descriptor category="Spring Web Services" id="org.springframework.webservices.tutorials.creatingcontroller" kind="tutorial" local="false" name="Creating a contract-first web service" size="9741990" url="https://dist.springsource.com/release/STS/help/org.springframework.webservices.tutorials.creatingcontroller-1.0.0.zip" version="1.0.0">
        <description>This tutorial shows you how to create a contract-first web service with Spring-WS. The contract-first approach is an industry recognized best practice. In short it means we'll design an XML contract first and a Java implementation second.</description>
        <dependency id="com.springsource.sts.org.apache.tomcat"/>
    </descriptor>
    <descriptor category="Integration" id="org.springframework.integration.sts.template.standalone.simple" kind="template" local="false" name="Spring Integration Project (Standalone) - Simple" requires="[3.0.0,4.0)" requiresbundle="org.eclipse.m2e.core" size="9500" url="https://raw.github.com/SpringSource/spring-integration-templates/master/si-sts-templates/builds/si-template-standalone-simple-1.0.1.RELEASE.zip" version="1.0.1.RELEASE">
        <description>Creates a Spring Integration project that runs as a standalone Java application using core components only.</description>
    </descriptor>
    <descriptor category="Integration" id="org.springframework.integration.sts.template.standalone" kind="template" local="false" name="Spring Integration Project (Standalone) - File" requires="[3.0.0,4.0)" requiresbundle="org.eclipse.m2e.core" size="12100" url="https://raw.github.com/SpringSource/spring-integration-templates/master/si-sts-templates/builds/si-template-standalone-1.0.1.RELEASE.zip" version="1.0.1.RELEASE">
        <description>Creates a Spring Integration project that runs as a standalone Java application using file polling and file output.</description>
    </descriptor>
    <descriptor category="Integration" id="org.springframework.integration.sts.template.war" kind="template" local="false" name="Spring Integration Project (War)" requires="[3.0.0,4.0)" requiresbundle="org.eclipse.m2e.core" size="155900" url="https://raw.github.com/SpringSource/spring-integration-templates/master/si-sts-templates/builds/si-template-war-1.0.1.RELEASE.zip" version="1.0.1.RELEASE">
        <description>Creates a Spring Integration project that runs within a servlet container. Uses the Spring Integration Twitter adapter.</description>
    </descriptor>
    <descriptor category="Integration" id="org.springframework.integration.sts.template.adapter" kind="template" local="false" name="Spring Integration Adapter Template Project" requires="[3.2.0,4.0)" requiresbundle="org.springsource.ide.eclipse.gradle.core" size="122100" url="https://raw.github.com/SpringSource/spring-integration-templates/master/si-sts-templates/builds/si-template-adapter-1.0.1.RELEASE.zip" version="1.0.1.RELEASE">
        <description>Creates a Spring Integration Adapter Template. Requires Gradle Support.</description>
    </descriptor>
    <descriptor category="Integration" id="org.springframework.integration.sts.template.adapter" kind="template" local="false" name="Spring Integration Adapter Template Project" requires="[3.0.0,3.2)" size="118119" url="https://raw.github.com/SpringSource/spring-integration-templates/master/si-sts-templates/builds/si-template-adapter-1.0.0.M4.zip" version="1.0.0.M4">
        <description>Creates a Spring Integration Adapter Template. Requires Gradle Support. Deprecated, please update STS to version 3.2+ for the latest template version</description>
    </descriptor>
    <descriptor id="org.springframework.integration.sts.template.standalone.simple" kind="template" local="false" name="Spring Integration Project (Standalone) - Simple" requires="[0.0.0,3.0.0)" size="8390" url="https://raw.github.com/SpringSource/spring-integration-templates/master/si-sts-templates/builds/si-template-standalone-simple-1.0.0.M2.zip" version="1.0.0.M2">
        <description>Creates a Spring Integration project that runs as a standalone Java application using core components only. Deprecated, please update STS to version 3.2+ for the latest template version</description>
    </descriptor>
    <descriptor id="org.springframework.integration.sts.template.standalone" kind="template" local="false" name="Spring Integration Project (Standalone) - File" requires="[0.0.0,3.0.0)" size="10258" url="https://raw.github.com/SpringSource/spring-integration-templates/master/si-sts-templates/builds/si-template-standalone-1.0.0.M2.zip" version="1.0.0.M2">
        <description>Creates a Spring Integration project that runs as a standalone Java application using file polling and file output. Deprecated, please update STS to version 3.2+ for the latest template version</description>
    </descriptor>
    <descriptor id="org.springframework.integration.sts.template.war" kind="template" local="false" name="Spring Integration Project (War)" requires="[0.0.0,3.0.0)" size="56242" url="https://raw.github.com/SpringSource/spring-integration-templates/master/si-sts-templates/builds/si-template-war-1.0.0.M2.zip" version="1.0.0.M2">
        <description>Creates a Spring Integration project that runs within a servlet container. Uses the Spring Integration Twitter adapter. Deprecated, please update STS to version 3.2+ for the latest template version</description>
    </descriptor>
    <descriptor id="org.springframework.templates.mvc" kind="template" local="true" name="Spring MVC Project" requiresbundle="org.eclipse.m2e.core" size="0" version="3.2.2">
        <description>A new Spring MVC web application development project</description>
    </descriptor>
</descriptors>


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

  
