package com.dealfaro.luca.class2;

import android.graphics.Color;
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
        ImageButton b = (ImageButton) findViewById(R.id.imageButton00);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton01);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton02);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton10);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton11);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton12);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton20);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton21);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton22);
        b.setBackgroundResource(android.R.drawable.btn_default);
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
        TextView c = (TextView) findViewById(R.id.wonView);
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
            if(ticked[0][0]!=-1 && ticked[0][0]==ticked[1][1] && ticked[0][0]==ticked[2][2]) {
                if(ticked[0][0]==0)
                    c.setText("O won!");
                else
                    c. setText("X won!");
                highlight('d',0);
                gameWin(v);
                turn=-1;
            }
            if(ticked[0][2]!=-1 && ticked[0][2]==ticked[1][1] && ticked [0][2]==ticked[2][0]) {
                if(ticked[0][2]==0)
                    c.setText("O won!");
                else
                    c. setText("X won!");
                highlight('d',1);
                gameWin(v);
                turn=-1;
            }
            for(int j=0; j<3; j++) {
                if (ticked[j][0] != -1 && ticked[j][0] == ticked[j][1] && ticked[j][0] == ticked[j][2]) {
                    if(ticked[j][0]==0)
                        c.setText("O won!");
                    else
                        c. setText("X won!");
                    highlight('r',j);
                    gameWin(v);
                    turn=-1;

                }
                if (ticked[0][j] != -1 && ticked[0][j] == ticked[1][j] && ticked[0][j] == ticked[2][j]) {
                    if(ticked[0][j]==0)
                        c.setText("O won!");
                    else
                        c. setText("X won!");
                    highlight('c',j);
                    gameWin(v);
                    turn=-1;
                }
                if(turn == 9){
                    c.setText("Tie");
                    gameWin(v);
                }
            }
        }
    }

    public void highlight(char type,int line){
        ImageButton b = (ImageButton) findViewById(R.id.imageButton00);
        if(type == 'r'){
            switch (line) {
                case 0:
                    b = (ImageButton) findViewById(R.id.imageButton00);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton01);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton02);
                    b.setBackgroundColor(Color.GREEN);
                    break;
                case 1:
                    b = (ImageButton) findViewById(R.id.imageButton10);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton11);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton12);
                    b.setBackgroundColor(Color.GREEN);
                    break;
                case 2:
                    b = (ImageButton) findViewById(R.id.imageButton20);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton21);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton22);
                    b.setBackgroundColor(Color.GREEN);
                    break;
            }
        }
        if(type == 'c'){
            switch(line){
                case 0:
                    b = (ImageButton) findViewById(R.id.imageButton00);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton10);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton20);
                    b.setBackgroundColor(Color.GREEN);
                    break;
                case 1:
                    b = (ImageButton) findViewById(R.id.imageButton01);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton11);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton21);
                    b.setBackgroundColor(Color.GREEN);
                    break;
                case 2:
                    b = (ImageButton) findViewById(R.id.imageButton02);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton12);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton22);
                    b.setBackgroundColor(Color.GREEN);
                    break;
            }
        }
        if(type == 'd'){
            switch (line){
                case 0:
                    b = (ImageButton) findViewById(R.id.imageButton00);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton11);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton22);
                    b.setBackgroundColor(Color.GREEN);
                    break;
                case 1:
                    b = (ImageButton) findViewById(R.id.imageButton02);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton11);
                    b.setBackgroundColor(Color.GREEN);
                    b = (ImageButton) findViewById(R.id.imageButton20);
                    b.setBackgroundColor(Color.GREEN);
                    break;
            }
        }

    }

    public void newGame(View v){
        ImageButton b = (ImageButton) findViewById(R.id.imageButton00);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton01);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton02);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton10);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton11);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton12);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton20);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton21);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        b = (ImageButton) findViewById(R.id.imageButton22);
        b.setImageResource(R.drawable.blank);
        b.setEnabled(true);
        b.setBackgroundResource(android.R.drawable.btn_default);
        turn = 0;
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3; j++){
                ticked[i][j]=-1;
            }
        }
        TextView c = (TextView) findViewById(R.id.wonView);
        c.setVisibility(View.INVISIBLE);
    }

    public void gameWin(View v){
        TextView c = (TextView) findViewById(R.id.wonView);
        c.setVisibility(View.VISIBLE);
        ImageButton b = (ImageButton) findViewById(R.id.imageButton00);
        b.setEnabled(false);
        b = (ImageButton) findViewById(R.id.imageButton01);
        b.setEnabled(false);
        b = (ImageButton) findViewById(R.id.imageButton02);
        b.setEnabled(false);
        b = (ImageButton) findViewById(R.id.imageButton10);
        b.setEnabled(false);
        b = (ImageButton) findViewById(R.id.imageButton11);
        b.setEnabled(false);
        b = (ImageButton) findViewById(R.id.imageButton12);
        b.setEnabled(false);
        b = (ImageButton) findViewById(R.id.imageButton20);
        b.setEnabled(false);
        b = (ImageButton) findViewById(R.id.imageButton21);
        b.setEnabled(false);
        b = (ImageButton) findViewById(R.id.imageButton22);
        b.setEnabled(false);
    }

}
