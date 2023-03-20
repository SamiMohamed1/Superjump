package org.entitie.speler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.geometry.Bounds;
import javafx.geometry.Side;
import javafx.scene.input.KeyCode;
import org.map.Grond;
import org.map.Ijs;
import org.map.Platform;
import org.map.Steen;

import java.util.Set;

public class Speler extends DynamicSpriteEntity implements KeyListener, Newtonian, SceneBorderCrossingWatcher, SceneBorderTouchingWatcher, Collided {
    private int health = 10;
    private int jumpCounter =2;


    public Speler(Coordinate2D Location) {
        super("afbeeldingen/testarcher1.png", Location, new Size(50, 50));
        setFrictionConstant(0.05);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(getSpeed() >= 15){
            setSpeed(25);
        }
        if (pressedKeys.contains(KeyCode.LEFT)) {
            addToMotion(5, 270d);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            addToMotion(5, 90d);

        } else if (pressedKeys.contains(KeyCode.UP) && jumpCounter> 0) {
            addToMotion(15, 180d);
            jumpCounter--;
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            addToMotion(5, 0d);
        }
        System.out.println(jumpCounter);
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
        if(collidingObject instanceof Platform) {
            if (collidingObject instanceof Grond) {
                if (getAnchorLocation().getY() > 500) {
                    setAnchorLocationY(513);
                    jumpCounter = 2;
                }
            } else if (collidingObject instanceof Ijs) {
                if (getCollisionSide(collidingObject) == Side.TOP) {
                    setAnchorLocationY(collidingObject.getBoundingBox().getMinY() - 52);
                    setSpeed(getSpeed() + 0.1);
                    setMotion(getSpeed(), getDirection());
                    jumpCounter = 2;
                }


            } else if (collidingObject instanceof Steen) {
                nullifySpeedInDirection(0d);
                jumpCounter = 2;
            }
        }
    }

    private Side getCollisionSide(Collider collider) {
        Bounds collidedBoundingBox = this.getBoundingBox();
        Bounds colliderBoundingBox = collider.getBoundingBox();

        double collidedHalfWidth = this.getWidth() / 2;
        double collidedHalfHeight = this.getHeight() / 2;
        double colliderHalfWidth = collider.getWidth() / 2;
        double colliderHalfHeight = collider.getHeight() / 2;

        double differenceX = colliderBoundingBox.getCenterX() - collidedBoundingBox.getCenterX();
        double differenceY = colliderBoundingBox.getCenterY() - collidedBoundingBox.getCenterY();

        double minXDistance = colliderHalfWidth + collidedHalfWidth;
        double minYDistance = colliderHalfHeight + collidedHalfHeight;

        double depthX = differenceX > 0 ? minXDistance - differenceX + 1 : -minXDistance - differenceX - 1;
        double depthY = differenceY > 0 ? minYDistance - differenceY + 1 : -minYDistance - differenceY - 1;

        // Add or subtract 1 to make sure depth can't be 0 at first collision
        depthX = depthX==0?differenceX>0?1:0:depthX;
        depthY = depthY==0?differenceY>0?1:0:depthY;

        // depthY < doe TOP of BOTTOM
        // depthX > doe LEFT of RIGHT

        // depthY positief && blok CenterY <= player hoogte doe TOP
        // depthY negatief doe BOTTOM


        // depthX positief && blok CenterX <= player hoogte doe LEFT
        // depthX negatief doe RIGHT

        if (Math.abs(depthX) >= Math.abs(depthY)) {
            if (depthY > 0 && collidedBoundingBox.getMaxY() <= colliderBoundingBox.getCenterY()) {
                return Side.TOP;
            }
            return Side.BOTTOM;
        }
        else {
            if (depthX > 0 && collidedBoundingBox.getMaxX() <= colliderBoundingBox.getCenterX()) {
                return Side.LEFT;
            }
            return Side.RIGHT;
        }
    }
}

