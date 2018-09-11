package com.example.user.at;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by johan on 2018-06-05.
 */

public class MyWritingFeedbackActivity extends AppCompatActivity {
    Skin skin;
    int color;
    ListView my_writing_feedback_list;
    MyWritingListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        skin = new Skin(this);
        color = skin.skinSetting();
        setContentView(R.layout.my_writing_feedback);
        my_writing_feedback_list=(ListView)findViewById(R.id.my_writing_feedback_list);
        adapter = new MyWritingListAdapter(this,1);
        my_writing_feedback_list.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.stop_translate, R.anim.center_to_right_translate);
    }
    /*프래그먼트이던 시절
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.my_writing_feedback,container,false);
        my_writing_feedback_list=(ListView)view.findViewById(R.id.my_writing_feedback_list);
        adapter = new MyWritingListAdapter(getActivity(),1);
        my_writing_feedback_list.setAdapter(adapter);
        return view;
    }
    */
}
