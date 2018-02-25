package com.example.vicente.fireman.currentgame;

import com.example.vicente.fireman.generic.GameBackground;

/**
 * Created by vicente on 14/02/18.
 */

public class Fondo extends GameBackground {

    public Fondo() {
        super(Assets.bground);
        this.setMovement(Movement.STILL);
    }
}
