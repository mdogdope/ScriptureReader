package com.github.mdogdope.scripturereader;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		UI screen = new UI();
		Generator gen = new Generator();
		Settings settings = new Settings();

		screen.showMainMenu();

		String choice = new String("q");
		Pattern pat = Pattern.compile("[1-9]");

		do {
			choice = screen.getInput();
			
			String[] parts = choice.split(" ");
			
			if(parts[0].equals("?")) {
				
			}
			
			if(pat.matcher(parts[0]).matches()) {
				
			}

		} while (!choice.toLowerCase().equals("q"));

	}
}
