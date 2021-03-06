package com.example.test.appancona.Ricerca;

import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.appancona.Database.DBManager;
import com.example.test.appancona.MappaActivity;
import com.example.test.appancona.MappaActivity.*;
import com.example.test.appancona.Punti_interesse.Punti_interesse2Activity;
import com.example.test.appancona.Punti_interesse.Punti_interesseActivity;
import com.example.test.appancona.R;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Ricerca_punti_interesseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ricerca_punti_interesse);
        valoreSeekBar(R.id.distanza,R.id.valoredist);
        addSeekerListener(R.id.distanza,R.id.valoredist);
        inizializzaSpinner();
        addListenerRicerca();

      /*  TextView tv = findViewById(R.id.distanza);
        tv.setText(CalcoloDistanza("via piave 5 ancona ","via piave 4 ancona").toString());*/

    }
    public LatLng getSingleLocationFromAddress(String strAddress)
    {
        Geocoder coder = new Geocoder(this, Locale.getDefault());
        List<Address> address = null;
        Address location = null;
        LatLng temp = null;
        String strAddresNew = strAddress.replace(",", " ");
        try
        {
            address = coder.getFromLocationName(strAddresNew, 1);
            if (!address.isEmpty())
            {
                location = address.get(0);
                location.getLatitude();
                location.getLongitude();
                temp = new LatLng(location.getLatitude(), location.getLongitude());
                Log.d("Latlng : ", temp + "");
            }
        } catch (IOException e)
        {
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return temp;
    }

    public void addSeekerListener(final int idseeker, final int idtext)
    {
        SeekBar dis = findViewById(idseeker);
        dis.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                valoreSeekBar(idseeker,idtext);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void valoreSeekBar(int idseeker, int idtext )
    {
    SeekBar dist = findViewById(idseeker);
    Integer numero =dist.getProgress()+100;
    TextView valore = findViewById(idtext);
        valore.setText(numero.toString()+ " m");
    }
    public void inizializzaSpinner()
    {
        List<String> spinnerArray =  new ArrayList<String>();
        DBManager db = new DBManager(this);
        Cursor tipi = db.tipiPuntiinteresse();
        spinnerArray.add("Tutte");
        while (tipi.moveToNext())
        {
            spinnerArray.add(tipi.getString(tipi.getColumnIndex("_id")));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.categoria);
        sItems.setAdapter(adapter);
    }
    public void addListenerRicerca()
    {
        Button cerca = findViewById(R.id.ricerca);
        cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner ris =findViewById(R.id.categoria);
                SeekBar di =findViewById(R.id.distanza);
               Integer dis= di.getProgress()+100;

                String tipo = ris.getSelectedItem().toString();
                Intent i;
                i = new Intent(Ricerca_punti_interesseActivity.this, Punti_interesse2Activity.class);
                i.putExtra("tipo", tipo);
                i.putExtra("distanza",dis);
                startActivity(i);
            }
        });
    }
}
