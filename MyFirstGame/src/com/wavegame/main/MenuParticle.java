package com.wavegame.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject implements Spawnable {

	private Handler handler;
	private Spawn spawn = new Spawn();
	Random r = new Random();
	
	private Color col;
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		velX = (r.nextInt(7 - - 7) + - 7);
		velY = (r.nextInt(7 - - 7) + - 7);
		if (velX == 0) velX = 1;
		if (velY == 0) velY = 1;
		this.handler = handler;
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
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
		
		spawn.spawnTrail(handler,x,y,col);
	}

	//Make their color and size
	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int)x, (int)y, 16, 16);
	}

}
