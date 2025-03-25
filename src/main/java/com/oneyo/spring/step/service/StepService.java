package com.oneyo.spring.step.service;

import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;

public interface StepService {

	StepVO selectStepByNo(int stepNo);

	int insertStep(StepInsertRequest step);

	int updateStep(StepUpdateRequest step);

	int deleteStep(int stepNo);


}
