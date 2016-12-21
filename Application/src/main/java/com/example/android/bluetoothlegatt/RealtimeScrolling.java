package com.example.android.bluetoothlegatt;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class RealtimeScrolling extends Fragment {
    private LineGraphSeries<DataPoint> mSeries;

    private double graphLastXValue = 5d;
    private double GminX = 0, GmaxX = 150, GminY = 0, GmaxY = 160;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.figure_layout, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        mSeries = new LineGraphSeries<>();

        Bundle args = getArguments();
        double[] axis;
        axis = args.getDoubleArray("AXIS_RANGE");
        GminX = axis[0];
        GmaxX = axis[1];
        GminY = axis[2];
        GmaxY = axis[3];

        String title;
        title = args.getString("FIGURE_NAME");

        graph.setTitle(title);

        graph.addSeries(mSeries);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(GminX);
        graph.getViewport().setMaxX(GmaxX);
        graph.getViewport().setMinY(GminY);
        graph.getViewport().setMaxY(GmaxY);
        graph.getViewport().setScalableY(false);
        graph.getViewport().setYAxisBoundsManual(true);

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
        mSeries.appendData(new DataPoint(graphLastXValue, cValue), true, 500);
    }
}