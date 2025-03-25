package com.oneyo.spring.step.controller.dto;

public class StepInsertRequest {
	private String stepWriter;
	private String stepContent;
	private String stepAmount;
	private String stepFilename;
	private String stepFileRename;
	private String stepFilepath;
	
	public String getStepWriter() {
		return stepWriter;
	}
	public void setStepWriter(String stepWriter) {
		this.stepWriter = stepWriter;
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
	public String getStepFilename() {
		return stepFilename;
	}
	public void setStepFilename(String stepFilename) {
		this.stepFilename = stepFilename;
	}
	public String getStepFileRename() {
		return stepFileRename;
	}
	public void setStepFileRename(String stepFileRename) {
		this.stepFileRename = stepFileRename;
	}
	public String getStepFilepath() {
		return stepFilepath;
	}
	public void setStepFilepath(String stepFilepath) {
		this.stepFilepath = stepFilepath;
	}
	
	@Override
	public String toString() {
		return "StepInsertRequest [stepWriter=" + stepWriter + ", stepContent=" + stepContent + ", stepAmount="
				+ stepAmount + ", stepFilename=" + stepFilename + ", stepFileRename=" + stepFileRename
				+ ", stepFilepath=" + stepFilepath + "]";
	}

}
	