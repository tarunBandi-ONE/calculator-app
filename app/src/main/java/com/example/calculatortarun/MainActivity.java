package com.example.calculatortarun;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.StringTokenizer;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    TextView t1;
    CharSequence t2;
    TextView one,two,three,four,five,six,seven,eight,nine,zero,c,equals,slash,times,plus,minus,time,divide;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.one);
        b2 = findViewById(R.id.two);
        b3 = findViewById(R.id.three);
        b4 = findViewById(R.id.Plus);
        b5 = findViewById(R.id.four);
        b6 = findViewById(R.id.five);
        b7 = findViewById(R.id.six);
        b8 = findViewById(R.id.minus);
        b9 = findViewById(R.id.Seven);
        b10 = findViewById(R.id.Eight);
        b11= findViewById(R.id.Nine);
        b12 = findViewById(R.id.Times);
        b13 = findViewById(R.id.C);
        b14 = findViewById(R.id.Zero);
        b15 = findViewById(R.id.equals);
        b16 = findViewById(R.id.slash);
        t1 = findViewById(R.id.zero);
        counter = 0;

    }

    public void onClickGo(View v) {
        if(counter==0)
            t1.setText("");
        if(v==b1){
            t1.append("1");
            counter++;
        }
        if(v==b2){
            t1.append("2");
            counter++;
        }
        if(v==b3){
            t1.append("3");
            counter++;
        }
        if(v==b5){
            t1.append("4");
            counter++;
        }
        if(v==b6){
            t1.append("5");
            counter++;
        }
        if(v==b7){
            t1.append("6");
            counter++;
        }
        if(v==b9){
            t1.append("7");
            counter++;
        }if(v==b10){
            t1.append("8");
            counter++;
        }if(v==b11){
            t1.append("9");
            counter++;
        }if(v==b13){
            t1.setText("0");
            counter=0;
        }if(v==b14){
            t1.append("0");
            counter++;
        }if(v==b4){
            t1.append("+");
            counter++;
        }if(v==b8){
            t1.append("-");
            counter++;
        }if(v==b12){
            t1.append("*");
            counter++;
        }if(v==b16) {
            t1.append("/");
            counter++;
        }if(v==b15) {
            t2=t1.getText();
            StringTokenizer Tokenizer = new StringTokenizer((String)t2,"+/-*",true);
            ArrayList<String> List = new ArrayList<String>();
            while(Tokenizer.hasMoreTokens())
            {
                String currentToken = Tokenizer.nextToken();
                List.add(currentToken);
            }
            double result = Double.parseDouble(List.get(0));
            int index = 1;
            while(index<List.size()-1)
            {
                switch(List.get(index)){
                    case "+":
                        result += (Double.parseDouble(List.get(index+1)));
                        break;
                    case "-":
                        result -= (Double.parseDouble(List.get(index+1)));
                        break;
                    case "/":
                        result /= (Double.parseDouble(List.get(index+1)));
                        break;
                    case "*":
                        result *= (Double.parseDouble(List.get(index+1)));
                        break;
                }
                if(index+2!=List.size())
                    index+=2;
                else
                    index++;
            }
            
            t1.setText(Double.toString(result));



        }






    }
}
