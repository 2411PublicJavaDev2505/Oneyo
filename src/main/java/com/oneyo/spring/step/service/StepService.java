package com.oneyo.spring.step.service;

import java.util.List;

import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.step.controller.dto.AddStepRequest;
import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;

public interface StepService {
	
	List<StepVO> getStepsByNo(int recipeNo);
	
	StepVO selectStepByNo(int stepNo);

	int updateStep(StepUpdateRequest step);

	int deleteStep(int stepNo);

	RecipeVO selectRecipeByNo(int recipeNo);

	List<StepVO> getStepsByRecipeNo(int recipeNo);

	List<SourcesVO> getSourcesByRecipeNo(int recipeNo);



	int addStep(List<AddStepRequest> aList);


}
