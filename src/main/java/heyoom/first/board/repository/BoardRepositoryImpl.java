package heyoom.first.board.repository;

import java.util.List;


import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import heyoom.first.board.domain.Board;

public class BoardRepositoryImpl implements BoardRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	public BoardRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public Board postBoard(Board board) {
		System.out.println(board.getBbd_title());
		String sql = "INSERT INTO t_bbd VALUES ((select IFNULL(MAX(bbd_seq) + 1, 1) FROM t_bbd b), 0, now(), ?, ?, ?, ?, null, null, null, null, ?, ?)";
		jdbcTemplate.update(sql, board.getReg_writer(), board.getBbd_title(), board.getBbd_content(), board.getBbd_attach_1(), board.getBbd_password(), board.getInq_security_yn());
		return board;
	}

	@Override
	public List<Board> getBoards() {
		return jdbcTemplate.query("SELECT a.bbd_seq, a.inq_security_yn, a.bbd_title, \r\n"
				+ "             (SELECT MAX(ans_seq) FROM bbd.t_bbd WHERE bbd_seq = a.bbd_seq) AS answer_count,\r\n"
				+ "             a.reg_writer, a.reg_datetime, a.bbd_password,\r\n"
				+ "             IFNULL((SELECT SUM(day_views) FROM bbd.t_inq_cnt WHERE bbd_seq = a.bbd_seq and ans_seq =a.ans_seq), 0) AS total_views \r\n"
				+ "       FROM bbd.t_bbd a \r\n"
				+ "       WHERE a.ans_seq = 0  \r\n"
				+ "       ORDER BY a.bbd_seq desc LIMIT 10", boardRowMapper());
	}
	
	public int getTotalBoards() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from t_bbd", Integer.class);
		return count;
	}
	
	
	
	private RowMapper<Board> boardRowMapper(){
		return (rs, rowNum) -> {
			Board board = new Board();
			board.setBbd_seq(rs.getLong("bbd_seq"));
			board.setReg_writer(rs.getString("reg_writer"));
			board.setReg_datetime(rs.getString("reg_datetime"));
			board.setBbd_title(rs.getString("bbd_title"));
			board.setBbd_password(rs.getString("bbd_password"));
			board.setInq_security_yn(rs.getString("inq_security_yn"));
			board.setAnswer_count(rs.getLong("answer_count"));
			board.setTotal_views(rs.getLong("total_views"));
			board.setTotal_boards(rs.getLong("total_boards"));
			
			return board;
		};
	}
	
}
