package com.oneyo.spring.myref.controller.dto;

public class CategoryList {
	private String categoryNo;
	private String firstCategory;
	private String secondCategory;
	private String thirdCategory;
	
	public CategoryList(String categoryNo, String firstCategory, String secondCategory, String thirdCategory) {
		super();
		this.categoryNo = categoryNo;
		this.firstCategory = firstCategory;
		this.secondCategory = secondCategory;
		this.thirdCategory = thirdCategory;
	}
	//제대로 해라잉
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
				+ secondCategory + ", thirdCategory=" + thirdCategory + "]";
	}

	

	
	
}
