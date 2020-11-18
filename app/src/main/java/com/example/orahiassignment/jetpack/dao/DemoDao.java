package com.example.orahiassignment.jetpack.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.orahiassignment.jetpack.Model.Demo;

import java.util.List;

@Dao
public interface DemoDao {
    @Query("Select * from Demo")
    List<Demo> getDemoData();
    @Insert
    void insert(List<Demo> demoList);
}
