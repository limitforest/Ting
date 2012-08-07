package com.example.ting;

import android.R.anim;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchFragment extends Fragment{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_search, container,false);
		
		ListView view = (ListView) v.findViewById(android.R.id.list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),R.layout.textview_hotkey,android.R.id.text1,getActivity().getResources().getStringArray(R.array.search_hotkey) );
		view.setAdapter(adapter);
		
		return v;
	}
	
}
