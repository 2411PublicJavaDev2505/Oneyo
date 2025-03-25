package com.oneyo.spring.step.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.step.domain.StepVO;

public interface StepStore {

	List<StepVO> getStepsByNo(SqlSession session, int recipeNo);

}
