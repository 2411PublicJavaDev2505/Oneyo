package com.oneyo.spring.board.domain;

import java.sql.Date;

public class BoardVO {
	private int boardNo;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private int boardCount;
	private Date boardDate;
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

	public String getBoardContent() {
		return boardContent;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public String getDelYn() {
		return delYn;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", memberId=" + memberId + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardCount=" + boardCount + ", boardDate=" + boardDate
				+ ", delYn=" + delYn + "]";
	}
	
}
