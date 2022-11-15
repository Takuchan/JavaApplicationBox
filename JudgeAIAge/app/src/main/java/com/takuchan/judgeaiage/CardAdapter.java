package com.takuchan.judgeaiage;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CardAdapter extends ArrayAdapter<CardModel> {
    private int mResorce;
    private List<CardModel> mItems;
    private LayoutInflater mLayoutInflater;

    TextView title,subtitle;
    ImageView imageView;
    Bitmap bitmap;
    public CardAdapter(Context context, int resorce, List<CardModel> items){
        super(context,resorce,items);
        mResorce = resorce;
        mItems = items;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view;
        if(convertView != null){
            view = convertView;
        }else{
            view =mLayoutInflater.inflate(mResorce,null);
        }
        CardModel item  = mItems.get(position);
        title = (TextView) view.findViewById(R.id.textView);
        subtitle = (TextView) view.findViewById(R.id.textView2);
        imageView = (ImageView)view.findViewById(R.id.imageView2);

        imageView.setImageBitmap(item.getBitmap());
        title.setText(item.getTitle());
        subtitle.setText(item.getSubtitle());

        return view;
    }
}



