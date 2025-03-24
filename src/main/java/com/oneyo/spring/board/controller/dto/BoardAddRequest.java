package com.oneyo.spring.board.controller.dto;

public class BoardAddRequest {
	private int boardNo;
	private String memberId;
	private String memberNickname; // 멤버 테이블의 닉네임
	private String boardTitle;
	private String boardContent;
	private String boardFilename;
	private String boardFileRename;
	private String boardFilePath;
	
	public BoardAddRequest() {
		super();
	}

	public BoardAddRequest(int boardNo, String memberId, String memberNickname, String boardTitle,
			String boardContent, String boardFilename, String boardFileRename, String boardFilePath) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.memberNickname = memberNickname;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardFilename = boardFilename;
		this.boardFileRename = boardFileRename;
		this.boardFilePath = boardFilePath;
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

	public String getBoardFilename() {
		return boardFilename;
	}

	public void setBoardFilename(String boardFilename) {
		this.boardFilename = boardFilename;
	}

	public String getBoardFileRename() {
		return boardFileRename;
	}

	public void setBoardFileRename(String boardFileRename) {
		this.boardFileRename = boardFileRename;
	}

	public String getBoardFilePath() {
		return boardFilePath;
	}

	public void setBoardFilePath(String boardFilePath) {
		this.boardFilePath = boardFilePath;
	}

	@Override
	public String toString() {
		return "BoardAddRequest [boardNo=" + boardNo + ", memberId=" + memberId + ", memberNickname=" + memberNickname
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardFilename=" + boardFilename
				+ ", boardFileRename=" + boardFileRename + ", boardFilePath=" + boardFilePath + "]";
	}



}
