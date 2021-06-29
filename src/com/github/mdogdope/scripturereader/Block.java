package com.github.mdogdope.scripturereader;

public class Block {
	public String book = new String();
	public Integer chapter = 0;
	public Integer start = 0;
	public Integer end = 0;
	
	public Block() {
		
	}
	
	public Block(String book) {
		this.book = book;
	}
	
	public Block(String book, int chapter, int start) {
		this.book = book;
		this.chapter = chapter;
		this.start = start;
		this.end = start;
	}
	
	public Block(String book, int chapter, int start, int end) {
		this.book = book;
		this.chapter = chapter;
		this.start = start;
		this.end = end;
	}
	
}

