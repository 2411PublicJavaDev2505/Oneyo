package com.oneyo.spring.member.controller.dto;

public class ModifyRequest {
	
	private String memberId;
	private String memberPw;
	private String memberPhone;
	private String memberNickname;
	
	
	public ModifyRequest() {
		super();
	}

	

	public ModifyRequest(String memberId, String memberPw, String memberPhone, String memberNickname) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberPhone = memberPhone;
		this.memberNickname = memberNickname;
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
		return "ModifyRequest [memberId=" + memberId + ", memberPw=" + memberPw + ", memberPhone=" + memberPhone
				+ ", memberNickname=" + memberNickname + "]";
	}
	
	
	
}