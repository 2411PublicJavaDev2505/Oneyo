package com.oneyo.spring.myref.controller.dto;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class DeleteSource {
		private String 	memberId;
		private int		sourceNo;
		private Date	dueDate;
		private String	storageCode;
				
		@Autowired
		public DeleteSource(String memberId, int sourceNo, Date dueDate, String storageCode) {
			this.memberId = memberId;
			this.sourceNo = sourceNo;
			this.dueDate = dueDate;
			this.storageCode = storageCode;
			
		}


		public String getStorageCode() {
			return storageCode;
		}


		public void setStorageCode(String storageCode) {
			this.storageCode = storageCode;
		}


		public String getMemberId() {
			return memberId;
		}


		public int getSourceNo() {
			return sourceNo;
		}


		public Date getDueDate() {
			return dueDate;
		}


		@Override
		public String toString() {
			return "deleteSource [memberId=" + memberId + ", sourceNo=" + sourceNo + ", dueDate=" + dueDate + "]";
		}	
	
		
	}
