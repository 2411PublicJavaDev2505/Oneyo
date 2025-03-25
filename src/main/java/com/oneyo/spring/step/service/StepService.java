package com.oneyo.spring.step.service;

import java.util.List;

import com.oneyo.spring.step.domain.StepVO;

public interface StepService {

	List<StepVO> getStepsByNo(int recipeNo);

}
