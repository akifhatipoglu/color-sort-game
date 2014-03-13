package com.cs.simpleproject;

import java.util.ArrayList;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.ImageColumns;
import android.provider.MediaStore.MediaColumns;
import android.view.View;
import android.widget.Button;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class image_HomeActivity extends image_BaseActivity {

	private ArrayList<String> imageUrls;
	Button imagegrid;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_home);
		imageLoader.init(ImageLoaderConfiguration.createDefault(this));

		final String[] columns = { MediaColumns.DATA, BaseColumns._ID };
		final String orderBy = ImageColumns.DATE_TAKEN;
		Cursor imagecursor = managedQuery(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
				null, orderBy + " DESC");

		this.imageUrls = new ArrayList<String>();

		for (int i = 0; i < imagecursor.getCount(); i++) {
			imagecursor.moveToPosition(i);
			int dataColumnIndex = imagecursor.getColumnIndex(MediaColumns.DATA);
			imageUrls.add(imagecursor.getString(dataColumnIndex));
		}

		imagegrid = (Button) findViewById(R.id.buton_grit);
		//imagegrid.setClickable(true);
		imagegrid.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(image_HomeActivity.this,
						image_GridActivity.class);
				intent.putExtra("images", imageUrls);
				startActivity(intent);
			}
		});
	}
	
	//Auto click
	@Override
    protected void onResume() {

		imagegrid.performClick();
        super.onResume();
    }
	@Override
	public void onBackPressed() {
		imageLoader.stop();
		super.onBackPressed();
	}
}