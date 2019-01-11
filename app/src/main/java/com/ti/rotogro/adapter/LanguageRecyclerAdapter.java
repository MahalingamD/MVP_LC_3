package com.ti.rotogro.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.ti.rotogro.R;
import com.ti.rotogro.data.db.entity.Language;
import com.ti.rotogro.ui.login.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class LanguageRecyclerAdapter extends RecyclerView.Adapter<LanguageRecyclerAdapter.ViewHolder> {

   private List<Language> myLanguageList;
   private RecyclerItemClickListener recyclerItemClickListener;

   public LanguageRecyclerAdapter( List<Language> aLanguageList, RecyclerItemClickListener recyclerItemClickListener ) {
      this.myLanguageList = aLanguageList;
      this.recyclerItemClickListener = recyclerItemClickListener;
   }


   @NonNull
   @Override
   public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
      LayoutInflater layoutInflater = LayoutInflater.from( parent.getContext() );
      View view = layoutInflater.inflate( R.layout.language_view_item, parent, false );
      return new ViewHolder( view );
   }

   @Override
   public void onBindViewHolder( @NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position ) {
      holder.myLanguageTXT.setText( myLanguageList.get( position ).getLan_Name() );


      holder.itemView.setOnClickListener( new View.OnClickListener() {
         @Override
         public void onClick( View v ) {
            recyclerItemClickListener.onItemClick( myLanguageList.get( position ) );
         }
      } );
   }

   @Override
   public int getItemCount() {
      return myLanguageList.size();
   }

   class ViewHolder extends RecyclerView.ViewHolder {

      TextView myLanguageTXT;

      ViewHolder( View itemView ) {
         super( itemView );
         myLanguageTXT = itemView.findViewById( R.id.lanuguage_name );


      }
   }
}