package com.example.myapplication;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatientListVO {
    @SerializedName("patient_id")
    @Expose
    private String patientId;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("survey_json")
    @Expose
    private String surveyJson;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getSurveyJson() {
        return surveyJson;
    }

    public void setSurveyJson(String surveyJson) {
        this.surveyJson = surveyJson;
    }
}
