package com.example.filemanager;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    ImageView mIcon;
    TextView mTitleText;
    TextView mSummaryText;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mIcon = itemView.findViewById(R.id.item_icon);
        mTitleText = itemView.findViewById(R.id.item_text_title);
        mSummaryText = itemView.findViewById(R.id.item_text_summary);
    }
}
