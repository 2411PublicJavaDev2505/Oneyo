package com.oneyo.spring.recipe.domain;

import java.sql.Date;

public class RecipeVO {
	
	private String memberId;
	private String recipeTitle;
	private String recipeContent;
	private int recipeNo;
	private int recipeSourcesNo;
	private int viewCount;
	private char delYn;
	private Date recipeDate;
	private Date updateDate;
	
	public RecipeVO() {}

	public String getMemberId() {
		return memberId;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public String getRecipeContent() {
		return recipeContent;
	}

	public int getRecipeNo() {
		return recipeNo;
	}

	public int getRecipeSourcesNo() {
		return recipeSourcesNo;
	}

	public int getViewCount() {
		return viewCount;
	}

	public char getDelYn() {
		return delYn;
	}

	public Date getRecipeDate() {
		return recipeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	@Override
	public String toString() {
		return "RecipeVO [memberId=" + memberId + ", recipeTitle=" + recipeTitle + ", recipeContent=" + recipeContent
				+ ", recipeNo=" + recipeNo + ", recipeSourcesNo=" + recipeSourcesNo + ", viewCount=" + viewCount
				+ ", delYn=" + delYn + ", recipeDate=" + recipeDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
