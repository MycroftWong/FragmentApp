package com.mycroft.fragmentapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Mycroft on 2017/1/9.
 */

public class SampleFragment extends Fragment {

    private static final String ARGS_DATA = "data.args";

    public static SampleFragment newInstance(String data) {

        Bundle args = new Bundle();
        args.putString(ARGS_DATA, data);
        SampleFragment fragment = new SampleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private String mData;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = getArguments().getString(ARGS_DATA);
    }

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_content, container, false);

        mTextView = (TextView) root.findViewById(R.id.text_view);

        mTextView.setText(mData);

        mTextView.setBackgroundColor(Color.argb(0xFF, RANDOM.nextInt(0xFF), RANDOM.nextInt(0xFF), RANDOM.nextInt(0xFF)));

        return root;
    }

    private static final Random RANDOM = new Random();
}
