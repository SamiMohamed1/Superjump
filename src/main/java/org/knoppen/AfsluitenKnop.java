package org.knoppen;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.SuperJumpGame;

public class AfsluitenKnop extends TextEntity implements MouseButtonPressedListener, MouseEnterListener {
    private SuperJumpGame superJumpGame;
    public AfsluitenKnop(Coordinate2D initialLocation, SuperJumpGame superJumpGame) {
        super(initialLocation,"stoppen");
        setFill(Color.INDIANRED);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        this.superJumpGame = superJumpGame;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);

    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        superJumpGame.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.INDIANRED);
        setCursor(Cursor.HAND);
    }
}
