package classesPackage;

import java.awt.Graphics;

public class Rectangle extends Figures{
    
    protected int Width, Height;
    Rectangle(int recX, int recY, int recFormWidth, int recFormHeight) {
        X = recX;
        Y = recY;
        Width = recFormWidth;
        Height = recFormHeight;
        
    }
    @Override
    protected void Draw(Graphics Figure) {
        Figure.drawRect(X, Y, Width, Height);
    }
}
