package com.cs.simpleproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Activity_NewGame extends Activity{
	
	@Override
 	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.newgame);
	
	}
	@Override
	public void onBackPressed() {
		Intent setIntent =new  Intent(this, Activity_Main.class);
		
		   setIntent.addCategory(Intent.CATEGORY_HOME);
		   setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   startActivity(setIntent);
	}
}
