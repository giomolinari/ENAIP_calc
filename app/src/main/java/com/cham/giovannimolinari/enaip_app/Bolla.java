package com.cham.giovannimolinari.enaip_app;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.widget.Toast;

public class Bolla extends AppCompatActivity {

    private static SensorManager mySensorManager;
    private boolean sersorrunning;
    private BollaView myHorizontalView;
    private TextView textviewPitch, textviewRoll;


    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolla);

        myHorizontalView = findViewById(R.id.myhorizontalview);
        textviewPitch = findViewById(R.id.textpitch);
        textviewRoll = findViewById(R.id.textroll);

        mySensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> mySensors = mySensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        if(mySensors.size() > 0){
            mySensorManager.registerListener(mySensorEventListener, mySensors.get(0), SensorManager.SENSOR_DELAY_NORMAL);
            sersorrunning = true;
            Toast.makeText(this, "Inizializzo sensore...", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Nessun sensore rilevato", Toast.LENGTH_LONG).show();
            sersorrunning = false;
            finish();
        }
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @TargetApi(Build.VERSION_CODES.CUPCAKE)
        @Override
        public void onSensorChanged(SensorEvent event) {
            // TODO Auto-generated method stub

           // textviewPitch.setText("Pitch: " + String.valueOf(event.values[1]));

           // textviewRoll.setText("Roll: " + String.valueOf(event.values[2]));

            myHorizontalView.updateHorizontal(
                    event.values[1], event.values[2]);
        }

    };

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_nohelp, menu);
        return true;
    }

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent i = new Intent(this, teoria_inclinometro.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */


    @TargetApi(Build.VERSION_CODES.CUPCAKE)
    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(sersorrunning){
            mySensorManager.unregisterListener(mySensorEventListener);
        }
    }


}
