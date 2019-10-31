package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class MyView extends View{
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        canvas.drawLine(0, 0, canvas.getWidth(),canvas.getHeight(),paint);
    }

    public MyView(Context context) {
        super(context);
    }
}
