package com.github.mdogdope.scripturereader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Settings {

	private final String[] defaultConfig = { "exportDirectory:./Exports/", "verseMark:-", "blockDirectory:./Saves" };

	private File settingsFile = new File("./config.cfg");

	private HashMap<String, String> settings = new HashMap<String, String>();

	public Settings() {

		// Check if config file exists.
		if (!settingsFile.exists()) {
			makeDefaultConfig();
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(settingsFile));
			String line = new String();
			while ((line = reader.readLine()) != null) {
				if (line.startsWith("#") || line.isBlank()) {
					continue;
				}
				String[] parts = line.split(":");
				if (parts.length > 1) {
					settings.put(parts[0], "");
				} else {
					settings.put(parts[0], parts[1]);
				}
			}

			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File exportDirectory() {
		return new File(settings.get("exportDirectory"));
	}

	public String verseMark() {
		return settings.get("verseMark");
	}

	public File saveDirectory() {
		return new File(settings.get("saveDirectory"));
	}

	public void saveConfig() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFile));
			String[] keys = (String[]) settings.keySet().toArray();
			for (int i = 0; i < keys.length; i++) {
				writer.write(String.format("%s:%s\n", keys[i], settings.get(keys[i])));
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void makeDefaultConfig() {

		try {
			settingsFile.createNewFile();

			BufferedWriter writer = new BufferedWriter(new FileWriter(settingsFile));

			for (int i = 0; i < defaultConfig.length; i++) {
				writer.write(String.format("%s\n", defaultConfig[i]));
			}

			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
