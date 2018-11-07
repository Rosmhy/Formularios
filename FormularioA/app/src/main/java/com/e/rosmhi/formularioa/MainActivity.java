package com.e.rosmhi.formularioa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btingresar= (Button) findViewById(R.id.btingresar);
        btingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario=((EditText) findViewById(R.id.txtUsuario)).getText().toString();
                String pass=((EditText) findViewById(R.id.txtPass)).getText().toString();
                if (usuario.equals("admin")&& pass.equals("admin"))
                {
                    startActivity(new Intent(Principal.this, Secundario.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
