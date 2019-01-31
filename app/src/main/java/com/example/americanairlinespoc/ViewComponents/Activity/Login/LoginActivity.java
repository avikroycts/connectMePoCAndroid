package com.example.americanairlinespoc.ViewComponents.Activity.Login;

import android.content.Context;

import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.DashboardActivity;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.americanairlinespoc.R;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Dialogs.LocationListDialogFragment;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.LoginView;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Model.LocationModel;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Presenters.LoginImplicator;

import java.util.ArrayList;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.user_id_edt)
    TextInputEditText user_id_edt;
    @BindView(R.id.password_edt)
    TextInputEditText password_edt;
    @BindView(R.id.login_btn)
    Button login_btn;
    @BindView(R.id.location_ll)
    LinearLayout location_ll;
    @BindView(R.id.location_tv)
    TextView location_tv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.starter_toolbar_view)
    LinearLayout starter_toolbar_view;
    @BindView(R.id.right_toolbar_view)
    LinearLayout right_toolbar_view;
    @BindView(R.id.toolbar_header_tv)
    TextView toolbar_header_tv;
    @BindView(R.id.imvLogo)
    ImageView imvLogo;

    public static final String TAG_LOGIN = LoginActivity.class
            .getSimpleName();

    private Context mContext;
    private LoginImplicator mLoginPresenter;
    private ArrayList<LocationModel> mLocationList;
    private LocationListDialogFragment dialog;

    private String userId= "";
    private String password= "";
    private String location= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        ButterKnife.bind(this);
        mContext = this;
        initView();
    }

    private void initView() {
        mLoginPresenter = new LoginImplicator(this, mContext);
        mLoginPresenter.fetchLocation();
        manageToolbarComponents();
    }

    @Override
    public void onSuccess(boolean isValidate) {
        if (isValidate) {
            Toast.makeText(mContext,"Success",Toast.LENGTH_LONG).show();
            mLoginPresenter.moveToNextView(mContext,DashboardActivity.class);
        } else {
            //Toast.makeText(mContext,"Something went wrong",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onLocationFetchSuccess(ArrayList<LocationModel> locationList) {
        this.mLocationList = locationList;
    }

    @Override
    public void onRetrivingLocation(String locationName) {
        if(dialog!=null && dialog.isVisible()){
            dialog.dismiss();
        }
        location_tv.setText(locationName);
    }

    @Override
    public String getUserNameTest() {
        return userId;
    }

    // JUnit Test Function
    @Override
    public void showUserNameErrorTest(int user_id_empty) {
Toast.makeText(mContext,getString(user_id_empty),Toast.LENGTH_LONG).show();
    }

    // JUnit Test Function
    @OnClick(R.id.login_btn)
    public void onLoginEventExecution() {
        userId = user_id_edt.getText().toString();
        password = password_edt.getText().toString();
        location = location_tv.getText().toString();
        mLoginPresenter.onValidate(user_id_edt.getText().toString(), password_edt.getText().toString(), location_tv.getText().toString());
        mLoginPresenter.onLoginButtonClickTest();
    }

    @OnTouch(R.id.location_ll)
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setAdapter();
                return true;
            case MotionEvent.ACTION_UP:
                return true;
        }
        return true;
    }

    private void setAdapter() {
        dialog = new LocationListDialogFragment();
        dialog.setInstance(mContext,this, mLocationList);
        dialog.show(getSupportFragmentManager(), "LocationListDialogFragment");
    }

    private void manageToolbarComponents(){
        starter_toolbar_view.setVisibility(View.VISIBLE);
        imvLogo.setVisibility(View.GONE);
        right_toolbar_view.setVisibility(View.GONE);
    }

}
