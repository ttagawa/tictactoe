package com.dealfaro.luca.class2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void putCross(View v) {
        ImageButton b = (ImageButton) findViewById(R.id.imageButton00);
        b.setImageResource(R.drawable.cross);
        b.setTag("X");
        String s = (String) b.getTag();
        TextView c = (TextView) findViewById(R.id.wonView);
        c.setVisibility(View.VISIBLE);
    }

    public void clickBoard(View v) {
        // Get id of button
        int i = v.getId();
        // More useful, let's get the tag.
        String t = (String) v.getTag();
        // If you want to put a cross on it.
        ImageButton vv = (ImageButton) v;
        vv.setImageResource(R.drawable.cross);

    }

}