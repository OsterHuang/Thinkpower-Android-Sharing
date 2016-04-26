package com.example.oster.easycake;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends AppCompatActivity {

    public final static String EXTRA_INPUT_VALUE = "EXTRA_INPUT_VALUE";

    private TextView txtValueFromMain;
    private Button btnActivityTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_one);

        txtValueFromMain = (TextView) findViewById(R.id.txtValueFromMain);
        btnActivityTwo = (Button) findViewById(R.id.btnActivityTwo);

        txtValueFromMain.setText(getIntent().getExtras().getString(EXTRA_INPUT_VALUE));
        btnActivityTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(ActivityOne.this, ActivityTwo.class);
                startActivity(intent);
            }
        });

    }
}
