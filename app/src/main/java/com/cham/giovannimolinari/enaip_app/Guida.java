package com.cham.giovannimolinari.enaip_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Guida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guida);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
