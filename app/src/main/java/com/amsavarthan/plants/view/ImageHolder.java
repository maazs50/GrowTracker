package com.amsavarthan.plants.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import lombok.Data;
import lombok.Getter;
import com.amsavarthan.plants.grow.R;
import com.amsavarthan.plants.lib.Views;


@Data
public class ImageHolder extends RecyclerView.ViewHolder
{
	private ImageView image;
	private CheckBox selection;

	public ImageHolder(View itemView)
	{
		super(itemView);

		image = (ImageView)itemView.findViewById(R.id.image);
		selection = (CheckBox)itemView.findViewById(R.id.selection);
	}
}
