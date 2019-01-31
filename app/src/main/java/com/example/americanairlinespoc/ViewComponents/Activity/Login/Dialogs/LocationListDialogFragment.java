package com.example.americanairlinespoc.ViewComponents.Activity.Login.Dialogs;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.americanairlinespoc.R;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Adapter.LocationRecyclerAdapter;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.LoginView;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.OnItemClickListener;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Model.LocationModel;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Presenters.LoginImplicator;

import java.util.ArrayList;

public class LocationListDialogFragment extends DialogFragment {

    private RecyclerView location_list_rv;
    private ArrayList<LocationModel> mLocationList;
    private Context mContext;
    private LinearLayoutManager linearLayoutManager;
    private LocationRecyclerAdapter locationAdapter;
    private LoginView mLoginView;

    public void setInstance(Context context, LoginView mLoginView, ArrayList<LocationModel> mLocationList) {
        this.mContext = context;
        this.mLocationList = mLocationList;
        this.mLoginView = mLoginView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.location_dialog, container, false);
        initView(v);

        return v;
    }

    private void initView(View v) {
        location_list_rv = v.findViewById(R.id.location_list_rv);
        linearLayoutManager = new LinearLayoutManager(mContext);
        location_list_rv.setLayoutManager(linearLayoutManager);

        locationAdapter = new LocationRecyclerAdapter(mContext, mLocationList, new OnItemClickListener() {
            @Override
            public void OnItemClick(LocationModel obj) {
                mLoginView.onRetrivingLocation(obj.getLocationName());

            }
        });
        location_list_rv.setAdapter(locationAdapter);
    }
}
