package com.oneyo.spring.sources.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oneyo.spring.sources.controller.dto.SourceList;
import com.oneyo.spring.sources.controller.dto.SourcesInsertRequest;
import com.oneyo.spring.sources.controller.dto.SourcesUpdateRequest;
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.sources.store.SourcesStore;

@Repository
public class SourcesStoreLogic implements SourcesStore{

	@Override
	public SourcesVO selectSourcesByNo(SqlSession session, int sourcesNo) {
		SourcesVO sources = session.selectOne("RecipeContentMapper.selectSourcesByNo", sourcesNo);
		return sources;
	}

	@Override
	public int insertSources(SqlSession session, SourcesInsertRequest sources) {
		int result = session.insert("RecipeContentMapper.insertSources", sources);
		return result;
	}

	@Override
	public int updateSources(SqlSession session, SourcesUpdateRequest sources) {
		int result = session.update("RecipeContentMapper.updateSources", sources);
		return result;
	}

	@Override
	public int deleteSources(SqlSession session, int sourcesNo) {
		int result = session.update("RecipeContentMapper.deleteSources", sourcesNo);
		return result;
	}
	@Override
	public List<SourcesVO> getSourcesByrecipeNo(SqlSession session, int recipeNo) {
		List<SourcesVO> sourceList = session.selectList("RecipeSourceMapper.getSourcesByrecipeNo", recipeNo);
		return sourceList;
	}
	@Override
	public int updateSources(SqlSession session, SourcesInsertRequest sources) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertSource(SqlSession session, SourcesVO source) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SourceList> getSourceList(SqlSession session) {
		List<SourceList> sList = session.selectList("source.getSourceList");
		return sList;
	}
}
