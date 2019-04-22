package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("/survey")
    Call<List<PatientListVO>> getPatientList();

    @GET("/survey/{patient}")
    Call<PatientDataVO> getPatientData(@Path("patient") String patient);
}
