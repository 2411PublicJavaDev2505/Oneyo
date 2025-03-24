package com.oneyo.spring.mypage.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.mypage.domain.MySourceList;

public interface MypageStore {

	List<MySourceList> selectSourceList(SqlSession session);

}
