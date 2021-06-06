package com.example.tp_final_inmobiliaria.ui.inmuebles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Inmueble;

import java.util.List;

public class InmuebleAdapter extends ArrayAdapter<Inmueble> {

    private Context context;
    private List<Inmueble> lista;
    private LayoutInflater li;


    public InmuebleAdapter(@NonNull Context context, int resource, @NonNull List<Inmueble> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }
    public InmuebleAdapter(@NonNull Context context, int resource, LayoutInflater li) {
        super(context, resource);
        this.context = context;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=li.inflate(R.layout.inmueble_item,parent,false);
        }
        Inmueble inmueble =lista.get(position);

        ImageView foto=itemView.findViewById(R.id.foto);
        //foto.setImageResource(inmueble.getFoto());
        Glide.with(getContext())
                .load(inmueble.getFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_background)
                .into(foto);


        TextView direccion=itemView.findViewById(R.id.direccion);
        direccion.setText(inmueble.getDireccion());

        TextView precio=itemView.findViewById(R.id.precio);
        precio.setText(inmueble.getTipo());



        return itemView;
    }
}
