package com.example.tp_final_inmobiliaria.ui;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp_final_inmobiliaria.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

        private Context context;
        private MutableLiveData<String> error;
        private MutableLiveData<Boolean> login;

    public MainActivityViewModel(@NonNull Application application) {
            super(application);
            context= application.getApplicationContext();
        }
        public LiveData<Boolean> getLogin() {
        if(login == null){
            login = new MutableLiveData<>();
        }
        return login;
       }

        public LiveData<String> getError() {
            if(error == null){
                error = new MutableLiveData<>();
            }
            return error;
        }

        public void autenticar( String clave, String email){
            Call<String> respuesta = ApiClient.getMyApiClient().login(clave,email);
            respuesta.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if(response.isSuccessful()){
                        Log.d("Token", response.body());
                        SharedPreferences sp= context.getSharedPreferences("token.dat",0);
                        SharedPreferences.Editor editor= sp.edit();
                        editor.putString("token","Bearer "+response.body());
                        editor.commit();
                        login.setValue(true);
                    }
                    else {
                        error.setValue("Usuario o contraseña incorrecto");
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("Token", "salida incorrecta "+t.getMessage());
                }
            });
        }



    }
