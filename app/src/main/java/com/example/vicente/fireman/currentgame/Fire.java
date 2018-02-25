package com.example.vicente.fireman.currentgame;

import com.example.vicente.fireman.generic.GameObject;

import java.util.Random;

/**
 * Created by vicente on 25/02/18.
 */

public class Fire extends GameObject {


    public Fire() {
        super(Assets.fire);

        Random rand = new Random(System.nanoTime());
        int maxX = this.getGraphics().getWidth() - this.getImage().getBitmap().getWidth();

        this.setY(0);
        this.setX(rand.nextInt(maxX - 2 + 1) + 2);

        this.setSpeedY(rand.nextInt(8 - 3 + 1) + 3);
    }

    @Override
    public void update() {
        this.setY(this.getY() + this.getSpeedY());

        if (this.getY() + this.getSpeedY() > this.getGraphics().getHeight() - this.getImage().getBitmap().getHeight()) {
            this.setVisible(false);
        }
    }
}
