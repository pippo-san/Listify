package com.main.listify.ui.homeGruppo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeGruppoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeGruppoViewModel() {
        mText = new MutableLiveData<>();
       // mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}