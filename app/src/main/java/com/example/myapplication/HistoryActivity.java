package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HistoryActivity extends Activity {

    private Retrofit mRetrofit;
    private RetrofitAPI mRetrofitAPI;
    private final String BASE_URL = "http://ec2-15-164-50-44.ap-northeast-2.compute.amazonaws.com:8000";
    private ListView mListView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mListView = findViewById(R.id.patientList);
        mTextView = findViewById(R.id.record);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);
        Call<List<PatientListVO>> call = mRetrofitAPI.getPatientList();

        call.enqueue(new Callback<List<PatientListVO>>() {
            @Override
            public void onResponse(Call<List<PatientListVO>> call, Response<List<PatientListVO>> response) {

                final List<PatientListVO> resource = response.body();

                ArrayList<String> array = new ArrayList<>();

                for(PatientListVO re : resource){
                    array.add(re.getPatientId());

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(HistoryActivity.this, android.R.layout.simple_list_item_1, array);
                mListView.setAdapter(adapter);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String vo = (String)parent.getAdapter().getItem(position);

                        Call<PatientDataVO> callData = mRetrofitAPI.getPatientData(vo);

                        callData.enqueue(new Callback<PatientDataVO>() {
                            @Override
                            public void onResponse(Call<PatientDataVO> call, Response<PatientDataVO> response) {

                                mTextView.setText(response.body().getSurveyJson());
                            }

                            @Override
                            public void onFailure(Call<PatientDataVO> call, Throwable t) {

                            }
                        });
                    }
                });
            }
            @Override
            public void onFailure(Call<List<PatientListVO>> call, Throwable t) {
            }
        });
    }
}
