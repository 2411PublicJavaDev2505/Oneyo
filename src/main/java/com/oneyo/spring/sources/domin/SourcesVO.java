package com.oneyo.spring.sources.domin;

public class SourcesVO {
	

		private int sourcesNo;
		private String sourcesName;
		private int categoryNo;
		private String firstCategory;
		private String secondCategory;
		private String thirdCategory;
		
		public SourcesVO() {}
		
		public int getSourcesNo() {
			return sourcesNo;
		}
		public void setSourcesNo(int sourcesNo) {
			this.sourcesNo = sourcesNo;
		}
		public String getSourcesName() {
			return sourcesName;
		}
		public void setSourcesName(String sourcesName) {
			this.sourcesName = sourcesName;
		}
		public int getCategoryNo() {
			return categoryNo;
		}
		public void setCategoryNo(int categoryNo) {
			this.categoryNo = categoryNo;
		}
		
		public String getFirstCategory() {
			return firstCategory;
		}

		public void setFirstCategory(String firstCategory) {
			this.firstCategory = firstCategory;
		}

		public String getSecondCategory() {
			return secondCategory;
		}

		public void setSecondCategory(String secondCategory) {
			this.secondCategory = secondCategory;
		}

		public String getThirdCategory() {
			return thirdCategory;
		}

		public void setThirdCategory(String thirdCategory) {
			this.thirdCategory = thirdCategory;
		}

		@Override
		public String toString() {
			return "Sources [sourcesNo=" + sourcesNo + ", sourcesName=" + sourcesName + ", categoryNo=" + categoryNo
					+ ", firstCategory=" + firstCategory + ", secondCategory=" + secondCategory + ", thirdCategory="
					+ thirdCategory + "]";
		}
	}

