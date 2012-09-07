package com.example.ting;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class LocalMusicActivity extends FragmentActivity implements OnItemClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_local_music);
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		LocalMusicGridFragment fragment = new LocalMusicGridFragment();

		ft.replace(R.id.local_music_fragment, fragment);
		ft.addToBackStack(null);
		ft.commit();
		setTitileBar(getResources().getString(R.string.local_music));
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
	}

	void setTitileBar(CharSequence text) {
		TextView view = (TextView) findViewById(R.id.activity_title_bar);
		view.setText(text);
	}
}
