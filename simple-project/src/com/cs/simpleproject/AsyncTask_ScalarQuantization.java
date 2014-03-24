package com.cs.simpleproject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class AsyncTask_ScalarQuantization extends
		AsyncTask<String, String, List<String>> {

	private Context context;
	private ProgressDialog progressDialog;
	private static int IMG_WIDTH = 400;
	private static int IMG_HEIGHT = 300;
	private int level = 0, section = 0;
	String file_path = "";
	Set<String> s = new HashSet<String>();
	List<String> a = new LinkedList<String>();

	public AsyncTask_ScalarQuantization(Context context, String path,
			int level, int section) {
		super();
		this.context = context;
		this.file_path = path;
		this.level = level;
		this.section = section;
	}

	@Override
	protected void onPreExecute() {
		progressDialog = ProgressDialog.show(context,
				"Loading Please Wait,Image Processing",
				"Thank You For Your Cooperation...", true);
	}

	@Override
	protected List<String> doInBackground(String... params) {
		return ScalarQuantization(context);
	}

	@Override
	protected void onProgressUpdate(String... values) {
		progressDialog.setMessage("Thank You For Your Cooperation...");
	}

	@Override
	protected void onPostExecute(List<String> result) {
		progressDialog.cancel();

		ArrayList<String> result1 = new ArrayList<String>(result);
		if (level == 0) {
			if(section==1){
			Intent intent = new Intent(context, Activity_Level_Easy.class);
			intent.putExtra("result", result1);
			intent.putExtra("level", level);
			intent.putExtra("section", section);
			context.startActivity(intent);}
			if(section==2){
				Intent intent = new Intent(context, Activity_Level_Easy2.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);}
			if(section==3){
				Intent intent = new Intent(context, Activity_Level_Easy2.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);}
			if(section==4){
				Intent intent = new Intent(context, Activity_Level_Easy3.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);}
		}
		if (level == 1) {
			if(section==1){
				Intent intent = new Intent(context, Activity_Level_Medium.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);}
			if(section==2){
				Intent intent = new Intent(context, Activity_Level_Medium1.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);}
			if(section==3){
				Intent intent = new Intent(context, Activity_Level_Medium2.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);}
			if(section==4){
				Intent intent = new Intent(context, Activity_Level_Medium3.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);}
			/*
			 * Intent intent = new Intent(context,image_GridActivity.class);
			 * intent.putExtra("result", result1);
			 * intent.putExtra("level",level);
			 * intent.putExtra("section",section);
			 * context.startActivity(intent);
			 */
		}
		if (level == 2) {
			if(section==1){
				Intent intent = new Intent(context, Activity_Level_Hard.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);}
			
			
			/*
			 * Intent intent = new Intent(context,image_GridActivity.class);
			 * intent.putExtra("result", result1);
			 * intent.putExtra("level",level);
			 * intent.putExtra("section",section);
			 * context.startActivity(intent);
			 */
		}
	}

	private List<String> ScalarQuantization(Context context2) {
		List<String> getlist = null;
		File image_path = new File(file_path);
		Log.i("aaaaaa", "ain backgrounda im");
		if (image_path.exists()) {
			Log.i("aaaaaa", "içerdeyim");
			Bitmap myBitmap = BitmapFactory.decodeFile(image_path
					.getAbsolutePath());
			IMG_HEIGHT = (int) (myBitmap.getHeight() * 0.1);
			IMG_WIDTH = (int) (myBitmap.getWidth() * 0.1);

			Bitmap resized = Bitmap.createScaledBitmap(myBitmap, IMG_WIDTH,
					IMG_HEIGHT, false);
			Log.i("aaaaaa",
					"resized" + resized.getWidth() + "," + resized.getHeight());
			fireOnImage(resized);
			System.out.println("he" + IMG_HEIGHT + " Wid " + IMG_WIDTH);
			System.out.println("HashSet size: " + s.size());
			System.out.println("LinkedList size: " + a.size());
			System.out.println(s);
			Log.i("aaaaaa", "HashSet size:" + s.size());
			Log.i("aaaaaa", "LinkedList size:" + a.size());

			int count = 0;

			Map<String, Integer> treeMap = new TreeMap<String, Integer>();

			for (String str : s) {
				count = 0;
				for (int j = 0; j < a.size(); j++) {
					if (str.equals(a.get(j))) {
						count++;
					}
				}
				System.out.println(str + " sayisi:" + count);
				treeMap.put(str, count);
			}

			System.out.println("**********");
			System.out.println(treeMap);
			System.out.println("" + treeMap.size());
			System.out.println("***************");
			Map<String, String> sortedMap = sortByComparator(treeMap);
			System.out.println(sortedMap);
			System.out.println("" + sortedMap.size());
			getlist = new ArrayList<String>(sortedMap.keySet());
		}

		publishProgress();
		return getlist;
	}

	private void fireOnImage(Bitmap image) {
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.println("width, height: " + w + ", " + h);
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int pixel = image.getPixel(j, i);
				System.out.println(pixel);
				String pixs = Integer.toHexString(pixel);
				printPixelARGB(pixel);
				// a.add(pixs);
				// s.add(pixs);
			}
		}
	}

	public void printPixelARGB(int pixel) {
		// int alpha = (pixel >> 24) & 0xff;
		int red = (pixel >> 16) & 0xff;
		int green = (pixel >> 8) & 0xff;
		int blue = (pixel) & 0xff;
		String hex = String.format("#%02x%02x%02x", red, green, blue);
		a.add(hex);
		s.add(hex);
		System.out.println("argb: " + red + ", " + green + ", " + blue);
		System.out.println("argb: " + Integer.toHexString(pixel) + " hex: "
				+ hex);

	}

	private static Map sortByComparator(Map unsortMap) {

		List list = new LinkedList(unsortMap.entrySet());
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
						.compareTo(((Map.Entry) (o2)).getValue());
			}
		});
		// put sorted list into map again
		// LinkedHashMap make sure order in which keys were inserted
		Map sortedMap = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
