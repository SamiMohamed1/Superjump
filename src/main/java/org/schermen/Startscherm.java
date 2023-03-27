package org.schermen;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.SuperJumpGame;
import org.knoppen.StartKnop;
import org.knoppen.StartKnop;

public class Startscherm extends StaticScene {
    private SuperJumpGame superJumpGame;

    public Startscherm(SuperJumpGame superJumpGame) {
        this.superJumpGame = superJumpGame;
    }

    @Override
    public void setupScene() {
    setBackgroundImage("afbeeldingen/jungle2.png");
    }

    @Override
    public void setupEntities() {
        var begintext = new TextEntity(new Coordinate2D(getWidth()/2, 100), "Superjump");
        begintext.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        begintext.setFill(Color.BLACK);
        addEntity(begintext);
        StartKnop startKnop = new StartKnop(new Coordinate2D(getWidth()/2,getHeight()/2), superJumpGame);
        addEntity(startKnop);
    }
}
