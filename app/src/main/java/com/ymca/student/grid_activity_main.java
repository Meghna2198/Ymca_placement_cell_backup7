package com.ymca.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class grid_activity_main extends AppCompatActivity {

    GridView gridView;

    String[] values = {
            "Post Vacancies", "View Applicants", "Edit Details"
    } ;

    int[] images = {
            R.mipmap.post,
            R.mipmap.people,
            R.mipmap.details,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_activity_main);

        gridView = (GridView) findViewById(R.id.griview);

        GridAdapter1 gridAdapter = new GridAdapter1(this, values, images);

        gridView.setAdapter(gridAdapter);

    }
}
