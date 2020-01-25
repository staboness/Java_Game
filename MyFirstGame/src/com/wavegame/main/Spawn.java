package com.wavegame.main;

import java.awt.*;
import java.util.Random;

import static com.wavegame.main.Game.WIDTH;
import static com.wavegame.main.Game.HEIGHT;

public class Spawn {
    private Spawnable BSEnemy;
    private Spawnable PlayerSpawn;
    private Spawnable BossSpawn;
    private Spawnable FEnemy;
    private Spawnable MPSpawn;
    private Spawnable SEnemy;
    private Spawnable Trail;
    private Spawnable BossBullet;
    private Random r = new Random();

    public void spawnBasic(Handler handler){
        handler.addObject((GameObject) (BSEnemy = new BasicEnemy(r.nextInt(WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler)));
    }
    public void spawnFast(Handler handler){
        handler.addObject((GameObject) (FEnemy = new FastEnemy(r.nextInt(WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler)));
    }
    public void playerSpawn(Handler handler){
        handler.addObject((GameObject) (PlayerSpawn = new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player, handler)));
    }
    public void menuParticlesSpawn(Handler handler){
        handler.addObject((GameObject) (MPSpawn = new MenuParticle(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.MenuParticle, handler)));
    }
    public void spawnSmart(Handler handler){
        handler.addObject((GameObject) (SEnemy = new SmartEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.SmartEnemy, handler)));
    }
    public void spawnTrail(Handler handler, float x, float y, Color color){
        handler.addObject((GameObject) (Trail = new Trail(x, y, ID.Trail, color, 16, 16, 0.02f, handler)));
    }
    public void spawnBossBullet(Handler handler, float x, float y){
        handler.addObject((GameObject) (BossBullet = new EnemyBossBullet((int)x + 48, (int)y + 48, ID.BasicEnemy, handler)));
    }
    public void bossSpawn(Handler handler){
        handler.addObject((GameObject) (BossSpawn = new EnemyBoss((Game.WIDTH / 2) - 48, -120, ID.EnemyBoss, handler)));
    }
}
