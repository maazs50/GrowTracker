package com.amsavarthan.plants.lib.helper;

import android.view.View;


public class FabAnimator
{
	public static void animateUp(View fab)
	{
		if (fab == null) return;

		fab.animate().translationYBy(-(fab.getHeight() * 0.85f)).setDuration(200).start();
	}

	public static void animateDown(View fab)
	{
		if (fab == null) return;

		fab.animate().translationYBy((fab.getHeight() * 0.85f)).setDuration(200).start();
	}
}
