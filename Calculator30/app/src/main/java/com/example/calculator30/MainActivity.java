package com.example.calculator30;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import org.mariuszgromada.math.mxparser.*;

import com.example.calculator30.database.DB;
import com.example.calculator30.database.History;
import com.example.calculator30.objects.Data;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.text.SpannableStringBuilder;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnClear, btnBackspace, btnPow, btnDiv, btnMulti, btnSub, btnAdd, btnEqual, btnPoint, btnHistory;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);
        display.setShowSoftInputOnFocus(false);

        btnZero = findViewById(R.id.btn0);
        btnOne = findViewById(R.id.btn1);
        btnTwo = findViewById(R.id.btn2);
        btnThree = findViewById(R.id.btn3);
        btnFour = findViewById(R.id.btn4);
        btnFive = findViewById(R.id.btn5);
        btnSix = findViewById(R.id.btn6);
        btnSeven = findViewById(R.id.btn7);
        btnEight = findViewById(R.id.btn8);
        btnNine = findViewById(R.id.btn9);

        btnClear = findViewById(R.id.btnCLR);
        btnBackspace = findViewById(R.id.btnBSP);
        btnPow = findViewById(R.id.btnPOW);
        btnDiv = findViewById(R.id.btnDIV);
        btnMulti = findViewById(R.id.btnMLT);
        btnSub = findViewById(R.id.btnMIN);
        btnAdd = findViewById(R.id.btnPLS);
        btnEqual = findViewById(R.id.btnEQ);
        btnPoint = findViewById(R.id.btnDEC);
        btnHistory = findViewById(R.id.btnHTR);

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("0");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("1");
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("2");
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("3");
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("4");
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("5");
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("6");
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("7");
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("8");
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("9");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
            }
        });

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cursorPos = display.getSelectionStart();
                int textLen = display.getText().length();

                if (cursorPos != 0 && textLen != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
                    selection.replace(cursorPos -1, cursorPos, "");
                    display.setText(selection);
                    display.setSelection(cursorPos - 1);
                }
            }
        });

        btnPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("^");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("÷");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("×");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("-");
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText("+");
            }
        });

        //Entry to Database
        DB entry = new DB();
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userExp = display.getText().toString();
                userExp = userExp.replaceAll("÷", "/");
                userExp = userExp.replaceAll("×", "*");

                Expression exp = new Expression(userExp);

                String result = String.valueOf(exp.calculate());

                Data data = new Data(display.getText().toString(),result);
                entry.add(data);

                display.setText(result);
                display.setSelection(result.length());
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText(".");
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHistory();
            }
        });
    }

    public void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursor = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursor);
        String rightStr = oldStr.substring(cursor);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursor+1);
    }

    public void openHistory(){
        Intent intent = new Intent(this, History.class);
        startActivity(intent);
    }
}