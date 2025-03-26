package com.oneyo.spring.sources.store;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.sources.controller.dto.SourcesInsertRequest;
import com.oneyo.spring.sources.controller.dto.SourcesUpdateRequest;
import com.oneyo.spring.sources.domin.SourcesVO;


public interface SourcesStore {


	int insertSources(SqlSession session, SourcesInsertRequest sources);

	int updateSources(SqlSession session, SourcesUpdateRequest sources);

	int deleteSources(SqlSession session, int sourcesNo);

	SourcesVO selectSourcesByNo(SqlSession session, int sourcesNo);

	List<SourcesVO> getSourcesByrecipeNo(SqlSession session, int recipeNo);

}
