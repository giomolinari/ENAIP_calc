package com.cham.giovannimolinari.enaip_app;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatButton;
import android.view.View;

import java.util.Objects;

public class Info extends AppCompatActivity {
    AppCompatButton button12;
    AppCompatButton button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        button12 = findViewById(R.id.button12);
        button12.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        button9 = findViewById(R.id.button9);
        button9.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        addListenerOnButton();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    public void addListenerOnButton(){

        button12.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "giovanni.molinari.dev@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Informazioni app Carpenteria ENAIP");
                //intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.cham.giovannimolinari.enaip_app&hl=it")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.cham.giovannimolinari.enaip_app&hl=it")));
                }
            }
        });
    }
}
