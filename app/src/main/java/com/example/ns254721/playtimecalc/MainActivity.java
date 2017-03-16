package com.example.ns254721.playtimecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View V) {

        EditText e1 = (EditText) findViewById(R.id.free);
        EditText e2 = (EditText) findViewById(R.id.length);
        TextView t1 = (TextView) findViewById(R.id.result);
        double free = Double.parseDouble(e1.getText().toString());
        double length = Double.parseDouble(e2.getText().toString());
        double res = length / free;


        if (TextUtils.isEmpty(e1.getText().toString()) || TextUtils.isEmpty(e2.getText().toString()))
        {
            //Text field is empty
            Toast.makeText(MainActivity.this,
                    "Please fill in the text fields.", Toast.LENGTH_LONG).show();

        }
        else //Text fields are not empty
        {
            if (length >= 60){
                // If game length is 60 hours or longer
                t1.setText(String.format("%.1f",res) + " days to finish! That'll take a while.");

            } else {

                if (Double.isInfinite(res)){
                    // If result is equal to infinity
                    t1.setText("Divide by zero error. Please close this app before your device sets on fire.");
                }else{

                    if (Double.isNaN(res) || res == 0) {
                        //if result is equal to NaN
                        t1.setText("Can't finish the game if there isn't one!");

                    }else{

                        //Actual result
                        t1.setText(String.format("%.1f",res) + " days to finish!");
                        //not rounded value
                        //t1.setText(Math.round(res) + " days to finish!");
                        //rounded value

                    }


                }

            }
        }
    }


}
