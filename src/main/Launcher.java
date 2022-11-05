package main;

import java.awt.Dimension;

import abstractFactory.DarkFactory;
import gui.GUI;
import sound.Sound;

public class Launcher {
	public static void main(String args[]) {
		new GUI(new DarkFactory(new Dimension(1280, 720)), new Sound());
	}
}
