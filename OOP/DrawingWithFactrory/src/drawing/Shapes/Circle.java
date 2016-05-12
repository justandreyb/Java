package drawing.Shapes;

import javax.swing.JOptionPane;

public class Circle extends Line{
    
    Circle (double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }
    
    @Override
    public void draw() {
        JOptionPane.showMessageDialog(null, "Circle");
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
