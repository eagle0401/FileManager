package com.example.filemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<TaskItemEntry> mNonGroupData;

    public RecyclerViewAdapter(Context context) {
        this(context,new ArrayList<TaskItemEntry>());
    }

    public RecyclerViewAdapter(Context context,List<TaskItemEntry> data) {
        mContext = context;
        mNonGroupData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        return new RecyclerViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof RecyclerViewHolder) {
            TaskItemEntry taskItemEntry = mNonGroupData.get(position);
            RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) viewHolder;
            recyclerViewHolder.mIcon.setImageResource(taskItemEntry.isDirectory ? android.R.drawable.ic_menu_week : android.R.drawable.ic_media_next);
            recyclerViewHolder.mTitleText.setText(taskItemEntry.title);
            recyclerViewHolder.mSummaryText.setText(taskItemEntry.summary);
        }
    }

    @Override
    public int getItemCount() {
        return mNonGroupData.size();
    }

    public void setData(List<TaskItemEntry> data) {
        mNonGroupData = data;
    }
}
