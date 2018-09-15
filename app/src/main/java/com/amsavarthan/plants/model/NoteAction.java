package com.amsavarthan.plants.model;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class NoteAction extends Action
{
	public NoteAction(String note)
	{
		this.setDate(System.currentTimeMillis());
		this.setNotes(note);
	}
}
