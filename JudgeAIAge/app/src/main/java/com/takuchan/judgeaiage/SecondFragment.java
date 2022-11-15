package com.takuchan.judgeaiage;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.util.ArrayList;
import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    Button sendButton;
    EditText editText;
    ListView listView;
    int count = 0;
    int randomInt = 0;
    ArrayList<CardModel> listItems = new ArrayList<>();

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

        Bitmap initBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.woman);
        CardModel cardModel = new CardModel("あーたん","私は何歳か当ててみてね",initBitmap);
        listItems.add(cardModel);
        CardAdapter adapter = new CardAdapter(getContext(),R.layout.card_layout,listItems);
        listView.setAdapter(adapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               count = Integer.parseInt(editText.getText().toString());
               if (count == randomInt){
                   System.out.println("同じです");
                   Bitmap initBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.otaku);
                   CardModel cardModel = new CardModel("オタクくん",String.valueOf(count),initBitmap);
                   listItems.add(cardModel);
                   Bitmap initBitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.woman);
                   CardModel cardModel2 = new CardModel("あーたん","あたり！",initBitmap2);
                   listItems.add(cardModel2);
                   CardAdapter adapter = new CardAdapter(getContext(),R.layout.card_layout,listItems);
                   listView.setAdapter(adapter);
                   System.out.println("もっとお姉さんです");
               }else{
                   if(count < randomInt){
                       Bitmap initBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.otaku);
                       CardModel cardModel = new CardModel("オタクくん",String.valueOf(count),initBitmap);
                       listItems.add(cardModel);
                       Bitmap initBitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.woman);
                       CardModel cardModel2 = new CardModel("あーたん","もっとお姉さんです",initBitmap2);
                       listItems.add(cardModel2);
                       CardAdapter adapter = new CardAdapter(getContext(),R.layout.card_layout,listItems);
                       listView.setAdapter(adapter);
                       System.out.println("もっとお姉さんです");
                   }else{
                       Bitmap initBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.otaku);
                       CardModel cardModel = new CardModel("オタクくん",String.valueOf(count),initBitmap);
                       listItems.add(cardModel);
                       Bitmap initBitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.woman);
                       CardModel cardModel2 = new CardModel("あーたん","もっと若いよ",initBitmap2);
                       listItems.add(cardModel2);
                       CardAdapter adapter = new CardAdapter(getContext(),R.layout.card_layout,listItems);
                       listView.setAdapter(adapter);
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