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
	
}

