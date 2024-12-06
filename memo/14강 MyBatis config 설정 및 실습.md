# 14강 MyBatis config 설정 및 실습

# 실습

## 1. 테이블 생성

```sql
CREATE TABLE TBL_TEST(
	ID VARCHAR2(1000) PRIMARY KEY,
	NAME VARCHAR2(500)
);

INSERT INTO TBL_TEST
VALUES('java1234', '자바');
INSERT INTO TBL_TEST
VALUES('python4321', '파이썬');
```

## 2. SQL 테이블의 속성과 매칭되는 VO(ValueObject) 클래스 생성

```java
package com.example.ex01.domain.vo;

import lombok.Data;

@Data
public class TestVO {
	private String id;
	private String name;
}
```

## 3. VO클래스를 담을 인터페이스 및 List 메서드 생성

```java
package com.example.ex01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ex01.domain.vo.TestVO;

@Mapper
public interface TestMapper {
	
	public List<TestVO> getList();

}
```

## 4. 테이블을 조회할 XML 파일 생성 및 쿼리문 입력

```sql
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.ex01.mapper.TestMapper">
	<select id="getList" resultType="com.example.ex01.domain.vo.TestVO">
		SELECT ID, NAME FROM TBL_TEST
	</select>
</mapper>
```

## 5. 단위 테스트를 실행할 클래스 생성

```java
package com.example.ex01.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TestMapperTests {
	
	@Autowired
	private TestMapper testMapper;
	
	@Test
	public void getListTest() {
		testMapper.getList().forEach(log::info);
	}
}
```

# MyBatis config 설정

- config 폴더의 config.xml 파일에서 mappers 폴더 안에 있는 xml 파일의 resultType이 가진 긴 문장을 alias(별명)을 줌으로써 줄일 수 있다.

![image](https://github.com/user-attachments/assets/ddb428cc-e2d2-424d-94ce-2ee6aa1e7363)

## config 파일에서 SQL 속성하고 매칭되는 클래스에 alias를 부여

```sql
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0/EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<typeAliases>
		<typeAlias type="com.example.ex01.domain.vo.TestVO" alias="testVO"/>
	</typeAliases>
</configuration>
```

## config 파일에서 alias를 부여 후 기존 mapper.xml 파일에도 똑같이 alias를 입력한다.

```sql
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.ex01.mapper.TestMapper">
	<select id="getList" resultType="testVO">
		SELECT ID, NAME FROM TBL_TEST
	</select>
</mapper>
```
