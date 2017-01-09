package com.mycroft.fragmentapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
//                return ContentFragment.newInstance("tab: " + position);
                return null;
            }

            @Override
            public int getCount() {
                return mCount;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "tab: " + position;
            }

            @Override
            public float getPageWidth(int position) {
                return 1f;
            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(mViewPager);
    }

    private int mCount = 5;

    public void change(View view) {
//        mCount = mViewPager.getAdapter().getCount();
        Log.e("mycroft", "count = " + mCount);
        mCount++;
        if (mCount > 5) {
            mCount = 3;
        }
        mViewPager.getAdapter().notifyDataSetChanged();
    }
}
