package com.github.mdogdope.scripturereader;

import java.util.Vector;

public class Book {
	private String name = new String();
	private Integer chapter = 0;
	private Integer start = 0;
	private Integer end = 0;
	
	public Book(String name, Integer ch, Integer start, Integer end) {
		this.name = name;
		this.chapter = ch;
		this.start = start;
		this.end = end;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getChapter() {
		return this.chapter;
	}
	
	public Integer[] getVerses() {
		Vector<Integer> verses = new Vector<Integer>();
		for(int i = start; i <= end; i++) {
			verses.add(i);
		}
		return (Integer[]) verses.toArray();
	}
}
