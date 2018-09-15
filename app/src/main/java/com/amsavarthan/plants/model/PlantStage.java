package com.amsavarthan.plants.model;

import lombok.Getter;


public enum PlantStage
{
	PLANTED("Planted"),
	GERMINATION("Germination"),
	CUTTING("Cutting"),
	VEGETATION("Vegetation"),
	FLOWER("Flower"),
	DRYING("Drying"),
	CURING("Curing"),
	HARVESTED("Harvested");

	@Getter private String printString;

	private PlantStage(String name)
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
