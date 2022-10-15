package main;

import java.awt.Dimension;

import factory.ColorfulFactory;
import gui.GUI;
import sound.Sound;

public class Launcher {
	public static void main(String args[]) {
		new GUI(new ColorfulFactory(new Dimension(1280, 720)), new Sound());
	}
}
