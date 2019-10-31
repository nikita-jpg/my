package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class Dz177LinePicture extends View {
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int y = 0;
        while (y < canvas.getHeight()) {
            canvas.drawLine(y, y, canvas.getWidth()-y,canvas.getHeight()-y,paint);
            y += 30;
        }
    }

    public Dz177LinePicture(Context context) {
        super(context);
    }
}
