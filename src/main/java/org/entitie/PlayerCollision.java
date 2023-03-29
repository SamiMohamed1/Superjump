package org.entitie;

import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import org.entitie.speler.Speler;

public interface PlayerCollision extends Collided {
    void PlayerCollision(Speler speler);
}
