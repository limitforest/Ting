package com.example.ting;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SearchActivity extends Activity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_search);
		setTitileBar(getString(R.string.search));
		ListView view = (ListView) findViewById(android.R.id.list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.textview_hotkey,android.R.id.text1,getResources().getStringArray(R.array.search_hotkey) );
		view.setAdapter(adapter);
		
	
	}
	void setTitileBar(CharSequence text) {
		TextView view = (TextView) findViewById(R.id.activity_title_bar);
		view.setText(text);
	}
}
