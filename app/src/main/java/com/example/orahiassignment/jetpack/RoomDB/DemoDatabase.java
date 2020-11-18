package com.example.orahiassignment.jetpack.RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.orahiassignment.jetpack.Model.Demo;
import com.example.orahiassignment.jetpack.dao.DemoDao;
import com.example.orahiassignment.utils.constants.Constants;

@Database(entities = Demo.class,exportSchema = false,version = 1)
public abstract class DemoDatabase extends RoomDatabase {
    private static final String DB_NAME = "demo_db";
    private static DemoDatabase demoDatabase;
    public static synchronized DemoDatabase getInstance(){
        if(demoDatabase==null)
            demoDatabase = Room.databaseBuilder(Constants.context,DemoDatabase.class,DB_NAME).fallbackToDestructiveMigration().build();
            return demoDatabase;
    }
public abstract DemoDao demoDao();
}
