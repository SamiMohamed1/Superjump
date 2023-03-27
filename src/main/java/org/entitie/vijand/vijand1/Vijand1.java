package org.entitie.vijand.vijand1;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.entitie.Hitbox;
import org.entitie.projectiel.ProjectielCollision;
import org.entitie.speler.Speler;
import org.entitie.vijand.Vijand;

import java.util.Set;

public class Vijand1 extends Vijand implements KeyListener, Collider, UpdateExposer, ProjectielCollision, SceneBorderCrossingWatcher {
    Speler richting;

    private boolean spelerBeweegt = false;

    private int levens;
    private int sterkte;


    public Vijand1(Coordinate2D initialLocation, Speler richting, int levens, int sterkte) {
        super(initialLocation, levens, sterkte, new Size(50, 50));
        this.richting = richting;
        this.levens = levens;
        this.sterkte = sterkte;

    }

    protected void setupEntities() {
        Hitbox hitbox = new Hitbox(new Coordinate2D(0, 0), 50, 50);
        addEntity(hitbox);
        Vijand1Sprite vijand1Sprite = new Vijand1Sprite(new Coordinate2D(0, 0));
        addEntity(vijand1Sprite);
        //  System.out.println(richting.getAnchorLocation());
//          Hitbox hitbox = new Hitbox(new Coordinate2D(0,0),50,50);
//          addEntity(hitbox);

    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.LEFT) || set.contains(KeyCode.UP) || set.contains(KeyCode.DOWN) || set.contains(KeyCode.RIGHT)) {
            if (richting.getBoundingBox().getMinX() > getBoundingBox().getMinX()) {
                setMotion(3, 90);
            }
            if (richting.getBoundingBox().getMinX() < getBoundingBox().getMinX()) {
                setMotion(3, 270);
            }
            if (richting.getBoundingBox().getMinY() > getBoundingBox().getMinY()) {
                //     setMotion(1, 0);
                System.out.println(99);
            }
            if (richting.getBoundingBox().getMinY() > getBoundingBox().getMinY()) {
                //     setMotion(1, 180);
                System.out.println(0);
            }
            spelerBeweegt = true;
        } else {
            spelerBeweegt = false;
        }
        vijandDoe();


        if (richting.getBoundingBox().getMinX() > getBoundingBox().getMinX()) {
            setMotion(1, 90);
        }
        if (richting.getBoundingBox().getMinX() < getBoundingBox().getMinX()) {
            setMotion(1, 270);
        }
        if (richting.getBoundingBox().getMinY() > getBoundingBox().getMinY()) {
            //     setMotion(1, 0);

        }
        if (richting.getBoundingBox().getMinY() > getBoundingBox().getMinY()) {
            //     setMotion(1, 180);

        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
    }

    @Override
    public void PlayerCollision(Speler speler) {
        speler.geraaktDoorVijand(sterkte);

        setAnchorLocationX(getBoundingBox().getMinX() - (getWidth() * 5));
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void vijandDoe() {
        if (spelerBeweegt == false) {
            if (getDirection() != 0.0) {

                setMotion(1, getDirection());
            }
        }
    }


    @Override
    public void spelerProjectilCollision(int spelersterkte) {
        levens = levens - spelersterkte;
        System.out.println("levens:" + levens);
        System.out.println("sterkte:" + spelersterkte);
        if (levens <= 0) {
            remove();
        }
    }

    @Override
    public void enemyProjectilCollision() {

    }
    @Override
    public void explicitUpdate(long l) {
        vijandDoe();
    }
}

