package com.oneyo.spring.sources.domin;

public class SourcesVO {
	
	private int sourcesNo;
	private int categoryNo;
	private String sourcesName;
	
	public int getSourcesNo() {
		return sourcesNo;
	}
	public void setSourcesNo(int sourcesNo) {
		this.sourcesNo = sourcesNo;
	}
	public String getSourcesName() {
		return sourcesName;
	}
	public void setSourcesName(String sourcesName) {
		this.sourcesName = sourcesName;
	}
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	@Override
	public String toString() {
		return "SourcesVO [sourcesNo=" + sourcesNo + ", sourcesName=" + sourcesName + ", categoryNo=" + categoryNo
				+ "]";
	}
}
