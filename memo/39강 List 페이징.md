# 39강 List 페이징

# 화면 페이징 처리

- ORDER BY보다 인덱스를 사용하면 정렬을 생략할 수 있다.
- 인덱스라는 존재가 이미 정렬된 구조이므로 이를 이용해서 별도의 정렬을 하지 않는다.
- 예를 들어 데이터베이스 테이블을 하나의 책이라고 가정하면, 인덱스는 각 페이지 번호를 의미한다.
- 이를 통해서 원하는 내용을 위에서부터 혹은 반대로 찾아나가는 것을 ‘스캔(scan)’이라고 표현한다.
- 데이터베이스에 테이블을 만들 때 PK를 부여하면 PK 컬럼을 기준으로 인덱스가 생성되고, 이는 실제 테이블의 데이터가 어디에 저장되어 있는 지를 찾을 수 있는 KEY값이다. 실제 테이블의 데이터가 저장된 각 행에는 ‘ROWID’라는 것이 존재하고 데이터베이스 내의 주소값을 의미한다.

# 예시

## 정렬 전

| BNO | ROWID |
| --- | --- |
| 1 | AAAE8A |
| 2 | AAAE8B |
| 3 | AAAE8C |
| … | … |
| 1000 | ABCD8A |

| BNO | ROWID | TITLE | CONTENT |
| --- | --- | --- | --- |
| 1 | AAAE8A | … | … |
| 2 | AAAE8B | … | … |
| 3 | AAAE8C | … | … |
| … | … | … | … |
| 1000 | ABCD8A | … | … |

# 힌트(Hint)

- SELECT문에 실행하고 싶을 계획을 전달할 때 사용하는 문법
- 잘못 작성되어도 실행할 때에는 무시되며 별도의 오류는 발생하지 않는다.

```sql
/*+로 시작되며 */로 마친다. 또한 뒤에 컬럼명을 작성할 때 ,(콤마)를 사용하지 않는다.
```

- 페이징 처리에서는 이미 정렬된 인덱스를 내림차순으로 가지고 오는 문법을 힌트 내에 작성해준다. 별도의 정렬이 필요 없어지므로 문법의 가독성이 좋아진다.

# 페이징 처리 위한 데이터 복사

- 한번 실행시킬 때 마다 입력된 데이터의 양이 기하급수적으로 늘어난다.

```sql
INSERT INTO HR.TBL_BOARD
(BNO, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE)
SELECT 
	SEQ_BOARD.NEXTVAL, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE
FROM TBL_BOARD;
```

# SQL 데이터 정렬

- ORDER BY를 쓰지 않아도  쉽게 정렬이 가능하다.

```sql
SELECT /*+ INDEX_DESC(TBL_BOARD, SYS_C007591)*/
BNO, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE
FROM TBL_BOARD;
```

# XML 쿼리문 수정

- DB쪽에서 바뀐 SELECT문을 똑같이 바꿔준다.

```sql
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.board.mapper.BoardMapper">
	<select id="getList" resultType="boardVO">
	<![CDATA[
	SELECT BNO, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE
	FROM
		(
		SELECT /*+ INDEX_DESC(TBL_BOARD, SYS_C007591)*/
		ROWNUM RN, BNO, TITLE, CONTENT, WRITER, REGDATE, UPDATEDATE
		FROM TBL_BOARD WHERE ROWNUM <= #{pageNum} * #{amount}
		)
		WHERE RN > (#{pageNum} -1) * #{amount}
	]]>
	</select>

	<insert id="insert">
		<selectKey keyProperty="bno" order="BEFORE"
			resultType="long">
			SELECT SEQ_BOARD.NEXTVAL FROM DUAL
		</selectKey>
		INSERT INTO TBL_BOARD (BNO, TITLE, CONTENT, WRITER)
		VALUES (#{bno},
		#{title}, #{content}, #{writer})
	</insert>

	<select id="read" resultType="boardVO">
		SELECT BNO, TITLE, CONTENT, WRITER,
		REGDATE, UPDATEDATE
		FROM TBL_BOARD WHERE BNO = #{bno}
	</select>

	<delete id="delete">
		DELETE FROM TBL_BOARD WHERE BNO = #{bno}
	</delete>

	<update id="update">
		UPDATE TBL_BOARD
		SET TITLE = #{title}, CONTENT =
		#{content}, WRITER = #{writer}, UPDATEDATE = SYSDATE
		WHERE BNO = #{bno}
	</update>

</mapper>
```

