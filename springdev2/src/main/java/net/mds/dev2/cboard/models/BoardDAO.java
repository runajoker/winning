package net.mds.dev2.cboard.models;

import java.util.List;

public interface BoardDAO {

	void insertBoard(BoardVO boardVO) throws Exception;

	List<BoardVO> listBoard() throws Exception;

	BoardVO getArticle(long no) throws Exception;

	void incrementReadcount(long no) throws Exception;

	void replyBoard(BoardVO boardVO) throws Exception;

}
