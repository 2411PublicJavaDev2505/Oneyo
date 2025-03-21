package com.oneyo.spring.member.controller.dto;

public class ModifyPasswordRequest {
	private String memberPw;
	
	public ModifyPasswordRequest() {
		super();
	}
	
	public ModifyPasswordRequest(String memberPw) {
		super();
		this.memberPw = memberPw;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	@Override
	public String toString() {
		return "ModifyPasswordRequest [memberPw=" + memberPw + "]";
	}
	
}
