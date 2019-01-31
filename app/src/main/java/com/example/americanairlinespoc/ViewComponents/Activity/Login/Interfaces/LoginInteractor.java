package com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces;

import android.content.Context;

public interface LoginInteractor {
    void onValidate(String username, String password,String location);
    void fetchLocation();
    void moveToNextView(Context context, Class viewClass);

// Interface for OnButton Click
    void onLoginButtonClickTest();
}
