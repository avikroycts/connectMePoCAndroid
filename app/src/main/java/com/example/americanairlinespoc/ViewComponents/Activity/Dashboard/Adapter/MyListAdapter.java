package com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.americanairlinespoc.R;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Model.DataModel;
import com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Utils.Constant;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

import static com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Utils.Constant.TYPE_HEADER;
import static com.example.americanairlinespoc.ViewComponents.Activity.Dashboard.Utils.Constant.TYPE_ITEM;


public class MyListAdapter extends RecyclerView.Adapter{
    private ArrayList<DataModel> listdata;
    private Context mContext;


    public MyListAdapter(Context mContext, ArrayList<DataModel> listdata) {
        this.mContext = mContext;
        this.listdata = listdata;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);
                return new HeaderViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_inner_subitems, parent, false);
                return new ItemViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final DataModel myData = listdata.get(position);
        if (myData != null) {
            switch (myData.getItemType()) {
                case 1:
                    ((HeaderViewHolder) holder).tvGrade.setText(myData.getGrade());
                    if(myData.getId() == Constant.CURRENTLY_OPENED_ID) {
                        ((HeaderViewHolder) holder).ibExpand.setImageResource(R.drawable.ic_arrow_up);
                    } else {
                        ((HeaderViewHolder) holder).ibExpand.setImageResource(R.drawable.ic_arrow_down);
                    }
                    ((HeaderViewHolder) holder).ibExpand.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            float deg = ((HeaderViewHolder) holder).ibExpand.getRotation() + 180F;
                            ((HeaderViewHolder) holder).ibExpand.animate().rotation(deg).setInterpolator(new AccelerateDecelerateInterpolator());
                            if(Constant.CURRENTLY_OPENED_ID != myData.getId()) {
                                Constant.CURRENTLY_OPENED_ID = myData.getId();
                            } else {
                                Constant.CURRENTLY_OPENED_ID = 0;
                            }
                            notifyDataSetChanged();
                        }
                    });
                    break;
                case 2:
                    if(myData.getId() == Constant.CURRENTLY_OPENED_ID) {
                        ((ItemViewHolder) holder).llMain.setVisibility(View.VISIBLE);
                        ((ItemViewHolder) holder).llMain.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    } else {
                        ((ItemViewHolder) holder).llMain.setVisibility(View.GONE);
                        ((ItemViewHolder) holder).llMain.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
                    }

                    ((ItemViewHolder) holder).tvVal.setText(myData.getLabel());
                    break;
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (listdata.get(position).getItemType()) {
            case 1:
                return TYPE_HEADER;
            case 2:
                return TYPE_ITEM;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView tvGrade;
        public ImageButton ibExpand;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            this.tvGrade = itemView.findViewById(R.id.tvGrade);
            this.ibExpand = itemView.findViewById(R.id.ibExpand);
        }
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout llMain;
        public TextView tvVal;
        public ItemViewHolder(View itemView) {
            super(itemView);
            this.llMain = itemView.findViewById(R.id.llMain);
            this.tvVal = itemView.findViewById(R.id.tvVal);
        }
    }
}