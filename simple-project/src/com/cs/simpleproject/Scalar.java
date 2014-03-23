package com.cs.simpleproject;

import java.io.File;
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

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Scalar extends Activity {
	private static int IMG_WIDTH = 400;
	private static int IMG_HEIGHT = 300;
	String file_path = "";
	Set<String> s = new HashSet<String>();
	List<String> a = new LinkedList<String>();
	private ArrayAdapter<String> adapter;
	private ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);

		Intent intent = getIntent();
		Bundle gelenVeri = intent.getExtras();
		file_path = gelenVeri.getString("yey");

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

			Bitmap rgb = reduceColorDepth(resized, 8);
			Log.i("aaaa", "" + rgb.getConfig());
			fireOnImage(rgb);

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
			/*
			 * List<String> as=new LinkedList<String>(); for (int i = 0; i <
			 * sortedMap.size(); i++) { as.add(sortedMap.get(0)); } list =
			 * (ListView) findViewById(R.id.listView2);
			 * 
			 * adapter = new
			 * ArrayAdapter<String>(getApplicationContext(),android
			 * .R.layout.simple_list_item_1,as); list.setAdapter(adapter);
			 */
		}

	}

	public Bitmap reduceColorDepth(Bitmap src, int bitOffset) {
		// get image original size
		int width = src.getWidth();
		int height = src.getHeight();
		// toplam=width*height;
		// create output bitmap
		Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());
		// color information
		int A, R, G, B;
		int pixel;

		// scan through all pixels
		for (int x = 0; x < width; ++x) {
			for (int y = 0; y < height; ++y) {
				// get pixel color
				pixel = src.getPixel(x, y);
				A = Color.alpha(pixel);
				R = Color.red(pixel);
				G = Color.green(pixel);
				B = Color.blue(pixel);

				// round-off color offset
				R = ((R + (bitOffset / 2))
						- ((R + (bitOffset / 2)) % bitOffset) - 1);
				if (R < 0) {
					R = 0;
				}
				G = ((G + (bitOffset / 2))
						- ((G + (bitOffset / 2)) % bitOffset) - 1);
				if (G < 0) {
					G = 0;
				}
				B = ((B + (bitOffset / 2))
						- ((B + (bitOffset / 2)) % bitOffset) - 1);
				if (B < 0) {
					B = 0;
				}

				// set pixel color to output bitmap
				bmOut.setPixel(x, y, Color.argb(A, R, G, B));
			}
		}
		// return final image
		return bmOut;
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

	private void fireOnImage(Bitmap image) {
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.println("width, height: " + w + ", " + h);

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int pixel = image.getPixel(j, i);
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
}
