package com.amsavarthan.plants.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter @Setter
@Accessors(prefix = {"m", ""}, chain = true)
public class StageChange extends Action
{
	private PlantStage newStage;

	public StageChange(PlantStage stage)
	{
		this.setDate(System.currentTimeMillis());
		this.setNewStage(stage);
	}
}
