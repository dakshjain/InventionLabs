package com.example.rajatjain.inventionlabs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;



public class Result extends AppCompatActivity {

    TextView result_text;
    int no;
    Button check;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        result_text = (TextView)findViewById(R.id.result_text);
        no = getIntent().getExtras().getInt("Results");
        if(no==21){
            result_text.setText("Congratulations !!!  You got All Points right");
        }
        result_text.setText("You got "+no+" Points right");
        result_text.setBackgroundColor(16777215);
        check = (Button)findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Result.this,Main3Activity.class);
                startActivity(intent);

            }
        });
    }
}
