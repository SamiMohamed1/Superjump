package org.entitie.projectiel;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.entitie.speler.Speler;

import java.util.Set;

public class ProjectielSpawner extends EntitySpawner  {
    private double locatieX;
    private double locatieY;
    Speler speler;
    private double richting;
    public ProjectielSpawner(double locatieX, double locatieY, double richting, Speler speler) {
        super(1000);
        this.locatieX =locatieX;
        this.locatieY =locatieY;
        this.richting = richting;
        this.speler = speler;

    }

    @Override
    public void spawnEntities() {
        spawn(new Projectiel(new Coordinate2D(speler.getBoundingBox().getMinX() ,speler.getBoundingBox().getMinY()), (int) richting));
        System.out.println("spatie");

    }

}
