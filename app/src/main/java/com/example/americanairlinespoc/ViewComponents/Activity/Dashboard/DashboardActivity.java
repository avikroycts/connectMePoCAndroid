package com.example.americanairlinespoc.ViewComponents.Activity.Dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.americanairlinespoc.R;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Adapter.MyListAdapter;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Interfaces.DashboardView;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Model.DataModel;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Presenters.DashboardImplicator;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Presenters.LoginImplicator;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Utils.Constant.TYPE_HEADER;
import static com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Utils.Constant.TYPE_ITEM;


public class DashboardActivity extends AppCompatActivity  implements DashboardView {

    public static final String TAG_DASHBOARD = DashboardActivity.class
            .getSimpleName();

    private Context mContext;
    private DashboardImplicator mDashboardPresenter;


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
@BindView(R.id.recyclerView)
RecyclerView recyclerView;

private MyListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ButterKnife.bind(this);
        mContext = this;
        initView();
    }

    private void initView() {
        manageToolbarComponents();
        mDashboardPresenter = new DashboardImplicator(this, mContext);
        mDashboardPresenter.fetchList();
    }


    @Override
    public void onListFetchSuccess(ArrayList<DataModel> locationList) {
        adapter = new MyListAdapter(this, locationList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void manageToolbarComponents(){
        starter_toolbar_view.setVisibility(View.VISIBLE);
        right_toolbar_view.setVisibility(View.VISIBLE);
    }
}
