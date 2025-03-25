package com.oneyo.spring.admin.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.admin.store.AdminStore;
import com.oneyo.spring.member.domain.MemberVO;

@Repository
public class AdminStoreLogic implements AdminStore {

	@Override //회원 전체목록 조회
	public List<MemberVO> selectAllMember(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		return session.selectList("AdminMapper.selectAllMember", null, rowBounds);
	}

	@Override // 페이지네이션(전체조회)
	public int selectListCount(SqlSession session) {
		return session.selectOne("AdminMapper.selectListCount");
	}

}
