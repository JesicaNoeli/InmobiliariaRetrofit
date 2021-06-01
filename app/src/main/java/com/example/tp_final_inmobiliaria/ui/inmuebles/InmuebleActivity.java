package com.example.tp_final_inmobiliaria.ui.inmuebles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Inmueble;
import com.example.tp_final_inmobiliaria.model.Propietario;

public class InmuebleActivity extends AppCompatActivity {

    private ImageView fotoGrande;
    private TextView txtDescripcion;
    private TextView txtDireccion;
   InmueblesViewModel vm;
    private TextView txtPrecio;
    private TextView txtTipo;
    private Switch disponible;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       vm= ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication()).create(InmueblesViewModel.class);
        setContentView(R.layout.activity_inmueble);
        fotoGrande=findViewById(R.id.fotoGrande);
        txtDescripcion=findViewById(R.id.textDescripcion);
        txtDireccion=findViewById(R.id.textDireccion);
        txtPrecio=findViewById(R.id.textPrecio1);
        txtTipo=findViewById(R.id.textTipo);
        disponible=findViewById(R.id.switchDisponible);
        getSupportActionBar().setTitle("Propiedad");
        Intent x= getIntent();
        final Inmueble casa = (Inmueble) x.getSerializableExtra("inmueble");

           //fotoGrande.setImageResource(casa.getFoto());
                       // txtDescripcion.setText(casa.getDescripcion());
                       txtPrecio.setText(casa.getPrecio()+"");
                       txtDireccion.setText(casa.getDireccion());
                       txtTipo.setText(casa.getTipo());
                       if(casa.getDisponible()){
                           disponible.setChecked(true);
                       }



       disponible.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               vm.disponibilidad(casa.getId());
               if(disponible.isChecked()){
                   Toast.makeText(getApplicationContext(),"La propiedad cambio a disponible",Toast.LENGTH_LONG).show();
               }else{Toast.makeText(getApplicationContext(),"La propiedad cambio a no disponible",Toast.LENGTH_LONG).show();}
           }
       });
        }
    }
