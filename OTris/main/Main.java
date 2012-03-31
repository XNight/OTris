package main;

import javax.swing.JFrame;

import view.Playground;

import controller.GameHandler;

public class Main {

	public static void main(String args[]){
		
		JFrame mFrame = new JFrame();
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setSize(500,500);
		mFrame.setResizable(false);
		Playground p = new Playground();
		mFrame.add(p);
		mFrame.setVisible(true);
		
		GameHandler gh = new GameHandler(p);
			
	}
	
}
