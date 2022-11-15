package com.takuchan.judgeaiage;

import android.graphics.Bitmap;

public class CardModel {
    private String title;
    private String subtitle;
    private Bitmap bitmap;

    CardModel(String title,String subtitle,Bitmap bitmap){
        this.title = title;
        this.subtitle = subtitle;
        this.bitmap = bitmap;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
