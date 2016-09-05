package StandartPackage;

import javax.swing.JOptionPane;

public class LineCreator extends Creator{
    @Override
    public Figure factoryMethod(){ 
        return new Line(Integer.parseInt(JOptionPane.showInputDialog("Input x"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input y"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input x2"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input y2"))); 
    };
}
