package org.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.entitie.PlayerCollision;

import org.entitie.speler.Speler;

public class BewegendPlatform extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, Collider, PlayerCollision {


    public BewegendPlatform(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(50, 50));
        setMotion(3,90d);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch ( (int) getDirection()) {
            case (90):
                setDirection(270d);
                break;
            case (270):
                setDirection(90d);
        }


    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void PlayerCollision(Speler speler) {

    }
}
