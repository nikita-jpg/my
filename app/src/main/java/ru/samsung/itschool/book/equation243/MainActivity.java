package ru.samsung.itschool.book.equation243;

import android.app.Activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

public class MainActivity extends Activity implements SensorEventListener {
    // Вызывается при создании Активности
    private  SensorManager mSensorManager;
    private  Sensor mLight;
    private double maxLight;
    private double tek;
    private TextView textLight;
    private MediaPlayer mPlayer;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Инициализирует Активность.
        setContentView(R.layout.activity_main);
        SensorActivity();
        textLight=findViewById(R.id.textLight);

        mPlayer=MediaPlayer.create(this,R.raw.music);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void SensorActivity() {
        mSensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        mLight =mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        maxLight=mLight.getMaxDelay();
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    public void resume(){
        mPlayer.start();
    }
    public void pause(){
        mPlayer.pause();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        tek=event.values[0];
        if(tek/maxLight>=30) pause();
        else resume();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        textLight.setText(String.valueOf((int)(tek/maxLight)));
    }
}
