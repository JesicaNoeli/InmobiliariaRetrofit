package com.example.tp_final_inmobiliaria.ui.pagos;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp_final_inmobiliaria.model.Inmueble;
import com.example.tp_final_inmobiliaria.model.Pago;
import com.example.tp_final_inmobiliaria.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagosViewModel extends AndroidViewModel {
    private MutableLiveData<List<Pago>> pagos;
    private Context context;



    public PagosViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
    }

    public LiveData<List<Pago>> getPagos() {
        if(pagos == null){
            pagos = new MutableLiveData<List<Pago>>();
        }
        return pagos;
    }

    public void cargarPagos(){
        Call<List<Pago>> pagosRecibidos = ApiClient.getMyApiClient().pagosRecibidos(ApiClient.obtenerToken(context));
       pagosRecibidos.enqueue(new Callback<List<Pago>>() {
            @Override
            public void onResponse(Call<List<Pago>> call, Response<List<Pago>> response) {
                if(response.isSuccessful()){
                   pagos.postValue(response.body());
                   // Log.d("Pago", response.body().get(1).getNumPago()+" ");
                }else{
                    Toast.makeText(context, "inmuebles no encontrados", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Pago>>call, Throwable t) {
                Toast.makeText(context, "ocurrio un error", Toast.LENGTH_LONG).show();

            }
        });
    }

}