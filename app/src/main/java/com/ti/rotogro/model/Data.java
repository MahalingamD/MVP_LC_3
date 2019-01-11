package com.ti.rotogro.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author mahalingam
 * @date 04-01-2019.
 */
public class Data {

   @SerializedName("RestResponse")
   private RestResponse restResponse;

   public RestResponse getRestResponse() {
      return restResponse;
   }
}
