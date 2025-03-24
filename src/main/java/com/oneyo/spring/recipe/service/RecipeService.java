package com.oneyo.spring.recipe.service;

import java.util.List;
import java.util.Map;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;

public interface RecipeService {

	int getTotalCount();

	int insertRecipe(RecipeInsertRequest recipe);

	RecipeVO selectOneByNo(int recipeNo);

	List<RecipeVO> selectListAll(int currentPage);

	List<RecipeVO> selectSearchList(Map<String, String> paramMap, int currentPage);

	int getTotalCount(Map<String, String> paramMap);

	List<RecipeVO> selectPersonalList(String memberId, int currentPage);
}
