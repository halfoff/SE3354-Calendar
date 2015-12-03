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
    private Button btn_addEvent;
    private String dateSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Bundle extra = getIntent().getExtras();
        dateSelect = extra.getString("DateSelect");
       // int position = EventManager.getLastIndexAdded();
        CalendarCollect.date_collection_arr=new ArrayList<CalendarCollect>();
        CalendarCollect.date_collection_arr.add(new CalendarCollect(dateSelect,"Event"));
        getWidget();
    }

    public void getWidget()
    {
        btn_calender = (Button) findViewById(R.id.btn_calender);
        btn_addEvent = (Button)  findViewById(R.id.btn_addEvent);
        btn_calender.setOnClickListener(this);
        btn_addEvent.setOnClickListener(this);
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
                this.finish();

                break;
            case R.id.btn_addEvent:
                Intent addEventIntent = new Intent(ListViewActivity.this, AddEventActivity.class);
                addEventIntent.putExtra("DateSelect",dateSelect);
                startActivity(addEventIntent);
                break;
                //TODO:Add Button Event Actions
            default:
                break;
        }
    }
}
