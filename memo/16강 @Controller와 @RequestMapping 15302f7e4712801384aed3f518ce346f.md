# 16강 @Controller와 @RequestMapping

# @Controller

- 스프링 MVC에서 웹 요청을 처리하는 컨트롤러 클래스임을 나타내는 어노테이션
- 클라이언트의 요청을 받아 비스니스 로직을 처리하고, 결과를 View로 전달하거나, 다른 API를 호출하는 등의 역할을 수행함

# @RequestMapping

- 컨트롤러 메서드에 매핑될 URL을 지정하는 어노테이션
- URL 요청이 들어왔을 때 어떤 메서드를 실행할 지 연결하는 역할을 함
- GET, POST, PUT, DELETE 등 특정 HTTP 메서드에 대한 요청만 허용하도록 설정할 수 있음
- URL에 포함된 변수나 요청 파라미터를 메서드 파라미터에 자동으로 바인딩할 수 있음

# 실습

```java
package com.example.ex02.controller;

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
	public void basic() {
		log.info("basic...");
	}
	
}
```