package com.torridion.personaltrainer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.torridion.personaltrainer.R;

public class FollowedTabFragment extends ATabFragment{

    private static int LAYOUT = R.layout.fragment_example;


    public static FollowedTabFragment getInstance(Context context){
        Bundle args = new Bundle();
        FollowedTabFragment fragment = new FollowedTabFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.item_menu_followed));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }


}
