package StandartPackage;

import java.awt.Graphics;

public class Ellipse extends Figure
{
   protected int height = 0,width = 0;
    
    Ellipse(int x,int y,int height,int width)
    {
         this.height = height;
         this.width = width;
         this.x = x;
         this.y = y;
    }
    
    protected void draw(Graphics picture)
    {
        picture.drawOval(x, y, width, height);
    }
}
