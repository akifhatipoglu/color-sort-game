package com.cs.simpleproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_SelectAlgorithm extends Activity {
	private int level = 0, section = 0;
	private static final int Scalar_Quantization = 1;
	private static final int Median_Cut = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.algorithm);
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		Bundle gelenVeri = intent.getExtras();
		level = gelenVeri.getInt("level");
		section = gelenVeri.getInt("section");

		Button button_Scalar = (Button) findViewById(R.id.button_Scalar);
		button_Scalar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activity_SelectAlgorithm.this,
						image_HomeActivity.class);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				intent.putExtra("algorithm", Scalar_Quantization);
				startActivity(intent);
			}
		});

		Button button_Median = (Button) findViewById(R.id.button_Median);
		button_Median.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Activity_SelectAlgorithm.this,
						image_HomeActivity.class);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				intent.putExtra("algorithm", Median_Cut);
				startActivity(intent);
			}
		});

	}

	@Override
	public void onBackPressed() {
		Intent setIntent = new Intent(this, Activity_NewGame.class);
		setIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(setIntent);
	}

}
