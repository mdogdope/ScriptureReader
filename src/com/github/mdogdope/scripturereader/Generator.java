package com.github.mdogdope.scripturereader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		if (this.blocks.size() < index) {
			System.out.println("Can't get block. Invalid index.");
			return null;
		}

		return this.blocks.elementAt(index);
	}

	public void editBlock(int index, Block block) {

		if (this.blocks.size() <= index || index < 0) {
			System.out.println("Can't edit block. Invalid index.");
			return;
		}

		if (block.book != new String()) {
			this.blocks.elementAt(index).book = block.book;
		}

		if (block.chapter != 0) {
			this.blocks.elementAt(index).chapter = block.chapter;
		}

		if (block.start != 0) {
			this.blocks.elementAt(index).start = block.start;
		}

		if (block.end != 0) {
			this.blocks.elementAt(index).end = block.end;
		}
	}

	public Boolean fileExist(String fname, File dir) {
		File file = new File(dir, fname);
		return file.exists();
	}

	public void listBlocks() {
		String[] titles = { "Index", "Block Code" };
		System.out.println(titles[0] + " - " + titles[1]);
		for (int i = 0; i < this.blocks.size(); i++) {

			Block buff = this.blocks.elementAt(i);
			System.out.println(String.format("%d - %s ch%d %d %d", i, buff.book, buff.chapter, buff.start, buff.end));
		}
	}
	
	public void removeBlock(int index) {
		this.blocks.remove(index);
	}
	
	public void saveBlock(String fname, Settings settings) {

	}

	public void exportBlock(String fname, Settings settings) {
		String verseStart = settings.verseMark();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(settings.exportDirectory(), fname)));

			for (int i = 0; i < this.blocks.size(); i++) {

				if (this.blocks.elementAt(i).book.equals("split")) {
					writer.write("\n\n\n");
					continue;
				}

				if (this.blocks.elementAt(i).book.isEmpty() || this.blocks.elementAt(i).chapter == 0 || this.blocks.elementAt(i).start == 0) {
					continue;
				}

				String fileDir = "./BookOfMormonData/" + this.blocks.elementAt(i).book + "/CH"
						+ this.blocks.elementAt(i).chapter.toString() + ".dat";
				BufferedReader reader = new BufferedReader(new FileReader(new File(fileDir)));
				String line = new String();
				int counter = 1;
				while ((line = reader.readLine()) != null) {
					if (counter >= this.blocks.elementAt(i).start && counter <= this.blocks.elementAt(i).end) {
						writer.write(String.format("%s%s\n", verseStart, line));
					}
					counter++;
				}

				reader.close();
			}

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
