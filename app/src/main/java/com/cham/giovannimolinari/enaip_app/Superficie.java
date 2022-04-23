package com.cham.giovannimolinari.enaip_app;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Superficie extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superficie);
        addListenerOnButton();
        addListenerOnButton1();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent i = new Intent(this, teoria_tavolato.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addListenerOnButton(){
        ImageButton imageButton = findViewById(R.id.imageButton);


        imageButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Superficie.this, Superficie_rettangolo.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButton1(){
        ImageButton imageButton2 = findViewById(R.id.imageButton2);


        imageButton2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                Intent intent1 = new Intent(Superficie.this, Superficie_ti.class);
                startActivity(intent1);
            }
        });
    }

}
