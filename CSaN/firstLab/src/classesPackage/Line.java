package classesPackage;

import java.awt.Graphics;

public class Line extends Figures {
        
    public int formX, formY;
    
    Line(int recX, int recY, int recFormX, int recFormY) {
        X = recX;
        Y = recY;
        formX = recFormX;
        formY = recFormY;
    }
    
    @Override
    protected void Draw(Graphics Figure) {
        Figure.drawLine(X, Y, formX, formY);
    }
}

