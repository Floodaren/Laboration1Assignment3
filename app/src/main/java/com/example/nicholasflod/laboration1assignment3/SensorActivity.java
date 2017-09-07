package com.example.nicholasflod.laboration1assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.*;
import android.hardware.*;
import android.util.Log;


public class SensorActivity extends Activity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private static final String TAG = "MainActivity";
    private final SensorManager mSensorManager;
    private final Sensor mAccelerometer;


    public SensorActivity()
    {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
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
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        Log.d(TAG, "Något hände");
    }

    public void onSensorChanged(SensorEvent event)
    {
        Log.d(TAG, "Något hände");
    }
}


