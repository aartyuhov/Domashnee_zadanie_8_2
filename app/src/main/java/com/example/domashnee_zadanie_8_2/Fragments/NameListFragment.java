package com.example.domashnee_zadanie_8_2.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.domashnee_zadanie_8_2.R;

public class NameListFragment extends Fragment {
    private String[] names = {"Alice", "Bob", "Catherine", "David"};
    private String[] birthDates = {"01/01/2000", "12/12/1998", "03/15/2002", "07/19/1995"};
    private String[] meanings = {
            "Noble and kind",
            "Bright fame",
            "Pure",
            "Beloved"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_list, container, false);
        GridView gridView = view.findViewById(R.id.gridView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, names);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NameDetailFragment detailFragment = NameDetailFragment.newInstance(
                        names[position], birthDates[position], meanings[position]);
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, detailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
