package com.takuchan.primecount;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    Button plusbutton,minusbutton;
    TextView primeText,evenText;
    EditText inputFigure;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plusbutton = (Button) findViewById(R.id.button);
        minusbutton = (Button) findViewById(R.id.button2);
        setTitle("素数チェッカ");
        primeText = (TextView) findViewById(R.id.textView2);
        evenText = (TextView) findViewById(R.id.textView);
        inputFigure = (EditText) findViewById(R.id.editTextTextPersonName);

        inputFigure.addTextChangedListener(this);

        plusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count +=1;
                inputFigure.setText(String.valueOf(count));
                boolean judgePrime = judgePrime(count);
                boolean judgeEven = judgeEven(count);
                showText(judgePrime,judgeEven);
                if(count < 2){
                    primeText.setText("判別不可");
                }
            }
        });
        minusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count -=1;
                inputFigure.setText(String.valueOf(count));
                boolean judgePrime = judgePrime(count);
                boolean judgeEven = judgeEven(count);
                showText(judgePrime,judgeEven);

                if(count < 2){
                    primeText.setText("判別不可");
                }
            }
        });


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(editable.length() == 0){

            primeText.setText("Ready");
        }else{
            int number = Integer.parseInt(editable.toString());
            count = number;
            if(number == 0 || number == 1){
                primeText.setText("処理不可");
            }else{
                boolean resultPrime = judgePrime(number);
                boolean resultEven = judgeEven(number);
                showText(resultPrime,resultEven);
            }
        }

    }

    public static boolean judgePrime(double number){
        Boolean judgeResult = true;
        for(int i = 2; i < number;i++){
            if(number % i == 0){
                judgeResult = false;
            }
        }
        return judgeResult;
    }
    public static boolean judgeEven(double number){
        if (number % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    void showText(boolean prime,boolean even){
        TextView primeText = this.primeText;
        TextView evenText = this.evenText;

        if(prime){
            primeText.setText("素数");
        }else{
            primeText.setText("合成数");
        }
        if(even){
            evenText.setText("偶数");
            evenText.setTextColor(Color.RED);
        }else{
            evenText.setText("奇数");
            evenText.setTextColor(Color.BLUE);
        }
    }
}