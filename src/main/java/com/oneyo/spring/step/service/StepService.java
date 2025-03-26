package com.oneyo.spring.step.service;

import java.util.List;

import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;

public interface StepService {
	
	List<StepVO> getStepsByNo(int recipeNo);
	
	StepVO selectStepByNo(int stepNo);

	int insertStep(StepInsertRequest step);

	int updateStep(StepUpdateRequest step);

	int deleteStep(int stepNo);

	void insertStep(RecipeVO recipe);

	void insertStep(StepVO step);
}
