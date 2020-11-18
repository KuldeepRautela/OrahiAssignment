package com.example.orahiassignment.utils.interfaces;

import com.example.orahiassignment.jetpack.Model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("stats")
    Call<DataModel> getData();
}
