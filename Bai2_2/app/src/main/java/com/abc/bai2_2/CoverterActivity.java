package com.abc.bai2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CoverterActivity extends AppCompatActivity {

    TextView input, output,note;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverter);

        Intent intent = getIntent();
        String description = intent.getStringExtra("description");

        if (description!= null){
            anhXa();
            note.setText(description);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] splited = description.split("\\s+");
                    String getValue="";
                    for (int i = 0 ; i < splited.length ; i++){
                        if (splited[i].equalsIgnoreCase("=")){
                            getValue = splited[i+1];
                            break;
                        }
                    }

                    String inputMoneyString = input.getText().toString();
                    double inputMoneyDouble = Double.parseDouble(inputMoneyString);
                    double exchangeRate = Double.parseDouble(getValue);;

                    double result = Converter(inputMoneyDouble, exchangeRate);
                    output.setText(result+"");
                }
            });
        }

    }

    private void anhXa() {
        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        note = (TextView) findViewById(R.id.textViewNote);
        button = (Button) findViewById(R.id.buttonConverter);
    }

    double Converter(Double input, double exchangeRate){
        return input*exchangeRate;
    }
}