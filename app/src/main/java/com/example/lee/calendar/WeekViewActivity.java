package com.example.lee.calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * Created by Jack on 12/4/2015.
 */
public class WeekViewActivity extends Activity implements OnClickListener {


    private Button btn_calendar;
    private ArrayList<CalendarEvent>[] eventsEachDay;//HAs the events for each day

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        eventsEachDay = new ArrayList[7];//The current day should be index[0]
        Calendar today = new GregorianCalendar();
        for (int i = 0; i < 7; i++) {

            String d = formatter.format(today.getTime());

            eventsEachDay[i] = EventManager.getEventsOnDate(d);
            today.add(Calendar.DAY_OF_MONTH, 1);
        }

        getWidget();


    }

    public void getWidget() {
        btn_calendar = (Button) findViewById(R.id.btn_calendarReturn);
        btn_calendar.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
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
