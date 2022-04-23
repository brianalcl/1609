package main;

import gui.GUI;
import imageFactory.DarkImageFactory;

public class Launcher {
	public static void main(String args[]) {
		new GUI(new DarkImageFactory(1280, 720));
	}
}
