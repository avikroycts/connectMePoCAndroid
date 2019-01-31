package com.example.americanairlinespoc.ViewComponents.Activity.Login.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.americanairlinespoc.R;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Interfaces.OnItemClickListener;
import com.example.americanairlinespoc.ViewComponents.Activity.Login.Model.LocationModel;

import java.util.ArrayList;

public class LocationRecyclerAdapter extends RecyclerView.Adapter<LocationRecyclerAdapter.MyViewHolder> {

    private ArrayList<LocationModel> mLocationList;
    private Context context;
    private OnItemClickListener listener;

    public LocationRecyclerAdapter(Context context, ArrayList<LocationModel> locationList,OnItemClickListener mListener) {
        this.context = context;
        this.mLocationList = locationList;
        this.listener = mListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.location_dialog_item_inflater, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        myViewHolder.populateItem(myViewHolder,position);
    }


    @Override
    public int getItemCount() {
        if (mLocationList != null)
            return mLocationList.size();
        else
            return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView location_name_tv;
        public LinearLayout main_item_ll;

        public MyViewHolder(View view) {
            super(view);
            main_item_ll = (LinearLayout)view.findViewById(R.id.main_item_ll);
            location_name_tv = (TextView) view.findViewById(R.id.location_name_tv);
        }

        public void populateItem(MyViewHolder item, final int position) {
            location_name_tv.setText(mLocationList.get(position).getLocationName());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.OnItemClick(mLocationList.get(position));
                }
            });
        }

    }

}
