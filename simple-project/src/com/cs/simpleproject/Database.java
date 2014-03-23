package com.cs.simpleproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper  {
	private static final String LOGCAT = null;

	public Database(Context applicationcontext) {
        super(applicationcontext, "androidsqlite.db", null, 1);
        Log.d(LOGCAT,"Created");
    }
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		String query;
		query = "CREATE TABLE animals ( ScoreID INTEGER PRIMARY KEY, Level TEXT,Score INTEGER)";
		arg0.execSQL(query);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		String query;
		query = "DROP TABLE IF EXISTS animals";
		arg0.execSQL(query);
        onCreate(arg0);
	}
	
	public void addScore(String level,int score)
	{
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("Level",level);
		values.put("Score",score);
		database.insert("animals", null, values);
		database.close();
	}
	
	 public List<String> getAllScore() {
		 List<String> list = new ArrayList<String>();
		 String selectQuery = "SELECT  * FROM animals";
		    SQLiteDatabase database = this.getWritableDatabase();
		    Cursor cursor = database.rawQuery(selectQuery, null);
		    cursor.moveToFirst();
			 while (!cursor.isAfterLast()) {
			      String puan=cursor.getString(0)+" "+cursor.getString(1)+" "+cursor.getString(2);
			      list.add(puan);
			      cursor.moveToNext();
			 }
		    cursor.close();
		 return list;
	 }

}
