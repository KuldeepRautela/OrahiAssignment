package com.example.orahiassignment.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.orahiassignment.R;
import com.example.orahiassignment.jetpack.Model.DataModel;
import com.example.orahiassignment.jetpack.Model.Demo;
import com.example.orahiassignment.jetpack.viewmodels.DemoViewmodel;
import com.example.orahiassignment.ui.fragments.GraphView;
import com.example.orahiassignment.utils.constants.Constants;
import com.example.orahiassignment.utils.interfaces.RetrofitInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private List<Demo> demoList;
    private DemoViewmodel demoViewmodel;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Constants.context = getApplicationContext();
        linearLayout = findViewById(R.id.id_homeLayout);
        demoViewmodel =ViewModelProviders.of(this).get(DemoViewmodel.class);
        if (isNetworkConnected())
            getData();
        else {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    demoList = demoViewmodel.getData();
                    GraphView graphView = new GraphView(getBaseContext(),demoList);
                    linearLayout.addView(graphView);
                    Log.e("demolist ", demoList.get(0).getMonth());
                }
            }.start();

        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void getData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://demo5636362.mockable.io/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        retrofitInterface.getData().enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {

                if (response.isSuccessful()) {
                    demoList = response.body().getDemoList();
                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            if(demoViewmodel.getData()==null)
                                demoViewmodel.insertData(demoList);

                        }
                    }.start();
                    GraphView graphView = new GraphView(getBaseContext(),demoList);
                    linearLayout.addView(graphView);
                } else
                    showToast(response.errorBody().toString());
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                showToast(t.getLocalizedMessage());
            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
