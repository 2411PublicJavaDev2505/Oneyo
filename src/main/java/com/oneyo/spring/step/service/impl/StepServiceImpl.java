package com.oneyo.spring.step.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.service.StepService;
import com.oneyo.spring.step.store.StepStore;

@Service
public class StepServiceImpl implements StepService{
	
	private StepStore stepStore;
	private SqlSession session;
	
	public StepServiceImpl(StepStore stepStore, SqlSession session) {
		this.stepStore = stepStore;
		this.session = session;
	}
	
	@Override
	public List<StepVO> getStepsByNo(int recipeNo) {
		List<StepVO> stepListByRecipeNo = stepStore.getStepsByNo(session, recipeNo);
		for(StepVO step : stepListByRecipeNo) {
//            System.out.println("Step Content: " + step.getStepContent());  // stepContent 출력
        }
		return stepListByRecipeNo;
	}
}
