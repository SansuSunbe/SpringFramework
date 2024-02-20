
- Qualifier란?
	- @Autowired를 통해 객체를 주입할 때 같은 타입의 객체가 여러 개 있다면, 구분할 수 없다. 이때, @Qualifier를 통해 식별자를 부여하면 원하는 객체를 주입받을 수 있다.

- @Primary를 사용하게 되면 default값으로 설정할 수 있으며, 이 때에는 식별자 없이 주입 시 @Primary가 사용된 객체가 주입된다.

- ex1)
	~~~
	@Qualifier("식별자A") @Primary
	public class 클래스명A implements 인터페이스{
		필드
	}

	@Qualifier("식별자B")
	public class 클래스명B implements 인터페이스{
		필드
	}
	~~~  

- ex2)
	~~~
	@Autowired
	@Qualifier("식별자B")
	private 인터페이스 객체;
	~~~

- 위의 예시에서 같은 인터페이스를 구현하는 클래스가 두 개 이상있을 때 어떤 클래스의 인터페이스 객체를 의존성 주입해줄 것인지 명확히 할 때 사용

- ex) Computer 인터페이스 생성
	- 
	- ![](https://i.imgur.com/cI0sG1C.png)

- ex) Computer인터페이스를 구현하는 Desktop 클래스를 생성 후 @Qualifier로 식별해준다.
	- 
	- ![](https://i.imgur.com/1Txm16E.png)

- ex) Laptop 클래스 생성 후 똑같이 해준 후 @Primary를 붙여서 default값으로 설정해준다.
	- 
	- ![](https://i.imgur.com/t3rQzgE.png)

- ex) 의존성 주입을 받을 클래스를 생성 후 단위 테스트를 위한 어노테이션을 붙여준 후 주입을 해준 후에 Junit Test로 실행해준다.
	- 
	- ![](https://i.imgur.com/rqtiGOx.png)

- ex) @Primary 예시
	- 
	- ![](https://i.imgur.com/Nl4VHlS.png)
