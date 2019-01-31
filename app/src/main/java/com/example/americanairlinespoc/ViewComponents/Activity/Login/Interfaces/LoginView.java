package com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces;

import com.example.americanairlinespoc.ViewComponents.Activity.Login.Model.LocationModel;

import java.util.ArrayList;

public interface LoginView {
    void onSuccess(boolean isValidate);
    void onLocationFetchSuccess(ArrayList<LocationModel> locationList);
    void onRetrivingLocation(String locationName);

    // View communicator for Test
    String getUserNameTest();
    void showUserNameErrorTest(int user_id_empty);
}
