
- @Component
	- 이 어노테이션이 붙은 클래스는 해당 클래스를 객체화 할 때 스프링에서 관리하도록 설정
	- ![](https://i.imgur.com/G4h3aPL.png)

- ex) 필드 주입
	- ![](https://i.imgur.com/M5MFrKs.png)

- ex) 생성자 주입
	- ![](https://i.imgur.com/KkZa10L.png)

- ex) Setter 주입
	- ![](https://i.imgur.com/4fC8AyR.png)

- ex) 의존성 주입이 잘 되었는지 테스트 할려면?
	1. src/test/java에 테스트할 클래스들을 담을 패키지를 만들어준다.
		-  ![](https://i.imgur.com/GKo1O2Q.png)

	2. root-context.xml에 테스트할 클래스들이 담긴 패키지를 스프링에서 인식할 수 있게끔 컴포넌트 스캔으로 등록해준다.
		- ![](https://i.imgur.com/uRYp0RZ.png)
	3. 테스트할 클래스를 만들어주고 테스트할 객체를 주입해준다.
		- 객체 주입 시 @Autowired 어노테이션으로 어떤 객체를 주입할 것인지 알려준다. 
		- Log.info는 자바에서 System.println.out 대신에 사용할 수 있다(자동 줄바꿈) 
		-  ![](https://i.imgur.com/2kHF4QW.png)

- @Runwith 어노테이션?
	- 클래스를 실행시킬 때 어떤방식으로 실행시킬것인지 알려준다.