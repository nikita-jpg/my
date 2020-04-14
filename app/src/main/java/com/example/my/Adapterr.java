package com.example.my;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;


public class Adapterr extends ArrayAdapter<Bitmap> {
    public Adapterr(@NonNull Context context, Bitmap[] resource) {
        super(context,R.layout.content_main, resource);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final Bitmap bitmap = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.content_main, null);
        }

        ((ImageView)convertView.findViewById(R.id.image)).setImageBitmap(bitmap);
        return convertView;
    }
}
