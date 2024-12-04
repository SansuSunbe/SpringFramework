# 11강 MyBatis 연결 1(JDBC, DBCP)

# JDBC 연결 테스트

```java
package com.example.ex01.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class JdbcTests {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testConnection() {
		try(Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr","hr")){
			log.info(connection);
		} catch (Exception e) {
//			JUnit의 메서드로써, 무조건 실패로 처리한 뒤 실행을 중지한다.
			fail(e.getMessage());
		}
	}

}
```

## fail()

- JUnit의 메서드로써, 무조건 실패로 처리한 뒤 실행을 중지한다.

# root-context.xml

```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- Root Context: defines shared resources visible to all other web components -->
	<bean id="hikariConfig" class="com.zaxxer.hikari.HikariConfig"> <!-- 오른쪽의 타입 객체를 왼쪽의 객체명으로 사용함 (id = 객체명 class = 자료형) -->
		<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:XE"/>
		<property name="username" value="hr"/>
		<property name="password" value="hr"/>
	</bean>
	
	<bean id="dataSource" class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
		<constructor-arg ref="hikariConfig"/> <!-- 생성자에다 ref(레퍼런스) 전달 -->
	</bean>
</beans>
```

### <bean id = 객체명 class = 자료형/>

### <constructor-arg ref=”ref(레퍼런스) 타입 전달"/>