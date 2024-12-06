# 17강 @GetMapping 화면 출력

# @RequestMapping에 value 유무 차이

- @RequestMapping에 value 값을 안적을 시 value값을 적은 메서드 보다 우선 순위로 실행된다.
- 밑의 코드에서 보면 실행 시 basic2() 메서드가 기본적으로 실행된다.
- 클래스 위에 있는 @RequestMapping은 부모 경로이다.

```java
package com.example.ex02.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex/*") // ex 경로로 시작하는 경로는 무조건 이쪽 컨트롤러로 온다.
@Log4j
public class SampleController {
// ex 경로 뒤에 basic이 들어오면 이 메서드 실행
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST}) // GET, POST 방식 둘 다 사용함
	public void basic(HttpServletRequest req) {
		log.info("basic..." + req.getMethod());
	}
	
	@RequestMapping
	public void basic2() {
		log.info("basic2...............");
	}
	
}
```

# @GetMapping

- 스프링 MVC에서 HTTP GET 요청을 처리하는 메서드에 사용되는 어노테이션.
- 클라이언트에서 서버로 데이터를 가져오는 요청을 처리할 때 사용됨
- `@RequestMapping` 어노테이션의 축약형으로, `method=RequestMethod.GET`을 생략하고 간단하게 사용할 수 있음

```java
	@GetMapping("/basicOnlyGet")
	public void basic3() {
		log.info("basic3...only get");
	}
```

## 외부 매개변수 전달

1. SQL 속성과 매칭 되는 클래스 생성

```java
package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // Spring에 등록
@Data
public class InfoDTO {
	
	private String name;
	private int age;

}
```

1. 컨트롤러 클래스에 SQL과 매칭되는 클래스의 변수를 전달받을 메서드 생성
    - 외부에서 전달된 매개변수를 매개변수 필드명과 자동으로 매핑함

```java
	@GetMapping("/ex01")
//	외부에서 전달된 파라미터(매개변수)를 매개변수 필드명과 자동으로 매핑한다.
	public void ex01(InfoDTO infoDTO) {
		log.info("ex01....." + infoDTO.getName() + ", " + infoDTO.getAge());
	}
```

## 외부에서 전달된 파라미터의 이름과 매개변수가 다를 경우

- @RequestParam 어노테이션을 사용하여 어디로 전달받을 지 알려준다.

```java
	@GetMapping("ex02")
//	외부에서 전달된 파라미터의 이름과 매개변수가 다를 경우 @RequestParam을 사용하여 어디로 전달받을 지 알려준다.
	public void ex02(@RequestParam("data1") String name, @RequestParam("data2") int age) {
		log.info("ex02..." + name + ", " + age);
	}
```

## 매개변수를 ArrayList로 받을 경우

```java
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas) {
		log.info("datas : " + datas);
		return "ex03";
	}
```