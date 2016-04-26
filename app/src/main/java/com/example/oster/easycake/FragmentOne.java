package com.example.oster.easycake;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentOne extends Fragment {

    private Button btnToAct3;
    private Button btnToAct3Clear;

    private OnFragmentOneClick mListener;

    public FragmentOne() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_one, container, false);
        btnToAct3 = (Button) myView.findViewById(R.id.btnToAct3);
        btnToAct3Clear = (Button) myView.findViewById(R.id.btnToAct3Clear);

        btnToAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick("This is button click from fragment 1");
                }
            }
        });
        btnToAct3Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClean();
                }
            }
        });

        return myView;
    }

    public void removeListener() {
        mListener = null;
    }

    public void setListener(OnFragmentOneClick mListener) {
        this.mListener = mListener;
    }

    public interface OnFragmentOneClick {
        void onClick(String param);
        void onClean();
    }
}
