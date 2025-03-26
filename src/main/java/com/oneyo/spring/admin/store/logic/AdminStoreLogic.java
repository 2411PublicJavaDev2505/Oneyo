package com.oneyo.spring.admin.store.logic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.admin.controller.dto.MemberListRequest;
import com.oneyo.spring.admin.store.AdminStore;
import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.myref.controller.dto.CategoryList;

@Repository
public class AdminStoreLogic implements AdminStore {

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		return session.delete("MemberMapper.deleteMember", memberId);
	}

	@Override //회원 전체목록 조회
	public List<MemberVO> selectAllMember(SqlSession session, int currentPage) {
		int limit = 7;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("AdminMapper.selectAllMember", null, rowBounds);
	}

	@Override // 회원 검색
	public List<MemberListRequest> selectOneByKeyword(SqlSession session, Map<String, String> paramMap, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("AdminMapper.selectOneByKeyword", paramMap, rowBounds);
	}

	@Override // 페이지네이션(전체조회)
	public int selectListCount(SqlSession session) {
		return session.selectOne("AdminMapper.selectListCount");
	}

	@Override // 페이지네이션(검색)
	public int getSearchCount(SqlSession session, Map<String, String> paramMap) {
		return session.selectOne("AdminMapper.getSearchCount", paramMap);
	}


	@Override
	public int updateCategory(SqlSession session, CategoryList cList) {
			return session.update("AdminMapper.updateCategory", cList);
	}

	@Override
	public int insertCategory(SqlSession session, CategoryList cList) {
			return session.insert("AdminMapper.insertCategory", cList);
	}

}
