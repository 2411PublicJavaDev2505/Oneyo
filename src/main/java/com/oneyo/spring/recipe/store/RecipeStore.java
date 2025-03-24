package com.oneyo.spring.recipe.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.controller.dto.RecipeUpdateRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;

public interface RecipeStore {
	
	List<RecipeVO> selectListAll(SqlSession session, int currentPage);
	
	int insertRecipe(SqlSession session, RecipeInsertRequest recipe);
	
	RecipeVO selectOneByNo(SqlSession session, int recipeNo);

	List<RecipeVO> selectRecipeList(SqlSession session, int currentPage);

	int getTotalCount(SqlSession session);

	int insertBoard(SqlSession session, RecipeInsertRequest recipe);

	int updateBoard(SqlSession session, RecipeUpdateRequest recipe);

	int deleteBoard(SqlSession session, int recipeNo);

	List<RecipeVO> selectRecipeStep(SqlSession session, int recipeNo);
}
