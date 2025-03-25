package com.oneyo.spring.step.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.service.StepService;
import com.oneyo.spring.step.store.StepStore;

@Service
public class StepServiceImpl implements StepService {

	private StepStore sStore;
	private SqlSession session;
	
	@Autowired
	public StepServiceImpl(StepStore sStore, SqlSession session) {
		this.sStore = sStore;
		this.session = session;
	}
	@Override
	public List<StepVO> getStepsByNo(int recipeNo) {
		List<StepVO> stepListByRecipeNo = sStore.getStepsByNo(session, recipeNo);
		for(StepVO step : stepListByRecipeNo) {
//            System.out.println("Step Content: " + step.getStepContent());  // stepContent 출력
		}
		return stepListByRecipeNo;
	}
	
	@Override
	public StepVO selectStepByNo(int stepNo) {
		StepVO step = sStore.selectStepByNo(session, stepNo);
		return step;
	}

	@Override
	public int insertStep(StepInsertRequest step) {
		int result = sStore.insertStep(session, step);
		return result;
	}

	@Override
	public int updateStep(StepUpdateRequest step) {
		int result = sStore.updateStep(session, step);
		return result;
	}

	@Override
	public int deleteStep(int stepNo) {
		int result = sStore.deleteStep(session, stepNo);
		return result;
	}

}
