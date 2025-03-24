package com.oneyo.spring.recipe.controller.dto;

public class RecipeUpdateRequest {
	private int recipeNo;
	private String recipeTitle;
	private String recipeContent;
	private String recipeWriter;
	private String recipeFilename;
	private String recipeFileRename;
	private String recipeFilepath;
	
	public int getRecipeNo() {
		return recipeNo;
	}
	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
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
	public String getRecipeWriter() {
		return recipeWriter;
	}
	public void setRecipeWriter(String recipeWriter) {
		this.recipeWriter = recipeWriter;
	}
	public String getRecipeFilename() {
		return recipeFilename;
	}
	public void setRecipeFilename(String recipeFilename) {
		this.recipeFilename = recipeFilename;
	}
	public String getRecipeFileRename() {
		return recipeFileRename;
	}
	public void setRecipeFileRename(String recipeFileRename) {
		this.recipeFileRename = recipeFileRename;
	}
	public String getRecipeFilepath() {
		return recipeFilepath;
	}
	public void setRecipeFilepath(String recipeFilepath) {
		this.recipeFilepath = recipeFilepath;
	}
	
	@Override
	public String toString() {
		return "RecipeModifyRequest [recipeNo=" + recipeNo + ", recipeTitle=" + recipeTitle + ", recipeContent="
				+ recipeContent + ", recipeWriter=" + recipeWriter + ", recipeFilename=" + recipeFilename
				+ ", recipeFileRename=" + recipeFileRename + ", recipeFilepath=" + recipeFilepath + "]";
	}
}
