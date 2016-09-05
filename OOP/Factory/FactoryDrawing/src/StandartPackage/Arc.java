package StandartPackage;

import java.awt.Graphics;

public class Arc extends Figure
{
    private int width = 0, height = 0,startAngle = 0, arcAngle = 0;
    
    
    Arc(int x,int y,int width,int height,int startAngle,int arcAngle)
    {
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
         this.startAngle = startAngle;
         this.arcAngle = arcAngle;
    }
    
    protected void draw(Graphics picture)
    {
        picture.drawArc(x, y, width, height,startAngle,arcAngle);
    }
    
}
