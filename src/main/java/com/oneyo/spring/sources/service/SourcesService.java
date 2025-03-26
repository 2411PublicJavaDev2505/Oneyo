package com.oneyo.spring.sources.service;

import java.util.List;

import com.oneyo.spring.sources.controller.dto.SourcesInsertRequest;
import com.oneyo.spring.sources.controller.dto.SourcesUpdateRequest;
import com.oneyo.spring.sources.domin.SourcesVO;


public interface SourcesService {


	int insertSources(SourcesInsertRequest sources);

	int updateSources(SourcesUpdateRequest sources);

	int deleteSources(int sourcesNo);

	SourcesVO selectSourcesByNo(int sourcesNo);

	List<SourcesVO> getSourcesByrecipeNo(int recipeNo);

	String getMemberNickname(String memberId);

	void insertSource(SourcesVO source);

	int updateSources(SourcesInsertRequest sources);

	

}
