package StandartPackage;

import javax.swing.JOptionPane;

public class CircleCreator extends Creator {
    @Override
    public Figure factoryMethod(){ return new Circle(Integer.parseInt(JOptionPane.showInputDialog("Input x"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input y"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input radius"))); };
}
