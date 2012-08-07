package com.example.ting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

public class OnlineMusicFragment extends Fragment {
	PagerAdapter mAdapter;
	ViewPager mPager;
	PageIndicator mIndicator;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_online, container, false);

		mAdapter = new MyPagerAdapter();
		mPager = (ViewPager) v.findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		CirclePageIndicator indicator = (CirclePageIndicator) v
				.findViewById(R.id.indicator);
		mIndicator = indicator;
		indicator.setViewPager(mPager);
		indicator.setSnap(true);
		return v;
	}

	class MyPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return 0;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return false;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			return super.instantiateItem(container, position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			super.destroyItem(container, position, object);
		}
	}

}
