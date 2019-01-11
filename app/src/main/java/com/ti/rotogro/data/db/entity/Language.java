package com.ti.rotogro.data.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "language")
public class Language {

   @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "id")
   public Long Id;
   @ColumnInfo(name = "lan_name")
   public String Lan_Name;
   @ColumnInfo(name = "lan_code")
   public String Lan_Code;
   @ColumnInfo(name = "last_update_time")
   public String Last_update_date;

   public Long getId() {
      return Id;
   }

   public void setId( Long id ) {
      Id = id;
   }

   public String getLan_Name() {
      return Lan_Name;
   }

   public void setLan_Name( String lan_Name ) {
      Lan_Name = lan_Name;
   }

   public String getLan_Code() {
      return Lan_Code;
   }

   public void setLan_Code( String lan_Code ) {
      Lan_Code = lan_Code;
   }

   public String getLast_update_date() {
      return Last_update_date;
   }

   public void setLast_update_date( String last_update_date ) {
      Last_update_date = last_update_date;
   }

   public Language() {
      Lan_Name = "";
      Lan_Code = "";
      Last_update_date = "";
   }

   public Language( String aLanName, String aLanCode, String aLastupdatedate ) {
      Lan_Name = aLanName;
      Lan_Code = aLanCode;
      Last_update_date = aLastupdatedate;
   }

}
