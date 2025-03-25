package com.oneyo.spring.step.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneyo.spring.step.service.StepService;

@Controller
@RequestMapping("")
public class StepController {

	private StepService sService;
	
	public StepController(StepService sService) {
		this.sService = sService;
	}
	
	
}
