package com.github.mdogdope.scripturereader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Scraper {
	
	Vector<ChapterData> chData = new Vector<ChapterData>();
	
	public Scraper() {
		
		File rawDir = new File("BookOfMormonRaw");
		if(!rawDir.exists()) {
			rawDir.mkdir();
		}
		
		this.chData = getChData();
		
		for(int i = 0; i < chData.size(); i++) {
			for(int ii = 1; ii <= chData.elementAt(i).chapters; ii++) {
				System.out.println(String.format("Starting %s - CH%d", chData.elementAt(i).name, ii));
				
				Document rawData = fetchUrlData(makeUrl(chData.elementAt(i).name, ii));
				writeFile(rawData, chData.elementAt(i).name,ii);
				
				System.out.println(String.format("Finished %s - CH%d", chData.elementAt(i).name, ii));
			}
		}
		System.out.println("Done Scraping Data.");
	}
	
	private Document fetchUrlData(String url) {
		Document ret = null;
		try {
			ret = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	private void writeFile(Document data, String name, Integer chapter) {
		
		File filePath = new File("BookOfMormonRaw/" + name);
		filePath.mkdir();
		String fileName = "BookOfMormonRaw/" + name + "/CH" + chapter + ".datraw";
		
		Vector<String> lines = new Vector<String>();
		Collections.addAll(lines,data.html().split("\\n"));
		try {
			BufferedWriter ofile = new BufferedWriter(new FileWriter(new File(fileName)));
			for(int i = 0; i < lines.size(); i++) {
				if(lines.get(i).contains("class=\"verse-number\"")) {
					ofile.write(lines.get(i).strip() + "\n");
				}
			}
			
			ofile.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String makeUrl(String name, int chapter) {
		final String baseBomUrl = "https://www.churchofjesuschrist.org/study/scriptures/bofm/%s/%d?lang=eng";
		return String.format(baseBomUrl, name, chapter);
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
