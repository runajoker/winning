package net.mds.dev2.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.mds.dev2.cboard.models.BoardVO;

//@Controller("board")
@Controller
@RequestMapping("board")// 해도 된다
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@RequestMapping("insert")
	public void insert(){}
	
	@RequestMapping( value = "insert", method =RequestMethod.POST)
	public void insert(BoardVO boardVO){
		logger.info(boardVO.toString());
		
	}
	
}
