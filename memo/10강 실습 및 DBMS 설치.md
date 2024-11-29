# 10강 실습 및 DBMS 설치

# 실습

- Chef 클래스 생성

```java
package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Chef {
	;
}
```

- Restaurant  클래스 생성 Chef 상수 선언

```java
package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
public class Restaurant {
	private final Chef chef;
}
```

- Restaurant 인터페이스 생성 후 멤버 변수 선언 및 초기화

```java
package com.example.ex00.dependency.qualifier;

public interface Restaurant {
	public int steak = 80000;
	public boolean hasSalad();
}
```

- Outback 클래스 생성 후 Restaurant 오버라이딩(재정의)

```java
package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("outback")
public class Outback implements Restaurant{

	@Override
	public boolean hasSalad() {
		// TODO Auto-generated method stub
		return false;
	}

}
```

- Vips 클래스 생성 후 Restaurant 오버라이딩 및 Primary로 기본값 설정

```java
package com.example.ex00.dependency.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vips") @Primary
public class Vips implements Restaurant {

	@Override
	public boolean hasSalad() {
		// TODO Auto-generated method stub
		return true;
	}

}
```

- 단위 테스트 실행

```java
package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.qualifier.Computer;
import com.example.ex00.dependency.qualifier.Laptop;
import com.example.ex00.dependency.qualifier.Outback;
import com.example.ex00.dependency.qualifier.Restaurant;
import com.example.ex00.dependency.qualifier.Vips;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class QualifierTests {

	@Autowired
	@Qualifier("desktop")
	private Computer desktop;

	@Autowired
	private Laptop laptop;

	@Autowired
	private Computer computer;
	
	@Autowired
	@Qualifier("outback")
	private Restaurant outback;
	
	@Autowired
	@Qualifier("vips")
	private Restaurant vips;
	
	@Autowired
	private Restaurant restaurant;

//	@Test
//	public void testQualifierComputer() {
//		log.info("--------------------------");
//		log.info("computer : " + desktop);
//		log.info("screen width : " + desktop.getScreenWidth());
//		log.info("--------------------------");
//
//		log.info("--------------------------");
//		log.info("computer : " + laptop);
//		log.info("screen width : " + laptop.getScreenWidth());
//		log.info("--------------------------");
//
//		log.info("--------------------------");
//		log.info("computer : " + computer);
//		log.info("screen width : " + computer.getScreenWidth());
//		log.info("--------------------------");
//	}
	
	@Test
	public void testQualifier() {
		log.info("--------------------------");
		log.info("outback : " + outback);
		log.info("outback salad : " + outback.hasSalad());
		log.info("steak price : " + Outback.steak);
		log.info("--------------------------");

		log.info("--------------------------");
		log.info("vips : " + vips);
		log.info("vips salad: " + vips.hasSalad());
		log.info("steak price" + Vips.steak);
		log.info("--------------------------");

		log.info("--------------------------");
		log.info("vips : " + restaurant);
		log.info("vips salad: " + restaurant.hasSalad());
		log.info("steak price" + Restaurant.steak);
		log.info("--------------------------");
	}
	
//	INFO : org.springframework.test.context.support.DefaultTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener]
//	INFO : org.springframework.test.context.support.DefaultTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@23348b5d, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@70325e14, org.springframework.test.context.support.DependencyInjectionTestExecutionListener@37ceb1df, org.springframework.test.context.support.DirtiesContextTestExecutionListener@7c9d8e2, org.springframework.test.context.transaction.TransactionalTestExecutionListener@20d525, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@6200f9cb]
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - outback : com.example.ex00.dependency.qualifier.Outback@3fc9504b
//	INFO : com.example.ex00.dependency.QualifierTests - outback salad : false
//	INFO : com.example.ex00.dependency.QualifierTests - steak price : 80000
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - vips : com.example.ex00.dependency.qualifier.Vips@6d025197
//	INFO : com.example.ex00.dependency.QualifierTests - vips salad: true
//	INFO : com.example.ex00.dependency.QualifierTests - steak price80000
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - vips : com.example.ex00.dependency.qualifier.Vips@6d025197
//	INFO : com.example.ex00.dependency.QualifierTests - vips salad: true
//	INFO : com.example.ex00.dependency.QualifierTests - steak price80000
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------

}
```

# DBMS 설치

- [오라클 설치하러 가기](https://blog.naver.com/coding_music/223575139524)
- [dbeaver 설치하러 가기](https://blog.naver.com/coding_music/223580774362)
- 
![image](https://github.com/user-attachments/assets/646adc01-37be-4cc0-9be3-d8f15c5fdc4d)

![image 1](https://github.com/user-attachments/assets/73b1caa9-a59c-4989-a4f5-68e32ae53e00)
