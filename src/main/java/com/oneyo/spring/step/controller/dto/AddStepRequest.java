package com.oneyo.spring.step.controller.dto;

public class AddStepRequest {
	private int stepNo;
	private String stepContent;
	private String stepAmount;
	private int	   recipeNo;
	public AddStepRequest(int stepNo, String stepContent, String stepAmount, int recipeNo) {
		super();
		this.stepNo = stepNo;
		this.stepContent = stepContent;
		this.stepAmount = stepAmount;
		this.recipeNo = recipeNo;
	}
	
	
	public AddStepRequest() {}


	public int getStepNo() {
		return stepNo;
	}


	public String getStepContent() {
		return stepContent;
	}


	public String getStepAmount() {
		return stepAmount;
	}


	public int getRecipeNo() {
		return recipeNo;
	}


	@Override
	public String toString() {
		return "AddStepRequest [stepNo=" + stepNo + ", stepContent=" + stepContent + ", stepAmount=" + stepAmount
				+ ", recipeNo=" + recipeNo + "]";
	}
	
	
	
	
}
