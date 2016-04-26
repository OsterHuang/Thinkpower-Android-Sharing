package com.example.oster.easycake;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ActivityThree extends AppCompatActivity {

    private Button btnFragment1;
    private Button btnFragment2;
    private Button btnFragmentList;
    private FrameLayout lytFragment;
    private TextView txtValueFromFragment;

    private FragmentOne fragmentOne;
    private FragmentTwo fragmentTwo;
    private FragmentList fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_three);

        btnFragment1 = (Button) findViewById(R.id.btnFragment1);
        btnFragment2 = (Button) findViewById(R.id.btnFragment2);
        btnFragmentList = (Button) findViewById(R.id.btnFragmentList);
        lytFragment = (FrameLayout) findViewById(R.id.lytFragment);
        txtValueFromFragment = (TextView) findViewById(R.id.txtValueFromFragment);

        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentOne == null) {
                    fragmentOne = new FragmentOne();
                }

                FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                t.replace(R.id.lytFragment, fragmentOne);
                t.commit();

                fragmentOne.setListener(new FragmentOne.OnFragmentOneClick() {
                    @Override
                    public void onClick(String param) {
                        txtValueFromFragment.setText(param);
                    }

                    @Override
                    public void onClean() {
                        txtValueFromFragment.setText("");
                    }

                });
            }
        });

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentTwo == null) {
                    fragmentTwo = new FragmentTwo();
                }

                FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                t.replace(R.id.lytFragment, fragmentTwo);
                t.commit();
            }
        });

        btnFragmentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fragmentList == null) {
                    fragmentList = new FragmentList();
                }

                FragmentTransaction t = getSupportFragmentManager().beginTransaction();
                t.replace(R.id.lytFragment, fragmentList);
                t.commit();
            }
        });

    }
}
