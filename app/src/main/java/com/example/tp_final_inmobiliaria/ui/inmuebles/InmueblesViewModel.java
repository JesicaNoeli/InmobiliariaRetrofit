package com.example.tp_final_inmobiliaria.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp_final_inmobiliaria.model.Inmueble;
import com.example.tp_final_inmobiliaria.model.Propietario;
import com.example.tp_final_inmobiliaria.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  InmueblesViewModel extends AndroidViewModel {
    private MutableLiveData<List<Inmueble>> inmuebles;
    private Context context;


    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }


    public LiveData<List<Inmueble>> getInmuebles() {
        if(inmuebles == null){
            inmuebles = new MutableLiveData<List<Inmueble>>();
        }
        return inmuebles;
    }

    public void cargarInmuebles(){
        Call<List<Inmueble>> misInmuebles = ApiClient.getMyApiClient().inmueblesPropios(ApiClient.obtenerToken(context));
        misInmuebles.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()){
                    inmuebles.postValue(response.body());
                }else{
                    Toast.makeText(context, "inmuebles no encontrados", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>>call, Throwable t) {
                Toast.makeText(context, "ocurrio un error", Toast.LENGTH_LONG).show();

            }
        });
    }



}