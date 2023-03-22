package org.entitie.items;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.PlayerCollision;
import org.entitie.speler.Speler;

public class StertkeBoost extends Item {

    public StertkeBoost(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }


    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void PlayerCollision(Speler speler) {
        speler.setSterkte();
        remove();
    }
}