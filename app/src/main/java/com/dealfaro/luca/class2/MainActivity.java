package com.dealfaro.luca.class2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int turn = 0;
    int[][] ticked = new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3; j++){
                ticked[i][j]=-1;
            }
        }
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
        ImageButton vv = (ImageButton) v;
        char temp = t.charAt(0);
        int row = Character.getNumericValue(temp);
        temp = t.charAt(1);
        int column = Character.getNumericValue(temp);
        if(ticked[row][column]==-1) {
            if (turn % 2 == 0) {
                vv.setImageResource(R.drawable.cross);
                ticked[row][column] = 1;
            } else {
                vv.setImageResource(R.drawable.circle);
                ticked[row][column] = 0;
            }
            turn++;
        }
    }

    public void newGame(View v){
        ImageButton b = (ImageButton) findViewById(R.id.imageButton00);
        b.setImageResource(R.drawable.blank);
        b = (ImageButton) findViewById(R.id.imageButton01);
        b.setImageResource(R.drawable.blank);
        b = (ImageButton) findViewById(R.id.imageButton02);
        b.setImageResource(R.drawable.blank);
        b = (ImageButton) findViewById(R.id.imageButton10);
        b.setImageResource(R.drawable.blank);
        b = (ImageButton) findViewById(R.id.imageButton11);
        b.setImageResource(R.drawable.blank);
        b = (ImageButton) findViewById(R.id.imageButton12);
        b.setImageResource(R.drawable.blank);
        b = (ImageButton) findViewById(R.id.imageButton20);
        b.setImageResource(R.drawable.blank);
        b = (ImageButton) findViewById(R.id.imageButton21);
        b.setImageResource(R.drawable.blank);
        b = (ImageButton) findViewById(R.id.imageButton22);
        b.setImageResource(R.drawable.blank);
        turn = 0;
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3; j++){
                ticked[i][j]=-1;
            }
        }
    }

}
