package com.listview;

public class RowItem {
	private int id;
	private String qnNumber;

	private String imageName;
	private String surveyId;
	
	

	public RowItem(int id,String qnNumber, String imageName, String surveyId) {
		this.id = id;
		this.qnNumber = qnNumber;
		this.imageName = imageName;
		this.surveyId = surveyId;
		
		
	}

	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getQnNumber() {
		return qnNumber;
	}

	public void setQnNumber(String qnNumber) {
		this.qnNumber = qnNumber;
	}

	

	

}
