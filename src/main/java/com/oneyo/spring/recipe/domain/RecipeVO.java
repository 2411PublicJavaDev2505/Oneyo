package com.oneyo.spring.recipe.domain;

import java.sql.Date;
import java.util.List;

import com.oneyo.spring.step.domain.StepVO.Step;

public class RecipeVO {
	
	private String memberId;
	private String recipeTitle;
	private int recipeContentNo;
	private int recipeNo;
	private int recipeSourcesNo;
	private int viewCount;
	private char delYn;
	private Date recipeDate;
	private Date updateDate;
	private String memberNickName;
	private String sourceName;
	private int stepNo;
	private String stepContent;
	private String stepAmount;
	private int fileNo;
	private int stepFileNo;
	
	private List<Step> steps;
	
	public RecipeVO() {}
	
	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	public int getRecipeContentNo() {
		return recipeContentNo;
	}

	public void setRecipeContentNo(int recipeContentNo) {
		this.recipeContentNo = recipeContentNo;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}

	public int getRecipeSourcesNo() {
		return recipeSourcesNo;
	}

	public void setRecipeSourcesNo(int recipeSourcesNo) {
		this.recipeSourcesNo = recipeSourcesNo;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public char getDelYn() {
		return delYn;
	}

	public void setDelYn(char delYn) {
		this.delYn = delYn;
	}

	public Date getRecipeDate() {
		return recipeDate;
	}

	public void setRecipeDate(Date recipeDate) {
		this.recipeDate = recipeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public int getStepNo() {
		return stepNo;
	}

	public void setStepNo(int stepNo) {
		this.stepNo = stepNo;
	}

	public String getStepContent() {
		return stepContent;
	}

	public void setStepContent(String stepContent) {
		this.stepContent = stepContent;
	}

	public String getStepAmount() {
		return stepAmount;
	}

	public void setStepAmount(String stepAmount) {
		this.stepAmount = stepAmount;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getStepFileNo() {
		return stepFileNo;
	}

	public void setStepFileNo(int stepFileNo) {
		this.stepFileNo = stepFileNo;
	}

	@Override
	public String toString() {
		return "RecipeVO [memberId=" + memberId + ", recipeTitle=" + recipeTitle + ", recipeContentNo="
				+ recipeContentNo + ", recipeNo=" + recipeNo + ", recipeSourcesNo=" + recipeSourcesNo + ", viewCount="
				+ viewCount + ", delYn=" + delYn + ", recipeDate=" + recipeDate + ", updateDate=" + updateDate
				+ ", memberNickName=" + memberNickName + ", sourceName=" + sourceName + ", stepNo=" + stepNo
				+ ", stepContent=" + stepContent + ", stepAmount=" + stepAmount + ", fileNo=" + fileNo + ", stepFileNo="
				+ stepFileNo + "]";
	}
}
