package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.mappers.BoardMapper;
import com.example.domains.BoardVO;
import com.example.services.BoardService;
import com.example.services.impl.BoardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class BoardServiceTest {
	
	
	private static Logger logger = LoggerFactory.getLogger(BoardServiceTest.class);
	
	@TestConfiguration
	public static class BoardServiceTestConfiguration{
		@Bean
		public BoardService boardService() {
			return new BoardServiceImpl();
		}
	}
	
	@Autowired
	private BoardService boardService;
	
	@MockBean
	private BoardMapper boardMapper;
	
	@Before
	public void setup() {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setWriter("yjy");
		board.setContent("Welcome!!!!");
		
		Mockito.when(boardService.findByBno(1)).thenReturn((List<BoardVO>) board);
	}
	
	@Test
	public void testFindByUserId() {
		logger.info("#### testFindByUserId() ####");
		BoardVO board = (BoardVO) boardService.findByBno(1);
		logger.info("list.get(0).getUserName() : " + board.getWriter());
		logger.info("list.get(0).getContent() : " + board.getContent());

		assertThat(board.getWriter()).isEqualTo("yjy");
	}

}
