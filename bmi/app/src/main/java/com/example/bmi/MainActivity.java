package com.example.bmi;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EditText editweight, editheightinch, editheightfit;
        TextView txtresult ;
        Button button;
        
        editweight = findViewById(R.id.EditWeight);
        editheightfit = findViewById(R.id.EditHeightFit);
        editheightinch = findViewById(R.id.EditHeightInch);
        button = findViewById(R.id.button);
        txtresult = findViewById(R.id.TxtResult);
        LinearLayout llmain = findViewById(R.id.llmain);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Calculated", Toast.LENGTH_SHORT).show();
                int wt = Integer.parseInt(editweight.getText().toString());
                int ft = Integer.parseInt(editheightfit.getText().toString());
                int inch = Integer.parseInt(editheightinch.getText().toString());

                int totalInch = ft*12 + inch;
                double totalcm = totalInch*2.53;
                double totalM = totalcm/100;
                double bmi = wt/(totalM*totalM);

                if(bmi>25){
                    txtresult.setText("Your Are Over Weight!");

                    llmain.setBackgroundColor(getResources().getColor(R.color.OW));
                } else if (bmi<18) {
                    txtresult.setText("Your Are Under Weight!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.UW));

                }
                else {
                    txtresult.setText("Your Are Healthy!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.Healt));
                }

            }
        });
        
    }
}