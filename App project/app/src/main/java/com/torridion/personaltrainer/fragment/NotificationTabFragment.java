package com.torridion.personaltrainer.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.torridion.personaltrainer.R;
import com.torridion.personaltrainer.adapter.NotificationElementAdapter;
import com.torridion.personaltrainer.model.Notification;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class NotificationTabFragment extends ATabFragment{

    private static int LAYOUT = R.layout.fragment_notifications;

    private ListView listView;

    private Realm realm;


    public static NotificationTabFragment getInstance(Context context){
        Bundle args = new Bundle();
        NotificationTabFragment fragment = new NotificationTabFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.item_menu_notifications));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);
        initFragmentList();
        return view;
    }

    private void initFragmentList() {
        listView = (ListView) view.findViewById(R.id.notificationFragmentList);

        realm = Realm.getDefaultInstance();
        RealmResults<Notification> results = realm.where(Notification.class).findAll();

        NotificationElementAdapter elementAdapter = new NotificationElementAdapter(getContext(), results);

        listView.setAdapter(elementAdapter);

    }




}
