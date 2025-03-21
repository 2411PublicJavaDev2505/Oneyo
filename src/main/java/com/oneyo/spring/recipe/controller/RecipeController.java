package com.oneyo.spring.recipe.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.recipe.service.RecipeService;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
		
	
	private RecipeService rService;
	private PageUtill page;
		
	@Autowired
	public RecipeController(RecipeService rService, PageUtill page) {
		this.rService = rService;
		this.page = page;
	}
	
	@GetMapping("/RecipeList")
	public String ShowRecipeList(
		@RequestParam(value="page", defaultValue="1") int currentPage
		, Model model) {
	try {
		List<RecipeVO> rList = rService.selectListAll(currentPage); 
		int totalCount = rService.getTotalCount();
		Map<String, Integer> pageInfo = page.generatePageInfo(totalCount, currentPage);
		if(!rList.isEmpty()) {
			model.addAttribute("maxPage", pageInfo.get("maxPage"));
			model.addAttribute("startNavi", pageInfo.get("startNavi"));
			model.addAttribute("endNavi", pageInfo.get("endNavi"));
			model.addAttribute("rList", rList);
			return "recipe/RecipeList";
		}else {
			model.addAttribute("errorMessage", "데이터가 존재하지 않습니다.");
			return "common/error";
		}
	} catch (Exception e) {
		e.printStackTrace();
		model.addAttribute("errorMessage", e.getMessage());
		return "common/error";
	}
}
	
	@GetMapping("/insert")
	public String InsertRecipe(Model model) {
		try {
			return "recipe/insert";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "common/error";
	}
	
	@GetMapping("/detail")
	public String RecipeDetail(
			@RequestParam("recipeNo")int recipeNo
			, Model model) {
		try {
			RecipeVO recipe = rService.selectOneByNo(recipeNo);
			model.addAttribute("recipe", recipe);
			return "recipe/detail";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMessage", e.getMessage());
			return "common/error";
		}
	}
}