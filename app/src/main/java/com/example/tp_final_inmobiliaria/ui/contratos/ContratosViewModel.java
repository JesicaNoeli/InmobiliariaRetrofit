package com.example.tp_final_inmobiliaria.ui.contratos;

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
import com.example.tp_final_inmobiliaria.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContratosViewModel extends AndroidViewModel {
    private MutableLiveData<List<Contrato>> contratos;
    private Context context;


    public ContratosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<List<Contrato>> getContratos() {
        if(contratos == null){
            contratos = new MutableLiveData<List<Contrato>>();
        }
        return contratos;
    }
    public void contratosVigentes(){
        Call<List<Contrato>>vigentes = ApiClient.getMyApiClient().obtenerVigentes(ApiClient.obtenerToken(context));
        vigentes.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
                Log.d("Token", "entro");
                if(response.isSuccessful()){
                    contratos.postValue(response.body());
                }else{
                    Toast.makeText(context, "contratos no encontrados", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Toast.makeText(context, "ocurrio un error", Toast.LENGTH_LONG).show();

            }
        });
    }

}