# 34~36강 게시판 만들기 Controller 단위 테스트 구축

# Controller

```java
package com.example.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.domain.vo.BoardVO;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

/*
 * Task			URL					Method		Parameter 	Form 		URL이동
 * 
 * 전체 목록		/board/list			GET						
 * 등록 처리 		/board/register		POST		모든 항목		입력화면 필요	이동
 * 조회			/board/read			GET			bno						
 * 삭제 처리		/board/remove		GET			bno			입력화면 필요	이동
 * 수정 처리		/board/modify		POST		모든 항목		입력화면 필요	이동
 * */

@Controller
@Log4j
@RequestMapping("/board/**")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("/list");
		model.addAttribute("boardList", boardService.getList());
	}

	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/register : " + boardVO);
		boardService.register(boardVO);

//		Flash라는 영역은 Session에 생기고, redirect로 전송할 때 request영역이 초기화 된다.
//		초기화 되기전에 Flash영역에 데이터를 저장해놓고, 초기화된 후 Flash영역에서 데이터를 가지고 온다.
//		데이터를 가져왔다면, Flash영역에 있던 데이터는 없어진다.
		rttr.addFlashAttribute("bno", boardVO.getBno());
//		redirect로 전송할 때에는 경로 앞에 "redirect"을 붙여준다.
		return "redirect:/board/list";
	}

	@GetMapping({"/read", "/modify"})
	public void read(Long bno, HttpServletRequest request, Model model) {
		String url = request.getRequestURI();
		
		log.info(url.substring(url.lastIndexOf("/")) + " : " + bno);
		
		model.addAttribute("board", boardService.get(bno));
	}

	@GetMapping("remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("/remove : " + bno);

		if (boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/modify : " + boardVO);
		
		if(boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("/register")
	public void register() {
		
	};

}
```

# Controller 단위 테스트 구축

```java
package com.example.board.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j
public class BoardControllerTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@org.junit.Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

//	@Test // 전체 조회 테스트
//	public void listTest() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).
//				andReturn().getModelAndView().getModelMap());
//	}

//	@Test // 등록 테스트
//	public void registerTest() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//				.param("title", "테스트 새 글 제목")
//				.param("content", "테스트 새 글 내용")
//				.param("writer", "tester1")
//				).andReturn().getFlashMap());
//	}

//	@Test // 단일 조회 테스트
//	public void readTest() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
//				.param("bno", "26")
//				).andReturn().
//				getModelAndView().
//				getModelMap());
//	}

//	@Test // 삭제 테스트
//	public void removeTest() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
//				.param("bno", "26")
//				).andReturn().getFlashMap());
//	}
	
//	@Test // 수정 테스트
//	public void modifyTest() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//				.param("bno", "1")
//				.param("title", "수정한 게시글 제목")
//				.param("content", "수정한 게시글 내용")
//				.param("writer", "wirterTester")
//				).andReturn().getFlashMap());
//	}
	
//	@Test // 수정 페이지 이동 테스트
//	public void goModifyTest() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/board/modify")
//				.param("bno", "21")
//				);
//	}

}
```

# WebApplicationContext 인터페이스

- 스프링 웹 애플리케이션의 중심이 되는 컨테이너

## WebApplicationContext의 역할

- 빈(Bean) 관리
    - 웹 애플리케이션에서 사용되는 모든 객체(빈)들을 관리하고, 필요한 곳에 주입
- 웹 한경 정보 제공
    - ServletContext와 같은 웹 환경 정보에 접근할 수 있는 메서드를 제공하여 웹 애플리케이션이 웹 환경과 상호작용할 수 있도록 도움
- 웹 관련 빈 등록
    - DispatcherServlet과 같은 웹 관련 빈들을 등록하고 관리함

# MockMvc 클래스

- 스프링 프레임워크에서 웹 애플리케이션의 컨트롤러를 테스트하기 위한 도구
- 실제 웹 서버를 실행하지 않고도 HTTP 요청을 시뮬레이션하여 컨트롤러의 동작을 검증할 수 있도록 해줌

## MockMvc 클래스의 역할

- HTTP 요청 시뮬레이션
    - GET, POST, PUT, DELETE 등 다양한 HTTP 메서드를 이용하여 컨트롤러에 요청을 보낼 수 있음
- 요청 파라미터(매개 변수) 설정
    - 요청 URL, 헤더, 바디 등을 자유롭게 설정하여 다양한 시나리오를 테스트 할 수 있음
- 비동기 요청 처리
    - 비동기 요청에 대한 테스트 지원

# 세션(Session)

- 하나의 사용자가 웹 애플리케이션과 상호작용하는 동안 유지되는 상태를 의미
- 즉 사용자의 브라우저가 웹 서버에 연결된 동안 유지되는 일종의 메모리 영역
- 세션을 통해 사용자의 정보를 저장하고, 이를 요청에 걸쳐 공유 가능 예로 사용자의 로그인 정보, 장바구니 정보 등을 세션에 저장하여 관리함

## 세션 특징

- 서버 메모리에 저장되며, 사용자의 브라우저에는 세션 ID만 저장됨
- 일반적으로 쿠키를 통해 세션 ID를 관리함
- 일정 시간이 지나면 자동으로 만료됨
- 하나의 세션은 여러 요청에서 공유될 수 있음

# 리다이렉트(Redirect)

- 클라이언트(브라우저)에게 다른 URL로 이동하도록 응답하는 것을 의미
- 즉 서버에서 클라이언트에게 새로운 요청을 하도록 유도하는 것
- 리다이렉트가 발생하면 브라우저 주소창의 URL이 변경됨

## 리다이렉트 특징

- 클라이언트는 새로운 URL로 요청을 보내기 때문에, 이전 요청의 정보는 유실됨
- 리다이렉트를 사용할려면 직접 return값을 주소값으로 입력하면 됨

# 포워드(Forward)

- 서버 내부에서 요청을 다른 서블릿이나 JSP로 전달하는 것을 의미함
- 클라이언트의 관점에서는 하나의 요청처럼 보이지만, 서버 내부에서는 다른 서블릿이나 JSP가 처리를 이어받음

## 포워드 특징

- 클라이언트에게 알리지 않고 서버 내부에서 처리가 이루어짐
- URL 변경이 없음
- 클라이언트 입장에서는 하나의 요청으로 처리됨

# HttpServletRequest

- 자바 서블릿 API에서 제공하는 인터페이스
- 클라이언트가 서버에 보낸 HTTP 요청에 대한 모든 정보를 담고 있는 객체