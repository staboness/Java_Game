package com.wavegame.main;

import java.awt.*;

public interface Spawnable {
    public Rectangle getBounds();
    public void tick();
    public void render(Graphics g);
}
