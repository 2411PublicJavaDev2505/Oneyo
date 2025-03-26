package com.oneyo.spring.recipe.store.Impl;

import java.util.List;
import java.util.Map;

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
		int limit = 8;
		int offset = (currentPage -1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<RecipeVO> rList = session.selectList("RecipeMapper.selectList", null, rowBounds);
		return rList;
	}
	@Override
	public RecipeVO selectOneByNo(SqlSession session, int recipeNo) {
		RecipeVO recipe = session.selectOne("RecipeMapper.selectOneByNo", recipeNo);
		return recipe;
	}
	
	@Override
	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("RecipeMapper.getTotalCount");
		return totalCount;
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
	public List<RecipeVO> selectSearchList(SqlSession session, Map<String, String> paramMap, int currentPage) {
		int limit = 8;
		int offset = (currentPage -1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<RecipeVO> searchList = session.selectList("RecipeMapper.selectSerachList", paramMap, rowBounds);
		return searchList;
	}
	
	@Override
	public int getTotalCount(SqlSession session, Map<String, String> paramMap) {
		int totalCount = session.selectOne("RecipeMapper.getTotalCount", paramMap);
		return totalCount;
	}
	@Override
	public List<RecipeVO> selectPersonalList(String memberId, int currentPage) {
		
		return null;
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
