package com.example.tp_final_inmobiliaria.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.tp_final_inmobiliaria.model.Contrato;
import com.example.tp_final_inmobiliaria.model.Inmueble;
import com.example.tp_final_inmobiliaria.model.Inquilino;
import com.example.tp_final_inmobiliaria.model.Propietario;
import com.example.tp_final_inmobiliaria.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClient {

    private static final String PATH="http:///192.168.1.143:45457/api/";
    private static  MyApiInterface myApiInteface;

    public static MyApiInterface getMyApiClient(){

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").setLenient().create();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
    }


    public interface MyApiInterface {

        //Propietarios
        @FormUrlEncoded
        @POST("propietarios/login")
        Call<String>login(@Field("Email") String email, @Field("Clave") String clave);

        @GET("propietarios")
        Call<Propietario>propietarioActual(@Header("Authorization") String token);

        @PUT("propietarios")
        Call<Propietario> editarPropietario(@Header("Authorization") String token,@Body Propietario propietario);

        @PUT("usuarios")
        Call<Usuario> cambiarContraseña(@Header("Authorization") String token, @Body Usuario usuario);

        //Inmuebles
        @GET("inmuebles")
        Call<List<Inmueble>> inmueblesPropios(@Header("Authorization") String token);

        @GET("inmuebles/{id}")
        Call<Inmueble> inmuebleVer(@Header("Authorization") String token,@Path("id") int id);

        @PUT("Inmuebles/disponible/{id}")
        Call<Inmueble> disponibilidad(@Header("Authorization") String token,@Path("id") int id);

        //Contratos
        @GET("Contratos/Vigente")
        Call<List<Contrato>> obtenerVigentes(@Header("Authorization") String token);

        //Inquiinos actuales
        @GET("inquilinos")
        Call<List<Contrato>> obtenerInquilinos(@Header("Authorization") String token );

    }

    public static String obtenerToken(Context contexto){
        SharedPreferences sp = contexto.getSharedPreferences("token.dat",0);
        return sp.getString("token", "token no encontrado");

    }

    }


