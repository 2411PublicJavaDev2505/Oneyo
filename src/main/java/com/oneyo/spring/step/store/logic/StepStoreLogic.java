package com.oneyo.spring.step.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.store.StepStore;

@Repository
public class StepStoreLogic implements StepStore{
	
	@Override
	public StepVO selectStepByNo(SqlSession session, int stepNo) {
		StepVO step = session.selectOne("RecipeContentMapper.selectStepByNo", stepNo);
		return step;
	}

	@Override
	public int insertStep(SqlSession session, StepInsertRequest step) {
		int result = session.insert("RecipeContentMapper.insertStep", step);
		return result;
	}

	@Override
	public int updateStep(SqlSession session, StepUpdateRequest step) {
		int result = session.update("RecipeContentMapper.updateStep", step);
		return result;
	}

	@Override
	public int deleteStep(SqlSession session, int stepNo) {
		int result = session.update("RecipeContentMapper.deleteStep", stepNo);
		return result;
	}
	@Override
	public List<StepVO> getStepsByNo(SqlSession session, int recipeNo) {
		List<StepVO> stepList = session.selectList("StepMapper.getStepsByNo", recipeNo);
		return stepList;
	}
	@Override
	public List<StepVO> getStepByRecipeNo(SqlSession session, int recipeNo) {
		List<StepVO> stepList = session.selectList("StepMapper.getStepByRecipeNo", recipeNo);
		return stepList;
	}
	@Override
	public List<SourcesVO> getSourcesByRecipeNo(SqlSession session, int recipeNo) {
		List<SourcesVO> sourcesList = session.selectList("StepMapper.getSourcesByRecipeNo", recipeNo);
		return sourcesList;
	}

	
}
