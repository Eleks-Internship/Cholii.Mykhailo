package com.torridion.personaltrainer.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.torridion.personaltrainer.Constants;
import com.torridion.personaltrainer.fragment.ATabFragment;
import com.torridion.personaltrainer.fragment.ChartsTabFragment;
import com.torridion.personaltrainer.fragment.DashboardTabFragment;
import com.torridion.personaltrainer.fragment.FollowedTabFragment;
import com.torridion.personaltrainer.fragment.FollowersTabFragment;
import com.torridion.personaltrainer.fragment.NotificationTabFragment;

import java.util.HashMap;
import java.util.Map;


public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, ATabFragment> tabs;

    public TabsPagerFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        initMap(context);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }


    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initMap(Context context) {
        tabs = new HashMap<>();
        tabs.put(Constants.TAB_DASHBOARD, DashboardTabFragment.getInstance(context));
        tabs.put(Constants.TAB_CHARTS, ChartsTabFragment.getInstance(context));
        tabs.put(Constants.TAB_NOTIFICATIONS, NotificationTabFragment.getInstance(context));
        tabs.put(Constants.TAB_FOLLOWED, FollowedTabFragment.getInstance(context));
        tabs.put(Constants.TAB_FOLLOWERS, FollowersTabFragment.getInstance(context));
    }
}
