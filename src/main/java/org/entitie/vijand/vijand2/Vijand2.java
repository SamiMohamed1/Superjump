package org.entitie.vijand.vijand2;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.PlayerCollision;
import org.entitie.Hitbox;
import org.entitie.projectiel.ProjectielCollision;
import org.entitie.speler.Speler;
import org.entitie.vijand.Vijand;


public class Vijand2 extends Vijand implements PlayerCollision,Collider, ProjectielCollision,UpdateExposer,SceneBorderCrossingWatcher {
    private int bewegingsRichting;
    public Vijand2(Coordinate2D initialLocation, int levens,int sterkte) {
        super(initialLocation, levens, sterkte,  new Size(50,50));
        setMotion(2,90);
        vijandDoe();
    }
    protected void setupEntities() {
         Hitbox hitbox = new Hitbox(new Coordinate2D(0,0),50,50);
         addEntity(hitbox);
        Vijand2Sprite vijand2Sprite = new Vijand2Sprite(new Coordinate2D(0,0), new Size(50,50));
        addEntity(vijand2Sprite);
    //    System.out.println(vijand2Sprite.getAnchorLocation());
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
        System.out.println(1234);
        speler.geraaktDoorVijand(sterkte);
       // setAnchorLocationX(getBoundingBox().getMinX()- (getWidth()*5));
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
