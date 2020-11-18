package com.example.orahiassignment.jetpack.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Demo {
     @ColumnInfo(name = "Month")
 private String month;
     @PrimaryKey
     @NonNull
    @ColumnInfo(name = "Stat")
 private String stat;

   public String getMonth() {
       return month;
   }

   public void setMonth(String month) {
       this.month = month;
   }

   public String getStat() {
       return stat;
   }

   public void setStat(String stat) {
       this.stat = stat;
   }
}
