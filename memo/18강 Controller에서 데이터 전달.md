# 18강 Controller에서 데이터 전달

# @ModelAttribute

- 스프링 MVC에서 컨트롤러 메서드의 파라미터나 메서드의 반환 값을 모델(Model)에 추가하는 데 사용되는 어노테이션
- Key값에 alias(별명)을 부여하듯이 쓸 수 있다.
- 만약 매개변수가 객체라면, 해당 클래스 타입의 앞글자만 소문자로 변경된 값이
화면에서 사용할 Key값이다.
- ex) 매개변수의 타입이 InfoDTO라면, 화면에서 사용 시 Key값은 infoDTO가 된다.
만약에 Key값을 수정하거나 매개변수가 많아진다면, 직접 requestScope에 담아서 전달해야 한다.
- 이 때 request객체를 직접 불려오지 않고, Model이라는 데이터 전달자를 사용하게 된다.
- 하지만 화면 쪽에 전달할 데이터가 여러 개가 아니라면, @ModelAttribute()를 사용하여 화면에 전달해준다.
- @ModelAttribute("화면에서 사용할 Key")

```java
	@GetMapping("/ex04")
//	@ModelAttribute : Key값에 alias(별명)을 부여하듯이 쓸 수 있다.
//	만약 매개변수가 객체라면, 해당 클래스 타입의 앞글자만 소문자로 변경된 값이
//	화면에서 사용할 Key값이다.
//	ex) 매개변수의 타입이 InfoDTO라면, 화면에서 사용 시 Key값은 infoDTO가 된다.
//	만약에 Key값을 수정하거나 매개변수가 많아진다면,
//	직접 requestScope에 담아서 전달해야 한다.
//	이 때 request객체를 직접 불려오지 않고, Model이라는 데이터 전달자를 사용하게 된다.
//	하지만 화면 쪽에 전달할 데이터가 여러 개가 아니라면, @ModelAttribute()를 사용하여 화면에 전달해준다.
//	@ModelAttribute("화면에서 사용할 Key")
	public String ex04(@ModelAttribute("dto") InfoDTO infoDTO) {
		log.info("---------------------");
		log.info("ex04............");
		log.info(infoDTO.toString());
		log.info("---------------------");
		
		return "ex04";
	}
```

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX04</title>
<style>
	table{
		text-align: center;
	}
</style>
</head>
<body>
	<h1>EX04</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<tr>
			<td><c:out value="${dto.name }"/></td>
			<td><c:out value="${dto.age }"/></td>
		</tr>
	</table>
</body>
</html>
```

# dto에 없는 값 추가하기

- @ModelAttribute를 사용하여 dto에 없는 값을 추가할 수도 있다.

```java
	@GetMapping("/ex05")
	public void ex05(InfoDTO infoDTO, @ModelAttribute("gender") String gender) {
		log.info("ex05.....");
		log.info(infoDTO.toString());
		log.info("gender ; " + gender);
	}
```

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX05</title>
<style>
	table{
		text-align: center;
	}
</style>
</head>
<body>
	<h1>EX04</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
		</tr>
		<tr>
			<td><c:out value="${infoDTO.name }"/></td>
			<td><c:out value="${infoDTO.age }"/></td>
			<td><c:out value="${gender }"></c:out></td>
		</tr>
	</table>
</body>
</html>
```

# Model

- **컨트롤러에서 처리된 데이터를 View로 전달하기 위한 저장소** 역할
- Model 객체는 파라미터(매개변수)로 request객체를 받는다.
- 따라서 여러 개의 데이터를 화면에 전달할 때 addAttribute(Key, Value)를 사용한다.
- 화면에서는 model에 설정한 Key, Values를 사용할 수 있다.

```java
	@GetMapping("/ex06")
//	Model 객체는 파라미터로 request객체를 받는다.
//	따라서 여러 개의 데이터를 화면에 전달할 때
//	addAttribute(Key, Value)를 사용한다.
//	화면에서는 model에 설정한 Key로 Values를 사용할 수 있다.
	public String ex06(InfoDTO infoDTO, String gender, Model model) {
		log.info("ex06.....");
		log.info(infoDTO.toString());
		log.info("gender : " + gender);
		
		model.addAttribute("dto", infoDTO);
		model.addAttribute("gender", gender);
		
		return "ex/ex06";
	}
```

```java
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX06</title>
<style>
	table{
		text-align: center;
	}
</style>
</head>
<body>
	<h1>EX06</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
		</tr>
		<tr>
			<td><c:out value="${dto.name }"/></td>
			<td><c:out value="${dto.age }"/></td>
			<td><c:out value="${gender }"></c:out></td>
		</tr>
	</table>
</body>
</html>
```