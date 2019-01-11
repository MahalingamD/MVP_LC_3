package com.ti.rotogro.ui.splash;

import com.ti.rotogro.base.BaseView;

public class TISplashContract {

   public interface Presenter {
      void initPresenter();

   }

   public interface View extends BaseView {

      void viewSplashCount();

      void initActivity();

      void callNextActivity();


   }
}
