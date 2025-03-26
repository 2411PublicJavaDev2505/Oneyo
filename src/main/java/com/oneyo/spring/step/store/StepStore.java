package com.oneyo.spring.step.store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;


public interface StepStore {

	StepVO selectStepByNo(SqlSession session, int stepNo);

	int insertStep(SqlSession session, StepInsertRequest step);

	int updateStep(SqlSession session, StepUpdateRequest step);

	int deleteStep(SqlSession session, int stepNo);

	List<StepVO> getStepsByNo(SqlSession session, int recipeNo);

	List<StepVO> getStepByRecipeNo(SqlSession session, int recipeNo);

	List<SourcesVO> getSourcesByRecipeNo(SqlSession session, int recipeNo);

	void insertStep(SqlSession session, StepVO step);
}
