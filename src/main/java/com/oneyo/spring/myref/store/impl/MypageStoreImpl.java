package com.oneyo.spring.myref.store.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.store.MypageStore;

@Repository
public class MypageStoreImpl implements MypageStore{

	@Override
	public List<MySourceList> selectSourceList(SqlSession session) {
		List<MySourceList> mList = session.selectList("mySourceList.selectSourceList");
		return mList;
	}

}
