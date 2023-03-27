package org.entitie.vijand.baas;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.scenes.SceneBorder;
import javafx.scene.input.KeyCode;
import org.PlayerCollision;
import org.entitie.Hitbox;
import org.entitie.speler.Speler;
import org.entitie.vijand.Vijand;

import java.util.Set;

public class Baas extends Vijand implements PlayerCollision {
    public Baas(Coordinate2D initialLocation, int levens, int sterkte) {
        super(initialLocation, levens, sterkte,new Size(50,50));
    }
    protected void setupEntities() {
       Hitbox hitbox = new Hitbox(new Coordinate2D(0,0),50,50);
       addEntity(hitbox);
        BaasSprite baasSprite = new BaasSprite(new Coordinate2D(0,0));
        addEntity(baasSprite);
        System.out.println(baasSprite.getAnchorLocation());
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void PlayerCollision(Speler speler) {
//        speler.geraaktDoorVijand(speler.set);

    }
    public void setLeven(int verandering){
        levens = levens + verandering;
    }
    @Override
    public void spelerProjectilCollision(int spelersterkte) {

    }

    @Override
    public void enemyProjectilCollision() {
        setLeven(-3);
    }

    @Override
    public void vijandDoe() {
        //schiet
    }

    public int getSterkte() {
        return sterkte;
    }
}
