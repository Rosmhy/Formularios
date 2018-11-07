package com.e.rosmhi.formulariob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btoningresar= (Button) findViewById(R.id.btoningresar);
        btoningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario=((AutoCompleteTextView) findViewById(R.id.correoLogin)).getText().toString();
                String pass=((AutoCompleteTextView) findViewById(R.id.contraseñaLogin)).getText().toString();
                if (usuario.equals("ZapatosMatheo")&& pass.equals("1234"))
                {
                    startActivity(new Intent(MainActivity.this, ActivityRegistro.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}