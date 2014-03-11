package com.cs.simpleproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Activity_NewGame extends Activity{
	private static final int LEVEL_EASY=0;
	private static final int LEVEL_MEDIUM=1;
	private static final int LEVEL_HARD=3;
	
	//final Context cont=getApplicationContext();
	
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
			onCreateDialog(LEVEL_EASY).show();
		}
	});
	
	button_medium.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			onCreateDialog(LEVEL_MEDIUM).show();	
		}
	});
	
	button_hard.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			onCreateDialog(LEVEL_HARD).show();	
		}
	});
	}
	
	private Dialog getChooseItemCheckedDialog(final int level) {
		final CharSequence[] items={"Section 1","Section 2","Section 3","Section 4"};
		/**
		 * Warning: ITEMS  3-> 2-> 1-> 0 
		 * 0. item selected "section 1 "
		 * */
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("Choose section");
		builder.setSingleChoiceItems(items,3,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub	
				if(level==LEVEL_EASY){}
				if(level==LEVEL_MEDIUM){}
				if(level==LEVEL_HARD){}
			}
		});
		builder.setSingleChoiceItems(items, 2,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
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
				if(level==LEVEL_EASY){}
				if(level==LEVEL_MEDIUM){}
				if(level==LEVEL_HARD){}
				dialog.dismiss();
			}
		});
		builder.setSingleChoiceItems(items, 0,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
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
		Dialog dialog =null;
		switch (id) {
		case LEVEL_EASY:
			dialog=getChooseItemCheckedDialog(LEVEL_EASY);
			break;
		case LEVEL_MEDIUM:
			dialog=getChooseItemCheckedDialog(LEVEL_MEDIUM);
			break;
		case LEVEL_HARD:
			dialog=getChooseItemCheckedDialog(LEVEL_HARD);
			break;
		default:
			dialog=null;
			break;
		}
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
