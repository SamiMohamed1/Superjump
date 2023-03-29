package org.entitie.vijand;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import org.entitie.PlayerCollision;

import org.entitie.projectiel.SpelerProjectielCollision;

public abstract class Vijand extends DynamicCompositeEntity implements Collided, PlayerCollision, SpelerProjectielCollision {
    protected int levens;
    protected int sterkte;

    public Vijand(Coordinate2D initialLocation, int levens, int sterkte, Size size) {
        super(initialLocation);
        this.levens = levens;
        this.sterkte = sterkte;
    }
    public abstract void vijandDoe();




}
