package classesPackage;

import java.awt.Graphics;

public class Ellipse extends Figures{
    
    public int Width, Height;
    Ellipse(int recX, int recY, int recFormWidth, int recFormHeight) {
        X = recX;
        Y = recY;
        Width = recFormWidth;
        Height = recFormHeight;
        
    }
    @Override
    protected void Draw(Graphics Figure) {
        Figure.drawOval(X, Y, Width, Height);
    }
}
