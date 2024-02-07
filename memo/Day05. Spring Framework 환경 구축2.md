
- STS 실행 후 프로젝트를 생성하였다면 pom.xml에 들어가서 버전을 최신버전으로 바꿔주자(JAVA는 다운받은 jdk버전으로 맞춰주자)
- ![](https://i.imgur.com/nBezpnp.png)


- 64번째줄의 log4j의 버전을 1.2.15에서 1.2.17로 바꿔준다. 그리고 65번째 줄부터 83번째 줄까지 exclusion태그랑 scope태그를 없애주자
- 
- ![](https://i.imgur.com/ybR0W3z.png)

- 76번째 줄부터 78번째 줄까지 다음과 같이 수정해주자.
- 
- ![](https://i.imgur.com/w8OEzrz.png)
- 
- pom.xml 수정 후 에는
- 프로젝트 우클릭 -> maven -> update project -> Force Update 체크 
- 
- ![](https://i.imgur.com/Ci5mPeG.png)
- ![](https://i.imgur.com/9lBLqX2.png)

- 
- Lombok 라이브러리이란?
	- Lombok(롬복)을 이용하면 JAVA 개발 시 getter/setter, toString(), 생성자 등을 @Data등의 어노테이션을 통해 자동으로 생성해준다.

- Lombok 설치
	1. google에 lombok 검색 -> Download -> Project Lombok -> Download -> 실행(java- jar lombok.jar) -> Specify location(IDE 경로 설정) 클릭 -> STS.exe(맥은 ini로) 경로 선택 -> install 클릭 -> STS.exe 경로에 lombok 유무 확인
