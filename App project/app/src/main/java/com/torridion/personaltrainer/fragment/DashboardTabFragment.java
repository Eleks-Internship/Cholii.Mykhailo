package com.torridion.personaltrainer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.torridion.personaltrainer.R;
import com.torridion.personaltrainer.adapter.DashboardElementAdapter;
import com.torridion.personaltrainer.model.Exercise;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class DashboardTabFragment extends ATabFragment{

    private static int LAYOUT = R.layout.fragment_dashboard;

    private ListView listView;
    private SwipeRefreshLayout refreshLayout;
    private Realm realm;
    private DashboardElementAdapter adapter;


    public static DashboardTabFragment getInstance(Context context){
        Bundle args = new Bundle();
        DashboardTabFragment fragment = new DashboardTabFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.item_menu_dashboard));


        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        initRefreshLayout();
        initFragmentList();
        return view;
    }

    private void initFragmentList() {
        listView = (ListView) view.findViewById(R.id.dashboardFragmentList);

        realm = Realm.getDefaultInstance();
        RealmResults<Exercise> results = realm.where(Exercise.class).findAll();

        adapter = new DashboardElementAdapter(getContext(), results);

        listView.setAdapter(adapter);

    }

    private void initRefreshLayout() {
        refreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.swipe_refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapter.notifyDataSetChanged();
                refreshLayout.setRefreshing(false);
            }
        });
    }


}
