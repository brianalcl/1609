package main;

import general.gui.GUI;
import imageFactory.DarkImageFactory;

public class Launcher {
	public static void main(String args[]) {
		new GUI(new DarkImageFactory(1280, 720, new java.awt.Color(47, 79, 79)));
	}
}