# 페이징 게시글 수 연산 클래스 생성

- 하나의 페이지에서 보여줄 게시글의 수를 조절할 클래스를 생성한다.

```java
package com.example.board.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
	
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1, 10);
	}
	
}
```

# 기존 DAO 클래스 수정

- Criteria 클래스를 매개변수로 받을 수 있게 기존 코드를 수정해준다.

```java
package com.example.board.domain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Repository
public interface BoardDAO {
	
	// 게시글 등록
	public void register(BoardVO board);
	
	// 특정 게시글 가져오기
	public BoardVO get(Long bno);
	
	// 게시글 수정
	public boolean Modify(BoardVO board);
	
	// 게시글 삭제
	public boolean remove(Long bno);
	
	// 전체 게시글 가져오기
	public List<BoardVO> getList(Criteria criteria);

}
```

- DAO 인터페이스를 구현한 클래스수정

```java
package com.example.board.domain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class BoardDAOImple implements BoardDAO{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public void register(BoardVO board) {
		boardMapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return boardMapper.read(bno);
	}

	@Override
	public boolean Modify(BoardVO board) {
		return boardMapper.update(board) != 0;
	}

	@Override
	public boolean remove(Long bno) {
		return boardMapper.delete(bno) != 0;
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		return boardMapper.getList(criteria);
	}

}
```

# 기존 Mapper 인터페이스 수정

```java
package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Mapper
public interface BoardMapper {

	public List<BoardVO> getList(Criteria criteria);
	
	public void insert(BoardVO board); // 삽입

	public BoardVO read(Long bno); // 조회
	
	public int delete(Long bno); // 삭제
	
	public int update(BoardVO board); // 업데이트

}
```

# 기존 Service 인터페이스 수정

```java
package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Service
public interface BoardService {
	
	// 게시글 등록
	public void register(BoardVO board);
	
	// 특정 게시글 가져오기
	public BoardVO get(Long bno);
	
	// 게시글 수정
	public boolean modify(BoardVO board);
	
	// 게시글 삭제
	public boolean remove(Long bno);
	
	// 전체 게시글 가져오기
	public List<BoardVO> getList(Criteria criteria);

}
```

- Service 인터페이스를 구현하는 클래스도 수정해준다.

```java
package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Service
public class BoardServiceImple implements BoardService{
	
	@Autowired
	BoardDAO boardDAO;
	
	@Override // 등록
	public void register(BoardVO board) {
		
		boardDAO.register(board);
	}

	@Override // 조회
	public BoardVO get(Long bno) {

		return boardDAO.get(bno);
	}

	@Override // 수정
	public boolean modify(BoardVO board) {
		
		return boardDAO.Modify(board);
	}

	@Override // 삭제
	public boolean remove(Long bno) {

		return boardDAO.remove(bno);
	}

	@Override // 전체 목록 조회
	public List<BoardVO> getList(Criteria criteria) {
		
		return boardDAO.getList(criteria);
	}

}
```

# 기존 Controller 수정

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
import com.example.board.domain.vo.Criteria;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

/*
 * Task		   	URL				    	 Method		Parameter 	Form 		      URL이동
 * 
 * 전체 목록		/board/list			 GET						
 * 등록 처리 	/board/register	 POST		  모든 항목		입력화면 필요	이동
 * 조회			  /board/read			 GET			bno						
 * 삭제 처리		/board/remove		 GET			bno			    입력화면 필요	이동
 * 수정 처리		/board/modify		 POST		  모든 항목		입력화면 필요	이동
 * */

@Controller
@Log4j
@RequestMapping("/board/**")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public void list(Criteria criteria, Model model) {
		log.info("/list");
		model.addAttribute("boardList", boardService.getList(criteria));
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