package com.example.tp_final_inmobiliaria.ui.pagos;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp_final_inmobiliaria.model.Contrato;
import com.example.tp_final_inmobiliaria.ui.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Pago;
import com.example.tp_final_inmobiliaria.ui.contratos.ContratoAdapter;
import com.example.tp_final_inmobiliaria.ui.contratos.ContratosViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PagosFragment extends Fragment {

    private ExpandableListView elv;
    private PagoAdapter adapter;
    private List<String> inmueblesList;
    private HashMap<String,List<Pago> >pagoList;
    Context context;
    PagosViewModel cvm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inmueblesList = new ArrayList<>();
        pagoList = new HashMap<>();

        cvm = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagosViewModel.class);
        View root =inflater.inflate(R.layout.fragment_pagos, container, false);
        context = root.getContext();
        elv= root.findViewById(R.id.listPago);
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Pagos");
        //cargarDatos();

        cvm.getPagos().observe(getViewLifecycleOwner(), new Observer<List<Pago>>() {
            @Override
            public void onChanged(final List<Pago> pagos) {
                for (int i=0; i< pagos.size(); i++) {
                    List<Pago>p = new ArrayList<>();
                    Log.d("Pago", pagos.get(i).getIdPago()+" ");

                     p.add(new Pago(pagos.get(i).getIdPago(),pagos.get(i).getNumPago(),pagos.get(i).getFechaPago(),pagos.get(i).getImporte()));
                    inmueblesList.add(pagos.get(i).getContrato().getInmueble().getDireccion());
                    pagoList.put(inmueblesList.get(i).toString(),p);
                }
                adapter = new PagoAdapter(getActivity(),inmueblesList,pagoList);
                elv.setAdapter(adapter);
            }
        });

        cvm.cargarPagos();
        return root;
    }

   /* private  void cargarDatos() {
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


    }*/

}