package com.example.tp_final_inmobiliaria.ui.inmuebles;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Inmueble;
import com.example.tp_final_inmobiliaria.ui.NavigationActivity;

public class VerInmuebleFragment extends Fragment {
    private ImageView fotoGrande;
    private TextView txtDescripcion;
    private TextView txtDireccion;
    private TextView txtPrecio;
    private TextView txtTipo;
    private Switch disponible;
    private VerInmuebleViewModel ivm;
    private Inmueble inmueble;

    /*public static VerInmuebleFragment newInstance() {
        return new VerInmuebleFragment();
    }*/

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        int id = getArguments().getInt("id");
        ivm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(VerInmuebleViewModel.class);
        View root = inflater.inflate(R.layout.ver_inmueble_fragment, container, false);
        inicializar(root);

        ivm.getInmueble().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {

                //fotoGrande.setImageResource(inmueble.getFoto());
                // txtDescripcion.setText(inmueble.getDescripcion());
                txtPrecio.setText(inmueble.getPrecio() + "");
                txtDireccion.setText(inmueble.getDireccion());
                txtTipo.setText(inmueble.getTipo());
                if (inmueble.getDisponible()) {
                    disponible.setChecked(true);
                }
            }
        });
        ivm.verInmueble(id);
        return root;
    }
    private void inicializar(View view) {
        fotoGrande=view.findViewById(R.id.fotoGrande);
        txtDescripcion=view.findViewById(R.id.textDescripcion);
        txtDireccion=view.findViewById(R.id.textDireccion);
        txtPrecio=view.findViewById(R.id.textPrecio1);
        txtTipo=view.findViewById(R.id.textTipo);
        disponible=view.findViewById(R.id.switchDisponible);
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Propiedad");
        disponible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivm.disponibilidad(inmueble.getId());
                if(disponible.isChecked()){
                    Toast.makeText(getContext(),"La propiedad cambio a disponible",Toast.LENGTH_LONG).show();
                }else{Toast.makeText(getContext(),"La propiedad cambio a no disponible",Toast.LENGTH_LONG).show();}
            }
        });
    }

    }



