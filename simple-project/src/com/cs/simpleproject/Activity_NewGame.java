package com.cs.simpleproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_NewGame extends Activity {
	private static final int LEVEL_EASY = 0;
	private static final int LEVEL_MEDIUM = 1;
	private static final int LEVEL_HARD = 3;

	// final Context cont=getApplicationContext();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);

		Button button_easy = (Button) findViewById(R.id.button_Easy);
		Button button_medium = (Button) findViewById(R.id.button_Medium);
		Button button_hard = (Button) findViewById(R.id.button_Hard);

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
		final CharSequence[] items = { "Section 1", "Section 2", "Section 3",
				"Section 4" };
		/**
		 * Warning: ITEMS 3-> 2-> 1-> 0 0. item selected "section 1 "
		 * */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Choose section");
		builder.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							gotoimageactivity(1, level);
							break;
						case 1:
							gotoimageactivity(2, level);
							break;
						case 2:
							gotoimageactivity(3, level);
							break;
						case 3:
							gotoimageactivity(4, level);
							break;
						default:
							break;
						}
						dialog.dismiss();
					}

				});

		return builder.create();
	}

	/*
	 * level ve section pun extra ile iletilmeli oyun kýsmýna *
	 */
	private void gotoimageactivity(int section, int level) {
		if (level == LEVEL_EASY) {
			Intent intent = new Intent(Activity_NewGame.this,
					Activity_SelectAlgorithm.class);
			intent.putExtra("level",level);
			intent.putExtra("section",section);
			startActivity(intent);
		}
		if (level == LEVEL_MEDIUM) {
			Intent intent = new Intent(Activity_NewGame.this,
					Activity_SelectAlgorithm.class);
			intent.putExtra("level",level);
			intent.putExtra("section",section);
			startActivity(intent);
		}
		if (level == LEVEL_HARD) {
			Intent intent = new Intent(Activity_NewGame.this,
					Activity_SelectAlgorithm.class);
			intent.putExtra("level",level);
			intent.putExtra("section",section);
			startActivity(intent);
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		switch (id) {
		case LEVEL_EASY:
			dialog = getChooseItemCheckedDialog(LEVEL_EASY);
			break;
		case LEVEL_MEDIUM:
			dialog = getChooseItemCheckedDialog(LEVEL_MEDIUM);
			break;
		case LEVEL_HARD:
			dialog = getChooseItemCheckedDialog(LEVEL_HARD);
			break;
		default:
			dialog = null;
			break;
		}
		return dialog;
	}

	@Override
	public void onBackPressed() {
		Intent setIntent = new Intent(this, Activity_Main.class);
		setIntent.addCategory(Intent.CATEGORY_HOME);
		setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(setIntent);
	}
}
