package org;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.schermen.SpelVoorbij;
import org.schermen.SpelLevels;
import org.schermen.Startscherm;

public class SuperJumpGame extends YaegerGame {
    private SuperJumpGame superJumpGame;
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void setupGame() {
    setGameTitle("Supergame");
    setSize(new Size(1500, 750));
    }


    @Override
    public void setupScenes() {
    addScene(0, new Startscherm(this));
    addScene(1,new SpelLevels(this));
    addScene(2,new SpelVoorbij(this));
    setActiveScene(0);
    }
}