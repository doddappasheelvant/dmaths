package com.dosta.dmaths;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class addition extends AppCompatActivity {

    public static int level = 1;
    int count = 0;
    Button button;
    TextView tvLEvelInfo;

    private int num1;
    private int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        tvLEvelInfo = (TextView) findViewById(R.id.levelInfoText);
        tvLEvelInfo.setText("Level " + Integer.toString(levels.level));

        //switch to edit Question
        Switch sw = (Switch) findViewById(R.id.switchToEdit);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EditText etNum1 = (EditText) findViewById(R.id.editTextNum1);
                EditText etNum2 = (EditText) findViewById(R.id.editTextNum2);
                if (isChecked) {
                    // The toggle is enabled
                    etNum1.setFocusable(true);
                    etNum1.setFocusableInTouchMode(true);
                    etNum1.setClickable(true);

                    etNum2.setFocusable(true);
                    etNum2.setFocusableInTouchMode(true);
                    etNum2.setClickable(true);
                    System.out.println("checked....");
                } else {
                    // The toggle is disabled
                    etNum1.setFocusable(false);
                    etNum1.setFocusableInTouchMode(false);
                    etNum1.setClickable(false);

                    etNum2.setFocusable(false);
                    etNum2.setFocusableInTouchMode(false);
                    etNum2.setClickable(false);
                    System.out.println("un checked...");
                }
            }
        });

        //Question button
        button = (Button) findViewById(R.id.qButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count ++;
                TextView quationNum = (TextView) findViewById(R.id.textViewQuationNum);
                quationNum.setText("Quation No. " + Integer.toString(count));

                switch (levels.level)
                {
                    case 1:
                        qUpdate(0,9);
                        break;
                    case 2:
                        qUpdate(0,999);
                        break;
                    case 3:
                        qUpdate(0,99999);
                        break;
                    case 4:
                        qUpdate(0,999999);
                        break;
                    default:
                        qUpdate(0,9);
                        break;
                }
            }
        });

        //Answer button
        button = (Button) findViewById(R.id.aButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText etNum1 = (EditText) findViewById(R.id.editTextNum1);
                num1 =  Integer.parseInt(etNum1.getText().toString());
                System.out.println("random num1: " + Integer.toString(num1));

                EditText etNum2 = (EditText) findViewById(R.id.editTextNum2);
                num2 =  Integer.parseInt(etNum2.getText().toString());
                System.out.println("random num2: " + Integer.toString(num2));

                int resultAdd = num1 + num2;
                EditText resultText = (EditText) findViewById(R.id.editTextSquareRoot);
                resultText.setText(Integer.toString(resultAdd));
            }
        });

        //Test result button
        button = (Button) findViewById(R.id.testButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultAdd = num1 + num2;
                EditText resultText = (EditText) findViewById(R.id.editTextSquareRoot);
                String resultManual = resultText.getText().toString();

                if (Integer.toString(resultAdd).equals(resultManual)) {
                    System.out.println("result PASS");

                    AlertDialog.Builder alert = new AlertDialog.Builder(addition.this);
                    alert.setTitle("    Congratulations !!!");
                    alert.setMessage("  You solved this CORRECT..");
                    alert.setIcon(R.drawable.thumbsupimg);
                    alert.setPositiveButton("OK",null);
                    alert.show();
                }
                else {
                    System.out.println("result FAIL");

                    AlertDialog.Builder alert = new AlertDialog.Builder(addition.this);
                    alert.setTitle("    Wrong Ans !!!");
                    alert.setMessage("          Try Again...");
                    alert.setIcon(R.drawable.thumbsdownimg);
                    alert.setPositiveButton("OK", null);
                    alert.show();
                }

            }
        });
    }
    /*
    public void qUpdate(int min, int max ) {

        num1 = getRandomNumber(min, max);
        TextView tvNum1 = (TextView) findViewById(R.id.number1);
        tvNum1.setText(Integer.toString(num1));
        System.out.println("random num1: " + Integer.toString(num1));

        num2 = getRandomNumber(min, max);
        TextView tvNum2 = (TextView) findViewById(R.id.number2);
        tvNum2.setText(Integer.toString(num2));
        System.out.println("random num2: " + Integer.toString(num2));

        EditText resultText = (EditText) findViewById(R.id.editTextDiv);
        resultText.setText(null);
    }*/

    public void qUpdate(int min, int max ) {

        num1 = getRandomNumber(min, max);
        num2 = getRandomNumber(min, max);

        EditText etNum1 = (EditText) findViewById(R.id.editTextNum1);
        etNum1.setText(Integer.toString(num1));
        System.out.println("random num1: " + Integer.toString(num1));


        EditText etNum2 = (EditText) findViewById(R.id.editTextNum2);
        etNum2.setText(Integer.toString(num2));
        System.out.println("random num2: " + Integer.toString(num2));

        EditText resultText = (EditText) findViewById(R.id.editTextSquareRoot);
        resultText.setText(null);
    }

    public int getRandomNumber(int min,int max) {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

}