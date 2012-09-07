package com.example.ting;

import java.io.UnsupportedEncodingException;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AllSongsFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				scanMusicFile();
			}
		}).start();
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_all_songs, container, false);

		return view;
	}

	public void scanMusicFile(){
		Log.d("scanMusicFile", "start"); 
		ContentResolver cr = getActivity().getContentResolver();
		Cursor cursor = cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Audio.Media.TITLE} , null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
		
		Log.d("scanMusicFile", cursor.getCount()+"");
		for(cursor.moveToNext();!cursor.isAfterLast();cursor.moveToNext()){
			String tilte = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)); 
			try {
				String temp = new String(tilte.getBytes(),"gbk");
				Log.d("scanMusicFile", getGbkX(temp)+"----"+tilte);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	private static String getGbkX(String str) {
		if (str.compareTo("ß¹") < 0)
			return str;
		if (str.compareTo("°Ë") < 0)
			return "A";
		if (str.compareTo("àê") < 0)
			return "B";
		if (str.compareTo("…ö") < 0)
			return "C";
		if (str.compareTo("ŠŠ") < 0)
			return "D";
		if (str.compareTo("·¢") < 0)
			return "E";
		if (str.compareTo("ê¸") < 0)
			return "F";
		if (str.compareTo("îþ") < 0)
			return "G";
		if (str.compareTo("¼¥") < 0)
			return "H";
		if (str.compareTo("ßÇ") < 0)
			return "J";
		if (str.compareTo("À¬") < 0)
			return "K";
		if (str.compareTo("‡`") < 0)
			return "L";
		if (str.compareTo("’‚") < 0)
			return "M";
		if (str.compareTo("àÞ") < 0)
			return "N";
		if (str.compareTo("Šr") < 0)
			return "O";
		if (str.compareTo("Æß") < 0)
			return "P";
		if (str.compareTo("’") < 0)
			return "Q";
		if (str.compareTo("Øí") < 0)
			return "R";
		if (str.compareTo("Ëû") < 0)
			return "S";
		if (str.compareTo("ÍÛ") < 0)
			return "T";
		if (str.compareTo("Ï¦") < 0)
			return "W";
		if (str.compareTo("Ñ¾") < 0)
			return "X";
		if (str.compareTo("Ž‰") < 0)
			return "Y";
		if (str.compareTo("…ø") < 0)
			return "Z";
		return str;
	}
}
