package com.oneyo.spring.board.domain;

public class BoardFileVO {
	private int bFileNo;
	private int boardNo;
	private String bFileName;
	private String bFileRename;
	private String bFilePath;
	
	public BoardFileVO() {
		super();
	}

	public BoardFileVO(int bFileNo, int boardNo, String bFileName, String bFileRename, String bFilePath) {
		super();
		this.bFileNo = bFileNo;
		this.boardNo = boardNo;
		this.bFileName = bFileName;
		this.bFileRename = bFileRename;
		this.bFilePath = bFilePath;
	}

	public int getbFileNo() {
		return bFileNo;
	}

	public void setbFileNo(int bFileNo) {
		this.bFileNo = bFileNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getbFileName() {
		return bFileName;
	}

	public void setbFileName(String bFileName) {
		this.bFileName = bFileName;
	}

	public String getbFileRename() {
		return bFileRename;
	}

	public void setbFileRename(String bFileRename) {
		this.bFileRename = bFileRename;
	}

	public String getbFilePath() {
		return bFilePath;
	}

	public void setbFilePath(String bFilePath) {
		this.bFilePath = bFilePath;
	}

	@Override
	public String toString() {
		return "BoardFileVO [bFileNo=" + bFileNo + ", boardNo=" + boardNo + ", bFileName=" + bFileName
				+ ", bFileRename=" + bFileRename + ", bFilePath=" + bFilePath + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
