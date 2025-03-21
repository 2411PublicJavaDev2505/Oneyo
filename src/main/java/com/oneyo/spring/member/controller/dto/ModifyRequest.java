package com.oneyo.spring.member.controller.dto;

public class ModifyRequest {
	
	private String memberId;
	private String memberName;
	private String memberPhone;
	private String memberNickname;
	
	
	public ModifyRequest() {
		super();
	}


	public ModifyRequest(String memberId, String memberName, String memberPhone, String memberNickname) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberNickname = memberNickname;
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


	public String getMemberNickname() {
		return memberNickname;
	}


	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}


	@Override
	public String toString() {
		return "ModifyRequest [memberId=" + memberId + ", memberName=" + memberName + ", memberPhone=" + memberPhone
				+ ", memberNickname=" + memberNickname + "]";
	}


	

	
	
	
}