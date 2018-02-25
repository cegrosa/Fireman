package com.example.vicente.fireman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import com.example.vicente.fireman.currentgame.Assets;
import com.example.vicente.fireman.currentgame.Bomberos;
import com.example.vicente.fireman.currentgame.Fire;
import com.example.vicente.fireman.currentgame.Fondo;
import com.example.vicente.fireman.currentgame.Life;
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

    private int lf = 3;
    private int score = 0;

    @Override
    public void start() {
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
            lf--;

            switch (lf) {
                case 3:
                    life.setImage(Assets.life1);
                    break;
                case 2:
                    life.setImage(Assets.life2);
                    break;
                case 1:
                    life.setImage(Assets.life3);
                    break;
                case 0:
                    showEndGame();
                    break;
            }

            f.setVisible(false);

            return true;
        }

        return false;
    }

    public void showEndGame() {

        Log.v("xyzyx", "Tu puntuacion:" + score);
        AlertDialog.Builder dialogRemove = new AlertDialog.Builder(JuegoNuevo.this);
        dialogRemove.setTitle("Tu puntuación: ");
        dialogRemove.setMessage("" + score);
        dialogRemove.setPositiveButton("Reiniciar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                JuegoNuevo.this.finish();
                Intent intent = new Intent(JuegoNuevo.this, JuegoNuevo.class);
                startActivity(intent);
            }
        });
        dialogRemove.setNegativeButton("Cerar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog1, int id) {
                JuegoNuevo.this.finish();
            }
        });
        dialogRemove.show();
    }
}
