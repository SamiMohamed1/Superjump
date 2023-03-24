package org.entitie.vijand.vijand1;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.entitie.speler.Speler;
import org.entitie.vijand.Vijand;
import org.entitie.vijand.baas.BaasSprite;
import org.entitie.vijand.vijand2.Vijand2;
import org.entitie.vijand.vijand2.Vijand2Sprite;

import java.util.Set;

public class Vijand1 extends Vijand implements KeyListener, Newtonian, Collider {
    private Speler richting;
    private double spelerRichting =0;
    public Vijand1(Coordinate2D initialLocation,Speler richting, int health, float sterkte) {
        super(initialLocation, health, sterkte, new Size(50,50));
        this.richting = richting;

    }
    protected void setupEntities() {
        //  Hitbox hitbox = new Hitbox();
        Vijand1Sprite vijand1Sprite = new Vijand1Sprite(new Coordinate2D(getWidth()/2,200));
        addEntity(vijand1Sprite);
        System.out.println(vijand1Sprite.getAnchorLocation());
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        spelerRichting =  richting.getBoundingBox().getCenterX();
        System.out.println(spelerRichting);
        if(spelerRichting >getSceneWidth()/2){
            setMotion(3,90);
            System.out.println(getSceneWidth());
        }
        else if(spelerRichting <getSceneWidth()/2){
            setMotion(3,270);
        }

    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }

    @Override
    public void PlayerCollision(Speler speler) {
    speler.geraaktDoorVijand(sterkte);
    }
}
