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
/*I made the viewHolders in the xml file week_item named tv_weekDay and tv_weekEvent, so a ViewHolder will have to be made for 
TextView tv_weekDay;
TextView tv_weekEvent;
also, the forward and previous buttons in the xml activity week view are names ib_prevWeek and ib_nextWeek, so buttons will have to be made for those.
tv_weekOf needs a ViewHolder to simply state the range of days.  Set the string equal to current day, and when the loop = 6 in WeekViewActivity.
Finally, the loop should read into lv_weekly reading the day, from the date format, and the events.
*/
