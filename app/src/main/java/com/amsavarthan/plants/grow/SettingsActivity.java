package com.amsavarthan.plants.grow;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import lombok.experimental.Accessors;

import com.amsavarthan.plants.grow.fragment.SettingsFragment;
import com.amsavarthan.plants.lib.Views;


@Accessors(prefix = {"m", ""}, chain = true)
public class SettingsActivity extends BaseActivity
{
	private static final String TAG_FRAGMENT = "current_fragment";

	@Override protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_holder);
		setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
		Views.inject(this);

		setTitle("Settings");

		if (getFragmentManager().findFragmentByTag(TAG_FRAGMENT) == null)
		{
			getFragmentManager().beginTransaction().replace(R.id.fragment_holder, new SettingsFragment(), TAG_FRAGMENT).commit();
		}
	}
}
