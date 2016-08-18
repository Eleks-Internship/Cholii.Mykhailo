package com.torridion.personaltrainer.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;


public abstract class ATabFragment extends Fragment{

    protected View view;
    private Context context;

    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected void setContext(Context context){
        this.context = context;
    }
}
