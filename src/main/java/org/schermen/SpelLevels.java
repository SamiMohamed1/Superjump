package org.schermen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.SuperJumpGame;
import org.entitie.projectiel.ProjectielSpawner;
import org.entitie.speler.Speler;
import org.entitie.vijand.baas.Baas;
import org.entitie.vijand.VijandVolgend.VijandVolgend;
import org.entitie.vijand.VijandHeenEnWeer.VijandHeenEnWeer;
import org.map.BewegendPlatform;
import org.map.Map;


public class SpelLevels extends DynamicScene implements MouseButtonPressedListener, TileMapContainer, EntitySpawnerContainer {
    private SuperJumpGame superJumpGame;
    private Speler speler;
    private Baas baas;

    public SpelLevels(SuperJumpGame superJumpGame){
        this.superJumpGame = superJumpGame;
    }

    @Override
    public void setupScene() {
   setBackgroundImage("afbeeldingen/jungle2.png");

    }

    @Override
    public void setupEntities() {
        speler = new Speler(new Coordinate2D(getWidth()/2,getHeight()/2), superJumpGame);
        addEntity(speler);
         baas = new Baas((new Coordinate2D(getWidth()/2, 0)),10,4,superJumpGame);
        addEntity(baas);
        BewegendPlatform bewegendPlatform = new BewegendPlatform("afbeeldingen/Ijzer.png", new Coordinate2D(100,200));
        addEntity(bewegendPlatform);
        VijandHeenEnWeer vijand2 = new VijandHeenEnWeer((new Coordinate2D(100,350)),10,9);
        addEntity(vijand2);
        VijandVolgend vijand1 = new VijandVolgend((new Coordinate2D(100,100)),speler,10,9);
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

      addEntitySpawner(new ProjectielSpawner(0,0,180d,speler,baas,"speler",300));
      addEntitySpawner(new ProjectielSpawner(getWidth()/2,0,0,speler,baas,"baas",700));

    }

}
