package com.amsavarthan.plants.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter @Setter
@Accessors(prefix = {"m", ""}, chain = true)
public class Additive
{
	private Double amount;
	private String description;
}
