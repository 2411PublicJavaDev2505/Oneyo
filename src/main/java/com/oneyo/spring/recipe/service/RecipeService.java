package com.oneyo.spring.recipe.service;

import java.util.List;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;

public interface RecipeService {

	int getTotalCount();

	List<RecipeVO> selectRecipeList();
	
	int insertRecipe(RecipeInsertRequest recipe);

	RecipeVO selectOneByNo(int recipeNo);

	List<RecipeVO> selectListAll(int currentPage);
}
