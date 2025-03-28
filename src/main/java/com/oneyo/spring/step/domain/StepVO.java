package com.oneyo.spring.step.domain;

public class StepVO {
	
		private int stepNo;
	    private String stepContent;
	    private String stepAmount;
	    private String stepFileName;
	    
	    public void StepVO() {}

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

		public String getStepFileName() {
			return stepFileName;
		}

		public void setStepFileName(String stepFileName) {
			this.stepFileName = stepFileName;
		}

		@Override
		public String toString() {
			return "StepVO [stepNo=" + stepNo + ", stepContent=" + stepContent + ", stepAmount=" + stepAmount
					+ ", stepFileName=" + stepFileName + "]";
		}
}