package classesPackage;

import classesPackage.Figures;
import java.awt.Graphics;

public class Rectangle extends Figures{
    
    public int Width, Height;
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
