package com.github.mdogdope.scripturereader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Parser {
	
	public Parser(Vector<ChapterData> chData) {
		for(int i = 0; i < chData.size(); i++) {
			for(int ii = 1; ii <= chData.elementAt(i).chapters; ii++) {
				System.out.println(String.format("Started Parsing %s - CH%d", chData.elementAt(i).name, ii));
				Vector<String> data = readRawFile(chData.elementAt(i).name, ii);
				for(int iii = 0; iii < data.size(); iii++) {
					System.out.println(String.format("Started Parsing Verse %d", iii + 1));
					data.set(iii, cleanData(data.get(iii)));
				}
				writeCleanFile(data, chData.elementAt(i).name, ii);
				System.out.println(String.format("Finished Parsing %s - CH%d", chData.elementAt(i).name, ii));
			}
		}
	}
	
	private void writeCleanFile(Vector<String> data, String name, Integer chapter) {
		
		File filePath = new File("BookOfMormonData/" + name);
		filePath.mkdir();
		String fileName = "BookOfMormonData/" + name + "/CH" + chapter + ".dat";
		
		try {
			BufferedWriter ofile = new BufferedWriter(new FileWriter(new File(fileName)));
			
			for(int i = 0; i < data.size(); i++) {
				ofile.write(String.format("%s\n", data.get(i)));
			}
			
			ofile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Vector<String> readRawFile(String name, Integer chapter){
		Vector<String> ret = new Vector<String>();
		
		File rawName = new File(String.format("BookOfMormonRaw/%s/CH%d.datraw", name, chapter));
		
		try {
			BufferedReader rawFile = new BufferedReader(new FileReader(rawName));
			
			while(rawFile.ready()) {
				ret.add(rawFile.readLine());
			}
			
			rawFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
	}
	
	private String cleanData(String rawLine){
		
		if(!rawLine.startsWith("<p")) {
			rawLine = rawLine.replaceFirst("</span>", "");
		}
		
		String line = rawLine.substring(rawLine.indexOf("</span>"));
		
		line = line.replace("</a>", "");
		line = line.replace("</span>", "");
		line = line.replaceAll("(</p>).*", "");
		
		while(line.contains("<") || line.contains(">")) {
			StringBuffer buff = new StringBuffer(line);
			
			if(line.contains("<span")) {
				int start = buff.indexOf("<span");
				int end = buff.indexOf(">", start) + 1;
				buff.replace(start, end, "");
				line = buff.toString();
				continue;
			}
			
			
			int start = buff.indexOf("<a");
			int end = buff.indexOf("sup>") + 4;
			
			buff.replace(start, end, "");
						
			line = buff.toString();
			
		}
		return line;
	}
}
