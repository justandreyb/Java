package StandartPackage;

import javax.swing.JOptionPane;

public class ArcCreator extends Creator {
    @Override
    public Figure factoryMethod(){ return new Arc(Integer.parseInt(JOptionPane.showInputDialog("Input x"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input y"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input height"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input width"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input start angle"))
                        ,Integer.parseInt(JOptionPane.showInputDialog("Input arc angle"))); };
}
