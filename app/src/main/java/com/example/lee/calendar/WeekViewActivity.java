package com.example.lee.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

import java.util.GregorianCalendar;

/**
 * Created by Jack on 12/4/2015.
 */
public class WeekViewActivity extends Activity implements OnClickListener {

    protected GregorianCalendar cal;
    private Button btn_calendar;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        Bundle extra =getIntent().getExtras();
        cal = (GregorianCalendar) GregorianCalendar.getInstance();
        cal.getFirstDayOfWeek();
        getWidget();


    }
    public void getWidget()
    {
        btn_calendar = (Button)findViewById(R.id.btn_calendarReturn);
        btn_calendar.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_calendarReturn:
                this.finish();
                break;
            default:
                break;
        }
    }


}
