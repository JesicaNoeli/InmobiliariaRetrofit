package com.example.tp_final_inmobiliaria.ui.contratos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.example.tp_final_inmobiliaria.ui.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Contrato;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContratosFragment extends Fragment {

    private ExpandableListView elv;
    private ContratoAdapter adapter;
    private List<String> inmueblesList;
    private HashMap<String,List<Contrato>> contList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_contratos, container, false);
        elv= view.findViewById(R.id.listContrato);
        cargarDatos();
        adapter = new ContratoAdapter(getActivity(),inmueblesList,contList);
        elv.setAdapter(adapter);
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Contratos");
        return view;
    }

    private  void cargarDatos() {
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


    }
}