package org.schermen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.SuperJumpGame;
import org.entitie.speler.Speler;
import org.entitie.vijand.baas.Baas;
import org.entitie.vijand.vijand1.Vijand1;
import org.map.BewegendPlatform;
import org.map.Map;

import static java.util.Objects.isNull;


public class SpelLevels extends DynamicScene implements MouseButtonPressedListener, TileMapContainer {
    private SuperJumpGame superJumpGame;

    public SpelLevels(SuperJumpGame superJumpGame){
        this.superJumpGame = superJumpGame;
    }

    @Override
    public void setupScene() {
//    setBackgroundImage("afbeeldingen/jungle2.png");

    }

    @Override
    public void setupEntities() {
         Speler speler = new Speler(new Coordinate2D(getWidth()/2,getHeight()/2));
        addEntity(speler);
        Baas baas = new Baas((new Coordinate2D(getWidth()/2, 200)),10,10);
        addEntity(baas);
        BewegendPlatform bewegendPlatform = new BewegendPlatform("afbeeldingen/Ijzer.png", new Coordinate2D(100,200));
        addEntity(bewegendPlatform);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }
Map map = new Map();
    @Override
    public void setupTileMaps() {
    addTileMap(map);
    }
}
