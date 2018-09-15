package com.amsavarthan.plants.lib.task;

import android.os.AsyncTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.amsavarthan.plants.grow.MainApplication;
import com.amsavarthan.plants.lib.stream.DecryptInputStream;


public class DecryptTask extends AsyncTask<ArrayList<String>, Void, Void>
{
	@Override protected Void doInBackground(ArrayList<String>... params)
	{
		for (String filePath : params[0])
		{
			FileOutputStream fos = null;
			DecryptInputStream dis = null;
			try
			{
				new File(filePath).renameTo(new File(filePath + ".temp"));

				dis = new DecryptInputStream(MainApplication.getKey(), new File(filePath + ".temp"));
				fos = new FileOutputStream(new File(filePath));

				byte[] buffer = new byte[8192];
				int len = 0;

				while ((len = dis.read(buffer)) != -1)
				{
					fos.write(buffer, 0, len);
				}

				new File(filePath + ".temp").delete();

				fos.flush();

			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				if (fos != null)
				{
					try
					{
						fos.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}

				if (dis != null)
				{
					try
					{
						dis.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}
		}

		return null;
	}
}
