package com.mrlonewolfer.example51;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    Button btnRed,btnYellow,btnGreen;
    EditText edtName,edtEmail;
    ImageView imageView;
    LinearLayout linearLayout;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        btnGreen=view.findViewById(R.id.btnGreen);
        btnRed=view.findViewById(R.id.btnRed);
        btnYellow=view.findViewById(R.id.btnYellow);
        btnRed.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnGreen){
            changeToastColor(Color.GREEN);

        }
        if(v.getId()==R.id.btnRed){
            changeToastColor(Color.RED);
        }
        if(v.getId()==R.id.btnYellow){
            changeToastColor(Color.YELLOW);

        }
    }

    private void changeToastColor(int color) {

        LayoutInflater layoutInflater=getLayoutInflater();
        View layoutInflateView=layoutInflater.inflate(R.layout.custom_toast_layout, (ViewGroup) getView().findViewById(R.id.customlayout));
        edtName=layoutInflateView.findViewById(R.id.edtName);
        edtEmail=layoutInflateView.findViewById(R.id.edtEmail);
        imageView=layoutInflateView.findViewById(R.id.imgview);
        linearLayout=layoutInflateView.findViewById(R.id.customlayout);
        imageView.setVisibility(View.VISIBLE);
        linearLayout.setBackgroundColor(color);
        Toast toast = new Toast(getActivity());
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layoutInflateView);
        toast.show();

    }
}
