# 08강 의존성 주입(setter, 생성자)

# @Data어노테이션과 final 주의점

- `@Data` 어노테이션이 포함된 클래스에서 `final` 필드를 선언해도 오류가 발생하지 않는 이유는 Lombok이 `final` 필드에 대해 setter 메서드를 생성하지 않기 때문
- `@Data` 어노테이션을 사용할 때 `final` 필드를 추가하는 것은 문제가 되지 않지만, 객체 지향 설계의 유연성을 고려하여 적절히 사용하는 것이 중요

# @AllArgsConstructor

- 클래스에 있는 모든 필드를 매개변수로 받는 생성자를 자동으로 생성해준다.

# @RequiredArgsConstructor

- 초기화가 필요한 필드의 생성자를 자동으로 생성해주는 어노테이션
- ‘final’ 키워드나 @NonNull 어노테이션이 붙은 필드만 자동으로 생성자를 생성해준다. 이를 통해 불변 필드나 초기화가 필요한 필드를 초기화 할 수 있다.

# 예시

```java
package com.example.ex00.dependency;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
@Getter
//@AllArgsConstructor
@RequiredArgsConstructor
public class Coding {

// 	필드 주입
// 	편하게 주입할 수 있으나 순환 참조(무한 루프)시
// 	오류가 발생하지 않기 때문에 StackOverFlow 발생
// 	final을 붙일 수 없기 때문에 다른 곳에서 변형 가능
//	@Autowired
//	@NonNull
	private final Computer computer;

//	생성자 주입
//	순환 참조 시 컴파일러가 인지 가능, 오류 발생
//	메모리에 할당하면서 초기값으로 주입되므로 final 키워드 사용 가능 
//	다른 곳에서 변형 불가능
//	의존성 주입이 되지 않으면 객체가 생성되지 않으므로 
//	@Autowired
//	public Coding(Computer computer) {
//		super();
//		this.computer = computer;
//	}

// 	Setter 주입
// 	편하게 주입할 수 있으나 순환 참조(무한 루프)시
// 	오류가 발생하지 않기 때문에 StackOverFlow 발생
// 	final을 붙일 수 없기 때문에 다른 곳에서 변형 가능
//	외부에서 직접 주입이 가능함
//	@Autowired
//	public void setComputer(Computer computer) {
//		this.computer = computer;
//	}

}
```