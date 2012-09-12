package com.example.ting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter.ViewBinder;

public class LocalMusicGridFragment extends Fragment implements OnItemClickListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_local_music_grid, container, false);

		GridView view = (GridView) v.findViewById(R.id.gridView1);
		view.setOnItemClickListener(this);

		List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();

		Map<String, Object> maps = new HashMap<String, Object>();
		StateListDrawable drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_allsongs_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_allsongs_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.all_songs));
		maps.put("text2", 76);
		lists.add(maps);

		maps = new HashMap<String, Object>();
		drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_singer_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_singer_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.singer));
		maps.put("text2", 44);
		lists.add(maps);

		maps = new HashMap<String, Object>();
		drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_thealbum_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_thealbum_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.the_album));
		maps.put("text2", 9);
		lists.add(maps);

		maps = new HashMap<String, Object>();
		drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_folder_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_folder_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.folder));
		maps.put("text2", 4);
		lists.add(maps);

		maps = new HashMap<String, Object>();
		drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_my_download_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_my_download_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.my_download));
		maps.put("text2", 0);
		lists.add(maps);

		maps = new HashMap<String, Object>();
		drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_recentlyplayed_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_recentlyplayed_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.recently_played));
		maps.put("text2", 0);
		lists.add(maps);

		maps = new HashMap<String, Object>();
		drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_recentlyadded_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_recentlyadded_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.recently_added));
		maps.put("text2", 76);
		lists.add(maps);

		maps = new HashMap<String, Object>();
		drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_thelocallist_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_thelocallist_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.the_local_list));
		maps.put("text2", 0);
		lists.add(maps);

		maps = new HashMap<String, Object>();
		drawable = new StateListDrawable();
		drawable.addState(new int[] { -android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_newlist_normal));
		drawable.addState(new int[] { android.R.attr.state_pressed },
				getResources().getDrawable(R.drawable.ic_tab_newlist_press));
		maps.put("image", drawable);
		maps.put("text1", getResources().getString(R.string.newlist));
		maps.put("text2", "");
		lists.add(maps);

		SimpleAdapter adapter = new SimpleAdapter(getActivity(), lists, R.layout.local_music_gridview_element,
				new String[] { "image", "text1", "text2" },
				new int[] { R.id.imageView1, R.id.textView1, R.id.textView2 });

		ViewBinder binder = new ViewBinder() {

			@Override
			public boolean setViewValue(View view, Object object, String textRepresentation) {
				if (view instanceof ImageView) {
					((ImageView) view).setImageDrawable((Drawable) object);
				} else if (view instanceof TextView) {
					if (object instanceof String)
						((TextView) view).setText((String) object);
					else if (object instanceof Integer) {
						((TextView) view).setText(String.valueOf(object));
					}
				}
				return true;
			}
		};
		adapter.setViewBinder(binder);
		view.setAdapter(adapter);
		
		return v;
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// position==0
		if (position == 0) {
			FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

			AllSongsFragment fragment = new AllSongsFragment();
			ft.replace(R.id.local_music_fragment, fragment);
			ft.addToBackStack(null);
			ft.commit();

			LocalMusicActivity activity = (LocalMusicActivity) getActivity();
			activity.setTitileBar(getString(R.string.all_songs));
			
		}

	}
}
