package com.oneyo.spring.board.controller.dto;

public class BoardAddRequest {
	private String memberId;
	private String boardTitle;
	private String baordContent;
	
	public BoardAddRequest() {
		super();
	}
	
	public BoardAddRequest(String memberId, String boardTitle, String baordContent) {
		super();
		this.memberId = memberId;
		this.boardTitle = boardTitle;
		this.baordContent = baordContent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBaordContent() {
		return baordContent;
	}

	public void setBaordContent(String baordContent) {
		this.baordContent = baordContent;
	}

	@Override
	public String toString() {
		return "BoardAddRequest [memberId=" + memberId + ", boardTitle=" + boardTitle + ", baordContent=" + baordContent
				+ "]";
	}
	
	
}
