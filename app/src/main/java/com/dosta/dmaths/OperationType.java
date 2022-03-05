package com.dosta.dmaths;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OperationType extends AppCompatActivity {

    Button button;
    TextView tvLEvelInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_type);

        tvLEvelInfo = (TextView) findViewById(R.id.levelInfoText);
        tvLEvelInfo.setText("Level " + Integer.toString(levels.level));

        //Addition
        button = (Button) findViewById(R.id.opTypeButton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivityAdd();
            }
        });

        //Subtraction
        button = (Button) findViewById(R.id.opTypeButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivitySub();
            }
        });

        //multiplication
        button = (Button) findViewById(R.id.opTypeButton3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivityMul();
            }
        });

        //division
        button = (Button) findViewById(R.id.opTypeButton4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivityDiv();
            }
        });

        //math tables
        button = (Button) findViewById(R.id.opTypeButtonTables);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivityTable();
            }
        });
        //Square
        button = (Button) findViewById(R.id.opTypeButtonSq);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivitySquare();
            }
        });

        //Square root
        button = (Button) findViewById(R.id.opTypeButtonSqrt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivitySqrt();
            }
        });

    }
    public void openNewActivityAdd(){
        Intent intent = new Intent(this, addition.class);
        startActivity(intent);
    }
    public void openNewActivitySub(){
        Intent intent = new Intent(this, subtraction.class);
        startActivity(intent);
    }
    public void openNewActivityMul(){
        Intent intent = new Intent(this, multiplication.class);
        startActivity(intent);
    }
    public void openNewActivityDiv(){
        Intent intent = new Intent(this, division.class);
        startActivity(intent);
    }

    public void openNewActivityTable(){
        Intent intent = new Intent(this, mathTable.class);
        startActivity(intent);
    }

    public void openNewActivitySquare(){
        Intent intent = new Intent(this, square.class);
        startActivity(intent);
    }
    public void openNewActivitySqrt(){
        Intent intent = new Intent(this, squareRoot.class);
        startActivity(intent);
    }
}

