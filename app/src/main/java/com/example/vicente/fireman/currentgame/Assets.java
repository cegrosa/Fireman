package com.example.vicente.fireman.currentgame;

import com.example.vicente.fireman.media.Image;
import com.example.vicente.fireman.media.Graphics;

public class Assets {

    public static Image bground, bomb1, bomb2, peasant1, peasant2, fire;
    public static Image life1, life2, life3;

    public static void load(Graphics g) {
        Assets.bground = g.newImage("bgroung.jpg");
        Assets.bomb1 = g.newImage("bomb1.png");
        Assets.bomb2 = g.newImage("bomb2.png");
        Assets.peasant1 = g.newImage("peasant1.png");
        Assets.peasant2 = g.newImage("peasant2.png");
        Assets.fire = g.newImage("fire.png");

        Assets.life1 = g.newImage("lf1.png");
        Assets.life2 = g.newImage("lf2.png");
        Assets.life3 = g.newImage("lf3.png");
    }
}