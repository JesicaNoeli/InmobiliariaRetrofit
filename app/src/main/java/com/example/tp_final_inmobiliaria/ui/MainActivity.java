package com.example.tp_final_inmobiliaria.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp_final_inmobiliaria.ui.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Propietario;

public class MainActivity extends AppCompatActivity {

    private Button btnIniciar;
    private EditText usuario;
    private EditText password;
    private MainActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        inicializar();


            vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
            vm.getError().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String mensaje) {

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Advertencia")
                            .setMessage(mensaje)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            }).show();
                }
            });
            vm.getLogin().observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(Boolean aBoolean) {
                    Intent i = new Intent(getApplicationContext(), NavigationActivity.class);
                    //i.putExtra("nombre", propietario.getNombre());
                    startActivity(i);
                }
            } );
        }

    public void inicializar(){
            btnIniciar = findViewById(R.id.iniciar);
            usuario = findViewById(R.id.editMail);
            password = findViewById(R.id.editPass);

            btnIniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    vm.autenticar(usuario.getText().toString(),password.getText().toString());

                }
            });

       /* btnIniciar.setOnClickListener(new View.OnClickListener() {
            // Equivalente a crear una clase que implemente la interfaz y luego enviar el objeto de la misma como parametro
            @Override
            public void onClick(View view) {

                Propietario propietario = new Propietario("admin","admin@admin.com","admin");

                if(usuario.getText().toString().equals(propietario.getEmail()) && password.getText().toString().equals(propietario.getPassword())) {

                    Intent i = new Intent(getApplicationContext(), NavigationActivity.class);
                  i.putExtra("nombre", propietario.getNombre());
                    startActivity(i);


                }else{
                    Toast.makeText(getApplicationContext(),"Email y/o contraseña incorrecto",Toast.LENGTH_LONG).show();
                }
            }
        }  );*/
    }
}
