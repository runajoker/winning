package net.mds.dev2.cboard.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.mds.dev2.cboard.models.BoardDAO;
import net.mds.dev2.cboard.models.BoardVO;

public class BoardReply extends AbstractController{

	private static Logger logger = LoggerFactory.getLogger(BoardReply.class);
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long no = Long.parseLong(request.getParameter("no")); 
		
		
			
			boardDAO.incrementReadcount(no);
			BoardVO boardVO = boardDAO.getArticle(no);
			logger.info(" "+boardVO.getNo());
			logger.info(" "+boardVO.getTitle());
			return new ModelAndView("board/reply", "boardVO", boardVO);
			
		
	}

}
