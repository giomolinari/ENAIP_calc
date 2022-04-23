package com.cham.giovannimolinari.enaip_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.AppCompatButton;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentTre extends Fragment {

    TextView link1;
    TextView link2;
    TextView link3;
    View v;
    AppCompatButton button4;

    public FragmentTre() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_tre, container, false);
        button4 = v.findViewById(R.id.button4);
        button4.setSupportBackgroundTintList(getResources().getColorStateList(R.color.colorPrimary));
        button4.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "scuolacarpenteriatione@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Informazioni Scuola di Carpenteria - ENAIP Tione");
                //intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            }
        });


        link1 = v.findViewById(R.id.textView38);
        link2 = v.findViewById(R.id.textView41);
        link3 = v.findViewById(R.id.textView42);

        link1.setText(Html.fromHtml(" - <a href=\"https://www.facebook.com/ScuolaCarpenteriaTione/\">Pagina Facebook Scuola di Carpenteria</a>"));
        link1.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());

        link2.setText(Html.fromHtml(" - <a href=\"http://www.enaiptrentino.it\">Sito web ENAIP Trentino</a>"));
        link2.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());

        link3.setText(Html.fromHtml(" - <a href=\"https://www.dietrichs.com/it/\">Dietrich's 3D CAD/CAM software</a>"));
        link3.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
        return v;
    }


}

