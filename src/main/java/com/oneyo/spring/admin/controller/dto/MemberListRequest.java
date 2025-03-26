package com.oneyo.spring.admin.controller.dto;

public class MemberListRequest {
	
	private String memberId;
	private String memberNickname;
	private String memberName;
	private String memberBirth;
	private String adminYn;
	private String delYn;
	
	public MemberListRequest() {
		super();
	}

	public MemberListRequest(String memberId, String memberNickname, String memberName, String memberBirth,
			String adminYn, String delYn) {
		super();
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.memberName = memberName;
		this.memberBirth = memberBirth;
		this.adminYn = adminYn;
		this.delYn = delYn;
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

	public String getAdminYn() {
		return adminYn;
	}

	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "MemberListRequest [memberId=" + memberId + ", memberNickname=" + memberNickname + ", memberName="
				+ memberName + ", memberBirth=" + memberBirth + ", adminYn=" + adminYn + ", delYn=" + delYn + "]";
	}
	
}
