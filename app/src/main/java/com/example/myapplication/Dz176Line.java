package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class Dz176Line extends View {
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int y = 0;
        while (y < canvas.getHeight()){
            canvas.drawLine(0, y, this.getWidth(), y, paint);
            y += 10;
        }

    }

    public Dz176Line(Context context) {
        super(context);
    }
}
