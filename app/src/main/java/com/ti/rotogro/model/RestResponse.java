package com.ti.rotogro.model;

import com.google.gson.annotations.SerializedName;
import com.ti.rotogro.data.db.entity.Country;

import java.util.List;

/**
 * @author mahalingam
 * @date 04-01-2019.
 */
public class RestResponse {

   @SerializedName("messages")
   private List<String> messages;

   @SerializedName("result")
   private List<Country> result;

   public List<Country> getResult() {
      return result;
   }

   public List<String> getMessages() {
      return messages;
   }
}