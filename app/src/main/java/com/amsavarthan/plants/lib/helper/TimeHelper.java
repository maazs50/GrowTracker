package com.amsavarthan.plants.lib.helper;


public class TimeHelper
{
	public static double toDays(long millis)
	{
		return millis / (1000d * 60d * 60d * 24d);
	}
}
