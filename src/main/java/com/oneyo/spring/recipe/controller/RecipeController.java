package com.oneyo.spring.recipe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
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
import com.oneyo.spring.sources.controller.dto.SourceList;
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.sources.service.SourcesService;
import com.oneyo.spring.step.controller.dto.AddStepRequest;
import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.service.StepService;


@Controller
@RequestMapping("/recipe")
public class RecipeController {
		
    private RecipeService rService;
    private StepService sService;
    private SourcesService sourceService;
    private PageUtill page;
    private FileUtil file;

    @Autowired
    public RecipeController(RecipeService rService, StepService sService, SourcesService sourceService, PageUtill page, FileUtil file) {
        this.rService = rService;
        this.sService = sService;
        this.sourceService = sourceService;
        this.page = page;
        this.file = file;
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
    public String RecipeDetail(@PathVariable int recipeNo, Model model) {
        try {
            RecipeVO recipe = rService.selectOneByNo(recipeNo);
            List<StepVO> stepList = sService.getStepsByNo(recipeNo);
            List<SourcesVO>sourceList = sourceService.getSourcesByrecipeNo(recipeNo);
            Integer viewCount = rService.countViewUpdate(recipeNo);
            System.out.println(sourceList);
            recipe.setStepList(stepList);
            model.addAttribute("recipe", recipe);
            model.addAttribute("stepList", stepList);
            model.addAttribute("sourceList", sourceList);
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
    public String insertRecipe(Model model,
    		HttpSession session) {
    	try {
    		String memberId = (String)session.getAttribute("memberId");
    		
    		System.out.println(memberId);
    		if(memberId != null) {
    			session.setAttribute("memberId", memberId);
    			List<SourceList>sList = sourceService.getSourceList();
    			System.out.println(sList);
    			session.setAttribute("sList", sList);
    			return "recipe/insert";
    		}    		
		} catch (Exception e) {
			// TODO: handle exception
		}return "common/error";
    }
    
    
    @PostMapping("/insert")
    public String insertRecipe(@ModelAttribute RecipeInsertRequest recipeInsertRequest, 
    		Model model,
    		HttpSession session,
    		@RequestParam("firstSource") String firstSource,
    		@RequestParam("secondSource") String secondSource,
    		@RequestParam("thirdSource") String thirdSource,
    		@RequestParam("stepInfo1") String stepInfo1,
    		@RequestParam("stepInfo2") String stepInfo2,
    		@RequestParam("stepInfo3") String stepInfo3,
    		@RequestParam("stepAmount1") String stepAmount1,
    		@RequestParam("stepAmount2") String stepAmount2,
    		@RequestParam("stepAmount3") String stepAmount3,
    		@RequestParam(value="page", defaultValue="1") int currentPage,
    		@RequestParam(value = "recipeTitle", required = false) String recipeTitle    		
    		) {
        try {
//        	String memberId = (String)session.getAttribute("memberId");
//        	RecipeVO pRecipe = new RecipeVO(memberId, recipeTitle);
//        	int insert = rService.insertRecipe(pRecipe); 
        	
//        	if(insert > 0) {
//        		int curval = rService.currentSeq();
//        		AddStepRequest addStep1 = new AddStepRequest(1, stepInfo1, stepAmount1, insert);
//        		AddStepRequest addStep2 = new AddStepRequest(2, stepInfo2, stepAmount2, insert);
//        		AddStepRequest addStep3 = new AddStepRequest(3, stepInfo3, stepAmount3, insert);
//        		
//        		List<AddStepRequest> aList = new ArrayList<AddStepRequest>();
//        		aList.add(addStep1);
//        		aList.add(addStep2);
//        		aList.add(addStep3);
//        		int addStepresult = sService.addStep(aList);
//        		if(addStepresult > 1) {
//        		
//        		}
//        	return "recipe/list";	
            List<RecipeVO> rList;rList = rService.selectListAll(currentPage);
            model.addAttribute("rList", rList);
            model.addAttribute("rList",rList);
//        	}			
    			return "recipe/RecipeList";			
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
        }
            return "recipe/RecipeList";}
        // 오류 발생 시 에러 페이지로 리다이렉트
	        
	
	@GetMapping("/update")
	public String showRecipeModifyForm(@RequestParam("recipeNo") int recipeNo, Model model) {
	    try {
	        RecipeVO recipe = rService.selectOneByNo(recipeNo);
	        
//	        List<StepVO> stepList = sService.getStepsByNo(recipeNo);
//	        List<SourcesVO> sourceList = sourceService.getSourcesByrecipeNo(recipeNo);

	        model.addAttribute("recipe", recipe);
//	        model.addAttribute("stepList", stepList);
//	        model.addAttribute("sourceList", sourceList);
	        return "recipe/modify";
	    } catch(Exception e) {
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
	public String deleteRecipe(@RequestParam("recipeNo") int recipeNo, Model model) {
	    try {
	        int result = rService.deleteRecipe(recipeNo); // 삭제 서비스 호출
	        return "redirect:/recipe/list";  // 삭제 후 목록 페이지로 리다이렉트
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("errorMsg", e.getMessage());
	        return "common/error";
	    }
	}
}
