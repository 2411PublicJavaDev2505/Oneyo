package com.oneyo.spring.board.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.board.controller.dto.BoardAddRequest;
import com.oneyo.spring.board.domain.BoardVO;
import com.oneyo.spring.board.store.BoardStore;

@Repository
public class BoardStoreLogic implements BoardStore {

	@Override // 게시글 등록
	public int insertBoard(SqlSession session, BoardAddRequest board) {
		int result = session.insert("BoardMapper.insertBoard", board);
		return (result>0) ? board.getBoardNo() : 0;
	}

	@Override // 게시글 수정
	public int updateBoard(SqlSession session, BoardAddRequest board) {
		return session.update("BoardMapper.updateBoard", board);
	}

	@Override // 게시글 삭제
	public int deleteBoard(SqlSession session, int boardNo) {
		return session.update("BoardMapper.deleteBoard", boardNo);
	}

	@Override // 조회수
	public Integer boardCountUpdate(SqlSession session, int boardNo) {
		return session.selectOne("BoardMapper.boardCountUpdate", boardNo);
	}

	@Override // 공지사항 리스트
	public List<BoardVO> selectNoticeBoard(SqlSession session) {
		return session.selectList("BoardMapper.selectNoticeBoard");
	}

	@Override // 일반게시판 리스트
	public List<BoardVO> selectAllBoard(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("BoardMapper.selectAllBoard", null, rowBounds);
	}

	@Override // 상세
	public BoardVO selectOneBoard(SqlSession session, int boardNo) {
		return session.selectOne("BoardMapper.selectOneBoard", boardNo);
	}

//	@Override // 공지사항 검색
//	public List<BoardVO> NoticeOneByKeyword(SqlSession session, Map<String, String> paramMap) {
//		return session.selectList("BoardMapper.NoticeOneByKeyword", paramMap);
//	}

	@Override // 일반게시글 검색
	public List<BoardVO> selectOneByKeyword(SqlSession session, Map<String, String> paramMap, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("BoardMapper.selectOneByKeyword", paramMap, rowBounds);
	}

	@Override // 페이지네이션
	public int getTotalCount(SqlSession session) {
		return session.selectOne("BoardMapper.getTotalCount");
	}

	@Override // 페이지네이션(검색)
	public int getTotalCount(SqlSession session, Map<String, String> paramMap) {
		return session.selectOne("BoardMapper.getSearchCount", paramMap);
	}

	@Override // 멤버에서 닉네임 가져오기
	public String getMemberNickname(SqlSession session, String memberId) {
		return session.selectOne("BoardMapper.getMemberNickname", memberId);
	}

}
