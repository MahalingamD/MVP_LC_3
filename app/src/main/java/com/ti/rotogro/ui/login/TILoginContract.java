package com.ti.rotogro.ui.login;

import com.ti.rotogro.base.BaseView;
import com.ti.rotogro.data.db.entity.Language;


import java.util.List;

public class TILoginContract {

   public interface Presenter {

      void initPresenter();

      void sendOTP( String s );

      void verifyOTP( String aMobile, String aOTP );

   }

   public interface View extends BaseView {

      void setRecyclerViewAdapter( List<Language> result );

      void initActivity();

      void callNextActivity();

      void onOTPResult(String aString);


   }
}
