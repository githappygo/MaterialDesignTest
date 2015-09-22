package com.example.materialdesigntest.activity;

import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.ca.materialdesigntest.R;
import com.example.materialdesigntest.fragment.BlankFragment;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private AnimationDrawable mAnimationDrawable;
    private ImageView mImageView;
    private FloatingActionButton mFloatingActionButton;
    private CoordinatorLayout mRootCoordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initData();
        setListener();
    }

    private void setListener() {

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(mRootCoordinatorLayout,"hello fab",Snackbar.LENGTH_SHORT).setAction("Confirm", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
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

    }

    private void findViews() {
        mToolbar = (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        mFloatingActionButton=(FloatingActionButton)findViewById(R.id.bt_fab);
        mRootCoordinatorLayout=(CoordinatorLayout)findViewById(R.id.cl_root);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

}
