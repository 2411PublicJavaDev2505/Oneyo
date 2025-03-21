package com.oneyo.spring.recipe.domain;

import java.sql.Date;

public class RecipeVO {
	private int recipeNo;
	private int recipeSourcesNo;
	private String memberId;
	private String recipeTitle;
	private String recipeContent;
	private int recommendCount;
	private Date recipeDate;
	private Date updateDate;
	private char delYn;
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
	public String getRecipeContent() {
		return recipeContent;
	}
	public void setRecipeContent(String recipeContent) {
		this.recipeContent = recipeContent;
	}
	public int getRecommendCount() {
		return recommendCount;
	}
	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
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
	@Override
	public String toString() {
		return "RecipeVO [recipeNo=" + recipeNo + ", recipeSourcesNo=" + recipeSourcesNo + ", memberId=" + memberId
				+ ", recipeTitle=" + recipeTitle + ", recipeContent=" + recipeContent + ", recommendCount="
				+ recommendCount + ", recipeDate=" + recipeDate + ", updateDate=" + updateDate + ", delYn=" + delYn
				+ "]";
	}
}	
	