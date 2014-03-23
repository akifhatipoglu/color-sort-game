package com.cs.simpleproject;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Activity_Score extends Activity {
	List<String> list=new LinkedList<String>();
	Database db=new Database(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
	super.onCreate(savedInstanceState);
	setContentView(R.layout.score);
	list=db.getAllScore();
	ArrayAdapter<String> as=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
	ListView lt=(ListView) findViewById(R.id.listView_score);
	lt.setAdapter(as);
	
	
	}
	@Override
	public void onBackPressed() {
		Intent intent = new Intent(Activity_Score.this,
				Activity_Main.class);
		startActivity(intent);
		Activity_Score.this.finish();
	}
}
