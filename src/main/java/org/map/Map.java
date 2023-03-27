package org.map;

import com.github.hanyaeger.api.scenes.TileMap;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.google.inject.Injector;
import org.entitie.items.Schild;
import org.entitie.items.SnelheidBoost;
import org.entitie.items.StertkeBoost;

import java.util.List;

public class Map extends TileMap{
    @Override
    public void setupEntities() {
        addEntity(1, Grond.class, "afbeeldingen/grond.png");
        addEntity(2,Ijs.class, "afbeeldingen/ijs.png");
        addEntity(3,Steen.class, "afbeeldingen/steen.png");
        addEntity(4,BrekendPlatform.class,"afbeeldingen/steen.png");
        addEntity(5, Schild.class,"afbeeldingen/schild1.png");
        addEntity(6, SnelheidBoost.class,"afbeeldingen/speedpotion.png");
        addEntity(7, StertkeBoost.class,"afbeeldingen/sterkte.png");
    }

    public int[][] defineMap() {
        return new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 4, 4, 0, 3, 3, 0, 0, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 3, 3, 3, 0, 0, 0, 0, 0, 3, 3},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 7, 3, 3, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
    }


}
