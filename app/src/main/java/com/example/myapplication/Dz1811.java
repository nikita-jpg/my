
package com.example.myapplication;

import android.content.Context;
import android.graphics.*;
import android.view.View;

public class Dz1811 extends View {
    Paint paint = new Paint();
    int N = 10; // количество шариков
    int j=0;
    float[] x  = new float[N];
    float[] y  = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];
    int[] col = new int[3*N];
    boolean started;
    @Override
    protected void onDraw(Canvas canvas) {
        if (!started) {
            for (int i = 0; i < N; i++) {
                x[i] = (float) (Math.random() * canvas.getWidth());
                y[i] = (float) (Math.random() * canvas.getHeight());
                vx[i] = (float) (Math.random() * 6 - 3);
                vy[i] = (float) (Math.random() * 6 - 3);

            }
            for (int i = 0; i < N * 3; i++) {
                col[i] = (int) (Math.random() * 255 - 0);
            }
            started = true;
        }
        j = 0;
        for (int i = 0; i < N; i++) {
            paint.setARGB(col[j], col[j + 1], col[j + 2], 0);
            canvas.drawCircle(x[i], y[i], 20, paint);
            j += 3;
        }
        // готовим массивы x и у для следущего кадра
        for (int i = 0; i < N; i++) {

            if (x[i] < 0 || x[i] > canvas.getHeight()) {
                vx[i] = -vx[i];
                x[i] += vx[i];
            } else x[i] += vx[i];
            if (y[i] < 0 || y[i] > canvas.getWidth()) {
                vy[i] = -vy[i];
                y[i] += vy[i];
            } else y[i] += vy[i];
        }
        invalidate();
    }
    public Dz1811(Context context) {
                super(context);

    }
}