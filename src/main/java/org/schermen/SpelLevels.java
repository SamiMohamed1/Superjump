package org.schermen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.SuperJumpGame;
import org.entitie.projectiel.Projectiel;
import org.entitie.projectiel.ProjectielSpawner;
import org.entitie.speler.Speler;
import org.entitie.vijand.baas.Baas;
import org.entitie.vijand.vijand1.Vijand1;
import org.entitie.vijand.vijand2.Vijand2;
import org.map.BewegendPlatform;
import org.map.Map;


public class SpelLevels extends DynamicScene implements MouseButtonPressedListener, TileMapContainer, EntitySpawnerContainer {
    private SuperJumpGame superJumpGame;
    private Speler speler;

    public SpelLevels(SuperJumpGame superJumpGame){
        this.superJumpGame = superJumpGame;
    }

    @Override
    public void setupScene() {
//    setBackgroundImage("afbeeldingen/jungle2.png");

    }

    @Override
    public void setupEntities() {
        speler = new Speler(new Coordinate2D(getWidth()/2,getHeight()/2));

        addEntity(speler);
        Baas baas = new Baas((new Coordinate2D(getWidth()/2, 0)),10,10);
        addEntity(baas);
        BewegendPlatform bewegendPlatform = new BewegendPlatform("afbeeldingen/Ijzer.png", new Coordinate2D(100,200));
        addEntity(bewegendPlatform);
        Vijand2 vijand2 = new Vijand2((new Coordinate2D(100,100)),10,10);
        addEntity(vijand2);
        Vijand1 vijand1 = new Vijand1((new Coordinate2D(100,100)),speler,4,10);
        addEntity(vijand1);

    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {

    }
Map map = new Map();
    @Override
    public void setupTileMaps() {
    addTileMap(map);

    }

    @Override
    public void setupEntitySpawners() {

      addEntitySpawner(new ProjectielSpawner(50,50,180, speler));
    }
}
