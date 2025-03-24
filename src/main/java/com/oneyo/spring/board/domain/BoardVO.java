package com.oneyo.spring.board.domain;

import java.sql.Date;

public class BoardVO {
	private int boardNo;
	private String memberId;
	private String memberNickname; // 멤버 테이블의 닉네임
	private String boardTitle;
	private String boardContent;
	private int boardCount;
	private Date boardDate;
	private String adminYn; // 멤버 테이블의 관리자 여부
	private String delYn;
	
	public int getBoardNo() {
		return boardNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public String getAdminYn() {
		return adminYn;
	}

	public String getDelYn() {
		return delYn;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", memberId=" + memberId + ", memberNickname=" + memberNickname
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardCount=" + boardCount
				+ ", boardDate=" + boardDate + ", adminYn=" + adminYn + ", delYn=" + delYn + "]";
	}

}
