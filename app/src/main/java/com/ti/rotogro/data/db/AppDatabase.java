package com.ti.rotogro.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.ti.rotogro.data.db.dao.CountryDao;
import com.ti.rotogro.data.db.dao.LanguageDao;
import com.ti.rotogro.data.db.dao.UserDao;
import com.ti.rotogro.data.db.entity.Country;
import com.ti.rotogro.data.db.entity.Language;
import com.ti.rotogro.data.db.entity.User;

@Database(entities = { User.class, Language.class,Country.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

   private static AppDatabase INSTANCE;

   public abstract UserDao personModel();

   public abstract LanguageDao languageModel();

   public abstract CountryDao CountryeModel();

   public static AppDatabase getDatabase( Context context ) {
      if( INSTANCE == null ) {
         INSTANCE = Room.databaseBuilder( context.getApplicationContext(), AppDatabase.class, "rotogro_db" )
                 .allowMainThreadQueries()
                 .build();
      }
      return INSTANCE;
   }

   public static AppDatabase getMemoryDatabase( Context context ) {
      if( INSTANCE == null ) {
         INSTANCE = Room.inMemoryDatabaseBuilder( context.getApplicationContext(), AppDatabase.class )
                 .allowMainThreadQueries()
                 .build();
      }
      return INSTANCE;
   }

   public static void destroyInstance() {
      INSTANCE = null;
   }

}
