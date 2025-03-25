package com.oneyo.spring.mypage.domain;

import java.sql.Date;

public class MyBoardVO {
	private String memberId;
	private String memberNickname;
	private String memberName;
	private String boardTitle;
	private int boardCount;
	private int boardNo;
	private Date boardDate;
	private String adminYn; // 멤버 테이블의 관리자 여부
	private String delYn;
		
	public MyBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyBoardVO(String memberId, String memberNickname, String memberName, String boardTitle, int boardCount,
			int boardNo, Date boardDate, String adminYn, String delYn) {
		super();
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.memberName = memberName;
		this.boardTitle = boardTitle;
		this.boardCount = boardCount;
		this.boardNo = boardNo;
		this.boardDate = boardDate;
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

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
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
		return "MyBoardVO [memberId=" + memberId + ", memberNickname=" + memberNickname + ", memberName=" + memberName
				+ ", boardTitle=" + boardTitle + ", boardCount=" + boardCount + ", boardNo=" + boardNo + ", boardDate="
				+ boardDate + ", adminYn=" + adminYn + ", delYn=" + delYn + "]";
	}

	
	

	


	
}
