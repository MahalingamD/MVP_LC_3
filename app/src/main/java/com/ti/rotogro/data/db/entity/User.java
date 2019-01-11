package com.ti.rotogro.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

   @PrimaryKey(autoGenerate = true)
   public long id;
   public String UserName;
   public String UserMobile;

   public long getId() {
      return id;
   }

   public String getUserName() {
      return UserName;
   }

   public String getUserMobile() {
      return UserMobile;
   }

   public User( String userName, String UserMobile ) {
      UserName = userName;
      this.UserMobile = UserMobile;
   }



   public User() {
      this.UserName = "";
      this.UserMobile = "";
   }
}
