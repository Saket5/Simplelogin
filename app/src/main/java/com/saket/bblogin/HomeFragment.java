package com.saket.bblogin;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Entity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity mainActivity = (MainActivity) requireActivity();
        mainActivity.toolbar.setTitle("Home Page");
        lineChart=view.findViewById(R.id.lineChart);
        ArrayList<Entry> points = new ArrayList<>();
        points.add(new Entry(1,2));
        points.add(new Entry(2,1));
        points.add(new Entry(3,1));
        points.add(new Entry(4,2));
        points.add(new Entry(5,3));
        points.add(new Entry(6,2));
        points.add(new Entry(7,4));
        LineDataSet set1= new LineDataSet(points,"points1");
        set1.setDrawCircles(true);
        set1.setDrawValues(true);
        set1.setCircleColor(Color.RED);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setLineWidth((float)3.0);
        set1.setDrawCircleHole(false);
        set1.setColor(R.color.black);
        set1.setValueTextSize(10f);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        lineChart.getAxisLeft().setAxisMinimum(0f);
        lineChart.getAxisRight().setAxisMinimum(0f);
        lineChart.getAxisLeft().setGranularity((float)1.0);
        lineChart.getAxisRight().setGranularity((float)1.0);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getXAxis().setAxisMinimum((float) 0.0);
        lineChart.getXAxis().setAxisMaximum((float) 8.0);
        lineChart.setDrawBorders(true);
        lineChart.getXAxis().setDrawAxisLine(true);
        LineData data = new LineData(dataSets);
        lineChart.setData(data);
        lineChart.invalidate();

    }
}