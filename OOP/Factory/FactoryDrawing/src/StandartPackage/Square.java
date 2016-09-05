package StandartPackage;

import java.awt.Graphics;


public class Square extends Figure
{
    
    protected int side = 0;
    
    Square(int x,int y,int side)
    {
         this.x = x;
         this.y = y;
         this.side = side;
    }
    
    protected void draw(Graphics picture)
    {
        picture.drawRect(x, y, side, side);
    }
}
