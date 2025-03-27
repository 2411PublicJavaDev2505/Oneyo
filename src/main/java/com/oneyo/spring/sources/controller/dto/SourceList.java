package com.oneyo.spring.sources.controller.dto;

public class SourceList {
		private String sourcesNo;
		private String categoryNo;
		private String sourceName;
		
		public SourceList() {}

		public SourceList(String sourcesNo, String categoryNo, String sourceName) {
			super();
			this.sourcesNo = sourcesNo;
			this.categoryNo = categoryNo;
			this.sourceName = sourceName;
		}

		public String getSourcesNo() {
			return sourcesNo;
		}

		public String getCategoryNo() {
			return categoryNo;
		}

		public String getSourceName() {
			return sourceName;
		}

		@Override
		public String toString() {
			return "SourceList [sourcesNo=" + sourcesNo + ", categoryNo=" + categoryNo + ", sourceName=" + sourceName
					+ "]";
		}
}
