package com.ti.rotogro.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ti.rotogro.data.db.entity.User;

import java.util.List;

@Dao
public interface UserDao {

   @Insert
   void insert( User... user );

   @Update
   void update( User... user );

   @Delete
   void delete( User... user );

   @Query("SELECT * FROM user")
   List<User> getAllUser();
}
