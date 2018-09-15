package com.amsavarthan.plants.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter @Setter
@Accessors(prefix = {"m", ""}, chain = true)
public class Water extends Action
{
	private Double ppm;
	private Double ph;
	private Double runoff;
	private Double amount;
	private Double temp;
	private List<Additive> additives = new ArrayList<>();

	@Deprecated private Nutrient nutrient;
	@Deprecated private Double mlpl;
}
