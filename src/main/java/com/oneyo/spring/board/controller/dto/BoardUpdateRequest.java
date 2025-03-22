package com.oneyo.spring.board.controller.dto;

public class BoardUpdateRequest {
	private String boardNo;
	private String memberId;
	private String memberNickname; // 멤버 테이블의 닉네임
	private String boardTitle;
	private String boardContent;
	
	public BoardUpdateRequest() {
		super();
	}

	public BoardUpdateRequest(String boardNo, String memberId, String memberNickname, String boardTitle,
			String boardContent) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
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

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	@Override
	public String toString() {
		return "BoardUpdateRequest [boardNo=" + boardNo + ", memberId=" + memberId + ", memberNickname="
				+ memberNickname + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + "]";
	}


}
