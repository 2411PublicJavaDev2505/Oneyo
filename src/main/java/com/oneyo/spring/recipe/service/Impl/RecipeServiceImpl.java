package com.oneyo.spring.recipe.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public int getTotalCount() {
		int totalCount = rStore.getTotalCount(session);
		return totalCount;	
	}
	
	@Override
	public int getTotalCount(Map<String, String> paramMap) {
	int totalCount = rStore.getTotalCount(session, paramMap);
	return totalCount;
	}
	

	@Override
	public List<RecipeVO> selectListAll(int currentPage) {
		List<RecipeVO> rList = rStore.selectListAll(session, currentPage);
		return rList;
	}

	@Override
	public List<RecipeVO> selectRecipeList(int currentPage) {
		List<RecipeVO> rList = rStore.selectRecipeList(session, currentPage);
		return rList;
	}
	@Override
	public RecipeVO selectOneByNo(int recipeNo) {

		RecipeVO recipe = rStore.selectOneByNo(session, recipeNo);
		return recipe;
	}
	@Override
	public List<RecipeVO> selectSearchList(Map<String, String> paramMap, int currentPage) {
		List<RecipeVO> searchList = rStore.selectSearchList(session, paramMap, currentPage);
		return searchList;
	}


	public int updateRecipe(RecipeUpdateRequest recipe) {
		int result = rStore.updateBoard(session, recipe);
		return result;
	}
	
	@Override
	public List<RecipeVO> selectPersonalList(String memberId, int currentPage) {
		List<RecipeVO> selectPersonalList = rStore.selectPersonalList(session, memberId, currentPage);
		return selectPersonalList;
	}

	@Override
	public int deleteRecipe(int recipeNo) {
		int result = rStore.deleteBoard(session, recipeNo);
		return result;
	}

	@Override
	public List<RecipeVO> selectRecipeStep(int recipeNo) {
		return null;
	}
	@Transactional
    @Override
    public int insertRecipe(RecipeInsertRequest recipeRequest) {
        return rStore.insertRecipe(session, recipeRequest);
    }

}
