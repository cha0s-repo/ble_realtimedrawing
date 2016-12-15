package com.example.android.bluetoothlegatt;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by jonas on 10.09.16.
 */
public class RealtimeScrolling extends Fragment {
    private final Handler mHandler = new Handler();
    private Runnable mTimer;
    private LineGraphSeries<DataPoint> mSeries;

    private double graphLastXValue = 5d;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.figure_layout, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        mSeries = new LineGraphSeries<>();
        graph.addSeries(mSeries);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(100);

        return rootView;
    }
/*
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((DeviceControlActivity) activity).onSectionAttached(
                getArguments().getInt(MainActivity.ARG_SECTION_NUMBER));
    }
*/
    /*
    @Override
    public void onResume() {
        super.onResume();

        mTimer = new Runnable() {
            @Override
            public void run() {
                graphLastXValue += 1d;
                mSeries.appendData(new DataPoint(graphLastXValue, getRandom()), true, 40);
                mHandler.postDelayed(this, 200);
            }
        };
        mHandler.postDelayed(mTimer, 1000);
    }
    */
    @Override
    public void onPause() {
        mHandler.removeCallbacks(mTimer);
        super.onPause();
    }
/*
    double mLastRandom = 2;
    Random mRand = new Random();
    private double getRandom() {
        return mLastRandom += mRand.nextDouble()*0.5 - 0.25;
    }
    */
    public void drawPoint(double cValue) {
        graphLastXValue += 1d;
        mSeries.appendData(new DataPoint(graphLastXValue, cValue), true, 100);
    }
}