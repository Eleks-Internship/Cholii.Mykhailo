package com.torridion.personaltrainer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.torridion.personaltrainer.R;

public class FollowersTabFragment extends ATabFragment{

    private static int LAYOUT = R.layout.fragment_example;


    public static FollowersTabFragment getInstance(Context context){
        Bundle args = new Bundle();
        FollowersTabFragment fragment = new FollowersTabFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.item_menu_followers));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        return view;
    }


}
