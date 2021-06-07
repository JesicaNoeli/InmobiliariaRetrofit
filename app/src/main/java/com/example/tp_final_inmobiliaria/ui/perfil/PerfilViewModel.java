package com.example.tp_final_inmobiliaria.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp_final_inmobiliaria.model.Propietario;
import com.example.tp_final_inmobiliaria.model.Usuario;
import com.example.tp_final_inmobiliaria.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> propietario;
    private MutableLiveData<String> msj;
    //private MutableLiveData<Usuario> usuario;
    private Context context;


    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<Propietario> getPropietario() {
        if(propietario== null){
            propietario= new MutableLiveData<>();
        }
        return propietario;
    }

    public LiveData<String> getMsj() {
        if(msj == null){
            msj = new MutableLiveData<>();
        }
        return  msj;
    }
    public void cargarPerfil(){
        Call<Propietario>obtenerPropietario = ApiClient.getMyApiClient().propietarioActual(ApiClient.obtenerToken(context));
        obtenerPropietario.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    propietario.postValue(response.body());
                }else{
                    Toast.makeText(context, "usuario no encontrado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context, "ocurrio un error", Toast.LENGTH_LONG).show();

            }
        });
    }

    public void editarPropietario(final Propietario p){
        Call<Propietario>editarPropietario = ApiClient.getMyApiClient().editarPropietario(ApiClient.obtenerToken(context),p);
       editarPropietario.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    propietario.setValue(response.body());
                     Toast.makeText(context, "Datos guardados", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(context, "usuario no encontrado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context, "ocurrio un error", Toast.LENGTH_LONG).show();


            }
        });
    }

    public void editarContraseña(Usuario us){
        Call<Usuario>nuevaClave = ApiClient.getMyApiClient().cambiarContraseña(ApiClient.obtenerToken(context),us);
        nuevaClave.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Log.d("Usuario", "listo ");
                   // msj.setValue("Datos de usuario cambiados, veuelva a iniciar sesion");
                }else{
                    Toast.makeText(context, "usuario no editado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(context, "ocurrio un error", Toast.LENGTH_LONG).show();
                Log.d("Token", "error ususario "+t.getMessage());

            }
        });
    }




}