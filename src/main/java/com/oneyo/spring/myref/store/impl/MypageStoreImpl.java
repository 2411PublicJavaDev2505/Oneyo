package com.oneyo.spring.myref.store.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.store.MypageStore;

@Repository
public class MypageStoreImpl implements MypageStore{

	@Override
	public List<MySourceList> selectCoolSourceList(SqlSession session) {
		List<MySourceList> mList = session.selectList("sourceList.selectCoolSourceList");
		return mList;
	}

	@Override
	public List<MySourceList> selectIceSourceList(SqlSession session) {
		List<MySourceList> iList = session.selectList("sourceList.selectIceSourceList");
		return iList;
	}

	@Override
	public List<MySourceList> selectStorageList(SqlSession session, Map<String, String> paramMap) {
		List<MySourceList> selectStorage = session.selectList("sourceList.selectStorageList", paramMap);
		System.out.println(selectStorage);
		return selectStorage;
	}



}
