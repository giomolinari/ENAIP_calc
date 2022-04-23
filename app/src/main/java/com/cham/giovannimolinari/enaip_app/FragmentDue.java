package com.cham.giovannimolinari.enaip_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FragmentDue extends Fragment {
    ListView listView2;
    public FragmentDue() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_due, container, false);
        listView2 = v.findViewById(R.id.listView2);

        String[] values = new String[]{
                "Introduzione",
                "Tetto a padiglione con pendenza costante",
                "Tetto a padiglione con pendenze diverse",
                "Superficie tavolato",
                "Triangolo delle pendenze",
                "Conversione angoli",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), R.layout.mytextview, android.R.id.text1, values);

        listView2.setAdapter(adapter);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition = position;
                String itemValue = (String) listView2.getItemAtPosition(position);

                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(getActivity(), teoria_intro.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), teoria_duefaldesingola.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), teoria_duefaldedoppia.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), teoria_tavolato.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), teoria_pendenze.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(), teoria_convertitore.class);
                        startActivity(intent5);
                        break;
                   /* case 6:
                        Intent intent6 = new Intent(getActivity(), teoria_distinta.class);
                        startActivity(intent6);
                        break; */
                   /* case 7:
                        Intent intent7 = new Intent(getActivity(), teoria_inclinometro.class);
                        startActivity(intent7);
                        break;
                        */

                }
            }

        });

        return v;

    }

}