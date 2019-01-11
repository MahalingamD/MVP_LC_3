package com.ti.rotogro.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ti.rotogro.data.db.entity.Country;
import com.ti.rotogro.data.db.entity.User;

import java.util.List;

@Dao
public interface CountryDao {

   @Insert
   void insert( Country... user );

   @Update
   void update( Country... user );

   @Delete
   void delete( Country... user );

   @Query("SELECT * FROM country")
   List<Country> getAllCountries();

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   void insertAllCountry( List<Country> order );

   @Query("DELETE FROM country")
   void deleteAllCountry();
}
