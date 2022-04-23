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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Triangolo2 extends AppCompatActivity {
    private Spinner spinner;
    private String selected;
    private AppCompatButton button7;
    private AppCompatButton button8;
    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayout2;
    private AppCompatEditText editText2;
    private AppCompatEditText editText3;
    private TextView textView24;
    private TextView textView25;
    private TextView textView26;
    private TextView textView27;
    private TextView textView31;
    private TextView textView76;
    private TextView textView77;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test3);

        button7 = findViewById(R.id.button7);
        button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        button8 = findViewById(R.id.button8);
        button8.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        editText2 = findViewById(R.id.textDialog);
        editText3 = findViewById(R.id.textDialog2);
        textInputLayout = findViewById(R.id.til);
        textInputLayout2 = findViewById(R.id.til2);
        textView25 = findViewById(R.id.textView25);
        textView24 = findViewById(R.id.textView24);
        textView26 = findViewById(R.id.textView26);
        textView27 = findViewById(R.id.textView27);
        textView31 = findViewById(R.id.textView31);
        textView76 = findViewById(R.id.textView76);
        textView77 = findViewById(R.id.textView77);

        addListenerOnButton();
        spinner = findViewById(R.id.spinner5);
        List<String> list = new ArrayList<String>();
        list.add("Trova lati h, L [dati b, α]");
        list.add("Trova lati b, h [dati L, α]");
        list.add("Trova lati L, b [dati h, α]");
        list.add("Trova angoli α, β e lato L [dati h, b]");
        list.add("Trova angoli α, β e lato b [dati L, h]");
        list.add("Trova angoli α, β e lato h [dati b, L]");
       // list.add("Pendenza percentuale P");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected = spinner.getSelectedItem().toString();

                if (selected.equals("Trova lati b, h [dati L, α]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    editText2.setFocusable(true);
                    editText3.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    editText3.setFocusableInTouchMode(true);
                    //    textView28.setVisibility(View.INVISIBLE);
                    textInputLayout.setHint("Lato L:");
                    textInputLayout2.setHint("Angolo α:");
                    editText3.setVisibility(View.VISIBLE);
            //        textView31.setVisibility(View.INVISIBLE);
                    textView24.setText("Lunghezza lato b:");
                    textView26.setText("Lunghezza lato h:");
                    textView76.setText("Ampiezza angolo \u03B2:");
                    editText2.setText("");
                    editText3.setText("");
                    textView25.setText("-null-");
                    textView27.setText("-null-");
                    textView77.setText("-null-");
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

                } else if (selected.equals("Trova lati h, L [dati b, α]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    editText2.setFocusable(true);
                    editText3.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    editText3.setFocusableInTouchMode(true);
                    //    textView28.setVisibility(View.INVISIBLE);
                    textInputLayout.setHint("Lato b:");
                    textInputLayout2.setHint("Angolo α:");
                    editText3.setVisibility(View.VISIBLE);
//                    textView31.setVisibility(View.INVISIBLE);
                    textView24.setText("Lunghezza lato h:");
                    textView26.setText("Lunghezza lato L:");
                    textView76.setText("Ampiezza angolo \u03B2:");
                    editText2.setText("");
                    editText3.setText("");
                    textView25.setText("-null-");
                    textView27.setText("-null-");
                    textView77.setText("-null-");
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

                } else if (selected.equals("Trova lati L, b [dati h, α]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    editText2.setFocusable(true);
                    editText3.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    editText3.setFocusableInTouchMode(true);
                    //       textView28.setVisibility(View.INVISIBLE);
                    textInputLayout.setHint("Lato h:");
                    textInputLayout2.setHint("Angolo α:");
                    editText3.setVisibility(View.VISIBLE);
              //      textView31.setVisibility(View.INVISIBLE);
                    textView26.setText("Lunghezza lato b:");
                    textView24.setText("Lunghezza lato L:");
                    textView76.setText("Ampiezza angolo \u03B2:");
                    editText2.setText("");
                    editText3.setText("");
                    textView25.setText("-null-");
                    textView27.setText("-null-");
                    textView77.setText("-null-");
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

                } else if (selected.equals("Trova angoli α, β e lato L [dati h, b]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    editText2.setFocusable(true);
                    editText3.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    editText3.setFocusableInTouchMode(true);
                    //      textView28.setVisibility(View.INVISIBLE);
                    textInputLayout.setHint("Lato h:");
                    textInputLayout2.setHint("Lato b:");
                    editText3.setVisibility(View.VISIBLE);
             //       textView31.setVisibility(View.INVISIBLE);
                    editText2.setText("");
                    editText3.setText("");
                    textView25.setText("-null-");
                    textView27.setText("-null-");
                    textView77.setText("-null-");
                    textView24.setText("Ampiezza angolo \u03B1:");
                    textView26.setText("Ampiezza angolo \u03B2:");
                    textView76.setText("Lunghezza lato L:");
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

                } else if (selected.equals("Trova angoli α, β e lato b [dati L, h]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    editText2.setFocusable(true);
                    editText3.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    editText3.setFocusableInTouchMode(true);
                    //      textView28.setVisibility(View.INVISIBLE);
                    textInputLayout.setHint("Lato h:");
                    textInputLayout2.setHint("Lato L:");
                    editText3.setVisibility(View.VISIBLE);
               //     textView31.setVisibility(View.INVISIBLE);
                    editText2.setText("");
                    editText3.setText("");
                    textView25.setText("-null-");
                    textView27.setText("-null-");
                    textView77.setText("-null-");
                    textView24.setText("Ampiezza angolo \u03B1:");
                    textView26.setText("Ampiezza angolo \u03B2:");
                    textView76.setText("Lunghezza lato b:");
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

                } else if (selected.equals("Trova angoli α, β e lato h [dati b, L]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    editText2.setFocusable(true);
                    editText3.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    editText3.setFocusableInTouchMode(true);
                    //      textView28.setVisibility(View.INVISIBLE);
                    textInputLayout.setHint("Lato b:");
                    textInputLayout2.setHint("Lato L:");
                    editText3.setVisibility(View.VISIBLE);
             //       textView31.setVisibility(View.INVISIBLE);
                    editText2.setText("");
                    editText3.setText("");
                    textView25.setText("-null-");
                    textView27.setText("-null-");
                    textView77.setText("-null-");
                    textView24.setText("Ampiezza angolo \u03B1:");
                    textView26.setText("Ampiezza angolo \u03B2:");
                    textView76.setText("Lunghezza lato h:");
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

                } else if (selected.equals("Pendenza percentuale P")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    editText2.setFocusable(true);
                    editText3.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    editText3.setFocusableInTouchMode(true);
              //      textView28.setVisibility(View.INVISIBLE);
                    textInputLayout.setHint("Inserisci l'ampiezza dell'angolo α:");
                    textInputLayout2.setHint("");
                    editText3.setText("-");
                    editText3.setVisibility(View.INVISIBLE);
               //     textView31.setVisibility(View.INVISIBLE);
                    textView25.setText("-null-");
                    textView26.setText("");
                    textView27.setText("");
                    textView76.setText("");
                    textView77.setText("");
                    textView24.setText("Pendenza P:");
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
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
                Intent i = new Intent(this, teoria_pendenze.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void addListenerOnButton() {

        button7.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View arg0) {
                if(editText2.getText().toString().isEmpty() && editText3.getText().toString().isEmpty()){
                    textInputLayout.setError("Inserisci un valore");
                    textInputLayout2.setError("Inserisci un valore");
                  //  button5.setClickable(true);
                }
                else if(editText2.getText().toString().isEmpty()){
                    textInputLayout.setError("Inserisci un valore");
                   // button5.setClickable(true);
                }
                else if(editText3.getText().toString().isEmpty()){
                    textInputLayout2.setError("Inserisci un valore");
                    textInputLayout.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    // button5.setClickable(true);
                } else if (selected.equals("Trova lati h, L [dati b, α]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                   // textView28.setVisibility(View.INVISIBLE);
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double alpha = Double.parseDouble((editText3.getText().toString()));
                    editText3.setText(editText3.getText() + "°");
                    editText2.setFocusable(false);
                    editText3.setFocusable(false);
                    button7.setClickable(false);
                    button7.setTextColor(Color.GRAY);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                    if (alpha < 90) {
                        double beta = 180 - (alpha + 90);
                        double alpha_rad = Math.toRadians(alpha);
                        double latoA = latoB * (Math.tan(alpha_rad));
                        double latoL = latoB / (Math.cos(alpha_rad));
                        textView27.setText(new DecimalFormat("0.0").format(latoL));
                        textView25.setText(new DecimalFormat("0.0").format(latoA));
                        textView77.setText(new DecimalFormat("0.0").format(beta) + "°");
                    } else {
                        textInputLayout2.setError("Errore: angolo α => 90°");
                    }

                } else if (selected.equals("Trova lati b, h [dati L, α]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                  //  textView28.setVisibility(View.INVISIBLE);
                    double latoC = Double.parseDouble(editText2.getText().toString());
                    double alpha = Double.parseDouble((editText3.getText().toString()));
                    editText3.setText(editText3.getText() + "°");
                    editText2.setFocusable(false);
                    editText3.setFocusable(false);
                    button7.setClickable(false);
                    button7.setTextColor(Color.GRAY);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                    if (alpha < 90) {
                        double beta = 180 - (alpha + 90);
                        double alpha_rad = Math.toRadians(alpha);
                        double latoA = latoC * (Math.sin(alpha_rad));
                        double latoB = latoC * (Math.cos(alpha_rad));
                        textView25.setText(new DecimalFormat("0.0").format(latoB));
                        textView27.setText(new DecimalFormat("0.0").format(latoA));
                        textView77.setText(new DecimalFormat("0.0").format(beta) + "°");
                    } else {
                        textInputLayout2.setError("Errore: angolo α => 90°");
                    }

                } else if (selected.equals("Trova lati L, b [dati h, α]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                  //  textView28.setVisibility(View.INVISIBLE);
                    double latoA = Double.parseDouble(editText2.getText().toString());
                    double alpha = Double.parseDouble((editText3.getText().toString()));
                    editText3.setText(editText3.getText() + "°");
                    editText2.setFocusable(false);
                    editText3.setFocusable(false);
                    button7.setClickable(false);
                    button7.setTextColor(Color.GRAY);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                    if (alpha < 90) {
                        double beta = 180 - (alpha + 90);
                        double alpha_rad = Math.toRadians(alpha);
                        double latoB = latoA / (Math.tan(alpha_rad));
                        double latoL = latoA / (Math.sin(alpha_rad));
                        textView25.setText(new DecimalFormat("0.0").format(latoL));
                        textView27.setText(new DecimalFormat("0.0").format(latoB));
                        textView77.setText(new DecimalFormat("0.0").format(beta) + "°");
                    } else {
                        textInputLayout2.setError("Errore: angolo α => 90°");
                    }
                } else if (selected.equals("Trova angoli α, β e lato L [dati h, b]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                //    textView28.setVisibility(View.INVISIBLE);
                    double latoA = Double.parseDouble(editText2.getText().toString());
                    double latoB = Double.parseDouble((editText3.getText().toString()));
                    editText2.setFocusable(false);
                    editText3.setFocusable(false);
                    double arctan = Math.atan(latoA / latoB);
                    double alpha = Math.toDegrees(arctan);
                    double beta = 180 - (alpha + 90);
                    double latoL = latoB / Math.cos(arctan);
                    textView25.setText(new DecimalFormat("0.0").format(alpha) + "°");
                    textView27.setText(new DecimalFormat("0.0").format(beta) + "°");
                    textView77.setText(new DecimalFormat("0.0").format(latoL));
                    button7.setClickable(false);
                    button7.setTextColor(Color.GRAY);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                } else if (selected.equals("Trova angoli α, β e lato b [dati L, h]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                  //  textView28.setVisibility(View.INVISIBLE);
                    double latoA = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble((editText3.getText().toString()));
                    editText2.setFocusable(false);
                    editText3.setFocusable(false);
                    double arcsen = Math.asin(latoA / latoC);
                    double alpha = Math.toDegrees(arcsen);
                    double beta = 180 - (alpha + 90);
                    double latoB = latoC * Math.cos(arcsen);
                    textView25.setText(new DecimalFormat("##.#").format(alpha) + "°");
                    textView27.setText(new DecimalFormat("##.#").format(beta) + "°");
                    textView77.setText(new DecimalFormat("##.#").format(latoB));
                    button7.setClickable(false);
                    button7.setTextColor(Color.GRAY);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                } else if (selected.equals("Trova angoli α, β e lato h [dati b, L]")) {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble((editText3.getText().toString()));
                    editText2.setFocusable(false);
                    editText3.setFocusable(false);
                    double arcos = Math.acos(latoB / latoC);
                    double alpha = Math.toDegrees(arcos);
                    double beta = 180 - (alpha + 90);
                    double latoH = latoC * Math.sin(arcos);
                    textView25.setText(new DecimalFormat("0.0").format(alpha) + "°");
                    textView27.setText(new DecimalFormat("0.0").format(beta) + "°");
                    textView77.setText(new DecimalFormat("0.0").format(latoH));
                    button7.setClickable(false);
                    button7.setTextColor(Color.GRAY);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                    button8.setClickable(true);
                    button8.setTextColor(Color.WHITE);
                } else if (selected.equals("Pendenza percentuale P")) {
               //     textView28.setVisibility(View.INVISIBLE);
                    double alpha = Double.parseDouble((editText2.getText().toString()));
                    editText2.setText(editText2.getText() + "°");
                    editText2.setFocusable(false);
                    button7.setClickable(false);
                    button7.setTextColor(Color.GRAY);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                    if (alpha < 90) {
                        double alpha_rad = Math.toRadians(alpha);
                        double p = 100 * (Math.tan(alpha_rad));
                        textView31.setVisibility(View.INVISIBLE);
                   //     textView28.setVisibility(View.INVISIBLE);
                        textView25.setText(new DecimalFormat("0.0").format(p) + "%");
                    } else {
                        textInputLayout.setError("Errore: angolo α => 90°");
                    }


                }
            }

        });

        button8.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View arg0) {
                if (selected.equals("Pendenza percentuale P")) {
                    editText2.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    textView25.setText("-null-");
                    editText2.setText("");
                    editText2.requestFocus();
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
                } else {
                    textInputLayout.setError(null);
                    textInputLayout2.setError(null);
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout2.setErrorEnabled(false);
                    editText2.setFocusable(true);
                    editText3.setFocusable(true);
                    editText2.setFocusableInTouchMode(true);
                    editText3.setFocusableInTouchMode(true);
              //      textView28.setVisibility(View.INVISIBLE);
                 //   textView31.setVisibility(View.INVISIBLE);
                    textView25.setText("-null-");
                    textView27.setText("-null-");
                    textView77.setText("-null-");
                    editText2.setText("");
                    editText3.setText("");
                    button7.setClickable(true);
                    button7.setTextColor(Color.WHITE);
                    button7.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
                   // editText2.requestFocus();
                }

            }

        });

    }

}
