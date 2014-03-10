package com.cs.simpleproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity_NewGame extends Activity{
	private static final int LEVEL_EASY=0;
	private static final int LEVEL_MEDIUM=1;
	private static final int LEVEL_HARD=3;
	private static final int DIALOG=0;
	
	final Context cont=getApplicationContext();
	
	@Override
 	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.newgame);
	
	Button button_easy=(Button) findViewById(R.id.button_Easy);
	Button button_medium=(Button) findViewById(R.id.button_Medium);
	Button button_hard=(Button) findViewById(R.id.button_Hard);
	
	button_easy.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			onCreateDialog(LEVEL_EASY);
			Toast.makeText(cont, "as", Toast.LENGTH_LONG).show();
		}
	});
	
	button_medium.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			onCreateDialog(LEVEL_MEDIUM);	
		}
	});
	
	button_hard.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			onCreateDialog(LEVEL_HARD);	
		}
	});
	}
	
	protected Dialog getChooseItemCheckedDialog(final int level) {
		final CharSequence[] items={"Section 1","Section 2","Section 3","Section 4"};
		
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("Choose section");
		builder.setSingleChoiceItems(items, 0,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(cont, items[0], Toast.LENGTH_LONG).show();
				if(level==LEVEL_EASY){}
				if(level==LEVEL_MEDIUM){}
				if(level==LEVEL_HARD){}
				dialog.dismiss();
			}
		});
		builder.setSingleChoiceItems(items, 1,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(cont, items[0], Toast.LENGTH_LONG).show();
				if(level==LEVEL_EASY){}
				if(level==LEVEL_MEDIUM){}
				if(level==LEVEL_HARD){}
				dialog.dismiss();
			}
		});
		builder.setSingleChoiceItems(items, 2,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(cont, items[0], Toast.LENGTH_LONG).show();
				if(level==LEVEL_EASY){}
				if(level==LEVEL_MEDIUM){}
				if(level==LEVEL_HARD){}
				dialog.dismiss();
			}
		});
		builder.setSingleChoiceItems(items, 3,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(cont, items[0], Toast.LENGTH_LONG).show();
				if(level==LEVEL_EASY){}
				if(level==LEVEL_MEDIUM){}
				if(level==LEVEL_HARD){}
				dialog.dismiss();
			}
		});
		
		return builder.create();
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog =getChooseItemCheckedDialog(id);
		
		return dialog;
	}
	
	@Override
	public void onBackPressed() {
		Intent setIntent =new  Intent(this, Activity_Main.class);
		
		   setIntent.addCategory(Intent.CATEGORY_HOME);
		   setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		   startActivity(setIntent);
	}
}
