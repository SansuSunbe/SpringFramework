
- @AllArgsConstructor
	- 모든 참조 변수에 생성자를 주입한다.

- @RequiredArgsConstructor
	- final 키워드 or @NomNull 어노테이션이 붙은 참조변수에만 생성자를 주입한다.

- @NonNull
	- 이 어노테이션이 붙은 참조변수는 절대 Null값이 들어갈 수 없다.
	- 참조변수에 final 대신 사용할 수 있으나 주로 final이 사용되기에 잘 사용되진 않는다.