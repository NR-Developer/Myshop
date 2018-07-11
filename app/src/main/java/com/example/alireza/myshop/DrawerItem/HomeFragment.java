package com.example.alireza.myshop.DrawerItem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.alireza.myshop.Adapter.Category0_Content;
import com.example.alireza.myshop.Models.CategoryMode;
import com.example.alireza.myshop.R;
import com.example.alireza.myshop.Utils.FontType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private View view;
    private TextView tx2, tx3;
    private SliderLayout mSliderLayout;
    private TextSliderView mTextSliderView;
    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        init();
        GetNameCategory();
        return view;
    }

    private void GetNameCategory() {

        StringRequest mRequest = new StringRequest(Request.Method.GET, "http://shop.asoopar.ir/PHP/category0.php", new Response.Listener<String>() {
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
                        mCategory.setID(jo.getString("id"));
                        mCategory.setTittle(jo.getString("tittle"));
                        sliders.add(mCategory);
                    }
                    Category0_Content adapter = new Category0_Content(sliders, getActivity());
                    LinearLayoutManager layoutManager
                            = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setAdapter(adapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getActivity(), "خطا در اتصال", Toast.LENGTH_LONG).show();
            }

        });
        Volley.newRequestQueue(getActivity()).add(mRequest);
    }

    private void init() {
        SetUpId();
        SetUpFonts();
        SetUpSlider();
    }

    private void SetUpId() {
        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        tx2 = view.findViewById(R.id.tx2);
        tx3 = view.findViewById(R.id.tx3);
        mSliderLayout = view.findViewById(R.id.mSliderlayout);

    }

    private void SetUpFonts() {
        FontType fontType = new FontType(getActivity());
        tx2.setTypeface(fontType.TF("far.ttf"));
        tx3.setTypeface(fontType.TF("far.ttf"));
    }

    private void SetUpSlider() {
        StringRequest request = new StringRequest(Request.Method.GET, "http://shop.asoopar.ir/PHP/slide.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONObject mJsonObject;
                try {
                    mJsonObject = new JSONObject(s);
                    JSONArray mJsonArray = mJsonObject.getJSONArray("Slider");
                    int a = mJsonArray.length();
                    for (int i = 0; i < a; i++) {
                        JSONObject jo = mJsonArray.getJSONObject(i);
                        mTextSliderView = new TextSliderView(getActivity());
                        GetPositionSlide(jo.getString("pic"), i);
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

        Volley.newRequestQueue(getActivity()).add(request);
    }

    private void GetPositionSlide(String pic, int i) {
        mTextSliderView.image(pic)
                .setScaleType(BaseSliderView.ScaleType.Fit)
                .setOnSliderClickListener(this);
        mTextSliderView.bundle(new Bundle())
                .getBundle()
                .putInt("PositionSlide", i + 1);

        mSliderLayout.addSlider(mTextSliderView);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(), "" + slider.getBundle().get("PositionSlide"), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        mSliderLayout.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
