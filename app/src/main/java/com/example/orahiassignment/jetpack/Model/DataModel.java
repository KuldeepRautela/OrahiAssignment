package com.example.orahiassignment.jetpack.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModel {

    private String message;

    @SerializedName("data")
    private List<Demo> demoList;

    public List<Demo> getDemoList() {
        return demoList;
    }

    public void setDemoList(List<Demo> demoList) {
        this.demoList = demoList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}

