package StandartPackage;

import javax.swing.JOptionPane;

public class RectangleCreator extends Creator {
    @Override
    public Figure factoryMethod(){ return new Rectangle(Integer.parseInt(JOptionPane.showInputDialog("Input x"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input y"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input height"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input width"))); };
}
