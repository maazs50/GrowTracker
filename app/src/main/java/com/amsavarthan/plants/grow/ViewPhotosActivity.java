package com.amsavarthan.plants.grow;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import lombok.experimental.Accessors;

import com.amsavarthan.plants.grow.fragment.ViewPhotosFragment;
import com.amsavarthan.plants.lib.Views;


@Views.Injectable
@Accessors(prefix = {"m", ""}, chain = true)
public class ViewPhotosActivity extends BaseActivity
{
	private static final String TAG_FRAGMENT = "current_fragment";

	@Override protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.fragment_holder);
		setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
		Views.inject(this);

		boolean feeding = true;
		int plantIndex = -1;
		if (getIntent().getExtras() != null)
		{
			plantIndex = getIntent().getExtras().getInt("plant_index", -1);
		}

		if (plantIndex < 0)
		{
			finish();
			return;
		}

		if (getFragmentManager().findFragmentByTag(TAG_FRAGMENT) == null)
		{
			getFragmentManager().beginTransaction().replace(R.id.fragment_holder, ViewPhotosFragment.newInstance(plantIndex), TAG_FRAGMENT).commit();
		}
	}
}
