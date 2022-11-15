package com.takuchan.judgeaiage;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.takuchan.judgeaiage.databinding.FragmentSecondBinding;

import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    Button sendButton;
    EditText editText;
    ListView listView;
    int count = 0;
    int randomInt = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        listView = binding.listView;
        editText = binding.TextNumberName;
        sendButton = binding.button;
        Random random = new Random();
        randomInt = random.nextInt(8) + 14;
        System.out.println(randomInt+"");
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               count = Integer.parseInt(editText.getText().toString());
               if (count == randomInt){
                   System.out.println("同じです");
               }else{
                   if(count < randomInt){
                       System.out.println("もっとお姉さんです");
                   }else{
                       System.out.println("もっと若いですs");
                   }
               }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}