package classesPackage;


import classesPackage.Figures;
import java.awt.Graphics;

public class rectangle3D extends Figures {
    
    public int Width, Height;
    public boolean Raised; //On/Off button
    
    rectangle3D(int recX, int recY, int recFormWidth, int recFormHeight, int recRaised) {
        X = recX;
        Y = recY;
        Width = recFormWidth;
        Height = recFormHeight;
        if (recRaised == 1)
            Raised = true;
        else
            Raised = false;
            
    }
    @Override
    protected void Draw(Graphics Figure) {
        Figure.draw3DRect(X, Y, Width, Height, Raised);
    }
}
