package com.amsavarthan.plants.controller.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;

import java.io.File;

import com.amsavarthan.plants.lib.manager.FileManager;

import static com.amsavarthan.plants.lib.manager.PlantManager.FILES_DIR;

/**
 * // TODO: Add class description
 */
public class BackupService extends BroadcastReceiver
{
	@Override public void onReceive(Context context, Intent intent)
	{
		new File(Environment.getExternalStorageDirectory(), "/backups/GrowTracker/").mkdirs();
		FileManager.getInstance().copyFile(FILES_DIR + "/plants.json", Environment.getExternalStorageDirectory().getAbsolutePath() + "/backups/GrowTracker/" + System.currentTimeMillis() + ".bak");
	}
}
