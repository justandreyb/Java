package classesPackage;

import java.awt.Graphics;

public class Arc extends Figures{
    
    protected int Width, Height, startAngle, arcAngle;
    Arc(int recX, int recY, int recFormWidth, int recFormHeight, int recStartAngle, int recArcAngle) {
        X = recX;
        Y = recY;
        Width = recFormWidth;
        Height = recFormHeight;
        startAngle = recStartAngle;
        arcAngle = recArcAngle;
        
    }
    @Override
    protected void Draw(Graphics Figure) {
        Figure.drawArc(X, Y, Width, Height, startAngle, arcAngle);
    }
}
