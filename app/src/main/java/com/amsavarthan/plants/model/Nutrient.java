package com.amsavarthan.plants.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Deprecated
@Getter @Setter
@Accessors(prefix = {"m", ""}, chain = true)
public class Nutrient
{
	private Double npc; // nitrogen
	private Double ppc; // phosphorus
	private Double kpc; // potassium
	private Double capc; // calcium
	private Double spc; // sulfur
	private Double mgpc; // magnesium
}
