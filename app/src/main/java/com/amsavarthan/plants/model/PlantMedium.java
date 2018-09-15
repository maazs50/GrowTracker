package com.amsavarthan.plants.model;

import lombok.Getter;


public enum PlantMedium
{
	SOIL("Soil"),
	HYDRO("Hydroponics"),
	COCO("Coco Coir"),
	AERO("Aeroponics");

	@Getter private String printString;

	private PlantMedium(String name)
	{
		this.printString = name;
	}

	public static String[] names()
	{
		String[] names = new String[values().length];
		for (int index = 0; index < names.length; index++)
		{
			names[index] = values()[index].getPrintString();
		}

		return names;
	}
}
