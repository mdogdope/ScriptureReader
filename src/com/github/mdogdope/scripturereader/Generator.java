package com.github.mdogdope.scripturereader;

import java.util.Vector;

public class Generator {
		
	private Vector<Book> sections = new Vector<Book>();
	
	public void add(String name, Integer chapter, Integer start, Integer end) {
		this.sections.add(new Book(name, chapter, start, end));
	}
	
	public void remove() {
		
	}
	
	public Vector<Book> getAll() {
		return this.sections;
	}
	
	private String transCode(String code) {
		String name = new String();
		final String[] names = {"1 Nephi", "2 Nephi", "Jacob", "Enos", "Jarom", "Omni", "Words of Mormon", "Mosiah", "Alma", "Helaman", "3 Nephi", "4 Nephi", "Mormon", "Ether", "Moroni"};
		final String[] codes = {"1-ne", "2-ne", "jacob", "enos", "jarom", "omni", "w-of-m", "mosiah", "alma", "hel", "3-ne", "4-ne", "morm", "ether", "moro"};
		
		for(int i = 0; i < codes.length; i++) {
			if(code.equals(codes[i])) {
				name = names[i];
				break;
			}
		}
		return name;
	}
	
}
