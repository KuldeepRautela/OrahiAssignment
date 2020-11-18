package com.example.orahiassignment.jetpack.repo;

import com.example.orahiassignment.jetpack.Model.Demo;
import com.example.orahiassignment.jetpack.RoomDB.DemoDatabase;
import com.example.orahiassignment.jetpack.dao.DemoDao;

import java.util.List;

public class DemoRepo {
    private DemoDao demoDao = DemoDatabase.getInstance().demoDao();
    public void setData(final List<Demo> demos){
        new Thread(){
            @Override
            public void run() {
                super.run();
                demoDao.insert(demos);
            }
        }.start();

    }
    public List<Demo> getData(){
      return demoDao.getDemoData();
    }
}
