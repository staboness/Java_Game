package com.wavegame.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -91312363743776375L;
	
	public Window(int width, int height, String title, Game game){
		JFrame frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exit button
		frame.setResizable(false); //Not able to change frame size
		frame.setLocationRelativeTo(null); //Window appears in center
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	

}
