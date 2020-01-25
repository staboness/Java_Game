package com.wavegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject implements Spawnable {

	private Handler handler;
	private Spawn spawn = new Spawn();

	public BasicEnemy(float x, float y, ID id, Handler handler) {
		super(x, y, ID.BasicEnemy);
		velX = 5;
		velY = 5;
		this.handler = handler;
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x,(int) y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		//This is for not going out of borders
		if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 20) velX *= -1;
		
		spawn.spawnTrail(handler,x,y,Color.red);
	}

	//Make their color and size
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
		
	}
}
