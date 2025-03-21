package com.oneyo.spring.member.controller.dto;

public class ModifyPasswordRequest {
	private String memberId;
	private String memberPw;
	
	public ModifyPasswordRequest() {
		super();
	}

	public ModifyPasswordRequest(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	@Override
	public String toString() {
		return "ModifyPasswordRequest [memberId=" + memberId + ", memberPw=" + memberPw + "]";
	}
	
	
	
}
