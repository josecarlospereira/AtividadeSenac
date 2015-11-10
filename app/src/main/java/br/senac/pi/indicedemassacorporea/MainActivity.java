package br.senac.pi.indicedemassacorporea;

import android.content.Intent;
import android.location.GpsStatus;
import android.net.sip.SipAudioCall;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.BotaoCalcular).setOnClickListener(calcular());
    }

    private View.OnClickListener calcular(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText kg = (EditText) findViewById(R.id.kg);
                EditText met_alt = (EditText) findViewById(R.id.met_alt);
                TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                double kilo = Double.parseDouble(kg.getText().toString());
                double metro = Double.parseDouble(met_alt.getText().toString());
                double total = kilo / (metro * metro);

                if (total <= 18.5) {
                    txtResultado.setText(getString(R.string.total) + " " + String.format("%.2f", total) + "\nAbaixo do Peso");
                }else if (total > 18.5 && total <= 25){
                    txtResultado.setText(getString(R.string.total) + " " + String.format("%.2f", total) + "\nPeso Normal");
                }else if (total > 25 && total <= 30){
                    txtResultado.setText(getString(R.string.total) + " " + String.format("%.2f", total) + "\nAcima do Peso");
                }else{
                    txtResultado.setText(getString(R.string.total) + " " + String.format("%.2f", total) + "\nObeso");
                }
            }
        };
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}