package com.dosta.dmaths;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class multiplication extends AppCompatActivity {

    public static int level = 1;
    int count = 0;
    Button button;
    TextView tvLEvelInfo;

    private int num1;
    private int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiply);

        tvLEvelInfo = (TextView) findViewById(R.id.levelInfoText);
        tvLEvelInfo.setText("Level " + Integer.toString(levels.level));

        //Question button
        button = (Button) findViewById(R.id.qButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                TextView quationNum = (TextView) findViewById(R.id.textViewQuationNum);
                quationNum.setText("Quation No. " + Integer.toString(count));
                qUpdate();
            }
        });

        //Answer button
        button = (Button) findViewById(R.id.aButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = num1 * num2;
                EditText resultText = (EditText) findViewById(R.id.editTextSquareRoot);
                resultText.setText(Integer.toString(result));
            }
        });

        //Test button
        button = (Button) findViewById(R.id.testButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = num1 * num2;
                EditText resultText = (EditText) findViewById(R.id.editTextSquareRoot);
                String resultManual = resultText.getText().toString();

                if (Integer.toString(result).equals(resultManual)) {
                    System.out.println("result PASS");

                    AlertDialog.Builder alert = new AlertDialog.Builder(multiplication.this);
                    alert.setTitle("    Congratulations !!!");
                    alert.setMessage("  You solved this CORRECT..");
                    alert.setIcon(R.drawable.thumbsupimg);
                    alert.setPositiveButton("OK",null);
                    alert.show();
                }
                else {
                    System.out.println("result FAIL");

                    AlertDialog.Builder alert = new AlertDialog.Builder(multiplication.this);
                    alert.setTitle("    Wrong Ans !!!");
                    alert.setMessage("          Try Again...");
                    alert.setIcon(R.drawable.thumbsdownimg);
                    alert.setPositiveButton("OK", null);
                    alert.show();
                }

            }
        });
    }
    public void qUpdate( ) {

        switch (levels.level)
        {
            case 1:
                num1 = getRandomNumber(1, 99);
                num2 = getRandomNumber(1,9);
                break;
            case 2:
                num1 = getRandomNumber(99, 9999);
                num2 = getRandomNumber(9,99);
                break;
            case 3:
                num1 = getRandomNumber(999, 99999);
                num2 = getRandomNumber(99,999);
                break;
            case 4:
                num1 = getRandomNumber(999, 99999);
                num2 = getRandomNumber(99,9999);
                break;
            default:
                num1 = getRandomNumber(1, 99);
                num2 = getRandomNumber(1,9);
                break;
        }

        TextView tvNum1 = (TextView) findViewById(R.id.number1);
        tvNum1.setText(Integer.toString(num1));
        System.out.println("random num1: " + Integer.toString(num1));

        TextView tvNum2 = (TextView) findViewById(R.id.number2);
        tvNum2.setText(Integer.toString(num2));
        System.out.println("random num2: " + Integer.toString(num2));

        EditText resultText = (EditText) findViewById(R.id.editTextSquareRoot);
        resultText.setText(null);
    }

    public int getRandomNumber(int min,int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

}