package com.ti.rotogro.helper;

import android.content.Context;

import com.ti.rotogro.utils.TIDCNetworkManager;

public class TIHelper {

   public static boolean checkInternet( Context aContext ) {
      return TIDCNetworkManager.isInternetOnCheck( aContext );
   }
}
