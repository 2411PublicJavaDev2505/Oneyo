package com.oneyo.spring.myref.controller.dto;

public class CheckLoginRequest {
	private String memberId;
	private String memberPw;
	private String storageCode;
	
	public CheckLoginRequest() {}
	
	
	public CheckLoginRequest(String memberId, String memberPw, String storageCode) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.storageCode = storageCode;
	}

	
	



	public CheckLoginRequest(String memberId) {
		super();
		this.memberId = memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public void setStorageCode(String storageCode) {
		this.storageCode = storageCode;
	}


	public String getMemberId() {
		return memberId;
	}


	public String getMemberPw() {
		return memberPw;
	}


	public String getStorageCode() {
		return storageCode;
	}


	@Override
	public String toString() {
		return "CheckLoginRequest [memberId=" + memberId + ", memberPw=" + memberPw + ", storageCode=" + storageCode
				+ "]";
	}
	
	
	
	
	
	
}
