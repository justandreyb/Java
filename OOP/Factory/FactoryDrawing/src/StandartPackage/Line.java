package StandartPackage;

import java.awt.Graphics;


public class Line extends Figure
{
    public int second_x = 0,second_y = 0;
    
    
    Line(int x1,int y1,int x2,int y2)
    {
         x = x1;
         y = y1;
         second_x = x2;
         second_y = y2;
    }
    
    
    protected void draw(Graphics picture)
    {
        picture.drawLine(x, y,second_x,second_y);
    }
}
