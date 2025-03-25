package com.oneyo.spring.recipe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oneyo.spring.common.PageUtill;
import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.recipe.service.RecipeService;
import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.service.StepService;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
		
    private RecipeService rService;
    private StepService sService;
    private PageUtill page;

    @Autowired
    public RecipeController(RecipeService rService, StepService sService, PageUtill page) {
        this.rService = rService;
        this.sService = sService;
        this.page = page;
    }

    @GetMapping("/list")
    public String ShowRecipeList(
        @RequestParam(value="page", defaultValue="1") int currentPage,
        Model model,
        HttpSession session) {
        try {
            List<RecipeVO> rList;
            String memberId = (String)session.getAttribute("memberId");
            if (memberId != null) {
                rList = rService.selectPersonalList(memberId, currentPage);
            } else {
                rList = rService.selectListAll(currentPage);
            }
            int totalCount = rService.getTotalCount();
            Map<String, Integer> pageInfo = page.generatePageInfo(totalCount, currentPage);
            if (!rList.isEmpty()) {
                model.addAttribute("maxPage", pageInfo.get("maxPage"));
                model.addAttribute("startNavi", pageInfo.get("startNavi"));
                model.addAttribute("endNavi", pageInfo.get("endNavi"));
                model.addAttribute("rList", rList);
                return "recipe/RecipeList";
            } else {
                model.addAttribute("errorMessage", "데이터가 존재하지 않습니다.");
                return "common/error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
            return "common/error";
        }
    }

    @GetMapping("/detail/{recipeNo}")
    public String RecipeDetail(@PathVariable int recipeNo,Model model) {
        try {
            RecipeVO recipe = rService.selectOneByNo(recipeNo);
            List<StepVO> stepList = sService.getStepsByNo(recipeNo);
            recipe.setStepList(stepList);
            model.addAttribute("recipe", recipe);
            model.addAttribute("stepList", stepList);
            return "recipe/detail";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
            return "common/error";
        }
    }

    @GetMapping("/search")
    public String showSearchList(
            @RequestParam("searchKeyword") String searchkeyword,
            @RequestParam(value="currentPage", defaultValue="1")int currentPage,
            Model model) {
        try {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("searchkeyword", searchkeyword);
            List<RecipeVO> searchList = rService.selectSearchList(paramMap, currentPage);
            int totalCount = rService.getTotalCount(paramMap);
            Map<String, Integer> pageInfo = page.generatePageInfo(totalCount, currentPage);
            model.addAttribute("maxPage", pageInfo.get("maxPage"));
            model.addAttribute("startNavi", pageInfo.get("startNavi"));
            model.addAttribute("endNavi", pageInfo.get("endNavi"));
            model.addAttribute("searchList", searchList);
            model.addAttribute("searchkeyword", searchkeyword);
            return "recipe/search";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
            return "common/error";
        }
    }
    
    @GetMapping("/insert")
    public String insertRecipe() {
		return "recipe/insert";
    }
}
