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
    private Speler richting;
    private double spelerRichting =0;
    Coordinate2D andereRichting = getLocationInScene();
    Coordinate2D playerRichting = richting.getAnchorLocation();
    public Vijand1(Coordinate2D initialLocation,Speler richting, int health, int sterkte) {
        super(initialLocation, health, sterkte, new Size(50,50));
        this.richting = richting;

    }
    protected void setupEntities() {
          Hitbox hitbox = new Hitbox(new Coordinate2D(0,0),50,50);
          addEntity(hitbox);
        Vijand1Sprite vijand1Sprite = new Vijand1Sprite(new Coordinate2D(getWidth()/2,200));
        addEntity(vijand1Sprite);
    //    System.out.println(vijand1Sprite.getAnchorLocation());
        System.out.println(richting.getAnchorLocation());
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
//if(playerRichting > andereRichting)
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
        System.out.println();
    }
}
