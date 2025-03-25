package com.oneyo.spring.sources.controller.dto;

public class SourcesInsertRequest {
	private String sourcesWriter;
	private String firstCategory;
	private String secondCategory;
	private String thirdCategory;
	private String sourcesName;
	private String sourcesFilename;
	private String sourcesFileRename;
	private String sourcesFilepath;
	
	
	public String getSourcesWriter() {
		return sourcesWriter;
	}
	public void setSourcesWriter(String sourcesWriter) {
		this.sourcesWriter = sourcesWriter;
	}
	public String getFirstCategory() {
		return firstCategory;
	}
	public void setFirstCategory(String firstCategory) {
		this.firstCategory = firstCategory;
	}
	public String getSecondCategory() {
		return secondCategory;
	}
	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}
	public String getThirdCategory() {
		return thirdCategory;
	}
	public void setThirdCategory(String thirdCategory) {
		this.thirdCategory = thirdCategory;
	}
	public String getSourcesName() {
		return sourcesName;
	}
	public void setSourcesName(String sourcesName) {
		this.sourcesName = sourcesName;
	}
	public String getSourcesFilename() {
		return sourcesFilename;
	}
	public void setSourcesFilename(String sourcesFilename) {
		this.sourcesFilename = sourcesFilename;
	}
	public String getSourcesFileRename() {
		return sourcesFileRename;
	}
	public void setSourcesFileRename(String sourcesFileRename) {
		this.sourcesFileRename = sourcesFileRename;
	}
	public String getSourcesFilepath() {
		return sourcesFilepath;
	}
	public void setSourcesFilepath(String sourcesFilepath) {
		this.sourcesFilepath = sourcesFilepath;
	}
	@Override
	public String toString() {
		return "SourcesInsertRequest [sourcesWriter=" + sourcesWriter + ", firstCategory=" + firstCategory
				+ ", secondCategory=" + secondCategory + ", thirdCategory=" + thirdCategory + ", sourcesName="
				+ sourcesName + ", sourcesFilename=" + sourcesFilename + ", sourcesFileRename=" + sourcesFileRename
				+ ", sourcesFilepath=" + sourcesFilepath + "]";
	}
}
	
	
	
	