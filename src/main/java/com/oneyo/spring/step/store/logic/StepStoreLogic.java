package com.oneyo.spring.step.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.store.StepStore;

@Repository
public class StepStoreLogic implements StepStore{
	
	@Override
	public List<StepVO> getStepsByNo(SqlSession session, int recipeNo) {
		List<StepVO> stepList = session.selectList("StepMapper.getStepsByNo", recipeNo);
		return stepList;
	}
}
