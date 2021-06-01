package com.example.tp_final_inmobiliaria.ui.Inquilinos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tp_final_inmobiliaria.ui.NavigationActivity;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Inquilino;

import java.util.ArrayList;

public class InquilinoFragment extends Fragment {

    private ArrayList<Inquilino> inquilinos=new ArrayList<>();
    private InquilinoViewModel inquilinoViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cargarDatos();
        inquilinoViewModel =
                ViewModelProviders.of(this).get(InquilinoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inquilino, container, false);
        final ListView lv = root.findViewById(R.id.listInquilino);

        ArrayAdapter<Inquilino> adapter = new InquilinoAdapter(getContext(),R.layout.inquilino_item,inquilinos,getLayoutInflater());
        lv.setAdapter(adapter);
        ((NavigationActivity) getActivity()).getSupportActionBar().setTitle("Inquilinos");
        return root ;
    }
    public void cargarDatos() {
        inquilinos.add(new Inquilino("34420243", "Anibal", "Acosta", "Gral Paz 148", "2657334101"));
        inquilinos.add(new Inquilino("32354379", "Leonardo", "Aguilera", "San Martin 789", "2657609089"));
        inquilinos.add(new Inquilino("31890031", "Sofia", "Shinoda", "Buenos Aires 23", "2657732991"));
    }
}