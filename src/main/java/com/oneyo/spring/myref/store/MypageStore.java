package com.oneyo.spring.myref.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.myref.controller.dto.MySourceList;

public interface MypageStore {

	List<MySourceList> selectSourceList(SqlSession session);

}
