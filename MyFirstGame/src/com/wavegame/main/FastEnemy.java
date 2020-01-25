package com.wavegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject implements Spawnable {

	private Handler handler;
	private Spawn spawn = new Spawn();
	
	public FastEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		velX = 2;
		velY = 11;
		this.handler = handler;
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		//This is for not going out of borders
		if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 20) velX *= -1;
		
		spawn.spawnTrail(handler,x,y,Color.cyan);
	}

	//Make their color and size
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
