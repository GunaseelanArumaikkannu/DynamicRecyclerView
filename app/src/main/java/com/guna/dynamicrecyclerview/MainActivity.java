package com.guna.dynamicrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    private int mColumnCount = 3;
    private RecyclerView recyclerView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        findViewById(R.id.btnAddColumn).setOnClickListener(this);
        findViewById(R.id.btnDecreaseColumn).setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        setLayoutManager();
        recyclerView.setAdapter(new CardsAdapter(DummyContent.ITEMS));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddColumn:
                mColumnCount++;
                setLayoutManager();
                break;
            case R.id.btnDecreaseColumn:
                mColumnCount--;
                setLayoutManager();
                break;
        }
    }

    private void setLayoutManager() {
        if (mColumnCount <= 1) {
            mColumnCount = 1;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
    }
}
