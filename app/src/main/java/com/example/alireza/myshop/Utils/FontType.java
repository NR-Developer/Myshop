package com.example.alireza.myshop.Utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Alireza on 3/30/2018.
 */
public class FontType  {
public Context mContext;
public FontType(Context mc){mContext=mc;}
   public Typeface TF(String FontName){
       return Typeface.createFromAsset(mContext.getAssets(), FontName);
   }
}
