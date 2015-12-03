package com.example.lee.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.app.ActivityCompat.startActivity;

public class CalendarAdapter extends BaseAdapter
{
    private Context context;
    private java.util.Calendar month;
    public GregorianCalendar previousMonth;
    public GregorianCalendar previousMonthMaxSet;
    private GregorianCalendar selectedDate;
    int firstDay;
    int maxWeeknumber;
    int maxPrevious;
    int calendarMaxPrevious;
    int monthLength;
    String itemValue;
    String currentDateString;
    DateFormat dateFormat;

    private ArrayList<String> items;
    public static List<String> day_string;
    private View previousView;
    public ArrayList<CalendarCollect>  date_collection_arr= new ArrayList<CalendarCollect>();
    public ArrayList<Integer> first = new ArrayList<Integer>();
    int l = first.size();
    public CalendarAdapter(Context context, GregorianCalendar monthCalendar,ArrayList<CalendarCollect> date_collection_arr)
    {
        this.date_collection_arr = date_collection_arr;
        CalendarAdapter.day_string = new ArrayList<String>();
        month = monthCalendar;
        selectedDate = (GregorianCalendar) monthCalendar.clone();
        this.context = context;
        month.set(GregorianCalendar.DAY_OF_MONTH, 1);
        Locale.setDefault(Locale.US);
        this.items = new ArrayList<String>();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        currentDateString = dateFormat.format(selectedDate.getTime());
        refreshDays();
    }

    public void setItems(ArrayList<String> items)
    {
        for (int i = 0; i != items.size(); i++)
        {
            if (items.get(i).length() == 1)
            {
                items.set(i, "0" + items.get(i));
            }
        }
        this.items = items;
    }

    public int getCount()
    {
        return day_string.size();
    }

    public Object getItem(int position)
    {
        return day_string.get(position);
    }

    public long getItemId(int position)
    {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        TextView dayView;
        if (convertView == null)
        {
            LayoutInflater viewInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = viewInflator.inflate(R.layout.calendar_item, null);
        }

        dayView = (TextView) view.findViewById(R.id.date);
        String[] separatedTime = day_string.get(position).split("-");
        String gridvalue = separatedTime[2].replaceFirst("^0*", "");
        if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay))
        {
            dayView.setTextColor(Color.GRAY);
            dayView.setClickable(false);
            dayView.setFocusable(false);
        }
        else if ((Integer.parseInt(gridvalue) < 7) && (position > 28))
        {
            dayView.setTextColor(Color.GRAY);
            dayView.setClickable(false);
            dayView.setFocusable(false);
        }
        else
        {
            dayView.setTextColor(Color.WHITE);
        }

        if (day_string.get(position).equals(currentDateString))
        {
            view.setBackgroundColor(Color.CYAN);
        }
        else
        {
            view.setBackgroundColor(Color.parseColor("#343434"));
        }

        dayView.setText(gridvalue);
        String date = day_string.get(position);
        if (date.length() == 1)
        {
            date = "0" + date;
        }
        String monthString = "" + (month.get(GregorianCalendar.MONTH) + 1);
        if (monthString.length() == 1) {
            monthString = "0" + monthString;
        }
        setEventView(view, position,dayView);
        return view;
    }

    public View setSelected(View view,int position)
    {
        if (previousView != null)
        {
            previousView.setBackgroundColor(Color.parseColor("#343434"));
        }
        view.setBackgroundColor(Color.CYAN);
        int length = day_string.size();
        if (length > position)
        {
            if (day_string.get(position).equals(currentDateString))
            {
            }
            else
            {
                previousView = view;
            }
        }

        return view;
    }



    public void refreshDays()
    {
        items.clear();
        day_string.clear();
        Locale.setDefault(Locale.US);
        previousMonth = (GregorianCalendar) month.clone();
        firstDay = month.get(GregorianCalendar.DAY_OF_WEEK);
        maxWeeknumber = month.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        monthLength = maxWeeknumber * 7;
        maxPrevious = getMaxPrevious();
        calendarMaxPrevious = maxPrevious - (firstDay - 1);
        previousMonthMaxSet = (GregorianCalendar) previousMonth.clone();
        previousMonthMaxSet.set(GregorianCalendar.DAY_OF_MONTH, calendarMaxPrevious + 1);
        for (int n = 0; n < monthLength; n++)
        {
            itemValue = dateFormat.format(previousMonthMaxSet.getTime());
            previousMonthMaxSet.add(GregorianCalendar.DATE, 1);
            day_string.add(itemValue);
        }
    }

    private int getMaxPrevious()
    {
        int maxPrevious;
        if (month.get(GregorianCalendar.MONTH) == month.getActualMinimum(GregorianCalendar.MONTH))
        {
            previousMonth.set((month.get(GregorianCalendar.YEAR) - 1),
                    month.getActualMaximum(GregorianCalendar.MONTH), 1);
        }
        else
        {
            previousMonth.set(GregorianCalendar.MONTH, month.get(GregorianCalendar.MONTH) - 1);
        }
        maxPrevious = previousMonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        return maxPrevious;
    }

    public void setEventView(View view,int position,TextView txt)
    {
        int length = CalendarCollect.date_collection_arr.size();
        for (int i = 0; i < length; i++)
        {
            CalendarCollect calendar_object = CalendarCollect.date_collection_arr.get(i);
            String date = calendar_object.date;
            int length1 = day_string.size();
            if (length1 > position)
            {
                if (day_string.get(position).equals(date))
                {
                    //EventManager.addEvent(new CalendarEvent());
                    view.setBackgroundColor(Color.parseColor("#343434"));
                    txt.setTextColor(Color.RED);
                }
            }
        }
    }

    public void getPositionList(String date,final Activity act)
    {
        int length = CalendarCollect.date_collection_arr.size();
        for (int i = 0; i < length; i++)
        {
            CalendarCollect calendar_collection = CalendarCollect.date_collection_arr.get(i);
            String event_date = calendar_collection.date;
            String event_message = calendar_collection.event_message;
            if (date.equals(event_date))
            {
                Toast.makeText(context, "Event: " + event_date, Toast.LENGTH_LONG).show();
                new AlertDialog.Builder(context).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Date: "+event_date).setMessage("Event: "+event_message).setPositiveButton("OK",new android.content.DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        act.finish();
                    }
                }).show();
                break;
            }
            else
            {
            }
        }
    }
}
