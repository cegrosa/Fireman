package com.example.vicente.fireman.currentgame;

import com.example.vicente.fireman.generic.GameObject;

/**
 * Created by vicente on 25/02/18.
 */

public class Life extends GameObject {

    private int life = 3;

    public Life() {
        super(Assets.life1);

        setX(0);
        setY(0);
    }

    @Override
    public void update() {
        switch (life) {
            case 3:
                this.setImage(Assets.life1);
                break;
            case 2:
                this.setImage(Assets.life2);
                break;
            case 1:
                this.setImage(Assets.life3);
                break;
            case 0:
                break;
        }
    }

    public int getLife() {
        return life;
    }

    public void lessLife() {
        life--;
    }
}
