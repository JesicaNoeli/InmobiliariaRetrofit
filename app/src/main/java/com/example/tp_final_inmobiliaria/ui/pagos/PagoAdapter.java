package com.example.tp_final_inmobiliaria.ui.pagos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Pago;

import java.util.HashMap;
import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

class PagoAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> propiedades;
    private HashMap<String,List<Pago>> listHashMap;


    public PagoAdapter(Context context, List<String> propiedades, HashMap<String, List<Pago>> listHashMap) {
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
            view = inflater.inflate(R.layout.activity_pago,null);
        }
        TextView textViewPropiedades = view.findViewById(R.id.inmueblePago);
        textViewPropiedades.setText(direPropiedad);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        Pago pago = (Pago)getChild(groupPosition,childPosition);
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.pago_item,null);
        }
        TextView editImporte = view.findViewById(R.id.editImporte);
        TextView editFechaP= view.findViewById(R.id.editFecha);
        TextView editPago = view.findViewById(R.id.editPago);

        editPago.setText(pago.getNroPago()+"");
        editFechaP.setText(pago.getFecha());
        editImporte.setText(pago.getImporte()+"");

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
