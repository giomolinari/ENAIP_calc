package com.cham.giovannimolinari.enaip_app;

import android.graphics.Color;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Superficie_rettangolo extends AppCompatActivity {

    AppCompatButton calcola;
    AppCompatButton resetta;

    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayout2;
    private TextInputLayout textInputLayout3;
    private TextInputLayout textInputLayout4;

    private AppCompatEditText latoA;
    private AppCompatEditText latoB;
    private AppCompatEditText pend;
    private AppCompatEditText gronda;

    private double doub_latoA;
    private double doub_latoB;
    private double doub_pend;
    private double doub_gronda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test4);
        calcola = findViewById(R.id.button2);
        calcola.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        resetta = findViewById(R.id.button3);
        resetta.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

        textInputLayout = findViewById(R.id.til);
        textInputLayout2 = findViewById(R.id.til2);
        textInputLayout3 = findViewById(R.id.til3);
        textInputLayout4 = findViewById(R.id.til4);

        latoA = findViewById(R.id.textDialog);
        latoB = findViewById(R.id.textDialog2);
        pend = findViewById(R.id.textDialog3);
        gronda = findViewById(R.id.textDialog4);

        addListenerOnButton();
    }
    /*public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        return true;
    }
    */

    public void addListenerOnButton(){
        final TextView textView71 = findViewById(R.id.textView71);
        final TextView textView72 = findViewById(R.id.textView72);
        final TextView textView125 = findViewById(R.id.textView125);

        calcola.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (latoA.getText().toString().isEmpty()||latoB.getText().toString().isEmpty()||pend.getText().toString().isEmpty()||gronda.getText().toString().isEmpty()) {
                    textView125.setVisibility(View.VISIBLE);

                } else {
                    textView125.setVisibility(View.INVISIBLE);
                    doub_latoA = Double.parseDouble(latoA.getText().toString());
                    doub_latoB = Double.parseDouble(latoB.getText().toString());
                    doub_pend = Double.parseDouble(pend.getText().toString());
                    doub_gronda = Double.parseDouble(gronda.getText().toString());

                    double parentesti = (doub_latoA + 2*doub_gronda)*(doub_latoB + 2*doub_gronda);
                    double pend_rad = Math.toRadians(doub_pend);
                    double cos = Math.cos(pend_rad);

                    double sup_tavol = parentesti/cos;
                    double sup_isol = (doub_latoA * doub_latoB)/cos;

                    textView71.setText(new DecimalFormat("0.0").format(sup_tavol) + "\u33A1");
                    textView72.setText(new DecimalFormat("0.0").format(sup_isol) + "\u33A1");

                    latoA.setText(latoA.getText() + " m");
                    latoB.setText(latoB.getText() + " m");
                    gronda.setText(gronda.getText() + " m");
                    pend.setText(pend.getText() + "°");
                    latoA.setFocusable(false);
                    latoB.setFocusable(false);
                    pend.setFocusable(false);
                    gronda.setFocusable(false);

                    calcola.setClickable(false);
                    calcola.setTextColor(Color.GRAY);
                    calcola.setSupportBackgroundTintList(getResources().getColorStateList(R.color.gray_button));
                }
            }

        });


        resetta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                textView125.setVisibility(View.INVISIBLE);
                textView71.setText("-null-");
                textView72.setText("-null-");
                latoA.setText(null);
                latoA.setFocusable(true);
                latoA.setFocusableInTouchMode(true);
                latoB.setText(null);
                latoB.setFocusable(true);
                latoB.setFocusableInTouchMode(true);
                pend.setText(null);
                pend.setFocusable(true);
                pend.setFocusableInTouchMode(true);
                gronda.setText(null);
                gronda.setFocusable(true);
                gronda.setFocusableInTouchMode(true);

                calcola.setClickable(true);
                calcola.setTextColor(Color.WHITE);
                calcola.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));

            }

        });

    }
}
