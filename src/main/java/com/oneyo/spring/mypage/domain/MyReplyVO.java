package com.oneyo.spring.mypage.domain;

import java.sql.Date;

public class MyReplyVO {
	
	private int replyNo;
	private String boardTitle;
	private int boardNo;
	private String memberId;
	private String memberNickname; // 멤버 테이블의 닉네임
	private String replyContent;
	private Date replyDate;
	
	
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public MyReplyVO(int replyNo, int boardNo, String memberId, String memberNickname, String replyContent,String BoardTitle,
			Date replyDate) {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.boardTitle = boardTitle;
	}
	@Override
	public String toString() {
		return "MyReplyVO [replyNo=" + replyNo + ", boardTitle=" + boardTitle + ", boardNo=" + boardNo + ", memberId="
				+ memberId + ", memberNickname=" + memberNickname + ", replyContent=" + replyContent + ", replyDate="
				+ replyDate + "]";
	}
	
	
	
	
}
