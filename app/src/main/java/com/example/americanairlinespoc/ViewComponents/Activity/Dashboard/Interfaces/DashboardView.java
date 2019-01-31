package com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Interfaces;

import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Model.DataModel;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Model.LocationModel;

import java.util.ArrayList;

public interface DashboardView {
    void onListFetchSuccess(ArrayList<DataModel> locationList);
}
