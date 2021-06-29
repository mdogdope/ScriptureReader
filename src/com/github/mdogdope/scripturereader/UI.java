package com.github.mdogdope.scripturereader;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UI {
	
	private Scanner scan = new Scanner(System.in);
	

	public UI() {
		
	}

	public String getInput() {
		String ret = new String();
		do {
			System.out.print(">> ");
			ret = scan.nextLine();
		} while (ret.isBlank());
		return ret;
	}
	
	protected void finalize() throws Throwable {
		this.scan.close();
	}
	
	public void showBlockHelp() {
		String[] menuItems = { "##################################################################################",
				"- Add a verse using the following without any < or >.", "\n\t<book code> <chapter> <verse>\n",
				"- Add multiple consecutive verses using the following without any < or >.",
				"\n\t<book code> <chapter> <first verse> <last verse>\n",
				"- Add a blank block that will act as a split.", "\n\tsplit\n",
				"- Remove an item using the following without any < or >.", "\n\tr <item number>\n",
				"- List all items using one of the following.", "\n\tlist\n\tshow\n\t=\n",
				"- Show this menu using one of the following.", "\n\t?\n\thelp\n", "\nShort Codes",
				"=====================", "1-ne ++++++ 1 Nephi", "2-ne ------ 2 Nephi", "jacob +++++ Jacob",
				"enos ------ Enos", "jarom +++++ Jarom", "omni ------ Omni", "w-of-m ++++ Words of Mormon",
				"mosiah ---- Mosiah", "alma ++++++ Alma", "hel ------- Helaman", "3-ne ++++++ 3 Nephi",
				"4-ne ------ 4 Nephi", "morm ++++++ Mormon", "ether ----- Ether", "moro ++++++ Moroni", "",
				"##################################################################################" };

		for (int i = 0; i < menuItems.length; i++) {
			System.out.println(menuItems[i]);
		}

	}

	public void showMainMenu() {

		// TODO: Print menu items as numbered list.

		String[] menuItems = { "Create new scripture block.", "Load saved scripture block.",
				"Edit selected scripture block.", "Delete saved scripture block(s).", "Settings menu." };

		String[] specialItems = { "?: Display help", "Q: Quit" };

		for (int i = 0; i < menuItems.length; i++) {
			System.out.println(Integer.toString(i + 1) + ": " + menuItems[i]);
		}

		for (int i = 0; i < specialItems.length; i++) {
			System.out.println(specialItems[i]);
		}

	}

	public File getDirectory() {
		JFileChooser chooser = new JFileChooser();
		chooser.updateUI();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chooser.updateUI();
		chooser.showSaveDialog(null);

		return chooser.getCurrentDirectory();
	}

}
