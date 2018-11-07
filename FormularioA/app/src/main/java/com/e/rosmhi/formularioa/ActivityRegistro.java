package com.e.rosmhi.formularioa;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class ActivityRegistro extends AppCompatActivity  {
    Button botonregistrar, botoncancelar;

    private AutoCompleteTextView textnombre, textapellido,textcorreo,textcontraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textnombre = (AutoCompleteTextView) findViewById(R.id.textnombre);
        textapellido = (AutoCompleteTextView) findViewById(R.id.textapellido);
        textcorreo = (AutoCompleteTextView) findViewById(R.id.textcorreo);
        textcontraseña = (AutoCompleteTextView) findViewById(R.id.textcontraseña);

        botonregistrar = (Button) findViewById(R.id.botonregistrar);
        botoncancelar = (Button) findViewById(R.id.botoncancelar);

        botonregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                String nombre = textnombre.getText().toString();
                String apellido = textapellido.getText().toString();
                String correo = textcorreo.getText().toString();
                String contraseña = textcontraseña.getText().toString();


                BasedeDatos basedeDatos = new BasedeDatos(this, "DEMODB", null, 1);

                SQLiteDatabase db = basedeDatos.getWritableDatabase();
                if (db != null) {
                    ContentValues registronuevo = new ContentValues();
                    registronuevo.put("nombre", nombre);
                    registronuevo.put("apellido",apellido);
                    registronuevo.put("correo", correo);
                    registronuevo.put("contraseña",contraseña);

                    db.insert("Registro", null, registronuevo);
                    Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(ActivityRegistro.this, SegundaActivity.class));
                }
                else{
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
