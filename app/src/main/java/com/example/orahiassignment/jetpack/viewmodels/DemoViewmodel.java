package com.example.orahiassignment.jetpack.viewmodels;

import android.util.Log;
import android.widget.LinearLayout;

import androidx.lifecycle.ViewModel;

import com.example.orahiassignment.jetpack.Model.DataModel;
import com.example.orahiassignment.jetpack.Model.Demo;
import com.example.orahiassignment.jetpack.repo.DemoRepo;
import com.example.orahiassignment.utils.interfaces.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DemoViewmodel extends ViewModel {
    private DemoRepo demoRepo = new DemoRepo();
    private List<Demo> demoList;
    public void insertData(List<Demo> demoList) {
        demoRepo.setData(demoList);
    }

    public List<Demo> getData() {
        return demoRepo.getData();
    }

}
