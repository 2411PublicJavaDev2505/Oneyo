package com.oneyo.spring.recipe.domain;

import java.sql.Date;

public class RecipeVO {
	private int recipeNo;
	private int recipeSourcesNo;
	private String memberId;
	private String recipeTitle;
	private Date recipeDate;
	private Date updateDate;
	private char delYn;
	private int viewCount;
	private int recipeContentNo;
	
	
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
	public char getDelYn() {
		return delYn;
	}
	public void setDelYn(char delYn) {
		this.delYn = delYn;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getRecipeContentNo() {
		return recipeContentNo;
	}
	public void setRecipeContentNo(int recipeContentNo) {
		this.recipeContentNo = recipeContentNo;
	}
	@Override
	public String toString() {
		return "RecipeVO [recipeNo=" + recipeNo + ", recipeSourcesNo=" + recipeSourcesNo + ", memberId=" + memberId
				+ ", recipeTitle=" + recipeTitle + ", recipeDate=" + recipeDate + ", updateDate=" + updateDate
				+ ", delYn=" + delYn + ", viewCount=" + viewCount + ", recipeContentNo=" + recipeContentNo + "]";
	}
	
	
}
	
	
	
	
	
	
	