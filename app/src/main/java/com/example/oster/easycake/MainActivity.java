package com.example.oster.easycake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String tag = getClass().getSimpleName();

    private EditText txtInput;
    private TextView txtOutput;
    private Button btnInput;

    private Button btnActivity1;
    private Button btnActivity2;
    private Button btnActivity3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViewHold();
        setListener();
    }

    // ----
    // User Interaction
    // ----

    // ----
    // Initial method
    // ----
    private void setViewHold() {
        txtInput = (EditText) findViewById(R.id.txtInput);
        txtOutput = (TextView) findViewById(R.id.txtOuput);
        btnInput = (Button) findViewById(R.id.btnInput);

        btnActivity1 = (Button) findViewById(R.id.btnActivity1);
        btnActivity2 = (Button) findViewById(R.id.btnActivity2);
        btnActivity3 = (Button) findViewById(R.id.btnActivity3);
    }

    private void setListener() {
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtOutput.setText(txtInput.getText());
            }
        });

        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ActivityOne.class);

                intent.putExtra(ActivityOne.EXTRA_INPUT_VALUE, txtInput.getText().toString());
                startActivity(intent);
            }
        });

        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

        btnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ActivityThree.class);
                startActivity(intent);
            }
        });
    }

}
