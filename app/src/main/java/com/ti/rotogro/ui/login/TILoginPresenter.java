package com.ti.rotogro.ui.login;

import com.ti.rotogro.base.BasePresenter;
import com.ti.rotogro.data.db.entity.Language;
import com.ti.rotogro.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

public class TILoginPresenter extends BasePresenter<TILoginContract.View> implements TILoginContract.Presenter {


   private TILoginContract.View myTiLoginView;
   private RetrofitInstance myRetrofitInstance;

   TILoginPresenter( TILoginContract.View tiLoginView ) {
      myTiLoginView = tiLoginView;

      if( this.myRetrofitInstance == null ) {
         myRetrofitInstance = new RetrofitInstance();
      }
   }

   @Override
   public void initPresenter() {

      getView().initActivity();

      getView().showProgress();

      List<Language> aLanguageList = new ArrayList<>();

      for( int i = 0; i < 3; i++ ) {
         Language aLanguage = new Language();
         if( i == 0 ) {
            aLanguage.setLan_Name( "Tamil" );
            aLanguage.setLan_Code( "ta" );
            aLanguage.setLast_update_date( "04-01-2019" );
         }

         if( i == 1 ) {
            aLanguage.setLan_Name( "English" );
            aLanguage.setLan_Code( "en" );
            aLanguage.setLast_update_date( "04-01-2019" );
         }

         if( i == 2 ) {
            aLanguage.setLan_Name( "Kannada" );
            aLanguage.setLan_Code( "ka" );
            aLanguage.setLast_update_date( "04-01-2019" );
         }

         aLanguageList.add( aLanguage );
      }

      myTiLoginView.setRecyclerViewAdapter( aLanguageList );

    /*  myRetrofitInstance.getAPI()
              .getResults()
              .enqueue( new Callback<Data>() {
                 @Override
                 public void onResponse( Call<Data> call, Response<Data> response ) {

                    getView().hideProgress();
                    Data data = response.body();

                    if( data != null && data.getRestResponse() != null ) {
                       List<Country> result = data.getRestResponse().getResult();
                       myTiLoginView.setRecyclerViewAdapter( result );
                    }
                 }

                 @Override
                 public void onFailure( Call<Data> call, Throwable t ) {
                    try {
                       getView().hideProgress();
                       throw new InterruptedException( "Something went wrong!" );
                    } catch( InterruptedException e ) {
                       e.printStackTrace();
                    }
                 }
              } );*/
   }

   @Override
   public void sendOTP( String aMobileNumber ) {
      myTiLoginView.onOTPResult( "Send OTP Click" );
   }

   @Override
   public void verifyOTP( String aMobileNumber, String aOTP ) {

   }

}
