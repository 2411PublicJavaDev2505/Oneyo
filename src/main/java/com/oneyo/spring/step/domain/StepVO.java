package com.oneyo.spring.step.domain;

public class StepVO {
	
	
		private int recipeNo;
		private int stepNo;
	    private String stepContent;
	    private String stepAmount;
	    
	    public void StepVO() {}
	    
		public int getStepNo() {
			return stepNo;
		}

		public void setStepNo(int stepNo) {
			this.stepNo = stepNo;
		}

		public int getRecipeNo() {
			return recipeNo;
		}

		public void setRecipeNo(int recipeNo) {
			this.recipeNo = recipeNo;
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

		@Override
		public String toString() {
			return "Step [recipeNo=" + recipeNo + ", stepNo=" + stepNo + ", stepContent=" + stepContent
					+ ", stepAmount=" + stepAmount + "]";
		}
	
}
