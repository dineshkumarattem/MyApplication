package com.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabbedActivity extends Fragment {


	TabsPagerAdapter mTabsPagerAdapter;

	public static final String TAG = TabbedActivity.class.getSimpleName();
	

	ViewPager mViewPager;

	
	public static TabbedActivity newInstance() {
		return new TabbedActivity();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.activity_item_one, container, false);
        mTabsPagerAdapter = new TabsPagerAdapter(
				getChildFragmentManager());
		
		mViewPager = (ViewPager) v.findViewById(R.id.pager);
		mViewPager.setAdapter(mTabsPagerAdapter);
		
		return v;
	}
	

	public class TabsPagerAdapter extends FragmentPagerAdapter {


		public TabsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {

			Fragment fragment = new TabsDetailsFragment();

			return fragment;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {

			switch (position) {
			case 0:
				return getString(R.string.title_section1);
			case 1:
				return getString(R.string.title_section2);
			case 2:
				return getString(R.string.title_section3);
			}
			return null;
		}
	}


	public static class TabsDetailsFragment extends Fragment {

		public TabsDetailsFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.tab_fragment,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);

			return rootView;
		}
	}

}
