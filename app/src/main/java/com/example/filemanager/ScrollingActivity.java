package com.example.filemanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        initAdapter();
        initRecyclerView();
    }

    private List<TaskItemEntry> getDataList(File dataFile) {
        File[] files = dataFile.listFiles();
        List<TaskItemEntry> data = new ArrayList<>();
        mRecyclerViewAdapter.setData(data);

        if (files != null) {
            for (File file : files) {
                TaskItemEntry taskItemEntry = new TaskItemEntry();
                taskItemEntry.title = file.getName();
                taskItemEntry.isDirectory = file.isDirectory();
                if (taskItemEntry.isDirectory) {
                    File[] childFiles = file.listFiles();
                    if (childFiles != null) {
                        taskItemEntry.summary = Integer.toString(childFiles.length);
                    } else {
                        taskItemEntry.summary = "0";
                    }
                } else {
                    taskItemEntry.summary = Long.toString(file.length());
                }
                data.add(taskItemEntry);
            }
        }

        mRecyclerViewAdapter.notifyDataSetChanged();
        return data;
    }

    private void initAdapter() {
        mRecyclerViewAdapter = new RecyclerViewAdapter(this, getDataList(Environment.getRootDirectory()));
        getDataList(Environment.getRootDirectory());
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setAdapter(mRecyclerViewAdapter);

//        mRecyclerView.addOnItemTouchListener();
    }

}
