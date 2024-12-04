# 12강 MyBatis 연결 2(SqlSession, Mapper)

# Mapper 인식

- mybatis-psring 체크
- 
![image](https://github.com/user-attachments/assets/80fab8e7-25f9-43fd-af82-bd14f992caa8)

# myBatis_Mapper_Default_Code

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="">
</mapper>
```

- XML 파일에다 붙여 넣고 namespace에는 패키지명을 넣고
- id에는 메서드명, resultType에는 자료형을 넣고 태그 안에다 쿼리문을 넣으면 된다.

```java
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.01.mapper.TimeMapper">
	<select id="getTime2" resultType="string">
		SELECT SYSDATE FROM DUAL
	</select>
</mapper>
```

## 간단한 쿼리문의 경우

- 간단한 쿼리문의 경우 자바 필드에다 넣으면 된다.

```java
package com.example.ex01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/*
 * Mapper 인터페이스
 * 	
 *	SQL을 작성하는 작업은 XML을 이용할 수도 있지만, 
 *	최소한의 코드를 작성하기 위해서는
 *	Mapper 인터페이스를 사용한다.
 * */
@Mapper
public interface TimeMapper {
	@Select("SELECT SYSDATE FROM DUAL") // 간단한 쿼리문은 자바 필드에서 작성
	public String getTime();
	
	public String getTime2();
}
```
