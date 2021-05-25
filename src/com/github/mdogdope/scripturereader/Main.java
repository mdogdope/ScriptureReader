package com.github.mdogdope.scripturereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Main {
	
	
	public static void main(String[] args) {
		
		
//		Vector<BookData> chData = getChData();
//		new Scraper(chData);
//		new Parser(chData);

		/*
		 * ####### Ideas #######
		 * Show short codes for the books
		 * Let user enter book "name ch [end] [verse [end]]"
		 * On first start have user set speed/pitch/volume
		 * Let user enter stops to take a break in reading.
		 * - at break let user continue or replay last or pick spot(include exit option).
		 * - let user quit at any break
		 * - adjust speed/pitch/volume. Shows current levels for reference.
		 * 
		 */
	}
	
	private static Vector<ChapterData> getChData(){
		Vector<ChapterData> rData = new Vector<ChapterData>();
		try {
			BufferedReader chData = new BufferedReader(new FileReader("bookchCount.txt"));
			while(chData.ready()) {
				String raw = chData.readLine();
				String[] data = raw.split(":");
				ChapterData temp = new ChapterData();
				temp.name = data[0];
				temp.chapters = Integer.parseInt(data[1]);
				rData.add(temp);
			}
			
			chData.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rData;
	}
}
