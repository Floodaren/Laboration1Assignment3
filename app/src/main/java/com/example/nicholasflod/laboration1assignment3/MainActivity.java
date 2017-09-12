package com.example.nicholasflod.laboration1assignment3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.app.*;
import android.hardware.*;
import android.media.*;

import java.io.IOException;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private float last_x, last_y, last_z;
    public MediaPlayer mp1;
    public MediaPlayer mp2;
    public MediaPlayer mp3;
    public MediaPlayer mp4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp1 = MediaPlayer.create(this, R.raw.ljud1);
        mp2 = MediaPlayer.create(this, R.raw.ljud2);
        mp3 = MediaPlayer.create(this, R.raw.ljud3);
        mp4 = MediaPlayer.create(this, R.raw.ljud4);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    protected void onResume()
    {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause()
    {
        super.onPause();
        mSensorManager.unregisterListener(this);
        mp1.release();
        mp2.release();
        mp3.release();
        mp4.release();
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    public final void onSensorChanged(SensorEvent event)
    {


        Sensor mySensor = event.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            last_x = x;
            Log.d("sensor", "X-Sensor: "+Float.toString(x));
            last_y = y;
            Log.d("sensor", "Y-Sensor: "+Float.toString(y));
            last_z = z;
            if(last_y < -1 && last_y < last_x)
            {
                mp1.start();
            }

            if(last_y > 1 && last_y > last_x)
            {
                mp2.start();
            }

            if (last_x > 1 && last_x > last_y)
            {
                mp3.start();
            }

            if (last_x < -1 && last_x < last_y)
            {
                mp4.start();
            }


        }

    }
}


