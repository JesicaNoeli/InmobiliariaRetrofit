package com.example.tp_final_inmobiliaria.ui.pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;

import com.example.tp_final_inmobiliaria.ui.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Pago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PagosFragment extends Fragment {

    private PagosViewModel PagosViewModel;

    private ExpandableListView elv;
    private PagoAdapter adapter;
    private List<String> inmueblesList;
    private HashMap<String,List<Pago> >pagoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_pagos, container, false);
        elv= view.findViewById(R.id.listPago);
        cargarDatos();
        adapter = new PagoAdapter(getActivity(),inmueblesList,pagoList);
        elv.setAdapter(adapter);
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Pagos");
        return view;
    }

    private  void cargarDatos() {
        inmueblesList = new ArrayList<>();
        pagoList = new HashMap<>();

        inmueblesList.add("Gral Paz 148, Villa Mercedes");
        inmueblesList.add("San Martin 789, Villa Mercedes");
        inmueblesList.add("Buenos Aires 23, Villa Mercedes");

        List<Pago> Gral_Paz_148 = new ArrayList<>();
        Gral_Paz_148.add(new Pago(1,"11/08/2019",8000));
        Gral_Paz_148.add(new Pago(2,"19/09/2019",8000));
        Gral_Paz_148.add(new Pago(3,"10/10/2019",8000));
        pagoList.put(inmueblesList.get(0),Gral_Paz_148);

        List<Pago> San_Martin_789 = new ArrayList<>();
        San_Martin_789.add(new Pago(1,"07/09/2019",11400));
        San_Martin_789.add(new Pago(2,"11/10/2019",11400));
        pagoList.put(inmueblesList.get(1),San_Martin_789);

        List<Pago> Buenos_Aires_23 = new ArrayList<>();
        Buenos_Aires_23.add(new Pago(1,"02/04/2019",9500));
        Buenos_Aires_23.add(new Pago(2,"05/05/2019",9500));
        Buenos_Aires_23.add(new Pago(3,"03/06/2019",9500));
        Buenos_Aires_23.add(new Pago(4,"06/07/2019",9500));
        pagoList.put(inmueblesList.get(2),Buenos_Aires_23);


    }

}