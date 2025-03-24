package com.oneyo.spring.board.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.controller.dto.BoardUpdateRequest;
import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.board.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore {

	@Override
	public int insertBoard(SqlSession session, BoardAddRequest board) {
		return session.insert("BoardMapper.insertBoard", board);
	}

	@Override
	public int updateBoard(SqlSession session, BoardUpdateRequest board) {
		return session.update("BoardMapper.updateBoard", board);
	}

	@Override
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.update("BoardMapper.deleteBoard", boardNo);
	}

	@Override
	public List<BoardVO> selectNoticeBoard(SqlSession session) {
		return session.selectList("BoardMapper.selectNoticeBoard");
	}

	@Override
	public List<BoardVO> selectAllBoard(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("BoardMapper.selectAllBoard", null, rowBounds);
	}

	@Override
	public BoardVO selectOneBoard(SqlSession session, int boardNo) {
		return session.selectOne("BoardMapper.selectOneBoard", boardNo);
	}

	@Override
	public List<BoardVO> NoticeOneByKeyword(SqlSession session, Map<String, String> paramMap) {
		return session.selectList("BoardMapper.NoticeOneByKeyword", paramMap);
	}

	@Override
	public List<BoardVO> selectOneByKeyword(SqlSession session, Map<String, String> paramMap, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("BoardMapper.selectOneByKeyword", paramMap, rowBounds);
	}

	@Override
	public int getTotalCount(SqlSession session) {
		return session.selectOne("BoardMapper.getTotalCount");
	}

	@Override
	public int getTotalCount(SqlSession session, Map<String, String> paramMap) {
		return session.selectOne("BoardMapper.getSearchCount", paramMap);
	}

	@Override
	public String getMemberNickname(SqlSession session, String memberId) {
		return session.selectOne("BoardMapper.getMemberNickname", memberId);
	}

}
