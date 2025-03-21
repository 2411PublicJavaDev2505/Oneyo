package com.oneyo.spring.recipe.service.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
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
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;	
	}
	@Override
	public List<RecipeVO> selectListAll(int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RecipeVO> selectRecipeList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insertRecipe(RecipeInsertRequest recipe) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public RecipeVO selectOneByNo(int recipeNo) {
		// TODO Auto-generated method stub
		return null;
	}
}
