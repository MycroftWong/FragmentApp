package com.mycroft.fragmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void viewPager(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void lazy(View view) {
        startActivity(new Intent(this, LazyActivity.class));
    }

    public void navigator(View view) {
        startActivity(new Intent(this, NavigatorActivity.class));
    }
}
