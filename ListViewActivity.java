// list view activity

package com.example.lee.calendar;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ListViewActivity extends Activity implements OnClickListener
{
    private ListView lv_android;
    private AndroidAdapter list_adapter;
    private Button btn_calender;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        CalendarCollect.date_collection_arr=new ArrayList<CalendarCollect>();
        CalendarCollect.date_collection_arr.add(new CalendarCollect("yyyy-mm-dd","Event"));
        getWidget();
    }

    public void getWidget()
    {
        btn_calender = (Button) findViewById(R.id.btn_calender);
        btn_calender.setOnClickListener(this);
        lv_android = (ListView) findViewById(R.id.lv_android);
        list_adapter = new AndroidAdapter(ListViewActivity.this,R.layout.list_item, CalendarCollect.date_collection_arr);
        lv_android.setAdapter(list_adapter);
    }

    @Override
    public void onClick(View view)
    {
        // TODO Auto-generated method stub
        switch (view.getId())
        {
            case R.id.btn_calender:
                startActivity(new Intent(ListViewActivity.this,Calendar.class));
                break;
            default:
                break;
        }
    }
}