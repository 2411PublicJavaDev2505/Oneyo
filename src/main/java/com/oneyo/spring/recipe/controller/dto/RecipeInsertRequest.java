package com.oneyo.spring.recipe.controller.dto;

import java.util.List;

import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.step.domain.StepVO;

public class RecipeInsertRequest {
	private int recipeNo;
	private String recipeTitle;
	private String recipeContent;
	private String memberNickName;
	private String recipeFilename;
	private String recipeFileRename;
	private String recipeFilepath;
	
	private List<SourcesVO> sourceList;  // 재료 목록
    private List<StepVO> stepList;   // 단계 목록

    
	public List<SourcesVO> getSourceList() {
		return sourceList;
	}
	public void setSourceList(List<SourcesVO> sourceList) {
		this.sourceList = sourceList;
	}
	public List<StepVO> getStepList() {
		return stepList;
	}
	public void setStepList(List<StepVO> stepList) {
		this.stepList = stepList;
	}
	public String getRecipeTitle() {
		return recipeTitle;
	}
	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}
	public String getRecipeContent() {
		return recipeContent;
	}
	public void setRecipeContent(String recipeContent) {
		this.recipeContent = recipeContent;
	}
	public String getMemberNickName() {
		return memberNickName;
	}
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}
	public String getRecipeFilename() {
		return recipeFilename;
	}
	public void setRecipeFilename(String recipeFilename) {
		this.recipeFilename = recipeFilename;
	}
	public String getRecipeFileRename() {
		return recipeFileRename;
	}
	public void setRecipeFileRename(String recipeFileRename) {
		this.recipeFileRename = recipeFileRename;
	}
	public String getRecipeFilepath() {
		return recipeFilepath;
	}
	public void setRecipeFilepath(String recipeFilepath) {
		this.recipeFilepath = recipeFilepath;
	}
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}
	@Override
	public String toString() {
		return "RecipeInsertRequest [recipeNo=" + recipeNo + ", recipeTitle=" + recipeTitle + ", recipeContent="
				+ recipeContent + ", memberNickName=" + memberNickName + ", recipeFilename=" + recipeFilename
				+ ", recipeFileRename=" + recipeFileRename + ", recipeFilepath=" + recipeFilepath + ", sourceList="
				+ sourceList + ", stepList=" + stepList + "]";
	}
}
