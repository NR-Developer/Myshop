package com.example.alireza.myshop.CategoryTab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.alireza.myshop.R;
import com.example.alireza.myshop.Utils.JsonConnection;


/**
 * A simple {@link Fragment} subclass.
 */
public class Categorydjital extends Fragment {


     View mView;
     RecyclerView mRcyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_category, container, false);

        mRcyclerView = mView.findViewById(R.id.mRecyclerView);

        JsonConnection mJsonConnection = new JsonConnection(getActivity(), 1, mRcyclerView);
        StringRequest request=mJsonConnection.getmRequest();
        Volley.newRequestQueue(getActivity()).add(request);

        return mView;
    }

}
