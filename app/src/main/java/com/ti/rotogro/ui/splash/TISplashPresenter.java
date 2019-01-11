package com.ti.rotogro.ui.splash;

import com.ti.rotogro.base.BasePresenter;

public class TISplashPresenter extends BasePresenter<TISplashContract.View> implements TISplashContract.Presenter {


   @Override
   public void initPresenter() {

      getView().initActivity();
      getView().viewSplashCount();

   }

}
