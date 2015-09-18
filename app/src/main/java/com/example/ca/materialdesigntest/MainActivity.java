package com.example.ca.materialdesigntest;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private AnimationDrawable mAnimationDrawable;
    private ImageView mImageView;
    private ListView mListView;
    private SimpleFragmentPagerAdapter mPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initData();
        setListener();
    }

    private void setListener() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                mPagerAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), MainActivity.this);
                mViewPager=(ViewPager)findViewById(R.id.viewPager);
                mViewPager.setAdapter(mPagerAdapter);
                mTabLayout=(TabLayout)findViewById(R.id.sliding_tabs);
                mTabLayout.setupWithViewPager(mViewPager);
                mTabLayout.setTabMode(TabLayout.MODE_FIXED);
                mDrawerLayout.closeDrawers();
            }
        });
    }

    private void initData() {
        mToolbar.setTitle("MyNews");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("item" + i);
        }

        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));


    }

    private void findViews() {
        mToolbar = (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        mListView = (ListView) findViewById(R.id.lv_left);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[]{"tab1", "tab2", "tab3"};
        private Context mContext;

        public SimpleFragmentPagerAdapter(FragmentManager fm, Context
                context) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            return BlankFragment.newInstance("", "", position + 1);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
