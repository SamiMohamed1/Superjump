package org.entitie.vijand.vijand1;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.entitie.Hitbox;
import org.entitie.speler.Speler;
import org.entitie.vijand.Vijand;
import org.entitie.vijand.baas.BaasSprite;
import org.entitie.vijand.vijand2.Vijand2;
import org.entitie.vijand.vijand2.Vijand2Sprite;

import java.util.Set;

public class Vijand1 extends Vijand implements KeyListener, Collider {
    Speler richting;

    public Vijand1(Coordinate2D initialLocation,Speler richting, int health, int sterkte) {
        super(initialLocation, health, sterkte, new Size(50,50));
        this.richting = richting;

    }
    protected void setupEntities() {
          Hitbox hitbox = new Hitbox(new Coordinate2D(0,0),50,50);
          addEntity(hitbox);
        Vijand1Sprite vijand1Sprite = new Vijand1Sprite(new Coordinate2D(getWidth()/2,200));
        addEntity(vijand1Sprite);
        System.out.println(richting.getAnchorLocation());
    }


    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

        if (richting.getBoundingBox().getMinX() > getBoundingBox().getMinX()) {
            setMotion(1, 90);
        }
        if (richting.getBoundingBox().getMinX() < getBoundingBox().getMinX()) {
            setMotion(1, 270);
        }
        if (richting.getBoundingBox().getMinY() > getBoundingBox().getMinY()) {
       //     setMotion(1, 0);
            System.out.println(99);
        }
            if (richting.getBoundingBox().getMinY() > getBoundingBox().getMinY()) {
           //     setMotion(1, 180);
                System.out.println(0);
            }
        }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
    }

    @Override
    public void PlayerCollision(Speler speler) {
    speler.geraaktDoorVijand(sterkte);
        System.out.println();
        setAnchorLocationX(getBoundingBox().getMinX()- (getWidth()*5));
    }

    @Override
    public void onCollision(Collider collider) {

    }
}
