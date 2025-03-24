package com.oneyo.spring.mypage.store.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.mypage.domain.MySourceList;
import com.oneyo.spring.mypage.store.MypageStore;

@Repository
public class MypageStoreLogic implements MypageStore{

	@Override
	public List<MySourceList> selectSourceList(SqlSession session) {
		List<MySourceList> mList = session.selectList("mySourceList.selectSourceList");
		return mList;
	}
	
	

}
