package com.oneyo.spring.myref.controller.dto;

import java.sql.Date;

public class SourceAddRequest {
	private String memberId;
	private String firstCategory;
	private String secondCategory;
	private String thirdCategory;
	private String sourceCount;
	private String sourceName;
	private Date dueDate;
	private String storageDate;
	private String storageCode;
	
	public SourceAddRequest() {}

	public SourceAddRequest(String memberId, String firstCategory, String secondCategory, String thirdCategory,
			String sourceCount, String sourceName, Date dueDate, String storageDate, String storageCode) {
		super();
		this.memberId = memberId;
		this.firstCategory = firstCategory;
		this.secondCategory = secondCategory;
		this.thirdCategory = thirdCategory;
		this.sourceCount = sourceCount;
		this.sourceName = sourceName;
		this.dueDate = dueDate;
		this.storageDate = storageDate;
		this.storageCode = storageCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public String getFirstCategory() {
		return firstCategory;
	}

	public String getSecondCategory() {
		return secondCategory;
	}

	public String getThirdCategory() {
		return thirdCategory;
	}

	public String getSourceCount() {
		return sourceCount;
	}

	public String getSourceName() {
		return sourceName;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public String getStorageDate() {
		return storageDate;
	}

	public String getStorageCode() {
		return storageCode;
	}

	@Override
	public String toString() {
		return "SourceAddRequest [memberId=" + memberId + ", firstCategory=" + firstCategory + ", secondCategory="
				+ secondCategory + ", thirdCategory=" + thirdCategory + ", sourceCount=" + sourceCount + ", sourceName="
				+ sourceName + ", dueDate=" + dueDate + ", storageDate=" + storageDate + ", storageCode=" + storageCode
				+ "]";
	}

	
	
}
