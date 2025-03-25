package com.oneyo.spring.step.controller;
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
import com.oneyo.spring.step.controller.dto.StepInsertRequest;
import com.oneyo.spring.step.controller.dto.StepUpdateRequest;
import com.oneyo.spring.step.domain.StepVO;
import com.oneyo.spring.step.service.StepService;

@Controller
@RequestMapping("/step")
public class StepController {
	
	private StepService sService;
	private FileUtil file;
	
	public StepController(StepService sService) {
		this.sService = sService;
		this.file = file;
	}
	
	
	@GetMapping("/insert")
	public String InsertStep() {
		return "step/insert";
		
	}
	
	@PostMapping("/insert")
	public String insertStep(@ModelAttribute StepInsertRequest step
			, @RequestParam("uploadFile") MultipartFile uploadFile
			, HttpSession session
			, Model model) {
		try {
			if(session.getAttribute("memberId") != null) {
				step.setStepWriter((String)session.getAttribute("memberId"));
			}else {
				model.addAttribute("errorMsg", "�α����� �ʿ��մϴ�~!");
				return "common/error";
			}
			
			if(uploadFile != null && !uploadFile.getOriginalFilename().isBlank()) {
				Map<String, String> fileInfo = file.saveFile1(uploadFile, session, "step");
				step.setStepFilename(fileInfo.get("sFilename"));
				step.setStepFileRename(fileInfo.get("sFileRename"));
				step.setStepFilepath(fileInfo.get("sFilepath"));
			}
			int result = sService.insertStep(step);
			return "redirect:/step/StepList";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	
	@GetMapping("/update/{recipeNo}")
	public String showStepModifyForm(@PathVariable int stepNo, Model model) {
		try {
			StepVO step = sService.selectStepByNo(stepNo);
			model.addAttribute("step", step);
			return "step/update";
		} catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	
	@PostMapping("/update")
	public String updateRecipe(@ModelAttribute StepUpdateRequest step
			, @RequestParam("reloadFile") MultipartFile reloadFile
			, HttpSession session
			, Model model) {
		try {
			if(session.getAttribute("memberId") == null) {
				model.addAttribute("errorMsg", "�α����� �ʿ��մϴ�~!");
				return "common/error";
			}
			String memberId = (String)session.getAttribute("memberId");
			if(!memberId.equals(step.getStepWriter())) {
				model.addAttribute("errorMsg", "�������� �ʴ� �����Դϴ�.");
				return "common/error";
			}
			if(reloadFile != null && !reloadFile.getOriginalFilename().isBlank()) {
				Map<String, String> fileInfo = file.saveFile1(reloadFile, session, "step");
				step.setStepFilename(fileInfo.get("sFilename"));
				step.setStepFileRename(fileInfo.get("sFileRename"));
				step.setStepFilepath(fileInfo.get("sFilepath"));
			}
			int result = sService.updateStep(step);
			return "redirect:/step/detail/"+step.getStepNo();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMsg", e.getMessage());
			return "common/error";
		}
	}
	 
	@GetMapping("/delete")
	public String deleteStep(@PathVariable int stepNo
			, Model model) {
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
