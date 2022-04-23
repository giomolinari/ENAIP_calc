package com.cham.giovannimolinari.enaip_app;

import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Inclinometro extends AppCompatActivity {

    TextView textGradi;
    OrientationEventListener myOrientationEventListener;
    private AppCompatButton annotaBtn;
    private TextView textValori;
    private final String fuori_int = "Fuori intervallo";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclinometro);
        textGradi = findViewById(R.id.textGradi);
        annotaBtn = findViewById(R.id.button13);
        annotaBtn.setVisibility(View.INVISIBLE);

        textValori = findViewById(R.id.textView130);

        addListenerOnButton();

        myOrientationEventListener
                = new OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL){

            @Override
            public void onOrientationChanged(int arg0) {

                if(arg0 < 270 && arg0 > 0 || Integer.valueOf(arg0).equals(-1))
                {
                    textGradi.setText(fuori_int);
                }
                else if (Integer.valueOf(arg0).equals(0)){
                    textGradi.setText(Integer.valueOf(90) + "°");
                }
                else {
                    textGradi.setText(Integer.valueOf(arg0 - 270) + "°");
                }
            }};

        if (myOrientationEventListener.canDetectOrientation()){
            Toast.makeText(this, "Inizializzo sensore...", Toast.LENGTH_LONG).show();
            annotaBtn.setVisibility(View.VISIBLE);
            myOrientationEventListener.enable();
        }
        else{
            Toast.makeText(this, "Impossibile determinare l'inclinazione", Toast.LENGTH_LONG).show();
            annotaBtn.setVisibility(View.INVISIBLE);
            finish();
        }


    }



    public void addListenerOnButton() {

        annotaBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(textGradi.getText().equals(fuori_int)){
                    //fai qualcosa?
                }
                else
                textValori.setText(textGradi.getText());
            }


        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_nohelp, menu);
        return true;
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        myOrientationEventListener.disable();
    }
}