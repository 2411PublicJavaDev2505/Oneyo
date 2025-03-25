package com.oneyo.spring.sources.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
