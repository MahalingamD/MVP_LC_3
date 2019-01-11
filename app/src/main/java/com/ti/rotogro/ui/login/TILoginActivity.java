package com.ti.rotogro.ui.login;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.stfalcon.smsverifycatcher.OnSmsCatchListener;
import com.stfalcon.smsverifycatcher.SmsVerifyCatcher;
import com.ti.rotogro.R;
import com.ti.rotogro.adapter.LanguageRecyclerAdapter;
import com.ti.rotogro.base.BaseActivity;
import com.ti.rotogro.data.db.AppDatabase;
import com.ti.rotogro.data.db.entity.Language;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TILoginActivity extends BaseActivity implements TILoginContract.View, View.OnClickListener {

   private AppDatabase db;
   AppCompatActivity myContext;

   RecyclerView myLanguageRecyclerView;
   Button myGetOTPBUT, mySubmitBut;

   TextInputEditText myMobileEditText;
   TextInputEditText myOTPEditText;
   private SmsVerifyCatcher smsVerifyCatcher;
   TILoginPresenter myTiLoginPresenter;

   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_tilogin );

      myTiLoginPresenter = new TILoginPresenter( this );
      myTiLoginPresenter.attachView( this );
      myTiLoginPresenter.initPresenter();
   }


   @Override
   public void initActivity() {

      myContext = this;
      db = AppDatabase.getDatabase( getApplication() );

      myLanguageRecyclerView = findViewById( R.id.language_recycrer_view );
      myGetOTPBUT = findViewById( R.id.login_get_otp_BUT );
      mySubmitBut = findViewById( R.id.login_submit_BUT );
      myMobileEditText = findViewById( R.id.login_mobile_EDT );
      myOTPEditText = findViewById( R.id.login_otp_EDT );


      //set listener
      myGetOTPBUT.setOnClickListener( this );
      mySubmitBut.setOnClickListener( this );

      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( TILoginActivity.this, LinearLayoutManager.HORIZONTAL, false );
      myLanguageRecyclerView.setLayoutManager( layoutManager );

      getOTPVerification();
   }


   @Override
   public void setRecyclerViewAdapter( List<Language> aLanguageList ) {

      hideProgress();
      LanguageRecyclerAdapter adapter = new LanguageRecyclerAdapter( aLanguageList, recyclerItemClickListener );
      myLanguageRecyclerView.setAdapter( adapter );


    /*  // See your Logcat :)
      for( Country country : countries ) {
         Log.i( "RETROFIT", country.getName() + "\n"
                 + " - Alpha2:  " + country.getAlphaCode_one() + " \n"
                 + " - Alpha3: " + country.getAlphaCode_two() );
      }

      db.CountryeModel().deleteAllCountry();

      db.CountryeModel().insertAllCountry( countries );

      List<Country> DBCountries = db.CountryeModel().getAllCountries();


      for( Country country : DBCountries ) {
         Log.i( "DB", country.name + "\n"
                 + " - DB2:  " + country.alphaCode_one + " \n"
                 + " - DB3: " + country.alphaCode_two );
      }*/
   }

   @Override
   public void callNextActivity() {

   }

   @Override
   public void onOTPResult( String aString ) {
      showToast( aString );
   }


   /**
    * RecyclerItem click event listener
    */
   private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
      @Override
      public void onItemClick( Language aLanguage ) {

         showToast( aLanguage.getLan_Name() );
      }

   };


   private void getOTPVerification() {
//        smsVerifyCatcher.setPhoneNumberFilter(getEditTextValue(myMobileNumberEDT));

      //init SmsVerifyCatcher


      smsVerifyCatcher = new SmsVerifyCatcher( TILoginActivity.this, new OnSmsCatchListener<String>() {

         @Override
         public void onSmsCatch( String message ) {
            String code = parseCode( message );//Parse verification code
            Log.e( "Login OTP", code );

            /*myOtpEDT.setText( code );//set code in edit text
            //then you can send verification code to server
            if( myOtpEDT.getText().toString().trim().length() > 0 ) {
               myCountTXT.setVisibility( View.GONE );
            }*/
         }
      } );

   }


   /**
    * Parse verification code
    *
    * @param message sms message
    * @return only four numbers from massage string
    */
   private String parseCode( String message ) {
      String code = "";
      try {
         Pattern p = Pattern.compile( "\\b\\d{5}\\b" );
         Matcher m = p.matcher( message );
         while( m.find() ) {
            code = m.group( 0 );
         }
      } catch( Exception e ) {
         e.printStackTrace();
      }
      return code;
   }


   @Override
   protected void onStart() {
      super.onStart();
      smsVerifyCatcher.onStart();
      Log.e( "smsVerifyCatcher", " Start" );
   }

   @Override
   protected void onStop() {

      super.onStop();
      smsVerifyCatcher.onStop();
      Log.e( "smsVerifyCatcher", " Stop" );
   }


   @Override
   protected void onResume() {
      super.onResume();
   }

   @Override
   public void onClick( View view ) {
      switch( view.getId() ) {
         case R.id.login_get_otp_BUT:
            myTiLoginPresenter.sendOTP( myMobileEditText.getText().toString() );
            break;
         case R.id.login_submit_BUT:
            showProgress();
            // btnLogin.setEnabled( false );
            // btnClear.setEnabled( false );
            myTiLoginPresenter.verifyOTP( myMobileEditText.getText().toString(), myOTPEditText.getText().toString() );
            break;
      }
   }
}
