package com.amsavarthan.plants.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import lombok.Data;
import com.amsavarthan.plants.grow.R;


@Data
public class PlantSelectHolder extends RecyclerView.ViewHolder
{
	private ImageView image;
	private CheckBox checkbox;
	private TextView name;

	public PlantSelectHolder(View itemView)
	{
		super(itemView);

		image = (ImageView)itemView.findViewById(R.id.image);
		checkbox = (CheckBox)itemView.findViewById(R.id.checkbox);
		name = (TextView)itemView.findViewById(R.id.name);
	}
}
