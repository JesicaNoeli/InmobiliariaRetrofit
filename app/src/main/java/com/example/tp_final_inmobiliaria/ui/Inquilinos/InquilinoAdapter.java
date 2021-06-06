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
import com.example.tp_final_inmobiliaria.model.Contrato;
import com.example.tp_final_inmobiliaria.model.Inquilino;

import java.util.List;

public class InquilinoAdapter extends ArrayAdapter<Contrato> {

    private Context context;
    private List<Contrato> inquilinos;
    private LayoutInflater li;

    public InquilinoAdapter(@NonNull Context context, int resource, @NonNull List<Contrato> inquilinos, LayoutInflater inflater) {
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
        Contrato inquilino =inquilinos.get(position);

        TextView editDni = itemView.findViewById(R.id.editDni);
        editDni.setText(inquilino.getInquilino().getDni());

        TextView editApellido = itemView.findViewById(R.id.editApellido);
        editApellido.setText(inquilino.getInquilino().getApellido());

        TextView editNombre = itemView.findViewById(R.id.editNombre);
        editNombre.setText(inquilino.getInquilino().getNombre());

        TextView editDireccion = itemView.findViewById(R.id.editDireccion);
        editDireccion.setText(inquilino.getInmueble().getDireccion());

        TextView editTrabajo = itemView.findViewById(R.id.editTrabajo);
        editTrabajo.setText(inquilino.getInquilino().getDireccionTrabajo());

        TextView editTelefono = itemView.findViewById(R.id.editTelefono);
        editTelefono.setText(inquilino.getInquilino().getTelefono());


        return itemView;


    }
}
