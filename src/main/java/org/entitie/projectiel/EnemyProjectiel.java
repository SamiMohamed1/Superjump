package org.entitie.projectiel;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class EnemyProjectiel extends DynamicSpriteEntity implements Collided, Collider, ProjectielCollision, SceneBorderTouchingWatcher {
    private  int sterkte;
    public EnemyProjectiel(Coordinate2D initialLocation, int directie, int sterkte) {
        super("afbeeldingen/vuurorb.png", initialLocation, new Size(50,50));
        setMotion(3,directie);
        this.sterkte = sterkte;
    }

    @Override
    public void onCollision(Collider collider) {
        if(collider instanceof ProjectielCollision projectielCollision){
            projectielCollision.ProjectilCollision(sterkte);
            remove();
        }
    }
    @Override
    public void ProjectilCollision(int spelersterkte) {
        remove();
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        remove();
    }
}