package com.oneyo.spring.sources.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.sources.service.SourcesService;

@Controller
@RequestMapping("/sources")
public class SourcesController {
	
	private SourcesService sService;
	private PageUtill page;
	
	
}
