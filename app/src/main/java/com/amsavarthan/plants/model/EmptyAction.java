package com.amsavarthan.plants.model;

import android.support.annotation.Nullable;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class EmptyAction extends Action
{
	@Nullable private ActionName action;

	public EmptyAction(Action.ActionName action)
	{
		this.setDate(System.currentTimeMillis());
		this.setAction(action);
	}
}
