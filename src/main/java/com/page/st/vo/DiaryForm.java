package com.page.st.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DiaryForm {
	
	@NotNull
    private String diaryId;

	@NotNull
    private String journaling;

	public String getDiaryId() {
		return diaryId;
	}




	public void setDiaryId(String diaryId) {
		this.diaryId = diaryId;
	}




	public String getJournaling() {
		return journaling;
	}




	public void setJournaling(String journaling) {
		this.journaling = journaling;
	}




	public String toString() {
        return "DiaryForm(diaryId: " + this.diaryId + ", journaling: " + this.journaling + ")";
    }
}
