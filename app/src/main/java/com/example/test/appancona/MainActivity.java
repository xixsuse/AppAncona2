package com.example.test.appancona;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.test.appancona.Percorsi.PercorsiActivity;
import com.example.test.appancona.Punti_interesse.Punti_interesseActivity;
import com.example.test.appancona.Ricerca.RicercaActivity;
import com.example.test.appancona.Ristorazione.RistorazioneActivity;
import com.example.test.appancona.Servizi.ServiziActivity;
import com.example.test.appancona.Pernottamento.PernottamentoActivity;
import com.example.test.appancona.Città.CittaActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.addListenerOnButton1();
        this.addListenerOnButton2();
        this.addListenerOnButton3();
        this.addListenerOnButton4();
        this.addListenerOnButton5();
        this.addListenerOnButton6();





    }
    public void addListenerOnButton1(){
        ImageButton a;
        a  =  findViewById(R.id.icona1);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,Punti_interesseActivity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton2(){
        ImageButton a;
        a  =  findViewById(R.id.icona2);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,RistorazioneActivity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton3(){
        ImageButton a;
        a  =  findViewById(R.id.icona3);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,PernottamentoActivity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton4(){
        ImageButton a;
        a  =  findViewById(R.id.icona4);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,PercorsiActivity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton5(){
        ImageButton a;
        a  =  findViewById(R.id.icona5);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,ServiziActivity.class);
                startActivity(i);

            }
        });

    }
    public void addListenerOnButton6(){
        ImageButton a;
        a  =  findViewById(R.id.icona6);
        a.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(MainActivity.this,CittaActivity.class);
                startActivity(i);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.actionbar,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch(id)
        {
            case R.id.MENU_1:
                Intent i;
                i = new Intent(MainActivity.this,RicercaActivity.class);
                startActivity(i);
                break;

            case R.id.MENU_2:
        }
        return true;
    }


}
