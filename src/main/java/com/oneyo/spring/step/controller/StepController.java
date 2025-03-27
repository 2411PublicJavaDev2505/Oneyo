package com.oneyo.spring.step.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.oneyo.spring.common.FileUtil;
import com.oneyo.spring.recipe.controller.dto.RecipeUpdateRequest;
import com.oneyo.spring.recipe.domain.RecipeVO;
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.service.StepService;

@Controller
@RequestMapping("/step")
public class StepController {
	
	private StepService sService;
	private FileUtil file;
	
	public StepController(StepService sService, FileUtil file) {
		this.sService = sService;
		this.file = file;
	}
	
	
	@GetMapping("/update/{recipeNo}")
    public String showStepModifyForm(@PathVariable int recipeNo, Model model) {
        try {
            RecipeVO recipe = sService.selectRecipeByNo(recipeNo);
            List<StepVO> steps = sService.getStepsByNo(recipeNo);
            List<SourcesVO> sources = sService.getSourcesByRecipeNo(recipeNo);

            model.addAttribute("recipe", recipe);
            model.addAttribute("stepList", steps);
            model.addAttribute("sourceList", sources);

            return "step/update";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "common/error";
        }
    }

    @PostMapping("/update")
    public String updateRecipe(@ModelAttribute StepUpdateRequest step,
                                @RequestParam(value = "reloadFile", required = false) MultipartFile reloadFile,
                                HttpSession session, Model model) {
        try {
            String memberId = (String) session.getAttribute("memberId");
            if (memberId == null || !memberId.equals(step.getStepWriter())) {
                model.addAttribute("errorMsg", "권한이 없습니다.");
                return "common/error";
            }

            if (reloadFile != null && !reloadFile.isEmpty()) {
                Map<String, String> fileInfo = file.saveFile1(reloadFile, session, "step");
                step.setStepFilename(fileInfo.get("sFilename"));
                step.setStepFileRename(fileInfo.get("sFileRename"));
                step.setStepFilepath(fileInfo.get("sFilepath"));
            }

            int result = sService.updateStep(step);
            return "redirect:/step/detail/" + step.getStepNo();
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "common/error";
        }
    }

    @GetMapping("/delete/{stepNo}")
    public String deleteStep(@PathVariable int stepNo, Model model) {
        try {
            int result = sService.deleteStep(stepNo);
            return "redirect:/step/list";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
            return "common/error";
        }
    }
}

