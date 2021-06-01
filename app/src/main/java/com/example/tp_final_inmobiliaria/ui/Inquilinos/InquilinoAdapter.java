package com.example.tp_final_inmobiliaria.ui.Inquilinos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Inquilino;

import java.util.List;

public class InquilinoAdapter extends ArrayAdapter<Inquilino> {

    private Context context;
    private List<Inquilino> inquilinos;
    private LayoutInflater li;

    public InquilinoAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> inquilinos, LayoutInflater inflater) {
        super(context, resource,inquilinos);
        this.context = context;
        this.inquilinos=inquilinos;
        this.li=inflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=li.inflate(R.layout.inquilino_item,parent,false);
        }
        Inquilino inquilino =inquilinos.get(position);

        TextView editDni = itemView.findViewById(R.id.editDni);
        editDni.setText(inquilino.getDni());

        TextView editApellido = itemView.findViewById(R.id.editApellido);
        editApellido.setText(inquilino.getApellido());

        TextView editNombre = itemView.findViewById(R.id.editNombre);
        editNombre.setText(inquilino.getNombre());

        TextView editDireccion = itemView.findViewById(R.id.editDireccion);
        editDireccion.setText(inquilino.getDireccion());

        TextView editTelefono = itemView.findViewById(R.id.editTelefono);
        editTelefono.setText(inquilino.getTelefono());


        return itemView;


    }
}
