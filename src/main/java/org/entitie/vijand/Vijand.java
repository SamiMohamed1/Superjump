package org.entitie.vijand;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Vijand extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, Collided, KeyListener {
    private int health;
    private float sterkte;

    public Vijand(Coordinate2D initialLocation, int health, float sterkte, Size size) {
        super(initialLocation);
        this.health = health;
        this.sterkte = sterkte;
    }


    protected void setupEntities() {

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case LEFT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 10);
                break;
            case RIGHT:
                setAnchorLocationX(10);
        }
    }

    @Override
    public void onCollision(Collider collider) {

    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {

    }
}
