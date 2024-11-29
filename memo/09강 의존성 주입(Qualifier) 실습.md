# 09강 의존성 주입(Qualifier) 실습

# @Qualifier

- @Autowired를 통해 객체를 주입할 때 같은 타입의 객체가 여러 개 있다면, 구분할 수 없다.
- 이 때, @Qualifier를 통해 식별자를 부여하면 원하는 객체를 주입받을 수 있다.

# @Primary

- default 값을 설정할 때 사용
- 이 때에는 식별자 없이 주입 시 @Primary어노테이션이 붙은 객체가 주입된다.

# 예시

```java
@Qualifier("식별자A") @Primary
public class 클래스A implements 인터페이스 {

}
```

```java
@Qualifier("식별자B")
public class 클래스B implements 인터페이스 {

}
```

```java
@Autowired
@Qualifier("식별자B")
private 인터페이스 객체;
```

# @Qualifier, @Primary예시

```java
package com.example.ex00.dependency.Qualifier;

public interface Computer {
	public int getScreenWidth();

}
```

```java
package com.example.ex00.dependency.Qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("desktop")
public class Desktop implements Computer{

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return 1920;
	}

}
```

```java
package com.example.ex00.dependency.Qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("laptop") @Primary
public class Laptop implements Computer{

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return 1280;
	}

}
```

```java
package com.example.ex00.dependency;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.ex00.dependency.Qualifier.Computer;
import com.example.ex00.dependency.Qualifier.Laptop;

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

	@Test
	public void testQualifierComputer() {
		log.info("--------------------------");
		log.info("computer : " + desktop);
		log.info("screen width : " + desktop.getScreenWidth());
		log.info("--------------------------");

		log.info("--------------------------");
		log.info("computer : " + laptop);
		log.info("screen width : " + laptop.getScreenWidth());
		log.info("--------------------------");

		log.info("--------------------------");
		log.info("computer : " + computer);
		log.info("screen width : " + computer.getScreenWidth());
		log.info("--------------------------");
	}

}
// 결과 : 
//	INFO : org.springframework.test.context.support.DefaultTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener]
//	INFO : org.springframework.test.context.support.DefaultTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@55b0dcab, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@38afe297, org.springframework.test.context.support.DependencyInjectionTestExecutionListener@2df3b89c, org.springframework.test.context.support.DirtiesContextTestExecutionListener@23348b5d, org.springframework.test.context.transaction.TransactionalTestExecutionListener@70325e14, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener@37ceb1df]
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - computer : com.example.ex00.dependency.Qualifier.Desktop@6bffbc6d
//	INFO : com.example.ex00.dependency.QualifierTests - screen width : 1920
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - computer : com.example.ex00.dependency.Qualifier.Laptop@1b84f475
//	INFO : com.example.ex00.dependency.QualifierTests - screen width : 1280
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------
//	INFO : com.example.ex00.dependency.QualifierTests - computer : com.example.ex00.dependency.Qualifier.Laptop@1b84f475
//	INFO : com.example.ex00.dependency.QualifierTests - screen width : 1280
//	INFO : com.example.ex00.dependency.QualifierTests - --------------------------

```