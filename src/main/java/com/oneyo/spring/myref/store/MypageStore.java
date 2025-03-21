package com.oneyo.spring.myref.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.myref.controller.dto.MySourceList;

public interface MypageStore {

	List<MySourceList> selectCoolSourceList(SqlSession session);

	List<MySourceList> selectIceSourceList(SqlSession session);

	List<MySourceList> selectStorageList(SqlSession session, Map<String, String> paramMap);


}
