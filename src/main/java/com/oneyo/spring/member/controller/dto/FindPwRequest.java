package com.oneyo.spring.member.controller.dto;

public class FindPwRequest {
	private String memberId;
	private String memberName;
	
	public FindPwRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FindPwRequest(String memberId, String memberName) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "FindPwRequest [memberId=" + memberId + ", memberName=" + memberName + "]";
	}
	
	
}
