package org.entitie.projectiel;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import org.entitie.speler.Speler;
import org.entitie.vijand.baas.Baas;

public class ProjectielSpawner extends EntitySpawner {
    private double locatieX;
    private double locatieY;
    private Speler speler;
    private Baas baas;
    private double richting;
    private String type;

    public ProjectielSpawner(double locatieX, double locatieY, double richting, Speler speler, Baas baas, String type) {
        super(1000);
        this.locatieX = locatieX;
        this.locatieY = locatieY;
        this.richting = richting;
        this.speler = speler;
        this.baas = baas;
        this.type = type;
    }

    @Override
    public void spawnEntities() {
        if (type == "speler") {
            spawn(new SpelerProjectiel(new Coordinate2D(speler.getBoundingBox().getMinX(), speler.getBoundingBox().getMinY()), (int) richting, speler.getSterkte()));
            System.out.println("spatie");
        } else if (type == "baas") {
            spawn(new EnemyProjectiel(new Coordinate2D(baas.getBoundingBox().getMinX(),baas.getBoundingBox().getMinY()), (int) richting,speler.getSterkte()));
        }
    }

}


