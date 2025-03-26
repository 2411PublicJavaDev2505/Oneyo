package com.oneyo.spring.myref.controller.dto;

public class SearchSourceRequest {
	private String memberId;
	private String sourceName;
	private String sourcesNo;
	private String searchKeyword;
	
	public SearchSourceRequest() {}

	public SearchSourceRequest(String memberId, String sourceName, String sourcesNo, String searchKeyword) {
		super();
		this.memberId = memberId;
		this.sourceName = sourceName;
		this.sourcesNo = sourcesNo;
		this.searchKeyword = searchKeyword;
	}
	
	

	public SearchSourceRequest(String memberId, String searchKeyword) {
		super();
		this.memberId = memberId;
		this.searchKeyword = searchKeyword;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getSourcesNo() {
		return sourcesNo;
	}

	@Override
	public String toString() {
		return "SearchSourceRequest [memberId=" + memberId + ", sourceName=" + sourceName + ", sourcesNo=" + sourcesNo
				+ ", searchKeyword=" + searchKeyword + "]";
	}

	
	
	
		
}
