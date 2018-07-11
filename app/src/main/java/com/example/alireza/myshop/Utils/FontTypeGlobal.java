package com.example.alireza.myshop.Utils;

import android.app.Application;

import com.example.alireza.myshop.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by Alireza on 4/1/2018.
 */

public class FontTypeGlobal extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("far.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
