package com.oneyo.spring.member.domain;

public class MemberVO {
	
	private String memberId;
	private String memberNickname;
	private String memberPw;
	private String memberName;
	private String memberBirth;
	private String memberPhone;
	private String adminYn;
	private String delYn;

	public MemberVO() {
		super();
	}
	
	public MemberVO(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public String getMemberBirth() {
		return memberBirth;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public String getAdminYn() {
		return adminYn;
	}
	public String getDelYn() {
		return delYn;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memberId=" + memberId + ", memberNickname=" + memberNickname + ", memberPw=" + memberPw
				+ ", memberName=" + memberName + ", memberBirth=" + memberBirth + ", memberPhone=" + memberPhone
				+ ", adminYn=" + adminYn + ", delYn=" + delYn + "]";
	}
	
	
}
