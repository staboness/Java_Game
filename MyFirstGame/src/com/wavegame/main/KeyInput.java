package com.wavegame.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Handler handler;
	//fix key stuck
	private boolean[] keyDown = new boolean[4];
	
	public KeyInput(Handler handler){
		this.handler = handler;
		keyDown[0/*up*/] = false;
		keyDown[1/*down*/] = false;
		keyDown[2/*right*/] = false;
		keyDown[3/*left*/] = false;
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				if (key == KeyEvent.VK_UP) { tempObject.setVelY(-5); keyDown[0] = true; }
				if (key == KeyEvent.VK_DOWN) { tempObject.setVelY(5); keyDown[1] = true; }
				if (key == KeyEvent.VK_RIGHT) { tempObject.setVelX(5); keyDown[2] = true; }
				if (key == KeyEvent.VK_LEFT) { tempObject.setVelX(-5); keyDown[3] = true; }
			}
			
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
			
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				if (key == KeyEvent.VK_UP) keyDown[0] = false;//tempObject.setVelY(0);
				if (key == KeyEvent.VK_DOWN) keyDown[1] = false;//tempObject.setVelY(0);
				if (key == KeyEvent.VK_RIGHT) keyDown[2] = false;//tempObject.setVelX(0);
				if (key == KeyEvent.VK_LEFT) keyDown[3] = false;//tempObject.setVelX(0);
				//vertical movement
				if(!keyDown [0] && !keyDown[1]) tempObject.setVelY(0);
				//horizontal movement
				if(!keyDown [2] && !keyDown[3]) tempObject.setVelX(0);
			}
			
		}
	}
	
}
