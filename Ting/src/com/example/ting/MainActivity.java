package com.example.ting;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.ting.LoginActivity.TabManager;

public class MainActivity extends TabActivity implements OnTabChangeListener {
	
	TabHost mTabHost;
	TabManager mTabManager;
	TabWidget tabWidget;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
mTabHost = getTabHost();
	//	mTabHost = (TabHost) findViewById(android.R.id.tabhost);
	//	mTabHost.setup();
		tabWidget = (TabWidget) findViewById(android.R.id.tabs);

		addTab(tabWidget, getString(R.string.local_music), LocalMusicActivity.class, null);
		addTab(tabWidget, getString(R.string.my_music), MyMusicActivity.class, null);
		addTab(tabWidget, getString(R.string.online_music), OnlineMusicActivity.class, null);
		addTab(tabWidget, getString(R.string.search), SearchActivity.class, null);

		if (savedInstanceState != null) {
			mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
		}
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if(event.getKeyCode()==KeyEvent.KEYCODE_BACK){
			 if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
				//ÍË³ö¶Ô»°¿ò
					View view = getLayoutInflater().inflate(R.layout.exit_dialog, null);
					final Dialog dialog = new Dialog(this,R.style.dialogStyle);
					
					dialog.show();
					TextView view1 = (TextView) view.findViewById(R.id.textView3);
					TextView view2 = (TextView) view.findViewById(R.id.textView4);
					
					view1.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							dialog.dismiss();
							finish();
						}
					});
					view2.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							dialog.dismiss();
						}
					});
					
					
					return true;
			 }
		}
		
		return super.dispatchKeyEvent(event);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("tab", mTabHost.getCurrentTabTag());
	}

	public void addTab(TabWidget tabWidget, String title, Class<?> clss, Bundle args) {
		TabSpec tabSpec = mTabHost.newTabSpec(title);
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, tabWidget, false);
		TextView titleView = (TextView) tabIndicator.findViewById(R.id.title);
		titleView.setText(title);

		tabSpec.setIndicator(tabIndicator);
		
		tabSpec.setContent(new Intent(this, clss));

		mTabHost.addTab(tabSpec);
		
	}

	@Override
	public void onTabChanged(String tabId) {
		
	}
	
	
	
}
