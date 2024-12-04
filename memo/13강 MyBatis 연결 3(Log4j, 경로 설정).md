# 13강 MyBatis 연결 3(Log4j, 경로 설정)

# MyBatis

- MyBatis는 내부적으로 JDBC의 PreparedStatement를 이용해서 SQL을 처리한다.
- 따라서 SQL에 전달되는 파라미터(매개변수)는 JDBC에서와 같이 ‘?(물음표)’로 치환되어 처리된다.
- 복잡한 SQL의 경우 ‘?’로 값이 제대로 되었는지 확인하기가 쉽지 않고
- 실행된 SQL의 내용을 정확히 어렵기 때문에 ‘log4jdbc-log4j2’라이브러리를 사용하여 어떤 값인지 정확하게 확인한다.

# log4j 설정

- SQL의 결과를 콘솔창에서 편하게 보기 위해 log4j를 설정해준다.

![image](https://github.com/user-attachments/assets/9d6ba6c9-48cd-45c7-a74d-294a867a8801)

- Untitled Text File 생성 후
- 밑의 텍스트를 작성 후 저장 후 파일명을 작성하면 파일이 생성된다.

```java
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
```

![image 1](https://github.com/user-attachments/assets/4899e45d-a9cf-4974-8af9-1759fd19ebc8)

- root-context에서도 기존의 oracle 계정 설정을 주석 처리 한 후 log4j를 등록한다.
    
    ![image 2](https://github.com/user-attachments/assets/a169b8ba-153b-4b59-b27a-c3a98f9bac50)
    
- 실행 후 결과가 더 보기 편하게 나온다.

![image 3](https://github.com/user-attachments/assets/7ca1e783-5025-4237-a430-f6f18294ad69)

## log4j.xml

- 콘솔창에 나오는 로그를 출력함

![image 4](https://github.com/user-attachments/assets/0424ece4-0bbd-44af-8a9e-dda4ade2ad62)

- 다음과 같은 코드를 추가해서 출력되는 로그의 양을 줄일 수 있음

![image 5](https://github.com/user-attachments/assets/693fc3b5-0537-47e0-833e-5e5913685f89)

# MyBatis_Config_Default_Code

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0/EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
</configuration>
```

# root-context 패키지 경로 설정

- value에 xml의 경로를 입력하면 해당하는 xml 파일의 경로를 찾아서 실행한다.
- 중간에 *를 붙이면 하위 폴더에서 해당하는 파일을 찾는다.

```java
<property name="객체명" value="classpath:폴더명/**/*실행할xml파일.xml"/>
```
![image 6](https://github.com/user-attachments/assets/94245eda-29cf-44bd-aa4c-7c6508e816ab)

