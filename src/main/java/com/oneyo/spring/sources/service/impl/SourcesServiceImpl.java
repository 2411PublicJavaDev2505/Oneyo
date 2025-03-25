package com.oneyo.spring.sources.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneyo.spring.sources.controller.dto.SourcesInsertRequest;
import com.oneyo.spring.sources.controller.dto.SourcesUpdateRequest;
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.sources.service.SourcesService;
import com.oneyo.spring.sources.store.SourcesStore;

@Service
public class SourcesServiceImpl implements SourcesService {
	
	private SourcesStore sStore;
	private SqlSession session;
	
	@Autowired
	public SourcesServiceImpl(SourcesStore sStore, SqlSession session) {
		this.sStore = sStore;
		this.session = session;
	}
	
	
	@Override
	public SourcesVO selectSourcesByNo(int sourcesNo) {
		SourcesVO sources = sStore.selectSourcesByNo(session, sourcesNo);
		return sources;
	}
	@Override
	public int insertSources(SourcesInsertRequest sources) {
		int result = sStore.insertSources(session, sources);
		return result;
	}
	@Override
	public int updateSources(SourcesUpdateRequest sources) {
		int result = sStore.updateSources(session, sources);
		return result;
	}
	@Override
	public int deleteSources(int sourcesNo) {
		int result = sStore.deleteSources(session, sourcesNo);
		return result;
	}

}
