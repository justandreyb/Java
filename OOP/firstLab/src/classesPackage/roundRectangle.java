package classesPackage;

import java.awt.Graphics;

public class roundRectangle extends Figures {
    
    protected int Width, Height, arcWidth, arcHeight;
    roundRectangle(int recX, int recY, int recFormWidth, int recFormHeight, int recArcWidth, int recArcHeight) {
        X = recX;
        Y = recY;
        Width = recFormWidth;
        Height = recFormHeight;
        arcWidth = recArcWidth;
        arcHeight = recArcHeight;
        
    }
    @Override
    protected void Draw(Graphics Figure) {
        Figure.drawRoundRect(X, Y, Width, Height, arcWidth, arcHeight);
    }    
}
