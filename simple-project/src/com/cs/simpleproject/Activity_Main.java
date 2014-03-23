package com.cs.simpleproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Main extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button_newGame = (Button) findViewById(R.id.button_NewGame);
		button_newGame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activity_Main.this,
						Activity_NewGame.class);
				startActivity(intent);
				Activity_Main.this.finish();
			}
		});
		Button button_score = (Button) findViewById(R.id.button_Score);
		button_score.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activity_Main.this,
						Activity_Score.class);
				startActivity(intent);
				Activity_Main.this.finish();
			}
		});

		Button button_exit = (Button) findViewById(R.id.button_Exit);
		button_exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		finish();
	}
}