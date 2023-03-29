package org.entitie.vijand.baas;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.entitie.PlayerCollision;
import org.SuperJumpGame;
import org.entitie.Hitbox;
import org.entitie.speler.Speler;
import org.entitie.vijand.Vijand;

public class Baas extends Vijand implements PlayerCollision, Collided, Collider {
    SuperJumpGame superJumpGame = new SuperJumpGame();
    public Baas(Coordinate2D initialLocation, int levens, int sterkte, SuperJumpGame superJumpGame) {
        super(initialLocation, levens, sterkte,new Size(50,50));
        this.superJumpGame = superJumpGame;
    }
    protected void setupEntities() {
       Hitbox hitbox = new Hitbox(new Coordinate2D(0,0),50,50);
       addEntity(hitbox);
        BaasSprite baasSprite = new BaasSprite(new Coordinate2D(0,0));
        addEntity(baasSprite);
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void PlayerCollision(Speler speler) {
    speler.setLevens(-sterkte*100);
    }
    public void setLeven(int verandering){
        levens = levens + verandering;
    }
    @Override
    public void spelerProjectilCollision(int spelersterkte) {
        setLeven(-3);
        if (levens <= 0) {
            remove();
            superJumpGame.setActiveScene(3);
        }
    }





    public int getSterkte() {
        return sterkte;
    }

    @Override
    public void vijandDoe() {

    }
}
