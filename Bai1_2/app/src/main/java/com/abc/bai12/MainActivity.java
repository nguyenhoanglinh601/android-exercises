package com.abc.bai12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioButton cTf, fTc;
    EditText num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cTf.isChecked()){
                    ctf();
                }
                else{
                    ftc();
                }
            }
        });

    }

    private void initial() {
        btn = (Button) findViewById(R.id.button);
        cTf = (RadioButton) findViewById(R.id.radioButton);
        fTc = (RadioButton) findViewById(R.id.radioButton2);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
    }

    void ctf(){
        String num_1 = num1.getText().toString();
        double temp1 = Double.parseDouble(num_1);

        //F = 9/5 x C + 32 = 1.8 x C + 32
        double temp2 = 1.8*temp1+32;
        String num_2 = temp2+"";
        num2.setText(num_2);
    }

    void ftc(){
        String num_1 = num1.getText().toString();
        double temp1 = Double.parseDouble(num_1);
        //C = 5/9  x  ( F – 32 ) =  ( F – 32 ) / 1.8
        double temp2 = (temp1 - 32) / 1.8;
        String num_2 = temp2+"";
        num2.setText(num_2);
    }

}