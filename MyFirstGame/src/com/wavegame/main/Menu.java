package com.wavegame.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.wavegame.main.Game.STATE;


public class Menu extends MouseAdapter {
	Random r = new Random();	
	private Game game;
	private Handler handler;
	private HUD hud;
	
	public Menu(Game game, Handler handler, HUD hud){
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		if(game.gameState == STATE.Menu){
		//play button
		if(mouseOver(mx, my, 210, 100, 200, 64)) {
			game.gameState = STATE.Game;
			handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player, handler));
			handler.clearEnemys();
			handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
		}
			//quit button
			if(mouseOver(mx, my, 210, 300, 200, 64)){
			System.exit(1);
			}
			//help button
			if(mouseOver(mx,my, 210, 200, 200, 64)){
			game.gameState = STATE.Help;
			}
		}
		//back button for help
		if(game.gameState == STATE.Help){
			if(mouseOver(mx,my, 10, 10, 100, 48)){
				game.gameState = STATE.Menu;
				return;
			}
		}
		if(game.gameState == STATE.End){
			if(mouseOver(mx,my, 10, 10, 230, 48)){
				game.gameState = STATE.Menu;
				hud.setLevel(1);
				hud.score(0);
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my,int x, int y, int width, int height){
		if (mx > x && mx < x + width){
			if (my > y && my < y + height){
				return true;
			} else return false;
		} else return false;
	}
	
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		if(game.gameState == STATE.Menu){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Wave", 245, 40);
			
			g.setFont(fnt2);
			g.drawRect(210, 100, 200, 64);
			g.drawString("Play", 280, 145);
			
			g.setColor(Color.white);
			g.drawRect(210, 200, 200, 64);
			g.drawString("Help", 280, 245);
			
			g.setColor(Color.white);
			g.drawRect(210, 300, 200, 64);
			g.drawString("Quit", 280, 345);
		} else if (game.gameState == STATE.Help){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", 270, 100);
			
			g.setFont(fnt2);
			g.drawString("Use arrow keys to dodge enemies", 100, 150);
			
			g.setFont(fnt2);
			g.drawRect(10, 10, 100, 48);
			g.drawString("Back", 25, 45);
		} else if (game.gameState == STATE.End){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 190, 100);
			
			g.setFont(fnt2);
			g.drawString("You lost with a score of: " + hud.getScore(), 120, 150);
			
			g.setFont(fnt2);
			g.drawRect(10, 10, 230, 48);
			g.drawString("Return to menu", 15, 45);
		}
	}
}
