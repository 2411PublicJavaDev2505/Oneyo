package com.oneyo.spring.recipe.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.controller.dto.RecipeUpdateRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.recipe.service.RecipeService;
import com.oneyo.spring.recipe.store.RecipeStore;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeStore rStore;
	private SqlSession session;
	
	@Autowired
	public RecipeServiceImpl(RecipeStore rStore, SqlSession session) {
		this.rStore = rStore;
		this.session = session;
	}
	
	@Override
	public List<RecipeVO> selectListAll(int currentPage) {
		List<RecipeVO> rList = rStore.selectRecipeList(session, currentPage);
		return rList;
	}
	@Override
	public List<RecipeVO> selectRecipeList(int currentPage) {
		List<RecipeVO> rList = rStore.selectRecipeList(session, currentPage);
		return rList;
	}
	@Override
	public RecipeVO selectOneByNo(int recipeNo) {
		
		System.out.println("여기9999999:"+recipeNo);
		RecipeVO recipe = rStore.selectOneByNo(session, recipeNo);
		return recipe;
	}

	@Override
	public int getTotalCount() {
		int totalCount = rStore.getTotalCount(session);
		return totalCount;
	}

	@Override
	public int insertRecipe(RecipeInsertRequest recipe) {
		int result = rStore.insertBoard(session, recipe);
		return result;
	}

	@Override
	public int updateRecipe(RecipeUpdateRequest recipe) {
		int result = rStore.updateBoard(session, recipe);
		return result;
	}

	@Override
	public int deleteRecipe(int recipeNo) {
		int result = rStore.deleteBoard(session, recipeNo);
		return result;
	}

	@Override
	public List<RecipeVO> selectRecipeStep(int recipeNo) {
		System.out.println("여기1234"+recipeNo);
		List<RecipeVO> rList = rStore.selectRecipeStep(session, recipeNo);
		return null;
	}
}
