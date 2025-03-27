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
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.step.domain.StepVO;


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
		System.out.println(recipe);
		return recipe;
	}
	
	@Override
	public int getTotalCount(SqlSession session) {
		int totalCount = session.selectOne("RecipeMapper.getTotalCount");
		return totalCount;
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
	public List<RecipeVO> selectPersonalList(SqlSession session, String memberId, int currentPage) {
		int limit = 8;
		int offset = (currentPage -1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<RecipeVO> rList = session.selectList("RecipeMapper.selectPersonalList", memberId, rowBounds);
		return rList;
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

	public RecipeVO selectRecipeByNo(SqlSession session, int recipeNo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insertRecipe(SqlSession session, RecipeInsertRequest recipeRequest) {
	    int result = session.insert("RecipeMapper.insertRecipe", recipeRequest);
	    if (result > 0) {
	        int recipeNo = recipeRequest.getRecipeNo(); // 생성된 레시피 번호 가져오기

	        // 레시피 단계 삽입
	        for (StepVO step : recipeRequest.getStepList()) {
	            step.setRecipeNo(recipeNo);
	            session.insert("StepMapper.insertStep", step);
	        }

	        // 레시피 재료 삽입
	        for (SourcesVO source : recipeRequest.getSourceList()) {
	            source.setRecipeNo(recipeNo);
	            Integer sourcesNo = session.selectOne("RecipeSourceMapper.getSourcesNoByName", source.getSourcesName());
	            if (sourcesNo != null) {
	                source.setSourcesNo(sourcesNo); // sourcesNo가 null이 아닐 때만 설정
	                session.insert("RecipeSourceMapper.insertRecipeSources", source); // 올바른 파라미터 전달
	            } else {
	                // sourcesNo가 없을 경우 처리 로직 추가 가능 (예: 새로운 재료 삽입 등)
	            }
	        }
	        return result;
	    }
	    return 0; // 실패 시 0 반환
	}
}
