package net.mds.dev2.cboard.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.mds.dev2.cboard.models.BoardDAO;
import net.mds.dev2.cboard.models.BoardVO;

public class BoardReplyAction extends AbstractController{
private static Logger logger = LoggerFactory.getLogger(BoardInsertAction.class);
	
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long pno = Long.parseLong(request.getParameter("pno"));
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setPno(pno);
		boardVO.setTitle(title);
		boardVO.setName(name);;
		boardVO.setPassword(password);;
		boardVO.setContent(content);;
		
		logger.info(boardVO.toString());
		System.out.println(boardVO.toString());
		
		
		try {
			boardDAO.replyBoard(boardVO);
			logger.info("입력성공");
			return new ModelAndView("redirect:list");
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","replyFail");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
	}
	
	
}
