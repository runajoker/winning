package net.mds.dev2.cboard.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import net.mds.dev2.cboard.models.BoardDAO;
import net.mds.dev2.cboard.models.BoardVO;

public class BoardList extends AbstractController {

	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		try {
			List<BoardVO> list = boardDAO.listBoard();
			return new ModelAndView("board/list", "list", list);
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg","리스트 실패실패");
			mav.addObject("url", "../");
			return mav;
		}
	}

}
