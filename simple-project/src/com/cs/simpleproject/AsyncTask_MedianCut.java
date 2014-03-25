package com.cs.simpleproject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

public class AsyncTask_MedianCut extends
		AsyncTask<String, String, List<String>> {

	private Context context;
	private ProgressDialog progressDialog;
	private static int IMG_WIDTH = 400;
	private static int IMG_HEIGHT = 300;
	private int level = 0, section = 0;
	String file_path = "";
	Set<String> s = new HashSet<String>();
	List<String> a = new LinkedList<String>();
	Bitmap sub1 = null, sub2 = null, sub3 = null, sub4 = null;

	public AsyncTask_MedianCut(Context context, String path, int level,
			int section) {
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
		return MedianCut(context);
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
			if (section == 1) {
				Intent intent = new Intent(context, Activity_Level_Easy.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 2) {
				Intent intent = new Intent(context, Activity_Level_Easy2.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 3) {
				Intent intent = new Intent(context, Activity_Level_Easy2.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 4) {
				Intent intent = new Intent(context, Activity_Level_Easy3.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
		}
		if (level == 1) {
			if (section == 1) {
				Intent intent = new Intent(context, Activity_Level_Medium.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 2) {
				Intent intent = new Intent(context,
						Activity_Level_Medium1.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 3) {
				Intent intent = new Intent(context,
						Activity_Level_Medium2.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 4) {
				Intent intent = new Intent(context,
						Activity_Level_Medium3.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
		}
		if (level == 2) {
			if (section == 1) {
				Intent intent = new Intent(context, Activity_Level_Hard.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 2) {
				Intent intent = new Intent(context, Activity_Level_Hard1.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 3) {
				Intent intent = new Intent(context, Activity_Level_Hard2.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
			if (section == 4) {
				Intent intent = new Intent(context, Activity_Level_Hard3.class);
				intent.putExtra("result", result1);
				intent.putExtra("level", level);
				intent.putExtra("section", section);
				context.startActivity(intent);
			}
		}

	}

	private List<String> MedianCut(Context context2) {
		List<String> getlist = null;
		File image_path = new File(file_path);
		Log.i("aaaaaa", "ain backgrounda im");
		if (image_path.exists()) {
			Bitmap myBitmap = BitmapFactory.decodeFile(image_path
					.getAbsolutePath());
			int values = (int) (myBitmap.getWidth() * 0.01);
			IMG_HEIGHT = (int) (myBitmap.getHeight() * 0.01 * values);
			values = (int) (myBitmap.getHeight() * 0.01);
			IMG_WIDTH = (int) (myBitmap.getWidth() * 0.01 * values);

			Bitmap resized = Bitmap.createScaledBitmap(myBitmap, IMG_WIDTH,
					IMG_HEIGHT, false);
			Log.i("aaaaaa",
					"resized" + resized.getWidth() + "," + resized.getHeight());

			resized = getimage24BitsTO8Bits(resized, 32);

			getImageHashSet(resized);

			System.out.println("he" + IMG_HEIGHT + " Wid " + IMG_WIDTH);
			System.out.println("HashSet size: " + s.size());
			System.out.println("LinkedList size: " + a.size());
			System.out.println(s);

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
			Map<String, Integer> sortedMap = sortByComparator(treeMap);
			System.out.println(sortedMap);
			System.out.println("" + sortedMap.size());

			getSubImage(resized);

			recursiveMediancut(15, resized);

			getlist = new ArrayList<String>(sortedMap.keySet());
			// burada sorted aþaðýdaki map olacak
		}
		publishProgress();
		return getlist;
	}

	
	
	public void getImageHashSet(Bitmap image) {
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.println("width, height: " + w + ", " + h);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int pixel = image.getPixel(j, i);
				String pixs = Integer.toHexString(pixel);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				String hex = String.format("#%02x%02x%02x", red, green, blue);
				a.add(hex);
				s.add(hex);
			}
		}
	}

	public static Bitmap getimage24BitsTO8Bits(Bitmap image, int bitoffset) {
		int width = image.getWidth();
		int height = image.getHeight();
		Bitmap return_image = Bitmap.createBitmap(width, height,
				image.getConfig());
		int Alpha, Red, Green, Blue;
		int pixel;

		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {

				pixel = image.getPixel(x, y);
				Alpha = Color.alpha(pixel);
				Red = Color.red(pixel);
				Green = Color.green(pixel);
				Blue = Color.blue(pixel);
				
				Red = ((Red + (bitoffset / 2))
						- ((Red + (bitoffset / 2)) % bitoffset) - 1);
				if (Red < 0) {
					Red = 0;
				}
				Green = ((Green + (bitoffset / 2))
						- ((Green + (bitoffset / 2)) % bitoffset) - 1);
				if (Green < 0) {
					Green = 0;
				}
				Blue = ((Blue + (bitoffset / 2))
						- ((Blue + (bitoffset / 2)) % bitoffset) - 1);
				if (Blue < 0) {
					Blue = 0;
				}


				return_image
						.setPixel(x, y, Color.argb(Alpha, Red, Green, Blue));
			}
		}

		return return_image;
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

	public void getSubImage(Bitmap rgb) {
		sub1 = Bitmap.createBitmap(rgb, 0, 0, rgb.getWidth() / 2,
				rgb.getHeight() / 2);
		sub2 = Bitmap.createBitmap(rgb, (rgb.getWidth() / 2), 0,
				rgb.getWidth() / 2, (rgb.getHeight() / 2));
		sub3 = Bitmap.createBitmap(rgb, 0, rgb.getHeight() / 2,
				rgb.getWidth() / 2, rgb.getHeight() / 2);
		sub4 = Bitmap.createBitmap(rgb, rgb.getWidth() / 2,
				rgb.getHeight() / 2, rgb.getWidth() / 2, rgb.getHeight() / 2);
		/*
		 * sub1 = rgb.getSubimage(0, 0, rgb.getWidth() / 2, rgb.getHeight() /
		 * 2); sub2 = rgb.getSubimage((rgb.getWidth() / 2), 0, rgb.getWidth() /
		 * 2, (rgb.getHeight() / 2)); sub3 = rgb.getSubimage(0, rgb.getHeight()
		 * / 2, rgb.getWidth() / 2, rgb.getHeight() / 2); sub4 =
		 * rgb.getSubimage(rgb.getWidth() / 2, rgb.getHeight() / 2,
		 * rgb.getWidth() / 2, rgb.getHeight() / 2);
		 */
	}

	public void recursiveMediancut(int level, Bitmap resized) {
		int colorscala = s.size();// 86
		int listsize = a.size();
		int thelargest = colorscala;
		Bitmap chose = resized;
		int sub1_color_number = 0, sub2_color_number = 0, sub3_color_number = 0, sub4_color_number = 0;
		while (thelargest >= level) {
			getSubImage(chose);

			getChooseHas(chose);

			sub1_color_number = getSubImageColorNumber(sub1);
			sub2_color_number = getSubImageColorNumber(sub2);
			sub3_color_number = getSubImageColorNumber(sub3);
			sub4_color_number = getSubImageColorNumber(sub4);

			System.out.println(sub1_color_number + "," + sub2_color_number
					+ "," + sub3_color_number + "," + sub4_color_number);

			int[] array = { sub1_color_number, sub2_color_number,
					sub3_color_number, sub4_color_number };
			Arrays.sort(array);
			if (sub1_color_number == array[3]) {
				chose = sub1;
				thelargest = sub1_color_number;
				System.out.println("sub1");
			}
			if (sub2_color_number == array[3]) {
				chose = sub2;
				thelargest = sub2_color_number;
				System.out.println("sub2");
			}
			if (sub3_color_number == array[3]) {
				chose = sub3;
				thelargest = sub3_color_number;
				System.out.println("sub3");
			}
			if (sub4_color_number == array[3]) {
				chose = sub4;
				thelargest = sub4_color_number;
				System.out.println("sub4");
			}

		}
		System.out.println(set2);

		int count = 0;
		Map<String, Integer> treeMap2 = new TreeMap<String, Integer>();

		for (String str1 : set2) {
			count = 0;
			for (int j = 0; j < list2.size(); j++) {
				if (str1.equals(list2.get(j))) {
					count++;
				}
			}
			System.out.println(str1 + " sayisi:" + count);
			treeMap2.put(str1, count);
		}

		System.out.println("**********");
		System.out.println(treeMap2);
		System.out.println("" + treeMap2.size());
		System.out.println("***************");
		Map<String, Integer> sortedMap = sortByComparator(treeMap2);
		System.out.println(sortedMap);
		System.out.println("" + sortedMap.size());

	}

	public int getSubImageColorNumber(Bitmap rgb) {
		set.clear();

		int w = rgb.getWidth();
		int h = rgb.getHeight();
		System.out.println("width, height: " + w + ", " + h);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int pixel = rgb.getPixel(j, i);
				String pixs = Integer.toHexString(pixel);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				String hex = String.format("#%02x%02x%02x", red, green, blue);
				set.add(hex);
			}
		}

		return set.size();
	}

	Set<String> set = new HashSet<String>();
	Set<String> set2 = new HashSet<String>();
	List<String> list2 = new LinkedList<String>();

	public void getChooseHas(Bitmap rgb) {
		set2.clear();
		list2.clear();

		int w = rgb.getWidth();
		int h = rgb.getHeight();
		System.out.println("width, height: " + w + ", " + h);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int pixel = rgb.getPixel(j, i);
				String pixs = Integer.toHexString(pixel);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				String hex = String.format("#%02x%02x%02x", red, green, blue);
				set2.add(hex);
				list2.add(hex);
			}
		}

	}

}
