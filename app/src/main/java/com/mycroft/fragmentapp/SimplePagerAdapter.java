package com.mycroft.fragmentapp;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mycroft on 2017/1/9.
 */

public class SimplePagerAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    private List<Object> mItems = new ArrayList<>();

    {
        for (int i = 0; i < 5; i++) {
            mItems.add(null);
        }
    }

    @Override
    public int getItemPosition(Object object) {
        int position = mItems.indexOf(object);
        if (position == 0) {
            return 4;
        } else if (position == 4) {
            return 0;
        } else {
            // 下面两种都可以
//            return POSITION_UNCHANGED;
            return position;
        }
    }
}
