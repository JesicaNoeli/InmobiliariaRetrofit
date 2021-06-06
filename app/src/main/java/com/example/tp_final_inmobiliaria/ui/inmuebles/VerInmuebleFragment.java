package com.example.tp_final_inmobiliaria.ui.inmuebles;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Inmueble;
import com.example.tp_final_inmobiliaria.ui.NavigationActivity;

public class VerInmuebleFragment extends Fragment {
    private ImageView fotoGrande;
    private TextView txtAmbientes, txtDireccion, txtPrecio, txtTipo, txtUso;
    private Switch disponible;
    private VerInmuebleViewModel ivm;
    private Inmueble inmue;

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
                txtAmbientes.setText(inmueble.getCantAmbientes()+"");
                txtPrecio.setText(inmueble.getPrecio() + "");
                txtDireccion.setText(inmueble.getDireccion());
                txtTipo.setText(inmueble.getTipo());
                txtUso.setText(inmueble.getUso());
                inmue = inmueble;

                if (inmueble.getDisponible()) {
                    disponible.setChecked(true);
                }

                Glide.with(getContext())
                        .load(inmueble.getFoto())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(fotoGrande);

            }
        });



        ivm.verInmueble(id);
        return root;
    }
    private void inicializar(View view) {
        fotoGrande=view.findViewById(R.id.fotoGrande);
        txtAmbientes=view.findViewById(R.id.textAmbientes);
        txtDireccion=view.findViewById(R.id.textDireccion);
        txtPrecio=view.findViewById(R.id.textPrecio1);
        txtTipo=view.findViewById(R.id.textTipo);
        txtUso=view.findViewById(R.id.textUso);
        disponible=view.findViewById(R.id.switchDisponible);



        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Propiedad");
        disponible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d("Token", "disponible"+ inmue.getId());
               ivm.disponibilidad(inmue.getId());
                if(disponible.isChecked()){
                    Toast.makeText(getContext(),"La propiedad cambio a disponible",Toast.LENGTH_LONG).show();
                }else{Toast.makeText(getContext(),"La propiedad cambio a no disponible",Toast.LENGTH_LONG).show();}
            }
        });

    }

    }



