package com.example.tp_final_inmobiliaria.ui.perfil;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.tp_final_inmobiliaria.R;
import com.example.tp_final_inmobiliaria.model.Propietario;
import com.example.tp_final_inmobiliaria.model.Usuario;
import com.example.tp_final_inmobiliaria.ui.MainActivity;
import com.example.tp_final_inmobiliaria.ui.NavigationActivity;

public class PerfilFragment extends Fragment {

    private EditText editDniP,editApellidoP,editNombreP, editTelefonoP, editEmailP,editClaveP;
    private TextView textClaveP;
    private Button btnEditar, btnGuardar;
    private PerfilViewModel vm;
    Propietario prop;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        inicializar(root);
        return root;
    }
    private void inicializar(View view){
        editApellidoP= view.findViewById(R.id.editApellidoP);
        editDniP= view.findViewById(R.id.editDniP);
        editNombreP= view.findViewById(R.id.editNombreP);
        editTelefonoP= view.findViewById(R.id.editTelefonoP);
        editEmailP= view.findViewById(R.id.editEmailP);
        editClaveP= view.findViewById(R.id.editClaveP);
        textClaveP=view.findViewById(R.id.textClaveP);
        btnEditar= view.findViewById(R.id.btnEditar);
        btnGuardar=view.findViewById(R.id.btnGuardar);

        editApellidoP.setEnabled(false);
        editDniP.setEnabled(false);
        editNombreP.setEnabled(false);
        editTelefonoP.setEnabled(false);
        editEmailP.setEnabled(false);
        textClaveP.setVisibility(View.GONE);
        editClaveP.setVisibility(View.GONE);
        btnGuardar.setVisibility(View.GONE);


        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PerfilViewModel.class);

       vm.getPropietario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                editApellidoP.setText(propietario.getApellido());
                editDniP.setText(propietario.getDni());
                editNombreP.setText(propietario.getNombre());
                editTelefonoP.setText(propietario.getTelefono());
                editEmailP.setText(propietario.getEmail());
                prop= propietario;

            }
       });

       vm.cargarPerfil();
       // String auxMail = prop.getEmail();

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editApellidoP.setEnabled(true);
                editDniP.setEnabled(true);
                editNombreP.setEnabled(true);
                editTelefonoP.setEnabled(true);
                editEmailP.setEnabled(true);
                textClaveP.setVisibility(View.VISIBLE);
                editClaveP.setVisibility(View.VISIBLE);
                btnEditar.setVisibility(View.GONE);
                btnGuardar.setVisibility(View.VISIBLE);
            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Propietario p = new Propietario();
                p.setNombre(editNombreP.getText().toString());
                p.setApellido(editApellidoP.getText().toString());
                //p.setEmail(editEmailP.getText().toString());
                p.setDni(editDniP.getText().toString());
                p.setTelefono(editTelefonoP.getText().toString());
                vm.editarPropietario(p);

                    final Usuario us = new Usuario();
                    us.setEmail(editEmailP.getText().toString().trim());
                    us.setClave(editClaveP.getText().toString().trim());
                    vm.editarContraseña(us);

                   /* vm.getMsj().observe(getViewLifecycleOwner(), new Observer<String>() {
                        @Override
                        public void onChanged(String mensaje) {

                            new AlertDialog.Builder(getContext())
                                    .setTitle("Advertencia")
                                    .setMessage(mensaje)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            vm.editarContraseña(us);
                                            System.exit(0);

                                        }
                                    }).show();
                        }
                    });*/



                editApellidoP.setEnabled(false);
                editDniP.setEnabled(false);
                editNombreP.setEnabled(false);
                editTelefonoP.setEnabled(false);
                editEmailP.setEnabled(false);
                btnEditar.setVisibility(View.VISIBLE);
                btnGuardar.setVisibility(View.GONE);
                textClaveP.setVisibility(View.GONE);
                editClaveP.setVisibility(View.GONE);


            }
        });
        vm.cargarPerfil();

    }
    /*public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        button = root.findViewById(R.id.btnEditar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                alertDialogBuilder.setTitle("Confirmar");
                alertDialogBuilder
                        .setMessage("Desea guardar los cambios?")
                        .setCancelable(false)
                        .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                Toast.makeText(getContext(),"Datos guardados",Toast.LENGTH_LONG).show();

                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                Toast.makeText(getContext(),"No se guardaron los cambios",Toast.LENGTH_LONG).show();
                                dialog.cancel();
                            }
                        }).create().show();
            }
        });

        return root;*/
    }
