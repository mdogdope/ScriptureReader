package com.github.mdogdope.scripturereader;

public class Main {

	public static void main(String[] args) {

		UI screen = new UI();
		Generator gen = new Generator();
		Settings settings = new Settings();

		screen.showMainMenu();

		String choice = new String("q");

		do {
			choice = screen.getInput();

			if (choice.equals("?")) {
				screen.showBlockHelp();
			}else if (choice.toLowerCase().equals("split")) {
				gen.addSplit();
			}else if(choice.toLowerCase().equals("show") || choice.toLowerCase().equals("list")) {
				gen.listBlocks();
			}else if(choice.equals("export")) {
				gen.exportBlock("test.txt", settings);
			}else if (choice.length() > 1 && choice.contains(" ")) {
				String[] params = choice.split(" ");
				
				if(params[0].equals("r")){
					gen.removeBlock( Integer.parseInt(params[1]));
				}else if (params.length == 3) {
					gen.addBlock(new Block(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2])));
				} else {
					gen.addBlock(new Block(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]),
							Integer.parseInt(params[3])));
				}
			}

		} while (!choice.toLowerCase().equals("q"));

//		Vector<BookData> chData = getChData();
//		new Scraper(chData);
//		new Parser(chData);

		/*
		 * ####### Ideas ####### Show short codes for the books Let user enter book
		 * "name ch [end] or [start end]" On first start have user set
		 * speed/pitch/volume Let user enter stops to take a break in reading. - at
		 * break let user continue or replay last or pick spot(include exit option). -
		 * let user quit at any break - adjust speed/pitch/volume. Shows current levels
		 * for reference.
		 * 
		 */
	}
}
