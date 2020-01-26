package com.wavegame.main;

import java.awt.Graphics;
import java.util.LinkedList;
//Handling all gameobjects
public class Handler {
	
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick(){
		for (int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g){
		for (int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}
	
	public void clearEnemies(){
		for (int i = 0; i < object.size(); i++){
			object.clear();
		}
	}
	
	public void addObject(GameObject object){
		this.object.add(object);
		/* Debugging
		for (int i = 0; i < this.object.size(); i++){
			if (this.object.get(i).getId() == ID.Player) {
				System.out.println(this.object.get(i).getId());
			}
		}*/
	}
	
	public void removeObject(GameObject object){
		this.object.remove(object);
	}
	
}
