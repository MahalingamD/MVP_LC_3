package com.ti.rotogro.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ti.rotogro.data.db.entity.Language;
import com.ti.rotogro.data.db.entity.User;

import java.util.List;

@Dao
public interface LanguageDao {

   @Insert
   void insert( Language... user );

   @Update
   void update( Language... user );

   @Delete
   void delete( Language... user );

   @Query("SELECT * FROM language")
   List<Language> getAllLanguages();
}
