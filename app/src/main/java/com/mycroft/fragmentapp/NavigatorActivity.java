package com.mycroft.fragmentapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.aspsine.fragmentnavigator.FragmentNavigator;
import com.aspsine.fragmentnavigator.FragmentNavigatorAdapter;

public class NavigatorActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private FragmentNavigator mFragmentNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);

        mFragmentNavigator = new FragmentNavigator(getSupportFragmentManager(), mAdapter, R.id.fragment_container);
        mFragmentNavigator.onCreate(savedInstanceState);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        for (int i = 0; i < mAdapter.getCount(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(mAdapter.getTag(i)).setTag(mAdapter.getTag(i)), i == 0);
        }

        tabLayout.addOnTabSelectedListener(this);

        mFragmentNavigator.showFragment(0);
    }

    final FragmentNavigatorAdapter mAdapter = new FragmentNavigatorAdapter() {
        @Override
        public Fragment onCreateFragment(int i) {
            return SampleFragment.newInstance(getTag(i));
        }

        @Override
        public String getTag(int i) {
            return "tab: " + i;
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mFragmentNavigator.showFragment(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
