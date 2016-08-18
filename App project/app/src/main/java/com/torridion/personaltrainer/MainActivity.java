package com.torridion.personaltrainer;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.torridion.personaltrainer.adapter.TabsPagerFragmentAdapter;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity{

    private static int LAYOUT = R.layout.activity_main;

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fab;
    private Animation animationIn;
    private Animation animationOut;
    private Context context;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        context = getApplicationContext();

        initToolbar();
        initNavigationView();
        initTabs();
        initAnimations();

        configureRealm();
    }

    private void initToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.string_open, R.string.string_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(listener);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.item_dashboard:
                        viewPager.setCurrentItem(Constants.TAB_DASHBOARD);
                        break;
                    case R.id.item_charts:
                        viewPager.setCurrentItem(Constants.TAB_CHARTS);
                        break;
                    case R.id.item_notification:
                        viewPager.setCurrentItem(Constants.TAB_NOTIFICATIONS);
                        break;
                    case R.id.item_followed:
                        viewPager.setCurrentItem(Constants.TAB_FOLLOWED);
                        break;
                    case R.id.item_followers:
                        viewPager.setCurrentItem(Constants.TAB_FOLLOWERS);
                        break;
                }
                return true;
            }
        });
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsPagerFragmentAdapter adapter = new TabsPagerFragmentAdapter(this ,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case Constants.TAB_DASHBOARD:
                        showFab();
                        break;
                    case Constants.TAB_CHARTS:
                        hideFab();
                        break;
                    case Constants.TAB_NOTIFICATIONS:
                        showFab();
                        break;
                    case Constants.TAB_FOLLOWED:
                        showFab();
                        break;
                    case Constants.TAB_FOLLOWERS:
                        hideFab();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initAnimations() {
        animationIn = AnimationUtils.loadAnimation(this, android.support.design.R.anim.abc_slide_in_bottom);
        animationOut= AnimationUtils.loadAnimation(this, android.support.design.R.anim.abc_slide_out_bottom);
    }

    private void hideFab(){
        if(fab.getVisibility() != View.GONE){
            fab.startAnimation(animationOut);
            fab.setVisibility(View.GONE);
        }
    }

    private void showFab(){
        if(fab.getVisibility() != View.VISIBLE){
            fab.setVisibility(View.VISIBLE);
            fab.startAnimation(animationIn);
        }
    }

    private void configureRealm() {
        RealmConfiguration config = new RealmConfiguration.Builder(context).build();
        Realm.setDefaultConfiguration(config);
        realm = Realm.getInstance(config);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent;
            if(viewPager.getCurrentItem() == Constants.TAB_DASHBOARD){
                intent = new Intent(context, ExercisesCreatorActivity.class);
                startActivity(intent);
            }
            if(viewPager.getCurrentItem() == Constants.TAB_NOTIFICATIONS){
                intent = new Intent(context, NotificationCreatorActivity.class);
                startActivity(intent);
            }
        }
    };

}
