package com.example.tp_final_inmobiliaria.ui.inmuebles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.tp_final_inmobiliaria.ui.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class InmueblesFragment extends Fragment {

    private InmueblesViewModel inmueblesViewModel;
    private ArrayList<Inmueble> lista = new ArrayList<>();
    private ListView lv;
    private View root;
    InmueblesViewModel vm;
    Context context;
    Inmueble inmueble;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmueblesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inmueble, container, false);
        context = root.getContext();


        final ListView lv = root.findViewById(R.id.listInmuebles);

        vm.getInmuebles().observe(getViewLifecycleOwner(), new Observer<List>() {
            @Override
            public void onChanged(final List list) {
                final ArrayAdapter<Inmueble> adapter = new InmuebleAdapter(getContext(), R.layout.inmueble_item,list, getLayoutInflater());
                lv.setAdapter(adapter);
                lv.setClickable(true);
                ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Inmuebles");

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Bundle bundle = new Bundle();
                        Inmueble inmueble = adapter.getItem(i);
                        // bundle.putSerializable("inmueble", inmueble);
                        bundle.putInt("id",inmueble.getId());
                        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.verInmuebleFragment, bundle);
                    }
                });

            }
        });

        vm.cargarInmuebles();
        return root;


    }








   /* public void cargarDatos(){
        lista.add(new Inmueble(R.drawable.casa1,"Gral Paz 148, Villa Mercedes", 8000, " Casa antigua con galeria, Living comedor, 3 dormitorios, cocina y comedor diario, , Patio y fondo libre.","casa"));
        lista.add(new Inmueble(R.drawable.casa2,"San Martin 789, Villa Mercedes", 11400, "Casa con Hall de ingreso, recepción, 3 dormitorios, sala de estar, cocina, 2 baños, patio con escalera a altillo.","casa"));
        lista.add(new Inmueble(R.drawable.casa3,"Buenos Aires 23, Villa Mercedes", 9500, "Casa con living comedor, 3 habitación con baño, cocina, 2 pieza en el fondo con baño y 2 terrazas con una pieza de servicio y 2 , uno con lavadero y churrasquera","casa"));
    }*/
}