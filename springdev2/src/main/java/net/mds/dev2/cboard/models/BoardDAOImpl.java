package net.mds.dev2.cboard.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BoardDAOImpl implements BoardDAO {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		String sql = "insert into cboard(no, title, name, password, content) values("
				+ "seq_cboard.nextval, ?, ?, ?, ? )";

		Object[] args = { boardVO.getTitle(), boardVO.getName(), boardVO.getPassword(), boardVO.getContent() };

		jdbcTemplate.update(sql, args);
	}

	@Override
	public List<BoardVO> listBoard() throws Exception {
		String sql = "select no, level , title, name, readcount, to_char(regdate,'yyyy.mm.dd') as regdate from CBOARD connect by prior no = pno start with pno is null order siblings by no desc";

		RowMapper<BoardVO> rowMapper = new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rownum) throws SQLException {
				BoardVO boardVO = new BoardVO();
				boardVO.setLevel(rs.getInt("level"));
				boardVO.setNo(rs.getInt("no"));
				boardVO.setName(rs.getString("name"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setRegdate(rs.getString("regdate"));
				return boardVO;
			}

		};

		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public BoardVO getArticle(final long no) throws Exception {
		String sql = "select no, title, name, content, readcount, regdate from cboard where no = ?";
				
		Object[] args = {	no	};
		RowMapper<BoardVO> rowMapper = new RowMapper<BoardVO>() {

			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO boardVO = new BoardVO();
				boardVO.setNo(no);
				boardVO.setName(rs.getString("name"));
				boardVO.setTitle(rs.getString("title"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setReadcount(rs.getInt("readcount"));
				boardVO.setRegdate(rs.getString("regdate"));
				return boardVO;
			}
			
		};
		
		return jdbcTemplate.queryForObject(sql,args, rowMapper);
	}

	@Override
	public void incrementReadcount(long no) throws Exception {
		String sql = "update cboard set readcount = readcount + 1 where no = ?";
		
		 
		jdbcTemplate.update(sql,new Object[]{no});
	}

	@Override
	public void replyBoard(BoardVO boardVO) throws Exception {
		String sql = "insert into cboard(no, pno, title, name, password, content) values("
				+ "seq_cboard.nextval, ?, ?, ?, ?, ? )";

		Object[] args = { boardVO.getPno() , boardVO.getTitle(), boardVO.getName(), boardVO.getPassword(), boardVO.getContent() };

		jdbcTemplate.update(sql, args);
	}
}
