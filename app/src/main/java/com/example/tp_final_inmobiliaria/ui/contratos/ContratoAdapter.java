package com.example.tp_final_inmobiliaria.ui.contratos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Contrato;

import java.util.HashMap;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ContratoAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> propiedades;
    private HashMap<String, List<Contrato>> listHashMap;


    public ContratoAdapter (Context context, List<String> propiedades, HashMap<String, List<Contrato>> listHashMap) {
        this.context = context;
        this.propiedades = propiedades;
        this.listHashMap = listHashMap;
    }

    @Override
    public int getGroupCount() {
        return propiedades.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return listHashMap.get(propiedades.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return propiedades.get(i);
    }

    @Override
    public Object getChild(int i, int  i1) {
        return listHashMap.get(propiedades.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String direPropiedad = (String)getGroup(groupPosition);
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_contrato,null);
        }
        TextView textViewPropiedades = view.findViewById(R.id.inmuebleCont);
        textViewPropiedades.setText(direPropiedad);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        Contrato cont = (Contrato) getChild(groupPosition,childPosition);
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.contrato_item,null);
        }
        TextView editPrecio = view.findViewById(R.id.editPrecio);
        TextView editFinal= view.findViewById(R.id.editFinalizacion);
        TextView editInicio = view.findViewById(R.id.editInicio);

        editInicio .setText(cont.getFechaInicio());
        editFinal.setText(cont.getFechaFinalizacion());
        editPrecio .setText(cont.getPrecio()+"");

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}


