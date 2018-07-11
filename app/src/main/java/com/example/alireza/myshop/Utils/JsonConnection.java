package com.example.alireza.myshop.Utils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.alireza.myshop.Models.CategoryMode;
import com.example.alireza.myshop.Adapter.Category_Content;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonConnection {
    private  RecyclerView mRecyclerView;
    private  Context mContext;
    private  int i;

    public JsonConnection(Context mContext, int i, RecyclerView mRecyclerView) {
        this.mContext=mContext;
        this.i=i;
        this.mRecyclerView=mRecyclerView;
    }

    public StringRequest getmRequest() {

        StringRequest mRequest = new StringRequest(Request.Method.GET, "http://shop.asoopar.ir/PHP/category.php?user=" + i, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONObject mJsonObject;
                try {
                    mJsonObject = new JSONObject(s);
                    JSONArray mJsonArray = mJsonObject.getJSONArray("Category");
                    int a = mJsonArray.length();
                    CategoryMode mCategory;
                    List<CategoryMode> sliders = new ArrayList<>();
                    for (int i = 0; i < a; i++) {
                        JSONObject jo = mJsonArray.getJSONObject(i);
                        mCategory = new CategoryMode();
                        mCategory.setID_parent(jo.getString("iD_Parent"));
                        mCategory.setID(jo.getString("id"));
                        mCategory.setTittle(jo.getString("tittle"));
//                        mCategory.setPic(jo.getString("pic"));
                        sliders.add(mCategory);
                    }
                    try {
                        Category_Content adapter = new Category_Content(sliders, (Activity) mContext);
                        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext.getApplicationContext(), 1));
                        mRecyclerView.setAdapter(adapter);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
            }
        });
        return mRequest;
    }

}