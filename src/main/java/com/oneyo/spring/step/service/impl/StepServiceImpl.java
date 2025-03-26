package com.oneyo.spring.step.service.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.recipe.store.RecipeStore;
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.sources.store.SourcesStore;
import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.service.StepService;
import com.oneyo.spring.step.store.StepStore;

@Service
public class StepServiceImpl implements StepService {

	private RecipeStore rStore;
	private StepStore sStore;
	private SourcesStore sourceStore;
	private SqlSession session;
	
	@Autowired
	public StepServiceImpl(StepStore sStore, RecipeStore rStore, SqlSession session) {
		this.rStore = rStore;
		this.sStore = sStore;
		this.session = session;
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
	@Override
	public void insertStep(RecipeVO recipe) {
		// 1. 레시피 저장
	    rStore.insertRecipe(session, recipe);  // RecipeStore에서 insert 처리
	    // 2. 단계 및 레시피 내용 처리
	    for (StepVO step : recipe.getStepList()) {
	        sStore.insertStep(session, step);  // StepStore에서 insert 처리
	    }
	    // 3. 재료 처리
	    for (SourcesVO source : recipe.getSourceList()) {
	        sourceStore.insertSource(session, source);  // SourcesStore에서 insert 처리
	    }
	}


	public StepVO selectStepByNo(int stepNo) {
		StepVO step = sStore.selectStepByNo(session, stepNo);
		return step;
	}

	@Override
	public RecipeVO selectRecipeByNo(int recipeNo) {
		RecipeVO recipe = rStore.selectRecipeByNo(session, recipeNo);
		return recipe;
	}

	@Override
	public List<StepVO> getStepsByNo(int recipeNo) {
		List<StepVO> stepListByRecipeNo = sStore.getStepsByNo(session, recipeNo);
		for(StepVO step : stepListByRecipeNo) {
		}
		return stepListByRecipeNo;
	}

	@Override
	public List<SourcesVO> getSourcesByRecipeNo(int recipeNo) {
		List<SourcesVO> sourcesListByRecipeNo = sStore.getSourcesByRecipeNo(session, recipeNo);
		for(SourcesVO sources : sourcesListByRecipeNo) {	
		}
		return sourcesListByRecipeNo;
	}

	@Override
	public List<StepVO> getStepsByRecipeNo(int recipeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertStep(StepVO step) {
		// TODO Auto-generated method stub
		
	}

	



	

	

	
	

	

	

	
	

}
