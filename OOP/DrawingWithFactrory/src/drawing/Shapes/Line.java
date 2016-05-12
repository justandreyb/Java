package drawing.Shapes;

import javax.swing.JOptionPane;
import drawing.*;

public class Line extends Shape {
    protected Point secondPoint;
    Line (double x1, double y1, double x2, double y2) {
        super(x1, y1);        
        secondPoint = new Point(x2, y2);
    }
    @Override
    public void draw() {
        JOptionPane.showMessageDialog(null, "Line");
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
