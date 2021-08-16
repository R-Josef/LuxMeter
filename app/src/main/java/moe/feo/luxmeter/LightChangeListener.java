package moe.feo.luxmeter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class LightChangeListener implements SensorEventListener {

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_LIGHT && !MainActivity.getInstance().isHold()) {
            float lux = event.values[0];
            MainActivity.getInstance().getTextView().setText(String.valueOf(lux));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
