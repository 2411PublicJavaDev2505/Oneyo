package com.oneyo.spring.myref.controller.dto;

import java.sql.Date;

public class MySourceList {
	private String memberId;
	private int sourcesNo;
	private String sourceCount;
	private Date dueDate;
	private Date storageDate;
	private String storageCode;
	private String sourceName;
	
	
	public MySourceList(String memberId, int sourcesNo, String sourceCount, Date dueDate, Date storageDate,
			String storageCode, String sourceName) {
		super();
		this.memberId = memberId;
		this.sourcesNo = sourcesNo;
		this.sourceCount = sourceCount;
		this.dueDate = dueDate;
		this.storageDate = storageDate;
		this.storageCode = storageCode;
		this.sourceName = sourceName;
	}

	
	
	
	public String getSourceName() {
		return sourceName;
	}

	public String getMemberId() {
		return memberId;
	}

	public int getSourcesNo() {
		return sourcesNo;
	}

	public String getSourceCount() {
		return sourceCount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public Date getStorageDate() {
		return storageDate;
	}

	public String getStorageCode() {
		return storageCode;
	}


	@Override
	public String toString() {
		return "MySourceList [memberId=" + memberId + ", sourcesNo=" + sourcesNo + ", sourceCount=" + sourceCount
				+ ", dueDate=" + dueDate + ", storageDate=" + storageDate + ", storageCode=" + storageCode
				+ ", sourceName=" + sourceName + "]";
	}


}
