package com.oneyo.spring.myref.controller.dto;

public class CategoryList {
	private String categoryNo;
	private String firstCategory;
	private String secondCategory;
	private String thirdCategory;
	private String sourcesNo;
	private String sourceName;
	
	
	
	public CategoryList(String categoryNo, String firstCategory, String secondCategory, String thirdCategory,
			String sourcesNo, String sourceName) {
		super();
		this.categoryNo = categoryNo;
		this.firstCategory = firstCategory;
		this.secondCategory = secondCategory;
		this.thirdCategory = thirdCategory;
		this.sourcesNo = sourcesNo;
		this.sourceName = sourceName;
	}
	public CategoryList(String categoryNo, String firstCategory, String secondCategory, String thirdCategory) {
		super();
		this.categoryNo = categoryNo;
		this.firstCategory = firstCategory;
		this.secondCategory = secondCategory;
		this.thirdCategory = thirdCategory;
	}
	
	
	public String getSourcesNo() {
		return sourcesNo;
	}
	public String getSourceName() {
		return sourceName;
	}

	public String getCategoryNo() {
		return categoryNo;
	}
	
	public String getFirstCategory() {
		return firstCategory;
	}
	
	public String getSecondCategory() {
		return secondCategory;
	}
	
	public String getThirdCategory() {
		return thirdCategory;
	}
	
	
	@Override
	public String toString() {
		return "CategoryList [categoryNo=" + categoryNo + ", firstCategory=" + firstCategory + ", secondCategory="
				+ secondCategory + ", thirdCategory=" + thirdCategory + ", sourcesNo=" + sourcesNo + ", sourceName="
				+ sourceName + "]";
	}

	
	
}
