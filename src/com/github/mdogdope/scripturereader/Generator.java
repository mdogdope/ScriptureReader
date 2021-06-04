package com.github.mdogdope.scripturereader;

import java.util.Vector;

public class Generator {

	private Vector<Block> blocks = new Vector<Block>();
	
	public void addBlock(Block block) {
		this.blocks.add(block);
	}
	
	public void getBlock(int index) {
		if(this.blocks.size() < index) {
			System.out.println("Can't get block. Invalid index.");
			return;
		}
	}
	
}

