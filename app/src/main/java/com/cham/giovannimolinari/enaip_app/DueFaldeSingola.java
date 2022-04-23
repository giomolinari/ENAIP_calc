package com.cham.giovannimolinari.enaip_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;


import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DueFaldeSingola extends AppCompatActivity {
    private AppCompatButton button6;
    private AppCompatButton button5;
    private TextInputLayout textInputLayout;
    private AppCompatEditText editText;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView14;
    private TextView textView13;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        button5 = findViewById(R.id.button5);
        button5.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        button6 = findViewById(R.id.button6);
        button6.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        textInputLayout = findViewById(R.id.til);
        editText = findViewById(R.id.textDialog);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView14 = findViewById(R.id.textView14);
        textView13 = findViewById(R.id.textView13);

        addListenerOnButton6();
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
                Intent i = new Intent(this, teoria_duefaldesingola.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    public void addListenerOnButton6() {

        button6.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View arg0) {
                if (editText.getText().toString().isEmpty()) {
                    textInputLayout.setError("Inserisci un valore");
                    button5.setClickable(true);

                } else {
                    textInputLayout.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    double alfa = Double.parseDouble(editText.getText().toString());
                    double alfa_rad = Math.toRadians(alfa);
                    double tan = Math.tan(alfa_rad);
                    double radice = Math.sqrt(2);
                    double parentesi = ((tan) / (radice));
                    double arctan = Math.atan(parentesi);
                    double pendenza = Math.toDegrees(arctan);

                    double arcar = Math.atan(Math.cos(arctan));
                    double arcareccio = Math.toDegrees(arcar);

                    double macchina = 45;

                    textView14.setText(macchina + "°");
                    textView13.setText(new DecimalFormat("0.0").format(arcareccio) + "°");
                    textView2.setText(new DecimalFormat("0.0").format(pendenza) + "°");

                    double arctan2 = Math.atan(parentesi);
                    double parentesi2 = (Math.sin(arctan2));
                    double arctan3 = Math.atan(parentesi2);
                    double smuss_diag = Math.toDegrees(arctan3);

                    textView3.setText(new DecimalFormat("0.0").format(smuss_diag) + "°");

                    double parentesi3 = (Math.cos(alfa_rad));
                    double arctan4 = Math.atan(parentesi3);
                    double ang_disp = Math.toDegrees(arctan4);

                    textView4.setText(new DecimalFormat("0.0").format(ang_disp) + "°");

                    editText.setText(editText.getText() + "°");
                    editText.setFocusable(false);
                    button6.setClickable(false);
                    button6.setTextColor(Color.GRAY);
                    button6.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                    button5.setClickable(true);
                   // button5.setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }

        });


        button5.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View arg0) {
                textView2.setText("-null-");
                textView3.setText("-null-");
                textView4.setText("-null-");
                textView13.setText("-null-");
                textView14.setText("-null-");
                editText.setText(null);
                editText.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                button6.setTextColor(Color.WHITE);
                button6.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
                button6.setClickable(true);
              //  editText.requestFocus();
                textInputLayout.setError(null);
                textInputLayout.setErrorEnabled(false);
            }

        });

    }

}
