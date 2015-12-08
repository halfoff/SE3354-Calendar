package com.example.lee.calendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.*;
import android.provider.BaseColumns;

import java.text.SimpleDateFormat;

/**
 * Created by randallblake on 12/3/15.
 */
public final class CalendarSQLite extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "calendar.db";
    public static final String TABLE_NAME = "calendar";
    public static final String COLUMN_NAME_TITLE = "title";
    public static final String COLUMN_NAME_START = "start";
    public static final String COLUMN_NAME_END = "end";
    public static final String COLUMN_NAME_TYPE = "type";

    public CalendarSQLite(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table if not exists calendar " +
                        "(id integer primary key, title text, start text, end text, type integer)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS calendar");
        onCreate(db);
    }

    public boolean insertCalendar(CalendarEvent calEvent)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", calEvent.getTitle());
        contentValues.put("start", calEvent.getStart().toString());
        //contentValues.put("end", calEvent.getEnd().toString());
        //contentValues.put("type", calEvent.getRepeat().toString());
        db.insert("calendar", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from calendar where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public void getAllEvents()
    {
        System.out.println(numberOfRows());
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from calendar", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            String title = res.getString(res.getColumnIndex(COLUMN_NAME_TITLE));
            String start = res.getString(res.getColumnIndex(COLUMN_NAME_START));
            System.out.println(start);
            String end = res.getString(res.getColumnIndex(COLUMN_NAME_END));
            EventType et = EventType.values()[res.getInt(res.getColumnIndex(COLUMN_NAME_TYPE))];
            CalendarEvent calEvent = new CalendarEvent(title);
            SimpleDateFormat sdf = new SimpleDateFormat();
            try {
                calEvent.setStart(sdf.parse(start));
                calEvent.setEnd(sdf.parse(end));
            } catch (Exception e) {}
            //TODO: read in type
            EventManager.addEvent(calEvent);
            res.moveToNext();
        }
    }
/*
    public static void createTable() {
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE calendar (" +
                    "ID INT PRIMARY KEY," +
                    "TITLE TEXT," +
                    "START TEXT," +
                    "END TEXT," +
                    "TYPE INT);";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.exit(-2);
        }

    }

    public static void writeSQL(CalendarEvent calEvent) {
        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO calendar (ID,TITLE,START,END,TYPE)" +
                    "VALUES (" + uid++ + ", " + "'" + calEvent.getTitle() + "', " +
                    "'" + calEvent.getStart() + "', " + "'" + calEvent.getEnd() + "', " +
                    calEvent.getEventType() + ");";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.exit(-3);
        }
    }

    public static void readSQL() {
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM calendar;");
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String start = rs.getString("start");
                String end = rs.getString("end");
                int type = rs.getInt("type");
                CalendarEvent calEvent = new CalendarEvent(title);
                SimpleDateFormat sdf = new SimpleDateFormat();
                calEvent.setStart(sdf.parse(start));
                calEvent.setEnd(sdf.parse(end));
                //TODO: read in type
                EventManager.addEvent(calEvent);
            }
            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.exit(-4);
        }
    }
*/
}
