package com.example.test.appancona;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;



public class Punti_interesseActivity extends AppCompatActivity {

    private ListView lv = null;
    private SimpleCursorAdapter adapter = null;
    private DBManager db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punti_interesse);


        lv = new ListView(this);
        setContentView(lv);

        db = new DBManager(this);
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.row_tipi_punti_interesse,
                db.tipiPuntiinteresse(),
                new String[]{"immagine", "_id"},
                new int[]{R.id.imagetipipuntint, R.id.nome},
                0
        );

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i;
                TextView textView =  view.findViewById(R.id.nome);
                String tipo = textView.getText().toString();

                    i = new Intent(Punti_interesseActivity.this, Punti_interesse2Activity.class);
                    i.putExtra("tipo", tipo);
                    startActivity(i);


            }
        });

    }

    }




