package StandartPackage;

import java.awt.Graphics;

public class Circle extends Figure
{
   
    public int radius = 0;
    
    Circle(int x,int y,int radius)
    {
         this.radius = radius;
         this.x = x;
         this.y = y;
    }
    
    protected void draw(Graphics picture)
    {
        picture.drawOval(x,y,radius,radius);
    }
}
