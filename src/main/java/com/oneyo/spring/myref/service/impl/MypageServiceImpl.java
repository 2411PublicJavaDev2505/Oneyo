package com.oneyo.spring.myref.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.oneyo.spring.myref.controller.dto.MySourceList;
import com.oneyo.spring.myref.service.MypageService;
import com.oneyo.spring.myref.store.MypageStore;

@Service
public class MypageServiceImpl implements MypageService{
	private MypageStore mStore;
	private SqlSession session;
	
	public MypageServiceImpl(MypageStore mStore, SqlSession session) {
		this.mStore = mStore;
		this.session = session;
		
	}
	
	
	@Override
	public List<MySourceList> selectCoolSourceList() {
		List<MySourceList> mList = mStore.selectCoolSourceList(session);
		return mList;
	}


	@Override
	public List<MySourceList> selectIceSourceList() {
		List<MySourceList> iList = mStore.selectIceSourceList(session);
		return iList;
	}


	@Override
	public List<MySourceList> selectStorageList(Map<String, String> paramMap) {
		List<MySourceList> storageList = mStore.selectStorageList(session, paramMap);
		return storageList;
	}




}
