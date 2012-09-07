package com.example.ting;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

public class OnlineMusicActivity extends Activity {
	PagerAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
setContentView(R.layout.activity_online);
setTitileBar(getString(R.string.online_music));
		String[] files = null;
		String dir = "album";
		try {
			String[] temp = getAssets().list(dir);
			files = new String[temp.length];
			for (int j = 0; j < temp.length; j++) {
				files[j] = dir + "/" + temp[j];

			}

			InputStream is = getAssets().open(files[0]);

			ImageView image = new ImageView(this);
			Bitmap bitmap = BitmapFactory.decodeStream(is);
			image.setImageBitmap(bitmap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		LayoutInflater inflater = getLayoutInflater();
		
		mAdapter = new MyPagerAdapter(inflater, files);
		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
		mIndicator = indicator;
		indicator.setViewPager(mPager);
		indicator.setFillColor(getResources().getColor(R.color.bg_color));
		indicator.setSnap(true);

		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		String[] s1 = getResources().getStringArray(
				R.array.online_music_hot_title);
		String[] s2 = getResources().getStringArray(
				R.array.online_music_hot_sub_title);
		int len = s1.length;
		for (int i = 0; i < len; i++) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("title", s1[i]);
			map.put("subtitle", s2[i]);
			list.add(map);
		}

		SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.online_music_textview, new String[] { "title",
						"subtitle" }, new int[] { R.id.textView1,
						R.id.textView2 });
		ListView lists = (ListView)findViewById(R.id.listview);
		lists.setAdapter(adapter);
		
		
	}
	void setTitileBar(CharSequence text) {
		TextView view = (TextView) findViewById(R.id.activity_title_bar);
		view.setText(text);
	}
	class MyPagerAdapter extends PagerAdapter {
		LayoutInflater inflater;
		String[] bitmapPath;

		public MyPagerAdapter(LayoutInflater inflater, String[] bitmapPath) {
			this.inflater = inflater;
			this.bitmapPath = bitmapPath;
		}

		@Override
		public int getCount() {
			int len = (int) Math.ceil(bitmapPath.length * 1.0 / 3);
			return len;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		// @Override
		// public Object instantiateItem(View container, int position) {
		// View v = inflater.inflate(R.layout.album_image_view,
		// null);
		//
		// ImageView view1 = (ImageView) v.findViewById(R.id.imageView1);
		// ImageView view2 = (ImageView) v.findViewById(R.id.imageView1);
		// ImageView view3 = (ImageView) v.findViewById(R.id.imageView1);
		// InputStream is;
		// try {
		// is = getActivity().getAssets().open(bitmapPath[position]);
		// Bitmap bitmap = BitmapFactory.decodeStream(is);
		// view1.setImageBitmap(bitmap);
		// view2.setImageBitmap(bitmap);
		// view3.setImageBitmap(bitmap);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// return v;
		// }

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View v = inflater.inflate(R.layout.album_image_view, container,
					false);

			ImageView view1 = (ImageView) v.findViewById(R.id.imageView1);
			ImageView view2 = (ImageView) v.findViewById(R.id.imageView2);
			ImageView view3 = (ImageView) v.findViewById(R.id.imageView3);
			InputStream is = null;
			Bitmap bitmap;
			try {
				int index = position * 3;
				int len = bitmapPath.length;
				if (index < len) {
					is = getAssets().open(bitmapPath[index]);
					bitmap = BitmapFactory.decodeStream(is);
					view1.setImageBitmap(bitmap);
				}

				index++;
				if (index < len) {
					is = getAssets().open(bitmapPath[index]);
					bitmap = BitmapFactory.decodeStream(is);
					view2.setImageBitmap(bitmap);
				}

				index++;
				if (index < len) {
					is = getAssets().open(bitmapPath[index]);
					bitmap = BitmapFactory.decodeStream(is);
					view3.setImageBitmap(bitmap);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			((ViewPager) container).addView(v);
			return v;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}

}
