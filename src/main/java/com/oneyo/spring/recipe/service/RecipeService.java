package com.oneyo.spring.recipe.service;

import java.util.List;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.controller.dto.RecipeUpdateRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;

public interface RecipeService {

	int getTotalCount();

	List<RecipeVO> selectRecipeList();
	
	List<RecipeVO> selectListAll(int currentPage);

	RecipeVO selectOneByNo(int recipeNo);
	
	int insertRecipe(RecipeInsertRequest recipe);

	int updateRecipe(RecipeUpdateRequest recipe);

	int deleteRecipe(int recipeNo);
}
