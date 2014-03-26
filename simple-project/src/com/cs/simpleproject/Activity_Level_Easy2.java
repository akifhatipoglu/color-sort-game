package com.cs.simpleproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

@SuppressLint("NewApi")
public class Activity_Level_Easy2 extends Activity implements OnTouchListener,
		OnDragListener {

	ArrayList<String> result = new ArrayList<String>();
	private int level = 0, section = 0;
	private String id1, id2, id3, id4, id5;
	List<String> getlist;
	String compare[] = new String[6];
	LinearLayout color_layout;
	private int PUAN = 100;
	private int isGameFinished = 0;
	long startTime = 0, finishTime = 0;
	Database db = new Database(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		startTime = System.currentTimeMillis();
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		Bundle gelenVeri = intent.getExtras();
		level = gelenVeri.getInt("level");
		section = gelenVeri.getInt("section");
		result = gelenVeri.getStringArrayList("result");
		System.out.println(result);
		if (section == 2) {
			setContentView(R.layout.easy2);
		}
		if (section == 3) {
			setContentView(R.layout.easy3);
		}

		String color[] = new String[10];
		int colorvalue[] = new int[10];
		String colorm = "";
		Map<String, Integer> treeMap = new TreeMap<String, Integer>();
		for (int i = 1; i < 6; i++) {
			colorm = result.get(result.size() - i);
			color[i - 1] = colorm;
			colorm = colorm.substring(1, colorm.length());
			colorvalue[i - 1] = Integer.parseInt(colorm, 16);
			treeMap.put(color[i - 1], colorvalue[i - 1]);
			colorm = "";
		}
		Map<String, Integer> sortedMap = sortByComparator(treeMap);
		System.out.println(sortedMap);
		getlist = new ArrayList<String>(sortedMap.keySet());
		System.out.println(getlist);

		Button bt1 = (Button) findViewById(R.id.color1);
		bt1.setBackgroundColor(Color.parseColor(color[0]));
		bt1.setOnTouchListener(this);
		id1 = "" + bt1.getId();

		Button bt2 = (Button) findViewById(R.id.color2);
		bt2.setOnTouchListener(this);
		id2 = "" + bt2.getId();
		bt2.setBackgroundColor(Color.parseColor(color[1]));

		Button bt3 = (Button) findViewById(R.id.color3);
		bt3.setOnTouchListener(this);
		id3 = "" + bt3.getId();
		bt3.setBackgroundColor(Color.parseColor(color[2]));

		Button bt4 = (Button) findViewById(R.id.color4);
		bt4.setOnTouchListener(this);
		id4 = "" + bt4.getId();
		bt4.setBackgroundColor(Color.parseColor(color[3]));

		Button bt5 = (Button) findViewById(R.id.color5);
		bt5.setOnTouchListener(this);
		id5 = "" + bt5.getId();
		bt5.setBackgroundColor(Color.parseColor(color[4]));

		LinearLayout l1 = (LinearLayout) findViewById(R.id.laoyut_1);
		l1.setOnDragListener(this);
		LinearLayout l2 = (LinearLayout) findViewById(R.id.laoyut_2);
		l2.setOnDragListener(this);
		LinearLayout l3 = (LinearLayout) findViewById(R.id.laoyut_3);
		l3.setOnDragListener(this);
		LinearLayout l4 = (LinearLayout) findViewById(R.id.laoyut_4);
		l4.setOnDragListener(this);
		LinearLayout l5 = (LinearLayout) findViewById(R.id.laoyut_5);
		l5.setOnDragListener(this);

		color_layout = (LinearLayout) findViewById(R.id.color_layout);

		for (int j = 0; j < getlist.size(); j++) {
			String s = getlist.get(j);
			System.out.println("holle: " + s);
			for (int i = 0; i < 5; i++) {
				if (color[i].equals(s)) {
					if (i == 0) {
						compare[0] = "" + bt1.getId();
						if (j == 0) {
							compare[0] += "" + l1.getId();
							System.out.println("l1 b1");
							l1.setBackground(bt1.getBackground());
							bt1.setOnTouchListener(null);
						}
						if (j == 1) {
							compare[0] += "" + l2.getId();
							System.out.println("l2 b1");
						}
						if (j == 2) {
							compare[0] += "" + l3.getId();
							System.out.println("l3 b1");
						}
						if (j == 3) {
							compare[0] += "" + l4.getId();
							System.out.println("l4 b1");
						}
						if (j == 4) {
							compare[0] += "" + l5.getId();
							System.out.println("l5 b1");
						}
						System.out.println("Button 1 " + bt1.getId() + " " + j
								+ " " + compare[0]);
					}
					if (i == 1) {
						compare[1] = "" + bt2.getId();
						if (j == 0) {
							compare[1] += "" + l1.getId();
							System.out.println("l1 b2");
							l1.setBackground(bt2.getBackground());
							bt2.setOnTouchListener(null);
						}
						if (j == 1) {
							compare[1] += "" + l2.getId();
							System.out.println("l2 b2");
						}
						if (j == 2) {
							compare[1] += "" + l3.getId();
							System.out.println("l3 b2");
						}
						if (j == 3) {
							compare[1] += "" + l4.getId();
							System.out.println("l4 b2");
						}
						if (j == 4) {
							compare[1] += "" + l5.getId();
							System.out.println("l5 b2");
						}
						System.out.println("Button 2 " + bt2.getId() + " " + j
								+ " " + compare[1]);
					}
					if (i == 2) {
						compare[2] = "" + bt3.getId();
						if (j == 0) {
							compare[2] += "" + l1.getId();
							System.out.println("l1 b3");
							l1.setBackground(bt3.getBackground());
							bt3.setOnTouchListener(null);
						}
						if (j == 1) {
							compare[2] += "" + l2.getId();
							System.out.println("l2 b3");
						}
						if (j == 2) {
							compare[2] += "" + l3.getId();
							System.out.println("l3 b3");
						}
						if (j == 3) {
							compare[2] += "" + l4.getId();
							System.out.println("l4 b3");
						}
						if (j == 4) {
							compare[2] += "" + l5.getId();
							System.out.println("l5 b3");
						}
						System.out.println("Button 3 " + bt3.getId() + " " + j
								+ " " + compare[2]);
					}
					if (i == 3) {
						compare[3] = "" + bt4.getId();
						if (j == 0) {
							compare[3] += "" + l1.getId();
							System.out.println("l1 b4");
							l1.setBackground(bt4.getBackground());
							bt4.setOnTouchListener(null);
						}
						if (j == 1) {
							compare[3] += "" + l2.getId();
							System.out.println("l2 b4");
						}
						if (j == 2) {
							compare[3] += "" + l3.getId();
							System.out.println("l3 b4");
						}
						if (j == 3) {
							compare[3] += "" + l4.getId();
							System.out.println("l4 b4");
						}
						if (j == 4) {
							compare[3] += "" + l5.getId();
							System.out.println("l4 b4");
						}
						System.out.println("Button 4 " + bt4.getId() + " " + j
								+ " " + compare[3]);
					}
					if (i == 4) {
						compare[4] = "" + bt5.getId();
						if (j == 0) {
							compare[4] += "" + l1.getId();
							System.out.println("l1 b4");
							l1.setBackground(bt5.getBackground());
							bt5.setOnTouchListener(null);
						}
						if (j == 1) {
							compare[4] += "" + l2.getId();
							System.out.println("l2 b4");
						}
						if (j == 2) {
							compare[4] += "" + l3.getId();
							System.out.println("l3 b4");
						}
						if (j == 3) {
							compare[4] += "" + l4.getId();
							System.out.println("l4 b4");
						}
						if (j == 4) {
							compare[4] += "" + l5.getId();
							System.out.println("l4 b4");
						}
						System.out.println("Button 4 " + bt4.getId() + " " + j
								+ " " + compare[3]);
					}

				}
			}
		}

	}

	@Override
	public boolean onDrag(View layoutview, DragEvent dragevent) {
		int action = dragevent.getAction();
		switch (action) {
		case DragEvent.ACTION_DRAG_STARTED:
			Log.d("aaa", "Drag event started");
			System.out.println("Drag event started");
			break;
		case DragEvent.ACTION_DRAG_ENTERED:
			Log.d("aaa", "Drag event entered into " + layoutview.toString());
			System.out.println("Drag event entered into"
					+ layoutview.toString());
			break;
		case DragEvent.ACTION_DRAG_EXITED:
			Log.d("aaa", "Drag event exited from " + layoutview.toString());
			System.out.println("Drag event exited from "
					+ layoutview.toString());
			break;
		case DragEvent.ACTION_DROP:
			boolean pass = false;
			Log.d("aaa", "Dropped");
			System.out.println("Dropped");
			View view = (View) dragevent.getLocalState();
			ViewGroup owner = (ViewGroup) view.getParent();
			LinearLayout container = (LinearLayout) layoutview;

			String c1 = "" + view.getId();
			String c2 = "" + view.getId();
			c2 += "" + layoutview.getId();
			System.out.println(c2);

			if (c1.equals(id1)) {
				System.out.println("bt1");
				if (c2.equals(compare[0])) {
					System.out.println("baþardýn la yuva");
					pass = true;
				}
			}

			if (c1.equals(id2)) {
				System.out.println("bt2");
				if (c2.equals(compare[1])) {
					System.out.println("baþardýn la yuva");
					pass = true;
				}
			}

			if (c1.equals(id3)) {
				System.out.println("bt3");
				if (c2.equals(compare[2])) {
					System.out.println("baþardýn la yuva");
					pass = true;
				}
			}

			if (c1.equals(id4)) {
				System.out.println("bt4");
				if (c2.equals(compare[3])) {
					System.out.println("baþardýn la yuva");
					pass = true;
				}
			}
			if (c1.equals(id5)) {
				System.out.println("bt5");
				if (c2.equals(compare[4])) {
					System.out.println("baþardýn la yuva");
					pass = true;
				}
			}

			if (pass == true) {
				owner.removeView(view);
				container.addView(view);
				container.setBackground(view.getBackground());
				view.setVisibility(View.VISIBLE);
				PUAN += 200;
				isGameFinished++;
				Toast.makeText(this, "Score: " + PUAN, Toast.LENGTH_SHORT)
						.show();
				if (isGameFinished == 4) {
					finishTime = System.currentTimeMillis() - startTime;
					finishTime = finishTime / 60;
					System.out.println(finishTime);
					PUAN -= finishTime;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Toast.makeText(
							this,
							"Congratulations! The game is over. Your Score: "
									+ PUAN, Toast.LENGTH_LONG).show();
					if (section == 2) {
						db.addScore("Level:Easy Section:2", PUAN);
					}
					if (section == 3) {
						db.addScore("Level:Easy Section:3", PUAN);
					}
					Intent intent = new Intent(Activity_Level_Easy2.this,
							Activity_Main.class);
					startActivity(intent);
					Activity_Level_Easy2.this.finish();
				}
			} else {
				owner.removeView(view);
				color_layout.addView(view);
				view.setVisibility(View.VISIBLE);
				PUAN -= 75;
				startTime -= 300;
				Toast.makeText(this, "Score: " + PUAN, Toast.LENGTH_SHORT)
						.show();
			}
			pass = false;
			break;
		case DragEvent.ACTION_DRAG_ENDED:
			Log.d("aaa", "Drag ended");
			System.out.println("Drag anded");
			break;
		default:
			break;
		}
		return true;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
			v.startDrag(null, shadowBuilder, v, 0);
			// v.setVisibility(View.INVISIBLE);
			return true;
		} else {
			return false;
		}
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
