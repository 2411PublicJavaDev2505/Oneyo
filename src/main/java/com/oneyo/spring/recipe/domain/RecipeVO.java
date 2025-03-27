package com.oneyo.spring.recipe.domain;

import java.sql.Date;
import java.util.List;

import com.oneyo.spring.member.domain.MemberVO;
import com.oneyo.spring.sources.domin.SourcesVO;
import com.oneyo.spring.step.domain.StepVO;

public class RecipeVO {
	
	private String memberId;
	private String recipeTitle;
	private int recipeNo;
	private int viewCount;
	private char delYn;
	private Date recipeDate;
	private Date updateDate;
	private String memberNickName;
	private List<StepVO> stepList;  // 추가된 stepList 속성
	
	public RecipeVO() {}

	

	public RecipeVO(String memberId, String recipeTitle) {
		super();
		this.memberId = memberId;
		this.recipeTitle = recipeTitle;
	}




	public List<StepVO> getStepList() {
		return stepList;
	}
	public void setStepList(List<StepVO> stepList) {
		this.stepList = stepList;
	}
	
	private List<SourcesVO> sourceList;
	
	public List<SourcesVO> getSourceList() {
		return sourceList;
	}
	public void setSourceList(List<SourcesVO> sourceList) {
		this.sourceList = sourceList;
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

	public int getRecipeNo() {
		return recipeNo;
	}

	public void setRecipeNo(int recipeNo) {
		this.recipeNo = recipeNo;
	}


	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public char getDelYn() {
		return delYn;
	}

	public void setDelYn(char delYn) {
		this.delYn = delYn;
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

	public String getMemberNickName() {
		return memberNickName;
	}

	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}

	@Override
	public String toString() {
		return "RecipeVO [memberId=" + memberId + ", recipeTitle=" + recipeTitle + ", recipeNo=" + recipeNo
				+", viewCount=" + viewCount + ", delYn=" + delYn
				+ ", recipeDate=" + recipeDate + ", updateDate=" + updateDate + ", memberNickName=" + memberNickName
				+ ", stepList=" + stepList + "]";
	}
}

