package com.oneyo.spring.recipe.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oneyo.spring.common.FileUtil;
import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.recipe.controller.dto.RecipeInsertRequest;
import com.oneyo.spring.recipe.controller.dto.RecipeUpdateRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.recipe.service.RecipeService;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
		
	
	private RecipeService rService;
	private FileUtil file;
	private PageUtill page;
		
	@Autowired
	public RecipeController(RecipeService rService, PageUtill page, FileUtil file) {
		this.rService = rService;
		this.file = file;
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

	@GetMapping("/insert")
	public String InsertRecipe() {
			return "recipe/insert";
		}

	@PostMapping("/insert")
	public String insertRecipe(@ModelAttribute RecipeInsertRequest recipe
			, @RequestParam("uploadFile") MultipartFile uploadFile
			, HttpSession session
			, Model model) {
		try {
			if(session.getAttribute("memberId") != null) {
				recipe.setRecipeWriter((String)session.getAttribute("memberId"));
			}else {
				model.addAttribute("errorMsg","로그인이 필요합니다~!" );
				return "common/error";
			}
			
			if(uploadFile != null && !uploadFile.getOriginalFilename().isBlank()) {
				Map<String, String> fileInfo = file.saveFile(uploadFile, session, "recipe");
				recipe.setRecipeFilename(fileInfo.get("rFilename"));
				recipe.setRecipeFileRename(fileInfo.get("rFileRename"));
				recipe.setRecipeFilepath(fileInfo.get("rFilepath"));
			}
			int result = rService.insertRecipe(recipe);
			return "redirect:/recipe/RecipeList";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/update")
	public String showRecipeModifyForm(@RequestParam("recipeNo") int recipeNo, Model model) {
		try {
			RecipeVO recipe = rService.selectOneByNo(recipeNo);
			model.addAttribute("recipe", recipe);
			return "recipe/modify";
		} catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	
	@PostMapping("/update")
	public String updateRecipe(@ModelAttribute RecipeUpdateRequest recipe
			, @RequestParam("reloadFile") MultipartFile reloadFile
			, HttpSession session
			, Model model) {
		try {
			if(session.getAttribute("memberId") == null) {
				model.addAttribute("errorMsg", "로그인이 필요합니다~!");
				return "common/error";
			}
			String memberId = (String)session.getAttribute("memberId");
			if(!memberId.equals(recipe.getRecipeWriter())) {
				model.addAttribute("errorMsg", "존재하지 않는 정보입니다.");
				return "common/error";
			}
			if(reloadFile != null && !reloadFile.getOriginalFilename().isBlank()) {
				Map<String, String> fileInfo = file.saveFile(reloadFile, session, "recipe");
				recipe.setRecipeFilename(fileInfo.get("rFilename"));
				recipe.setRecipeFileRename(fileInfo.get("rFileRename"));
				recipe.setRecipeFilepath(fileInfo.get("rFilepath"));
			}
			int result = rService.updateRecipe(recipe);
			return "redirect:/recipe/detail/"+recipe.getRecipeNo();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	// 삭제 
	@GetMapping("/delete")
	public String deleteRecipe(@PathVariable int recipeNo
			, Model model) {
		try {
			int result = rService.deleteRecipe(recipeNo);
			return "redirect:/recipe/list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
}
	