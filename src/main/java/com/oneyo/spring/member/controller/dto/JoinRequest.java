package com.oneyo.spring.member.controller.dto;

public class JoinRequest {
	
	private String memberId;
	private String memberNickname;
	private String memberPw;
	private String memberName;
	private String memberBirth;
	private String memberPhone;
	private String adminYn;
	
	public JoinRequest() {
		super();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberBirth() {
		return memberBirth;
	}

	public void setMemberBirth(String memberBirth) {
		this.memberBirth = memberBirth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getAdminYn() {
		return adminYn;
	}

	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}
	
	
	
	public JoinRequest(String memberId, String memberNickname, String memberPw, String memberName, String memberBirth,
			String memberPhone, String adminYn) {
		super();
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.memberPhone = memberPhone;
		this.adminYn = adminYn;
	}

	@Override
	public String toString() {
		return "JoinRequest [memberId=" + memberId + ", memberNickname=" + memberNickname + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", memberBirth=" + memberBirth + ", memberPhone=" + memberPhone
				+ ", adminYn=" + adminYn + "]";
	}
	
	
}
