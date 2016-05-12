package drawing.Shapes;

import javax.swing.JOptionPane;

public class Rectangle extends Line {
    
    Rectangle(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }
    
    @Override
    public void draw() {
        JOptionPane.showMessageDialog(null, "Rectangle");
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
