package com.example.domashnee_zadanie_8_2.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.domashnee_zadanie_8_2.R;

public class NameDetailFragment extends Fragment {
    private static final String ARG_NAME = "name";
    private static final String ARG_DOB = "dob";
    private static final String ARG_MEANING = "meaning";

    private String name;
    private String dob;
    private String meaning;

    public static NameDetailFragment newInstance(String name, String dob, String meaning) {
        NameDetailFragment fragment = new NameDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_DOB, dob);
        args.putString(ARG_MEANING, meaning);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_detail, container, false);

        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            dob = getArguments().getString(ARG_DOB);
            meaning = getArguments().getString(ARG_MEANING);
        }

        TextView nameTextView = view.findViewById(R.id.nameTextView);
        TextView dobTextView = view.findViewById(R.id.dobTextView);
        TextView meaningTextView = view.findViewById(R.id.meaningTextView);

        nameTextView.setText("Name: " + name);
        dobTextView.setText("Date of Birth: " + dob);
        meaningTextView.setText("Meaning: " + meaning);

        return view;
    }
}
