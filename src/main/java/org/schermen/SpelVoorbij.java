package org.schermen;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import org.SuperJumpGame;
import org.knoppen.AfsluitenKnop;
import org.knoppen.AfsluitenKnop;
import org.knoppen.StartKnop;

public class SpelVoorbij extends StaticScene {
    SuperJumpGame superJumpGame;
    public SpelVoorbij(SuperJumpGame superJumpGame){
        this.superJumpGame = superJumpGame;
    }
    @Override
    public void setupScene() {
        setBackgroundImage("afbeeldingen/jungle2.png");
    }

    @Override
    public void setupEntities() {
        StartKnop herstartKnop = new StartKnop(new Coordinate2D(getWidth()/2, 100), superJumpGame);
        addEntity(herstartKnop);
        AfsluitenKnop afsluitenKnop = new AfsluitenKnop(new Coordinate2D(getWidth()/2,getHeight()/2), superJumpGame);
        addEntity(afsluitenKnop);
    }
}
