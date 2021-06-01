package com.example.tp_final_inmobiliaria.ui.Inquilinos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InquilinoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InquilinoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Inquilinos fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}