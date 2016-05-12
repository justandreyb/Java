package classesPackage;

import java.awt.Graphics;

public class Circle extends Ellipse{
    
    protected int Size;
    Circle(int recX, int recY, int recFormSize) {
        super(0,0,0,0);
        X = recX;
        Y = recY;
        Size = recFormSize;    
    }
    @Override
    protected void Draw(Graphics Figure) {
        Figure.drawOval(X, Y, Size, Size);
    }
}