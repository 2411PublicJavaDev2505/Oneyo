package com.oneyo.spring.recipe.store.Impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.controller.dto.RecipeUpdateRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.recipe.store.RecipeStore;


@Repository
public class RecipeStoreLogic implements RecipeStore{
	
	@Override
	public List<RecipeVO>selectListAll(SqlSession session, int currentPage) {
		int limit = 5;
		int offset = (currentPage -1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<RecipeVO> rList = session.selectList("RecipeMapper.selectList", null, rowBounds);
		return rList;
	}
	@Override
	public int insertRecipe(SqlSession session, RecipeInsertRequest recipe) {
		int result = session.insert("RecipeMapper.insertRecipe", recipe);
		return result;
	}
	
	@Override
	public List<RecipeVO> selectRecipeList(SqlSession session, int currentPage) {
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<RecipeVO> rList = session.selectList("RecipeMapper.selectRecipeList", null, rowBounds);
		return rList;
	}
	@Override
	public RecipeVO selectOneByNo(SqlSession session, int recipeNo) {
		
		
		System.out.println("여기444444:"+recipeNo);
		RecipeVO recipe = session.selectOne("RecipeMapper.selectOneByNo", recipeNo);
		System.out.println("여기555555:"+recipeNo);
		return recipe;
	}
	@Override
	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("RecipeMapper.getTotalCount");
		return totalCount;
	}
	@Override
	public int insertBoard(SqlSession session, RecipeInsertRequest recipe) {
		int result = session.insert("RecipeMapper.insertRecipe", recipe);
		return result;
	}
	@Override
	public int updateBoard(SqlSession session, RecipeUpdateRequest recipe) {
		int result = session.update("RecipeMapper.updateRecipe", recipe);
		return result;
	}
	@Override
	public int deleteBoard(SqlSession session, int recipeNo) {
		int result = session.update("RecipeMapper.deleteRecipe", recipeNo);
		return result;
	}
	@Override
	public List<RecipeVO> selectRecipeStep(SqlSession session, int recipeNo) {
		List<RecipeVO> rList = session.selectList("RecipeMapper.selectRecipeStep", recipeNo);
		return rList;
	}

}
