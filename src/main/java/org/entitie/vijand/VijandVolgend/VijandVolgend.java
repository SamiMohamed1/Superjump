package org.entitie.vijand.VijandVolgend;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.entitie.Hitbox;
import org.entitie.speler.Speler;
import org.entitie.vijand.Vijand;

import java.util.Set;

public class VijandVolgend extends Vijand implements KeyListener, Collider, UpdateExposer, SceneBorderCrossingWatcher {
    Speler richting;

    private boolean spelerBeweegt = false;

    private int levens;
    private int sterkte;


    public VijandVolgend(Coordinate2D initialLocation, Speler richting, int levens, int sterkte) {
        super(initialLocation, levens, sterkte, new Size(50, 50));
        this.richting = richting;
        this.levens = levens;
        this.sterkte = sterkte;

    }

    protected void setupEntities() {
        Hitbox hitbox = new Hitbox(new Coordinate2D(0, 0), 50, 50);
        addEntity(hitbox);
        VijandVolgendSprite vijand1Sprite = new VijandVolgendSprite(new Coordinate2D(0, 0));
        addEntity(vijand1Sprite);

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
            spelerBeweegt = true;
        } else {
            spelerBeweegt = false;
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
    }

    @Override
    public void PlayerCollision(Speler speler) {
        speler.setLevens(-sterkte);

        setAnchorLocationX(getBoundingBox().getMinX() - (getWidth() * 5));
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void vijandDoe() {
        if (!spelerBeweegt) {
            if (getDirection() != 0.0) {

                setMotion(1, getDirection());
            }
        }
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

