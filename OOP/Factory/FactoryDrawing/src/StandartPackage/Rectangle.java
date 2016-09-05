package StandartPackage;

import java.awt.Graphics;

public class Rectangle extends Figure
{
    public int height = 0, width = 0;
            
    Rectangle(int x,int y,int height,int width)
    {
         this.height = height;
         this.width = width;
         this.x = x;
         this.y = y;
    }
    
    protected void draw(Graphics picture)
    {
        picture.drawRect(x, y,width,height);
    }
}
