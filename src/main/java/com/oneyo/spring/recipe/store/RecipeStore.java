package com.oneyo.spring.recipe.store;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.controller.dto.RecipeUpdateRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;

public interface RecipeStore {

	List<RecipeVO> selectListAll(SqlSession session, int currentPage);

	RecipeVO selectOneByNo(SqlSession session, int recipeNo);

	int getTotalCount(SqlSession session);

	List<RecipeVO> selectSearchList(SqlSession session, Map<String, String> paramMap, int currentPage);

	int getTotalCount(SqlSession session, Map<String, String> paramMap);

	List<RecipeVO> selectPersonalList(SqlSession session, String memberId, int currentPage);
	
	List<RecipeVO> selectRecipeList(SqlSession session, int currentPage);

	int updateBoard(SqlSession session, RecipeUpdateRequest recipe);

	int deleteBoard(SqlSession session, int recipeNo);

	List<RecipeVO> selectRecipeStep(SqlSession session, int recipeNo);

	RecipeVO selectRecipeByNo(SqlSession session, int recipeNo);

	int insertRecipe(SqlSession session, RecipeInsertRequest recipeRequest);
}
