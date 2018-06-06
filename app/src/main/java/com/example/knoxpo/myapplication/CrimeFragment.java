package com.example.knoxpo.myapplication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class CrimeFragment extends android.support.v4.app.Fragment {

    private Crime mCrime;
    private EditText mCrime_title;
    private Button mDate_button;
    private CheckBox mSolve_checkbox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCrime = new Crime();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime,container,false);

           mCrime_title = view.findViewById(R.id.crime_title);
           mDate_button = view.findViewById(R.id.crime_date);
           mSolve_checkbox = view.findViewById(R.id.crime_solved);

           mCrime_title.addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

                   mCrime.setmTitle(s.toString());
               }

               @Override
               public void afterTextChanged(Editable s) {

               }
           });

        mDate_button.setText(mCrime.getmDate().toString());
        mDate_button.setEnabled(false);

        mSolve_checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setmSolved(isChecked);
            }
        });

           return  view;

    }
}
