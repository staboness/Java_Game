package com.wavegame.main;

import java.util.Random;

public class GameSpawn {
	
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	private Spawn spawn = new Spawn();
	private GameObject player;
	private float playerXPos, playerYPos;
	private int scoreKeep = 0;
	
	public GameSpawn(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}

	public void tick(){
		scoreKeep++;
		if(scoreKeep >= 500){
			scoreKeep = 0;
			hud.setLevel((int) (hud.getLevel() + 1));
			if(hud.getLevel() == 2){
				spawn.spawnBasic(handler);
			} else if(hud.getLevel() == 3){
				spawn.spawnBasic(handler);
			} else if(hud.getLevel() == 4){
				spawn.spawnFast(handler);
			} else if(hud.getLevel() == 5){
				spawn.spawnSmart(handler);
			} else if(hud.getLevel() == 6){
				spawn.spawnFast(handler);
			} else if(hud.getLevel() == 7){
				spawn.spawnFast(handler);
			} else if(hud.getLevel() == 8){
				spawn.spawnSmart(handler);
			} else if(hud.getLevel() == 9){
				spawn.spawnBasic(handler);
			} else if(hud.getLevel() == 10){
				for (int i = 0; i < handler.object.size(); i++){
					if (handler.object.get(i).getId() == ID.Player){
						player = handler.object.get(i);
						playerXPos = player.getX();
						playerYPos = player.getY();
					}
				}
				handler.clearEnemies();
				handler.addObject(new Player(playerXPos, playerXPos, ID.Player, handler));
				spawn.bossSpawn(handler);
			}
		}
	
	}
}
