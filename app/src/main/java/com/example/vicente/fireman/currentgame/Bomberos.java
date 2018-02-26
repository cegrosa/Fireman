package com.example.vicente.fireman.currentgame;

import com.example.vicente.fireman.generic.GameObject;

/**
 * Created by vicente on 14/02/18.
 */

public class Bomberos extends GameObject {

    public Bomberos() {
        super(Assets.bomb1);
        this.setX((this.getGraphics().getWidth() - this.getImage().getBitmap().getWidth()) / 2);
        this.setY(this.getGraphics().getHeight() - this.getImage().getBitmap().getHeight() - 15);
    }

    @Override
    public void update() {


        if (this.getX() + this.getSpeedX() > this.getGraphics().getWidth() - this.getImage().getBitmap().getWidth()) {
            this.setX(this.getGraphics().getWidth() - this.getImage().getBitmap().getWidth());
        } else {
            this.setX(this.getX() + this.getSpeedX());
        }

        if (this.getX() + this.getSpeedX() < 0) {
            this.setX(0);
        } else {
            this.setX(this.getX() + this.getSpeedX());
        }

        if (getTouchHandler().isMoving() && getTouchHandler().isMovingRight()) {
            this.setSpeedX(3);
        } else if (getTouchHandler().isMoving() && getTouchHandler().isMovingLeft()) {
            this.setSpeedX(-3);
        }else{
            this.setSpeedX(0);
        }
    }
}
