package com.oneyo.spring.recipe.store.Impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
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
	public RecipeVO selectOneByNo(SqlSession session, int recipeNo) {
		RecipeVO recipe = session.selectOne("RecipeMapper.selectOneByNo", recipeNo);
		return recipe;
	}

}
