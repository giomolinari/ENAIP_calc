package com.cham.giovannimolinari.enaip_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DueFaldeDoppia extends AppCompatActivity {

    private AppCompatButton button;
    private AppCompatButton button5;
    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayout2;
    private AppCompatEditText editText;
    private AppCompatEditText editText5;
    private TextView textView2;
    private TextView textView3;
    private TextView textView19;
    private TextView textView20;
    private TextView textView30;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);
        button = findViewById(R.id.button);
        button.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        button5 = findViewById(R.id.button5);
        button5.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        editText = findViewById(R.id.textDialog);
        editText5 = findViewById(R.id.textDialog2);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView30 = findViewById(R.id.textView30);
        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        textInputLayout = findViewById(R.id.til);
        textInputLayout2 = findViewById(R.id.til2);

        addListenerOnButton2();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent i = new Intent(this, teoria_duefaldedoppia.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addListenerOnButton2() {

        button.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View arg0) {

                if(editText.getText().toString().isEmpty() && editText5.getText().toString().isEmpty()){
                    textInputLayout.setError("Inserisci un valore");
                    textInputLayout2.setError("Inserisci un valore");
                }
                else if(editText.getText().toString().isEmpty()){
                    textInputLayout.setError("Inserisci un valore");
                    button5.setClickable(true);
                }
                else if(editText5.getText().toString().isEmpty()){
                    textInputLayout2.setError("Inserisci un valore");
                    button5.setClickable(true);
                    textInputLayout.setError(null);
                    textInputLayout.setErrorEnabled(false);
                }


                else {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    double alfa = Double.parseDouble(editText.getText().toString());
                    double alfa_rad = Math.toRadians(alfa);

                    double beta = Double.parseDouble(editText5.getText().toString());
                    double beta_rad = Math.toRadians(beta);

                    double alfa_tan = Math.tan(alfa_rad);
                    double beta_tan = Math.tan(beta_rad);

                    double parentesiA = ((beta_tan) / (alfa_tan));
                    double arctanA = Math.atan(parentesiA);
                    double angolo_pianta_faldaA = Math.toDegrees(arctanA);

                    double parentesiB = ((alfa_tan) / (beta_tan));
                    double arctanB = Math.atan(parentesiB);
                    double angolo_pianta_faldaB = Math.toDegrees(arctanB);

                    double seno_angolo_pianta = Math.sin(arctanA);
                    double parentesi2 = (alfa_tan * seno_angolo_pianta);
                    double arctan_par2 = Math.atan(parentesi2);
                    double pendenza_angolo = Math.toDegrees(arctan_par2);

                    double tan_smussA = Math.atan((Math.sin(arctan_par2)) / (Math.tan(arctanB)));
                    double smussoA = Math.toDegrees(tan_smussA);

                    double tan_smussB =  Math.atan((Math.sin(arctan_par2)) / (Math.tan(arctanA)));
                    double smussoB = Math.toDegrees(tan_smussB);

                    textView2.setText(new DecimalFormat("0.0").format(angolo_pianta_faldaA)+ "°");
                    textView30.setText(new DecimalFormat("0.0").format(angolo_pianta_faldaB)+ "°");
                    textView19.setText(new DecimalFormat("0.0").format(smussoA)+ "°");
                    textView20.setText(new DecimalFormat("0.0").format(smussoB)+ "°");
                    textView3.setText(new DecimalFormat("0.0").format(pendenza_angolo)+ "°");

                    editText.setText(editText.getText() + "°");
                    editText.setFocusable(false);
                    editText5.setText(editText5.getText() + "°");
                    editText5.setFocusable(false);
                    button.setClickable(false);
                    button.setEnabled(false);
                    button.setTextColor(getResources().getColor(R.color.gray));
                    button.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                    button5.setClickable(true);
                 //   button5.setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }

        });

        button5.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View arg0) {
                textInputLayout.setError(null);
                textInputLayout2.setError(null);
                textInputLayout.setErrorEnabled(false);
                textInputLayout2.setErrorEnabled(false);
                textView2.setText("-null-");
                textView3.setText("-null-");
                textView19.setText("-null-");
                textView20.setText("-null-");
                textView30.setText("-null-");
                editText.setText(null);
                editText5.setText(null);
                editText.setFocusable(true);
                editText5.setFocusableInTouchMode(true);
                editText5.setFocusable(true);
                editText.setFocusableInTouchMode(true);
                button.setClickable(true);
                button.setEnabled(true);
                button.setTextColor(Color.WHITE);
                button.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
            //    button.setTextColor(getResources().getColor(R.color.colorAccent));
               // editText.requestFocus();
            }
        });


    }
}
