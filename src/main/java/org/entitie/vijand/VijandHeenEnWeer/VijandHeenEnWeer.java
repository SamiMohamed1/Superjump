package org.entitie.vijand.VijandHeenEnWeer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.entitie.PlayerCollision;
import org.entitie.Hitbox;
import org.entitie.projectiel.SpelerProjectielCollision;
import org.entitie.speler.Speler;
import org.entitie.vijand.Vijand;


public class VijandHeenEnWeer extends Vijand implements PlayerCollision,Collider, SpelerProjectielCollision,UpdateExposer,SceneBorderCrossingWatcher {
    private int bewegingsRichting;
    public VijandHeenEnWeer(Coordinate2D initialLocation, int levens, int sterkte) {
        super(initialLocation, levens, sterkte,  new Size(50,50));
        setMotion(2,90);
        vijandDoe();
    }
    protected void setupEntities() {
         Hitbox hitbox = new Hitbox(new Coordinate2D(0,0),50,50);
         addEntity(hitbox);
        VijandHeenEnWeerSprite vijand2Sprite = new VijandHeenEnWeerSprite(new Coordinate2D(0,0), new Size(50,50));
        addEntity(vijand2Sprite);
    }
    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case LEFT:
               bewegingsRichting = 0;
                break;
            case RIGHT:
                bewegingsRichting = 1;
        }
        vijandDoe();
    }
    public void beweeg(){
        if (bewegingsRichting == 0){
            setMotion(2,90);
        }
        if (bewegingsRichting == 1){
            setMotion(2,270);
        }
    }

    @Override
    public void PlayerCollision(Speler speler) {
        speler.setLevens(-sterkte);
        switch(bewegingsRichting) {
            case 0:
                setAnchorLocationX(getBoundingBox().getMinX()- (getWidth()*1.5));
                bewegingsRichting = 1;
                break;
            case 1:
                bewegingsRichting = 0;
                setAnchorLocationX(getBoundingBox().getMinX()+ (getWidth()*1.5));

                break;
        }
        vijandDoe();

    }

    @Override
    public void vijandDoe() {
     beweeg();
    }



    @Override
    public void spelerProjectilCollision(int spelersterkte) {
        levens = levens - spelersterkte;

        if (levens <= 0) {
            remove();
        }
    }


    @Override
    public void explicitUpdate(long l) {
        vijandDoe();
    }


}
