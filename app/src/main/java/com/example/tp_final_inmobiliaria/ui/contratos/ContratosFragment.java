package com.example.tp_final_inmobiliaria.ui.contratos;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.tp_final_inmobiliaria.model.Inmueble;
import com.example.tp_final_inmobiliaria.ui.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Contrato;
import com.example.tp_final_inmobiliaria.ui.inmuebles.InmuebleAdapter;
import com.example.tp_final_inmobiliaria.ui.inmuebles.InmueblesViewModel;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContratosFragment extends Fragment {

    private ExpandableListView elv;
    ContratoAdapter adapter;
    private List<String> inmueblesList;
    private HashMap<String,List<Contrato>> contList;
    Context context;
    ContratosViewModel cvm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inmueblesList = new ArrayList<>();
        contList = new HashMap<>();

        cvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosViewModel.class);
        View root =inflater.inflate(R.layout.fragment_contratos, container, false);
        context = root.getContext();
        elv= root.findViewById(R.id.listContrato);
       //cargarDatos();
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Contratos");

        cvm.getContratos().observe(getViewLifecycleOwner(), new Observer<List<Contrato>>() {
            @Override
            public void onChanged( final List<Contrato> contratoes) {

                for (int i=0; i< contratoes.size(); i++) {
                    List<Contrato>con = new ArrayList<>();
                    con.add(new Contrato(contratoes.get(i).getFechaInicio(),contratoes.get(i).getFechaCierre(),contratoes.get(i).getMonto(),contratoes.get(i).getInquilino()));
                    inmueblesList.add(contratoes.get(i).getInmueble().getDireccion());
                    contList.put(inmueblesList.get(i).toString(),con);
                }

                adapter = new ContratoAdapter(getContext(), inmueblesList,contList);
                elv.setAdapter(adapter);


            }
        });


        cvm.contratosVigentes();

        return root;

    }

    }

   /* private  void cargarDatos() {
        inmueblesList = new ArrayList<>();
        contList = new HashMap<>();

        inmueblesList.add("Gral Paz 148, Villa Mercedes");
        inmueblesList.add("San Martin 789, Villa Mercedes");
        inmueblesList.add("Buenos Aires 23, Villa Mercedes");

        List<Contrato> Gral_Paz_148 = new ArrayList<>();
        Gral_Paz_148.add(new Contrato("11/08/2019","10/02/2020",8000));
        contList.put(inmueblesList.get(0),Gral_Paz_148);

        List<Contrato> San_Martin_789 = new ArrayList<>();
        San_Martin_789.add(new Contrato("07/09/2019","07/09/2020",11400));
        contList.put(inmueblesList.get(1),San_Martin_789);

        List<Contrato> Buenos_Aires_23 = new ArrayList<>();
        Buenos_Aires_23.add(new Contrato("02/04/2019","02/08/2019",9500));
        contList.put(inmueblesList.get(2),Buenos_Aires_23);


    }*/
