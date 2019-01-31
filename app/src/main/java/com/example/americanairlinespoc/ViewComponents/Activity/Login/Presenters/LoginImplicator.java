package com.example.americanairlinespoc.ViewComponents.Activity.Login.Presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.americanairlinespoc.R;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.DashboardActivity;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.LoginInteractor;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.LoginView;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Model.LocationModel;

import java.util.ArrayList;

public class LoginImplicator implements LoginInteractor {
    private LoginView viewInterface;
    private ArrayList<LocationModel> locationList;
    private Context context;
    public LoginImplicator(LoginView viewInf, Context mContext){
        this.viewInterface = viewInf;
        this.context = mContext;
    }
    @Override
    public void onValidate(String username, String password, String location) {
        viewInterface.onSuccess(validateInputs(username,password,location));
    }

    @Override
    public void fetchLocation() {
        locationList = new ArrayList<>();
        LocationModel model = new LocationModel();
        model.setLocationId("1");
        model.setLocationName("JFK");
        locationList.add(model);

        LocationModel model1 = new LocationModel();
        model1.setLocationId("2");
        model1.setLocationName("LGA");
        locationList.add(model1);

        LocationModel model2 = new LocationModel();
        model2.setLocationId("3");
        model2.setLocationName("LAX");
        locationList.add(model2);

        LocationModel model3 = new LocationModel();
        model3.setLocationId("4");
        model3.setLocationName("ORD");
        locationList.add(model3);

        LocationModel model4 = new LocationModel();
        model4.setLocationId("5");
        model4.setLocationName("EWR");
        locationList.add(model4);

        viewInterface.onLocationFetchSuccess(locationList);
    }

    @Override
    public void moveToNextView(Context context, Class viewClass) {
        Intent in  = new Intent(context, viewClass);
        context.startActivity(in);
    }


    // JUnit Test for onLoginButton Clicked
    @Override
    public void onLoginButtonClickTest() {
        String getUserId =  viewInterface.getUserNameTest();
        if(getUserId.isEmpty()){
            viewInterface.showUserNameErrorTest(R.string.user_id_empty);
        }
    }


    boolean validateInputs(String username, String password, String location){

        if(username.trim().isEmpty()){
            Toast.makeText(context,context.getResources().getString(R.string.user_id_empty),Toast.LENGTH_LONG).show();
            return false;
        }else if(password.trim().isEmpty()){
            Toast.makeText(context,context.getResources().getString(R.string.user_password_empty),Toast.LENGTH_LONG).show();
            return false;
        } else if(location.trim().isEmpty()){
            Toast.makeText(context,context.getResources().getString(R.string.user_location_empty),Toast.LENGTH_LONG).show();
            return false;
        } else{
            return  true;
        }


    }
}
