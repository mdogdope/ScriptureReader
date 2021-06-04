package com.github.mdogdope.scripturereader;

import java.util.Vector;

public class Generator {

	private Vector<Block> blocks = new Vector<Block>();
	
	public void addBlock(Block block) {
		this.blocks.add(block);
	}
	
	public void addSplit() {
		this.blocks.add(new Block("split"));
	}
	
	public Block getBlock(int index) {
		if(this.blocks.size() < index) {
			System.out.println("Can't get block. Invalid index.");
			return null;
		}
		
		return this.blocks.elementAt(index);
	}
	
	public void editBlock(int index, Block block) {
		
		if(this.blocks.size() < index) {
			System.out.println("Can't edit block. Invalid index.");
			return;
		}
		
		if(block.book != new String()) {
			this.blocks.elementAt(index).book = block.book;
		}
		
		if(block.chapter != 0) {
			this.blocks.elementAt(index).chapter = block.chapter;
		}
		
		if(block.start != 0) {
			this.blocks.elementAt(index).start = block.start;
		}
		
		if(block.end != 0) {
			this.blocks.elementAt(index).end = block.end;
		}
	}
	
}

