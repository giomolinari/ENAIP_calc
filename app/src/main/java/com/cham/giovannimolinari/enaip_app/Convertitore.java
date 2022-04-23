package com.cham.giovannimolinari.enaip_app;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Convertitore extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner1;
    private Spinner spinner2;
    private Button converti;
    private EditText casella1;
    private String selected1;
    private String selected2;
    private EditText casella2;
    private Button resetta;
    private TextView errore;
    private ImageView freccia;
    private ImageButton freccetta;
    private int sp_1;
    private int sp_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertitore);
        addListenerOnButton();

        EditText editText2 = findViewById(R.id.editText7);
        //editText2.setEnabled(false);
        editText2.setFocusable(false);
        editText2.setClickable(false);
        editText2.setKeyListener(null);

        spinner1 = findViewById(R.id.spinner3);
        List<String> list = new ArrayList<String>();
        list.add("Gradi");
        list.add("Percentuale");
        list.add("Radianti");
        list.add("Centesimali");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);

        spinner2 = findViewById(R.id.spinner4);
        List<String> list2 = new ArrayList<String>();
        list2.add("Gradi");
        list2.add("Percentuale");
        list2.add("Radianti");
        list2.add("Centesimali");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        sp_1 = spinner1.getSelectedItemPosition();
        sp_2 = spinner2.getSelectedItemPosition();
        selected1 = spinner1.getSelectedItem().toString();
        selected2 = spinner2.getSelectedItem().toString();

        switch (parent.getId()) {
            case R.id.spinner3:
                if ((sp_1 == 0) && (sp_2 == 0)) {
                    spinner2.setSelection(sp_2 + 1);
                } else if ((sp_1 == 1) && (sp_2 == 1)) {
                    spinner2.setSelection(0);
                } else if ((sp_1 == 2) && (sp_2 == 2)) {
                    spinner2.setSelection(sp_2 + 1);
                } else if ((sp_1 == 3) && (sp_2 == 3)) {
                    spinner2.setSelection(0);
                }
                break;
            case R.id.spinner4:
                if ((sp_1 == 0) && (sp_2 == 0)) {
                    spinner1.setSelection(sp_1 + 1);
                } else if ((sp_1 == 1) && (sp_2 == 1)) {
                    spinner1.setSelection(0);
                } else if ((sp_1 == 2) && (sp_2 == 2)) {
                    spinner1.setSelection(sp_1 + 1);
                } else if ((sp_1 == 3) && (sp_2 == 3)) {
                    spinner1.setSelection(0);
                }
                break;
            default:
                break;


        }

        // System.out.println("uguale");

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void addListenerOnButton() {

        resetta = findViewById(R.id.button11);
        casella1 = findViewById(R.id.editText6);
        casella2 = findViewById(R.id.editText7);
        converti = findViewById(R.id.button10);
        errore = findViewById(R.id.textView37);
        freccetta = findViewById(R.id.imageButton7);

        freccetta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if ((sp_1 == 0) && (sp_2 == 1)) {
                    spinner1.setSelection(1);
                    spinner2.setSelection(0);
                } else if ((sp_1 == 1) && (sp_2 == 0)) {
                    spinner1.setSelection(0);
                    spinner2.setSelection(1);
                } else if ((sp_1 == 0) && (sp_2 == 2)) {
                    spinner1.setSelection(2);
                    spinner2.setSelection(0);
                } else if ((sp_1 == 0) && (sp_2 == 3)) {
                    spinner1.setSelection(3);
                    spinner2.setSelection(0);
                } else if ((sp_1 == 1) && (sp_2 == 2)) {
                    spinner1.setSelection(2);
                    spinner2.setSelection(1);
                } else if ((sp_1 == 1) && (sp_2 == 3)) {
                    spinner1.setSelection(3);
                    spinner2.setSelection(1);
                } else if ((sp_1 == 2) && (sp_2 == 0)) {
                    spinner1.setSelection(0);
                    spinner2.setSelection(2);
                } else if ((sp_1 == 2) && (sp_2 == 1)) {
                    spinner1.setSelection(1);
                    spinner2.setSelection(2);
                } else if ((sp_1 == 2) && (sp_2 == 3)) {
                    spinner1.setSelection(3);
                    spinner2.setSelection(2);
                } else if ((sp_1 == 3) && (sp_2 == 0)) {
                    spinner1.setSelection(0);
                    spinner2.setSelection(3);
                } else if ((sp_1 == 3) && (sp_2 == 1)) {
                    spinner1.setSelection(1);
                    spinner2.setSelection(3);
                } else if ((sp_1 == 3) && (sp_2 == 2)) {
                    spinner1.setSelection(2);
                    spinner2.setSelection(3);
                }
            }
        });


        converti.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (casella1.getText().toString().isEmpty()) {
                    errore.setText("Inserisci un valore nel campo");
                    errore.setVisibility(View.VISIBLE);
                    //converti.setClickable(false);
                    //converti.setTextColor(getResources().getColor(R.color.gray));
                } else if (selected1.equals("Gradi") && selected2.equals("Gradi")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText() + "°");
                    casella1.setFocusable(false);
                    casella2.setText(input1 + "°");
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Gradi") && selected2.equals("Radianti")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double rad1 = Math.toRadians(input1);
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText() + "°");
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.00").format(rad1));
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Gradi") && selected2.equals("Percentuale")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    if (input1 < 90) {
                        double perc1_rad = Math.toRadians(input1);
                        double perc1 = 100 * (Math.tan(perc1_rad));
                        freccetta.setEnabled(false);
                        freccetta.setVisibility(View.INVISIBLE);
                        casella1.setText(casella1.getText() + "°");
                        casella1.setFocusable(false);
                        casella2.setText(new DecimalFormat("0.0").format(perc1) + "%");
                        errore.setVisibility(View.INVISIBLE);
                        spinner1.setEnabled(false);
                        spinner2.setEnabled(false);
                        converti.setClickable(false);
                        converti.setTextColor(Color.GRAY);
                        casella2.setEnabled(true);
                    } else {
                        casella1.setText(casella1.getText() + "°");
                        errore.setText("Errore: valore > 90°");
                        errore.setVisibility(View.VISIBLE);
                        casella1.setFocusable(false);
                        converti.setClickable(false);
                        converti.setTextColor(getResources().getColor(R.color.gray));
                        casella2.setEnabled(true);
                    }
                } else if (selected1.equals("Gradi") && selected2.equals("Centesimali")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double cent = (input1 / 360) * 400;
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText() + "°");
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(cent));
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Radianti") && selected2.equals("Gradi")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double deg1 = Math.toDegrees(input1);
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText());
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(deg1) + "°");
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Radianti") && selected2.equals("Radianti")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText());
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(input1));
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Radianti") && selected2.equals("Percentuale")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double perc2 = 100 * (Math.tan(input1));
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText());
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(perc2) + "%");
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Radianti") && selected2.equals("Centesimali")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double deg1 = Math.toDegrees(input1);
                    double cent = (deg1 / 360) * 400;
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText());
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(cent));
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Percentuale") && selected2.equals("Gradi")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double alfa = Math.atan(input1 / 100);
                    double alfa_deg = Math.toDegrees(alfa);
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText() + "%");
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(alfa_deg) + "°");
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    errore.setVisibility(View.INVISIBLE);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Percentuale") && selected2.equals("Radianti")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double alfa = Math.atan(input1 / 100);
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText() + "%");
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.00").format(alfa));
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Percentuale") && selected2.equals("Percentuale")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText() + "%");
                    casella1.setFocusable(false);
                    casella2.setText(input1 + "%");
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Percentuale") && selected2.equals("Centesimali")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double alfa = Math.atan(input1 / 100);
                    double alfa_deg = Math.toDegrees(alfa);
                    double cent = (alfa_deg / 360) * 400;
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText() + "%");
                    casella2.setText(new DecimalFormat("0.00").format(cent));
                    casella1.setFocusable(false);
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Centesimali") && selected2.equals("Gradi")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double cent_grad = (input1 / 400) * 360;
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText());
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(cent_grad) + "°");
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Centesimali") && selected2.equals("Radianti")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double cent_grad = (input1 / 400) * 360;
                    double cent_rad = Math.toRadians(cent_grad);
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText());
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(cent_rad));
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);
                } else if (selected1.equals("Centesimali") && selected2.equals("Percentuale")) {
                    double input1 = Double.parseDouble(casella1.getText().toString());
                    double cent_grad = (input1 / 400) * 360;
                    double perc1_rad = Math.toRadians(cent_grad);
                    double perc1 = 100 * (Math.tan(perc1_rad));
                    freccetta.setEnabled(false);
                    freccetta.setVisibility(View.INVISIBLE);
                    casella1.setText(casella1.getText());
                    casella1.setFocusable(false);
                    casella2.setText(new DecimalFormat("0.0").format(perc1) + "%");
                    errore.setVisibility(View.INVISIBLE);
                    spinner1.setEnabled(false);
                    spinner2.setEnabled(false);
                    converti.setClickable(false);
                    converti.setTextColor(Color.GRAY);
                    casella2.setEnabled(true);

                }
            }

        });

        resetta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                casella1.setFocusable(true);
                casella1.setFocusableInTouchMode(true);
                casella1.requestFocus();
                casella1.setText("");
                casella2.setText("");
                errore.setVisibility(View.INVISIBLE);
                spinner1.setEnabled(true);
                spinner2.setEnabled(true);
                converti.setClickable(true);
                converti.setTextColor(getResources().getColor(R.color.colorAccent));
                freccetta.setEnabled(true);
                freccetta.setVisibility(View.VISIBLE);
                casella2.setEnabled(false);

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
                Intent i = new Intent(this, teoria_convertitore.class);
                this.startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
