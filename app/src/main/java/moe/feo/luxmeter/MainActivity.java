package moe.feo.luxmeter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static MainActivity instance;
    private boolean hold = false;
    private TextView text;
    private SensorManager sensorManager;
    private Sensor sensor;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.num);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (sensorManager != null) {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            sensorManager.registerListener(new LightChangeListener(), sensor, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            text.setText(R.string.sensor_invalid);
        }
        button = findViewById(R.id.button);
        button.setOnClickListener(new ButtonListener());
    }

    public TextView getTextView() {
        return text;
    }

    public Button getButton() {
        return button;
    }

    public void setHold(boolean hold) {
        this.hold = hold;
    }

    public boolean isHold() {
        return hold;
    }

    public static MainActivity getInstance() {
        return instance;
    }
}