package com.cham.giovannimolinari.enaip_app;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;


public class FragmentUno extends Fragment {
    ListView listView;


    public FragmentUno() {

    }


    public boolean isPackageExisted(String targetPackage){
        List<ApplicationInfo> packages;
        PackageManager pm = Objects.requireNonNull(getActivity()).getPackageManager();
        packages = pm.getInstalledApplications(0);
        for (ApplicationInfo packageInfo : packages) {
            if(packageInfo.packageName.equals(targetPackage)) return true;
        }
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_uno, container, false);
        listView = v.findViewById(R.id.listView);

        String[] values = new String[]{
                "Tetto a padiglione con pendenza costante",
                "Tetto a padiglione con pendenze diverse",
                "Superficie tavolato",
                "Triangolo delle pendenze",
                "Conversione angoli",
                //"Distinta legname",
                "Inclinometro",
                "Livella a bolla",
                "Calcolatrice"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Objects.requireNonNull(this.getActivity()), R.layout.mytextview, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //int itemPosition = position;
                //String itemValue = (String) listView.getItemAtPosition(position);

                switch (position) {
                    case 0:
                        Intent intent0 = new Intent(getActivity(), DueFaldeSingola.class);
                        startActivity(intent0);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), DueFaldeDoppia.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(), Superficie.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), Triangolo2.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), Convertitore.class);
                        startActivity(intent4);
                        break;
                   /* case 5:
                        Intent intent5 = new Intent(getActivity(), Distinta.class);
                        startActivity(intent5);
                       break; */
                    case 5:
                        Intent intent6 = new Intent(getActivity(), Inclinometro.class);
                        startActivity(intent6);
                        break;
                    case 6:
                        Intent intent7 = new Intent(getActivity(), Bolla.class);
                        startActivity(intent7);
                        break;
                    case 7:
                        if (isPackageExisted("com.android.calculator2")){
                            try{
                            PackageManager packageManager = Objects.requireNonNull(getActivity()).getPackageManager();
                            Intent appStartIntent = packageManager.getLaunchIntentForPackage("com.android.calculator2");
                            getActivity().startActivity(appStartIntent);}
                            catch(Exception e){
                                Toast.makeText(getActivity(), getString(R.string.avv_calc),
                                Toast.LENGTH_LONG).show();
                            }

                        } else if(isPackageExisted("com.google.android.calculator")){
                            try{
                            PackageManager packageManager = Objects.requireNonNull(getActivity()).getPackageManager();
                            Intent appStartIntent = packageManager.getLaunchIntentForPackage("com.google.android.calculator");
                            getActivity().startActivity(appStartIntent);}
                            catch(Exception e){
                                Toast.makeText(getActivity(), getString(R.string.avv_calc),
                                Toast.LENGTH_LONG).show();
                            }

                        } else if(isPackageExisted("com.sec.android.app.popupcalculator")){
                            try{
                            PackageManager packageManager = Objects.requireNonNull(getActivity()).getPackageManager();
                            Intent appStartIntent = packageManager.getLaunchIntentForPackage("com.sec.android.app.popupcalculator");
                            getActivity().startActivity(appStartIntent);}
                            catch(Exception e){
                                Toast.makeText(getActivity(), getString(R.string.avv_calc),
                                Toast.LENGTH_LONG).show();
                            }

                        } else {
                            Toast.makeText(getActivity(), getString(R.string.ind_calc),
                            Toast.LENGTH_LONG).show();
                        }

                        break;

                }
            }

        });

        return v;

    }


}
