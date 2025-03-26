package com.oneyo.spring.recipe.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.controller.dto.RecipeUpdateRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;

public interface RecipeService {

	int getTotalCount();

	List<RecipeVO> selectListAll(int currentPage);

	List<RecipeVO> selectRecipeList(int currentPage);

	RecipeVO selectOneByNo(int recipeNo);
	
	int insertRecipe(RecipeInsertRequest recipe);

	List<RecipeVO> selectSearchList(Map<String, String> paramMap, int currentPage);

	int getTotalCount(Map<String, String> paramMap);

	List<RecipeVO> selectPersonalList(String memberId, int currentPage);
	
	int deleteRecipe(int recipeNo);

	List<RecipeVO> selectRecipeStep(int recipeNo);

	int updateRecipe(RecipeUpdateRequest recipe);


}
