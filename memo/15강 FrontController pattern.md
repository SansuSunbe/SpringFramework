# 15강 FrontController pattern

# FrontController 패턴(동작 원리)

![image](https://github.com/user-attachments/assets/17361fc7-a82b-4be3-8156-fc450291812f)

1. (①).
사용자의 Request는 Front-Controller인 DispatcherServlet을 통해 처리된다.
2. (②, ③).
HandlerMapping은 Request의 처리를 담당하는 컨트롤러를 찾기 위해서 존재한다.
여러 객체 중 @RequestMapping 어노테이션이 적용된 것을 기준으로 판단하며,
적절한 컨트롤러가 찾아졌다면 HandlerAdapter를 이용해서 해당 컨트롤러를 동작시킨다.
3. (④, ⑤).
Controller는 Request를 처리하는 비지니스 로직을 작성하며, View에 전달해야 하는
데이터를 RequestScope에 담아서 전달한다. 응답 페이지 대한 경로 처리는
ViewResolver를 이용하게 된다.
4. (⑤).
ViewResolver는 Controller가 리턴한 결과 값을 전체 경로로 완성시켜준다.
5. (⑥, ⑦).
View는 실제 응답을 보내야하는 데이터를 HTML, JSP등을 이용해서 생성하는 역할을 한다.
6. (⑧).
만들어진 응답 페이지를 DispatcherServlet을 통해 전송한다.

![front-controller-pattern2](https://github.com/user-attachments/assets/8b8758fb-2cf7-4438-9e62-73dde651b27a)

# FrontController 패턴 특징

- HttpServletRequest, HttpServletResponse를 거의 사용할 필요 없이 기능 구현 가능
- 다양한 타입의 파라미터(매개변수) 처리, 다양한 타입의 리턴 타입 사용 가능
- GET 방식, POST 방식 등 전송 방식에 대한 처리를 어노테이션으로 처리 가능
- 상속, 인터페이스 방식 대신 어노테이션 만으로도 설정 가능
