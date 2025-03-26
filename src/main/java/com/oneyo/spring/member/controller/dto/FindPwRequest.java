package com.oneyo.spring.member.controller.dto;

public class FindPwRequest {
	private String memberId;
	private String memberName;
	private String memberPhone;
	
	public FindPwRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FindPwRequest(String memberId, String memberName, String memberPhone) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
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

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	@Override
	public String toString() {
		return "FindPwRequest [memberId=" + memberId + ", memberName=" + memberName + ", memberPhone=" + memberPhone
				+ "]";
	}


	
}
