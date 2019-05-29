package com.example.dell.h1810a_5_29_2;

import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.h1810a_5_29_2.adapter.MainAdapter;
import com.example.dell.h1810a_5_29_2.bean.Bean;
import com.example.dell.h1810a_5_29_2.dbutils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRel;
    private ArrayList<Bean> mList;
    private DbUtils mDbUtils;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbUtils = new DbUtils();
        initView();
//        initData();
        initquery();
    }

    private void initquery() {
        List<Bean> query = mDbUtils.query();
        mList.addAll(query);
        mMainAdapter.setList(mList);
        mMainAdapter.notifyDataSetChanged();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mList.add(new Bean(Long.valueOf(i), "数据" + i, R.mipmap.ic_launcher));
        }
        mDbUtils.insert(mList);
    }

    private void initView() {
        mRel = (RecyclerView) findViewById(R.id.rel);
        mList = new ArrayList<>();
        mMainAdapter = new MainAdapter(this, mList);
        mRel.setAdapter(mMainAdapter);
        mRel.setLayoutManager(new LinearLayoutManager(this));
    }
}
