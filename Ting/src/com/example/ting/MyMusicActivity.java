package com.example.ting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyMusicActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_music);
		setTitileBar(getString(R.string.my_music));
	}

	void setTitileBar(CharSequence text) {
		TextView view = (TextView) findViewById(R.id.activity_title_bar);
		view.setText(text);
	}
	 public void login(View view) {
			Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
			startActivity(intent);
		}
}
