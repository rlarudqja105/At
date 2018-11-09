package com.example.user.at;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LikeActivity extends Activity {
    Skin skin;
    int color;
    String[] testTimes = {"2018.04.30 14:20", "2018.04.28 14:20", "2018.04.27 14:20", "2018.04.01 14:20", "2018.04.01 14:20"};
    String[] testTitles = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "bbbb", "cccc", "abcd", "555"};
    String[] testWriters = {"Tea", "Coffee", "Bean", "Tom", "behind"};
    String[] testfeedbacks = {"2", "3", "2", "1", "4"};

    TextView tvLikeTitle;
    ImageView btnLikeBack;
    ConstraintLayout loLikeHeader;
    RecyclerView myInfoRecycler;
    LinearLayoutManager layoutManager;
    MyInfoAdapter adapter;
    ArrayList<MyInfoItem> items;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        skin = new Skin(this);
        color = skin.skinSetting();
        setContentView(R.layout.my_writing_post);

        myInfoRecycler = (RecyclerView) findViewById(R.id.my_info_recycler);
        tvLikeTitle = findViewById(R.id.tvMyWriteTitle);
        btnLikeBack = findViewById(R.id.btnMyWriteBack);
        loLikeHeader = findViewById(R.id.loMyWriteHeader);

        tvLikeTitle.setText("관심있는 작품");
        loLikeHeader.setBackgroundColor(color);

        btnLikeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.stop_translate, R.anim.center_to_right_translate);
            }
        });

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        items = new ArrayList();
        for (int num = 0; num <= 4; num++) {
            items.add(new MyInfoItem(testTimes[num], testTitles[num], testWriters[num], testfeedbacks[num]));
        }
        ;

        myInfoRecycler.setLayoutManager(layoutManager);
        myInfoRecycler.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyInfoAdapter(items);
        myInfoRecycler.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.stop_translate, R.anim.center_to_right_translate);
    }
}
