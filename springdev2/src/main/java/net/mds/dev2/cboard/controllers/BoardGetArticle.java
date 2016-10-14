package net.mds.dev2.cboard.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.mds.dev2.cboard.models.BoardDAO;
import net.mds.dev2.cboard.models.BoardVO;

public class BoardGetArticle extends AbstractController{

	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		long no = Long.parseLong(arg0.getParameter("no")); 
		
		try {
			
			boardDAO.incrementReadcount(no);
			BoardVO boardVO = boardDAO.getArticle(no);
			return new ModelAndView("/board/article", "boardVO", boardVO);
			
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", "글 불러오기 실패");
			mav.addObject("url", "../");
			return mav;
		}
	}

}
