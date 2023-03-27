package org.knoppen;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.SuperJumpGame;

public class StartKnop extends TextEntity implements MouseButtonPressedListener, MouseEnterListener {
    protected SuperJumpGame superJumpGame;
    public StartKnop(Coordinate2D initialLocation, SuperJumpGame superJumpGame) {
        super(initialLocation,"Starten");
        this.superJumpGame = superJumpGame;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("calibri", FontWeight.BOLD, 20));
        setFill(Color.BLACK);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        superJumpGame.setActiveScene(1);
        System.out.println(22222);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }
}
