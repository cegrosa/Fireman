package com.example.vicente.fireman;

import android.content.Intent;
import android.util.Log;

import com.example.vicente.fireman.currentgame.Life;
import com.example.vicente.fireman.currentgame.Assets;
import com.example.vicente.fireman.currentgame.Bomberos;
import com.example.vicente.fireman.currentgame.Fire;
import com.example.vicente.fireman.currentgame.Fondo;
import com.example.vicente.fireman.generic.GenericGameActivity;
import com.example.vicente.fireman.currentgame.Peasant;

/**
 * Created by vicente on 14/02/18.
 */

public class JuegoNuevo extends GenericGameActivity {

    private Bomberos bombero;
    private Peasant peasant1, peasant2, peasant3;
    private Fire fire1, fire2, fire3;
    private Life life;

    public static JuegoNuevo contextJuegoNuevo;

    private int score = 0;

    @Override
    public void start() {
        contextJuegoNuevo = JuegoNuevo.this;
        addGameObject(new Fondo());

        bombero = new Bomberos();
        addGameObject(bombero);

        life = new Life();
        addGameObject(life);

        peasant1 = new Peasant();
        addGameObject(peasant1);
        peasant2 = new Peasant();
        addGameObject(peasant2);

        fire1 = new Fire();
        addGameObject(fire1);
        fire2 = new Fire();
        addGameObject(fire2);
        fire3 = new Fire();
        addGameObject(fire3);
    }

    @Override
    public void update() {
        super.update();

        bombero.setImage(Assets.bomb1);

        if (!peasant1.isVisible()) {
            peasant1 = new Peasant();
            addGameObject(peasant1);
        }

        if (!peasant2.isVisible()) {
            peasant2 = new Peasant();
            addGameObject(peasant2);
        }

        if (!fire1.isVisible()) {
            fire1 = new Fire();
            addGameObject(fire1);
        }

        if (!fire2.isVisible()) {
            fire2 = new Fire();
            addGameObject(fire2);
        }

        if (!fire3.isVisible()) {
            fire3 = new Fire();
            addGameObject(fire3);
        }

        collisionPB(peasant1, bombero);
        collisionPB(peasant2, bombero);

        collisionFB(fire1, bombero);
        collisionFB(fire2, bombero);
        collisionFB(fire3, bombero);
    }

    private boolean collisionPB(Peasant p, Bomberos b) {
        boolean collision = p.instersects(b);

        if (collision) {
            b.setImage(Assets.bomb2);
            p.setVisible(false);
            score++;

            return true;
        }

        return false;
    }

    private boolean collisionFB(Fire f, Bomberos b) {
        boolean collision = f.instersects(b);

        if (collision) {
            life.lessLife();

            if (life.getLife() <= 0) {
                showEndGame();
            }

            f.setVisible(false);

            return true;
        }

        return false;
    }

    public void showEndGame() {

        Log.v("xyzyx", "Tu puntuacion:" + score);
        Intent intent = new Intent(JuegoNuevo.this, MainActivity.class);
        intent.putExtra("score", score + "");
        startActivity(intent);
    }
}
