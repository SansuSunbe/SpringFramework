# 56강 댓글 Service 단위 테스트

# 댓글 Service 구현

- ReplyService 인터페이스 생성

```java
package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.vo.ReplyVO;

@Service
public interface ReplyService {
	
	public boolean register(ReplyVO replyVO);
	
	public ReplyVO findByRNO(Long rno);
	
	public boolean remove(Long rno);
	
	public boolean removeAllByBNO(Long bno);
	
	public boolean modify(ReplyVO replyVO);
	
	public List<ReplyVO> findAllByRNO(Long bno);

}
```

- ReplyService 인터페이스를 구현하는 클래스 생성

```java
package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.board.domain.dao.ReplyDAO;
import com.example.board.domain.vo.ReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	
	private final ReplyDAO replyDAO;
	
	@Override
	public boolean register(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return replyDAO.register(replyVO);
	}

	@Override
	public ReplyVO findByRNO(Long rno) {
		// TODO Auto-generated method stub
		return replyDAO.findByRNO(rno);
	}

	@Override
	public boolean remove(Long rno) {
		// TODO Auto-generated method stub
		return replyDAO.remove(rno);
	}

	@Override
	public boolean removeAllByBNO(Long bno) {
		// TODO Auto-generated method stub
		return replyDAO.removeAllByBNO(bno);
	}

	@Override
	public boolean modify(ReplyVO replyVO) {
		// TODO Auto-generated method stub
		return replyDAO.modify(replyVO);
	}

	@Override
	public List<ReplyVO> findAllByRNO(Long bno) {
		// TODO Auto-generated method stub
		return replyDAO.findAllByBNO(bno);
	}

}
```

# 댓글 Service 단위 테스트

```java
package com.example.board.service;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {

	private Long[] arBno = { 16454L, 16453L, 16452L, 16451L, 16450L };

	@Autowired
	private ReplyService replyService;

	@Test
	public void serviceTest() {
		log.info("=====================");
		log.info(replyService);
		log.info("=====================");
	}

//	@Test // 댓글 삽입 테스트
//	public void registerTest() {
//	// 5개의 게시글에 2개씩 댓글 달기
//		IntStream.rangeClosed(31, 40).forEach(i -> {
//			ReplyVO replyVO = new ReplyVO();
//			replyVO.setBno(arBno[i % 5]);
//			replyVO.setReply("댓글 테스트" + i);
//			replyVO.setReplier("댓글 작성자" + i);
//
//			replyService.register(replyVO);
//
//		});
//	}

//	@Test // 지정 댓글 하나 조회 테스트
//	public void finByRNO_test() {
//		log.info(replyService.findByRNO(40L));
//	}

//	@Test // 지정 댓글 하나 삭제 테스트
//	public void removeTest() {
//		log.info(replyService.remove(40L));
//	}

//	@Test // 지정 게시글의 모든 댓글 삭제
//	public void removeAllByBNO_test() {
//		log.info(replyService.removeAllByBNO(16454L));
//	}

//	@Test // 댓글 수정 테스트
//	public void modifyTest() {
//		ReplyVO replyVO = replyService.findByRNO(32L);
//		replyVO.setReply("수정된 댓글 테스트3");
//		
//		log.info(replyService.modify(replyVO) + "수정");
//	}

//	@Test // 지정된 게시글의 댓글 전부 조회
//	public void findAllByBNO() {
//		replyService.findAllByRNO(16452L).forEach(log::info);;
//	}

}
```