package com.oneyo.spring.step.domain;

public class StepVO {
	
	public class Step {
		private int recipeContentNo;
	    private int stepNo;
	    private String stepContent;
	    private String stepAmount;
	    
	    public Step() {}

		public int getRecipeContentNo() {
			return recipeContentNo;
		}

		public void setRecipeContentNo(int recipeContentNo) {
			this.recipeContentNo = recipeContentNo;
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

		@Override
		public String toString() {
			return "Step [recipeContentNo=" + recipeContentNo + ", stepNo=" + stepNo + ", stepContent=" + stepContent
					+ ", stepAmount=" + stepAmount + "]";
		}
	}
}
