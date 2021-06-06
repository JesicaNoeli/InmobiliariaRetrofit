package com.example.tp_final_inmobiliaria.ui.Inquilinos;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp_final_inmobiliaria.model.Contrato;
import com.example.tp_final_inmobiliaria.model.Inmueble;
import com.example.tp_final_inmobiliaria.model.Inquilino;
import com.example.tp_final_inmobiliaria.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquilinoViewModel extends AndroidViewModel {
    private MutableLiveData<List<Contrato>> inquilinos;
    private Context context;


    public InquilinoViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<List<Contrato>> getInquilinos() {
        if(inquilinos == null){
            inquilinos = new MutableLiveData<List<Contrato>>();
        }
        return inquilinos;
    }

    public void cargarInquilinos(){
        Call<List<Contrato>> getInquilinos = ApiClient.getMyApiClient().obtenerInquilinos(ApiClient.obtenerToken(context));
        getInquilinos.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
                if(response.isSuccessful()){
                    inquilinos.postValue(response.body());
                    Log.d("Inquilino", response.body().get(1).getInquilino().getApellido());
                }else{
                    Toast.makeText(context, "inquilinos no encontrados", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Toast.makeText(context, "ocurrio un error", Toast.LENGTH_LONG).show();

            }
        });
    }
}