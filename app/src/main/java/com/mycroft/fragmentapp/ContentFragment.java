package com.mycroft.fragmentapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mycroft.fragmentapp.fragment.LazyFragment;

import java.util.Random;

/**
 * Created by Mycroft on 2017/1/9.
 */

public class ContentFragment extends LazyFragment {
//public class ContentFragment extends BaseLazyFragment {

    private static final String ARGS_DATA = "data.args";

    public static ContentFragment newInstance(String data) {

        Bundle args = new Bundle();
        args.putString(ARGS_DATA, data);
        ContentFragment fragment = new ContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private String mData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = getArguments().getString(ARGS_DATA);
    }

    @Override
    protected int getResId() {
        return R.layout.fragment_content;
    }

    private TextView mTextView;

    @Override
    protected void onRealViewLoaded(View view) {
        Log.e("mycroft", "onViewLoaded = " + view);

        mTextView = (TextView) view.findViewById(R.id.text_view);

        mTextView.setText(mData);

        mTextView.setBackgroundColor(Color.argb(0xFF, RANDOM.nextInt(0xFF), RANDOM.nextInt(0xFF), RANDOM.nextInt(0xFF)));
    }

    private static final Random RANDOM = new Random();
}
