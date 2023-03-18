package org.entitie.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.map.Grond;

import java.util.Set;

public class Speler extends DynamicSpriteEntity implements KeyListener, Newtonian, SceneBorderCrossingWatcher, SceneBorderTouchingWatcher, Collided {
    private int health = 10;

    public Speler(Coordinate2D Location) {
        super("afbeeldingen/testarcher1.png", Location, new Size(50, 50));
        setFrictionConstant(0.05);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            addToMotion(13, 270d);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            addToMotion(13, 90d);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            addToMotion(13, 180d);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            addToMotion(13, 0d);
        }
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        switch (border) {
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 10);
                break;
            case RIGHT:
                setAnchorLocationX(10);
            default:
                break;
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case TOP:
                setAnchorLocationY(1);
                break;
        }
    }

    @Override
    public void onCollision(Collider collidingObject) {
        if (collidingObject instanceof Grond) {
            System.out.println(getAnchorLocation());
            System.out.println(getAnchorPoint());
            System.out.println("---------------------------");
//            nullifySpeedInDirection(Direction.DOWN);
            setAnchorLocationY(513);
        }
    }


}
