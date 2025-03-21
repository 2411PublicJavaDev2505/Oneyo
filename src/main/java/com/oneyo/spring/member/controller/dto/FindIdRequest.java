package com.oneyo.spring.member.controller.dto;

public class FindIdRequest {
	private String memberPhone;
	private String memberName;
	
	public FindIdRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Override
	public String toString() {
		return "FindIdRequest [memberPhone=" + memberPhone + ", memberName=" + memberName + "]";
	}

	public FindIdRequest(String memberPhone, String memberName) {
		super();
		this.memberPhone = memberPhone;
		this.memberName = memberName;
	}
	
	
}
