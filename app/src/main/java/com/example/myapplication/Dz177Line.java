package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class Dz177Line extends View {
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        int y = -30;
        while (y < canvas.getHeight()) {
            canvas.drawLine(0, y, canvas.getWidth(),y+50,paint);
            y += 30;
        }
    }

    public Dz177Line(Context context) {
        super(context);
    }
}
