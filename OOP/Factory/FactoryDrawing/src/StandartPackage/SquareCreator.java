package StandartPackage;

import javax.swing.JOptionPane;

public class SquareCreator extends Creator {
    @Override
    public Figure factoryMethod(){ return new Square(Integer.parseInt(JOptionPane.showInputDialog("Input x"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input y"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input side"))); };
}
