package com.ti.rotogro.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.ti.rotogro.R;
import com.ti.rotogro.base.BaseActivity;
import com.ti.rotogro.constant.TICommonvalues;
import com.ti.rotogro.data.db.AppDatabase;
import com.ti.rotogro.helper.TIHelper;
import com.ti.rotogro.ui.login.TILoginActivity;

public class TISplashActivity extends BaseActivity implements TISplashContract.View, TICommonvalues {


   private AppCompatActivity myAppContext;
   private TISplashPresenter myPresenter;
   int DELAY_TIME_FOR_SPLASH_SCREEN = 3000;
   AppDatabase db;


   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_splash );

      myPresenter = new TISplashPresenter();
      myPresenter.attachView( this );
      myPresenter.initPresenter();


   }

   @Override
   public void viewSplashCount() {
      Handler aHoldScreen = new Handler();
      aHoldScreen.postDelayed( new Runnable() {

         public void run() {
            callNextActivity();
         }
      }, DELAY_TIME_FOR_SPLASH_SCREEN );
   }

   @Override
   public void initActivity() {

      myAppContext = TISplashActivity.this;
      db = AppDatabase.getDatabase( getApplication() );


      // UserDao userDao = this.db.personModel();
      // LanguageDao aLanguageDao = db.languageModel();


    /*  ArrayList<User> aList = ( ArrayList<User> ) userDao.getAllUser();

      for( int i = 0; i < aList.size(); i++ ) {
         User bUser = aList.get( i );
         Log.e( "user" + i, bUser.id + " " + bUser.UserName + " " + bUser.UserMobile );
      }

      showToast( "User ArrayListSize " + aList.size() );


      Language aLanguage = new Language( "English", "2", "03-01-2018 10:35 AM" );
      aLanguageDao.insert( aLanguage );

      ArrayList<Language> aLanguageList = ( ArrayList<Language> ) aLanguageDao.getAllLanguages();

      for( int i = 0; i < aLanguageList.size(); i++ ) {
         Language bLanguage = aLanguageList.get( i );
         Log.e( "user" + i, bLanguage.Id + " " + bLanguage.Lan_Name + " " + bLanguage.Lan_Code );
      }

      showToast( "Language ArrayListSize " + aLanguageList.size() );*/

   }

   @Override
   public void callNextActivity() {
      Intent aIntent = new Intent( TISplashActivity.this, TILoginActivity.class );
      startActivity( aIntent );
      this.finish();
   }


   public boolean checkInternet() {
      return TIHelper.checkInternet( myAppContext );
   }

}
