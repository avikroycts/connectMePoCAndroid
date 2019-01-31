package com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Presenters;

import android.content.Context;
import android.widget.Toast;

import com.example.americanairlinespoc.R;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Interfaces.DashboardInteractor;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Interfaces.DashboardView;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Model.DataModel;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.LoginInteractor;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.LoginView;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Model.LocationModel;

import java.util.ArrayList;

import static com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Utils.Constant.TYPE_HEADER;
import static com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Utils.Constant.TYPE_ITEM;

public class DashboardImplicator implements DashboardInteractor {
    private DashboardView viewInterface;
    private ArrayList<LocationModel> locationList;
    private Context context;
    private ArrayList<DataModel> list;
    public DashboardImplicator(DashboardView viewInf, Context mContext){
        this.viewInterface = viewInf;
        this.context = mContext;
    }


    @Override
    public void fetchList() {
        list = new ArrayList<>();

        DataModel model = new DataModel();
        model.setItemType(TYPE_HEADER);
        model.setGrade("Grade A");
        model.setId(1);
        list.add(model);

        DataModel model2 = new DataModel();
        model2.setItemType(TYPE_ITEM);
        model2.setLabel("One");
        model2.setId(1);
        list.add(model2);

        DataModel model3 = new DataModel();
        model3.setItemType(TYPE_ITEM);
        model3.setLabel("Two");
        model3.setId(1);
        list.add(model3);

        DataModel model4 = new DataModel();
        model4.setItemType(TYPE_HEADER);
        model4.setGrade("Grade B");
        model4.setId(2);
        list.add(model4);
        DataModel model5 = new DataModel();
        model5.setItemType(TYPE_ITEM);
        model5.setLabel("One");
        model5.setId(2);
        list.add(model5);
        DataModel model6 = new DataModel();
        model6.setItemType(TYPE_ITEM);
        model6.setLabel("Two");
        model6.setId(2);
        list.add(model6);

        DataModel model7 = new DataModel();
        model7.setItemType(TYPE_HEADER);
        model7.setGrade("Grade C");
        model7.setId(3);
        list.add(model7);
        DataModel model8 = new DataModel();
        model8.setItemType(TYPE_ITEM);
        model8.setLabel("One");
        model8.setId(3);
        list.add(model8);


        DataModel model10 = new DataModel();
        model10.setItemType(TYPE_HEADER);
        model10.setGrade("Grade D");
        model10.setId(4);
        list.add(model10);
        DataModel model11 = new DataModel();
        model11.setItemType(TYPE_ITEM);
        model11.setLabel("One");
        model11.setId(4);
        list.add(model11);
        DataModel model12 = new DataModel();
        model12.setItemType(TYPE_ITEM);
        model12.setLabel("Two");
        model12.setId(4);
        list.add(model12);
        DataModel model13 = new DataModel();
        model13.setItemType(TYPE_ITEM);
        model13.setLabel("Two");
        model13.setId(4);
        list.add(model13);


        viewInterface.onListFetchSuccess(list);
    }


}
