package com.example.e_assess.ui.HomeAdmin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeAdminViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeAdminViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is admin home " +
                "");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
