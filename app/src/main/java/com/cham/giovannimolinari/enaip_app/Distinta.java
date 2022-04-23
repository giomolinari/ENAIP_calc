package com.cham.giovannimolinari.enaip_app;

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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Distinta extends AppCompatActivity {
    private Spinner spinner;
    private String selected;
    private double peso_specifico;
    private double prezzo;
    private AppCompatButton button6;
    private AppCompatButton button5;
    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayout2;
    private TextInputLayout textInputLayout3;
    private TextInputLayout textInputLayout4;
    private TextView textView2;
    private TextView textView3;
    private TextView textView13;
    private AppCompatEditText editText;
    private AppCompatEditText editText2;
    private AppCompatEditText editText3;
    private AppCompatEditText editText4;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private RadioGroup radioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distinta);

        button6 = findViewById(R.id.button6);
        button5 = findViewById(R.id.button5);
        editText = findViewById(R.id.textDialog);
        editText2 = findViewById(R.id.textDialog2);
        editText3 = findViewById(R.id.textDialog3);
        editText4 = findViewById(R.id.textDialog4);
        textInputLayout = findViewById(R.id.til);
        textInputLayout2 = findViewById(R.id.til2);
        textInputLayout3 = findViewById(R.id.til3);
        textInputLayout4 = findViewById(R.id.til4);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView13 = findViewById(R.id.textView13);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        radioGroup = findViewById(R.id.RadioGroup);



        addListenerOnButton();

        spinner = findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("Abete rosso");
        list.add("Faggio");
        list.add("Betulla");
        list.add("Quercia");
        list.add("Castagno");
        list.add("Frassino");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                selected = spinner.getSelectedItem().toString();

                if (selected.equals("Abete rosso")) {
                    clear_spinner();
                    //peso_specifico = 11;
                    prezzo = 1;

                } else if (selected.equals("Faggio")){
                    clear_spinner();
                   // peso_specifico = 12;
                    prezzo = 2;

                } else if (selected.equals("Betulla")){
                    clear_spinner();
                  //  peso_specifico = 13;
                    prezzo = 3;

                } else if (selected.equals("Quercia")){
                    clear_spinner();
                   // peso_specifico = 14;
                    prezzo = 4;

                } else if (selected.equals("Castagno")){
                    clear_spinner();
                   // peso_specifico = 15;
                    prezzo = 5;

                } else if (selected.equals("Frassino")){
                    clear_spinner();
                   // peso_specifico = 16;
                    prezzo = 6;

                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

    }

    public void clear_spinner(){
        editText.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");

        radioGroup.clearCheck();

        textView2.setText("-null-");
        textView3.setText("-null-");
        textView13.setText("-null-");
    }

    public void lock(){
        editText.setFocusable(false);
        editText2.setFocusable(false);
        editText3.setFocusable(false);
        editText4.setFocusable(false);
        button6.setClickable(false);
        button6.setTextColor(Color.GRAY);
        button6.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));

    }

    public void unlock(){
        radioGroup.clearCheck();
        editText.setFocusable(true);
        editText4.setFocusable(true);
        editText2.setFocusable(true);
        editText3.setFocusable(true);
        editText2.setFocusableInTouchMode(true);
        editText3.setFocusableInTouchMode(true);
        editText.setFocusableInTouchMode(true);
        editText4.setFocusableInTouchMode(true);
        textView2.setText("-null-");
        textView3.setText("-null-");
        textView13.setText("-null-");
        editText2.setText("");
        editText3.setText("");
        editText.setText("");
        editText4.setText("");
        button6.setClickable(true);
        button6.setTextColor(Color.WHITE);
        button6.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
    }



    public void addListenerOnButton() {

        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (editText2.getText().toString().isEmpty() && editText3.getText().toString().isEmpty()) {
                    //textInputLayout.setError("Inserisci un valore");
                    //textInputLayout2.setError("Inserisci un valore");

                } else if (selected.equals("Abete rosso")&&radioButton.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 1;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Abete rosso")&&radioButton2.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 0.4;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                }
                else if (selected.equals("Faggio")&&radioButton.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 1.05;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Faggio")&&radioButton2.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 0.7;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("castagno")&&radioButton.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 1.02;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Castagno")&&radioButton2.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 0.54;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Frassino")&&radioButton.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 1.1;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Frassino")&&radioButton2.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 0.6;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Betulla")&&radioButton.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 0.95;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Betulla")&&radioButton2.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 0.62;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Quercia")&&radioButton.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 1.12;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                } else if (selected.equals("Quercia")&&radioButton2.isChecked()) {
                    double latoA = Double.parseDouble(editText.getText().toString());
                    double latoB = Double.parseDouble(editText2.getText().toString());
                    double latoC = Double.parseDouble(editText3.getText().toString());
                    double metri_cubi = Double.parseDouble(editText4.getText().toString());
                    double volume = (latoA * latoB * latoC);
                    double pezzi = volume / metri_cubi;
                    double prezzo_tot = metri_cubi * prezzo;
                    peso_specifico = 0.84;
                    double peso = peso_specifico * metri_cubi * 10;
                    textView2.setText(Double.toString(pezzi));
                    textView3.setText(Double.toString(prezzo_tot));
                    textView13.setText(Double.toString(peso));
                    lock();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                unlock();
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
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent i = new Intent(this, teoria_distinta.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

