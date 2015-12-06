package com.example.lee.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jack on 12/6/2015.
 */
public class WeekAdapter extends ArrayAdapter<WeekCollect> {
    private final Context context;
    private final ArrayList<WeekCollect> values;
    private ViewHolder viewHolder;
    private final int resourceId;

    public WeekAdapter(Context context, int resourceId,ArrayList<WeekCollect> values)
    {
        super(context, resourceId, values);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.values = values;
        this.resourceId = resourceId;
        viewHolder = new ViewHolder();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resourceId, parent, false);

            viewHolder.tv_weekDay = (TextView) convertView.findViewById(R.id.tv_weekDay);
            viewHolder.tv_weekEvent = (TextView) convertView.findViewById(R.id.tv_weekEvent);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        this.clearWeekEvent();
        WeekCollect list_obj=values.get(position);
        //viewHolder.tv_date.setText(list_obj.date);
       // viewHolder.tv_weekEvent.setText(list_obj.event_message);
        for(int i=0; i<list_obj.event_message.size();i++)
        {
            viewHolder.tv_weekEvent.append(list_obj.event_message.get(i));

        }
        return convertView;

    }
    public void clearWeekEvent()
    {
        viewHolder.tv_weekEvent.setText("");
    }



    public class ViewHolder
    {
        TextView tv_weekEvent;
        TextView tv_weekDay;
    }
}


