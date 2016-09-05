package com.Controller;

import com.Model.Automobile;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ArrayList;

public class EditFormController {

    Stage editForm;
    boolean okClicked = false;
    private ArrayList characteristics;
    private Automobile currentAutomobile;
    public TextField idManufacturer;
    public TextField idModel;
    public TextField idYear;
    public TextField idPower;
    public TextField idAdditionalFirst;
    public TextField idAdditionalSecond;
    public TextField idAdditionalThird;
    public TextField idAdditionalFourth;

    public void init() {

        idAdditionalFirst.setEditable(true);
        idAdditionalSecond.setEditable(true);
        idAdditionalThird.setEditable(true);
        idAdditionalFourth.setEditable(true);
    }

    public void handleCancel(ActionEvent actionEvent) {

        editForm.close();
    }

    public void setAutomobile(Automobile automobile) {

        init();
        currentAutomobile = automobile;
        characteristics = new ArrayList();
        characteristics = currentAutomobile.getInformation();
        idManufacturer.setText((String) characteristics.get(0));
        idModel.setText((String) characteristics.get(1));
        idYear.setText(String.valueOf(characteristics.get(2)));
        idPower.setText(String.valueOf(characteristics.get(3)));

        switch (characteristics.size()) {

            case 5:
                idAdditionalFirst.setText(String.valueOf(characteristics.get(4)));

                idAdditionalSecond.setText("Not set");
                idAdditionalThird.setText("Not set");
                idAdditionalFourth.setText("Not set");

                idAdditionalSecond.setEditable(false);
                idAdditionalThird.setEditable(false);
                idAdditionalFourth.setEditable(false);
                break;
            case 6:
                idAdditionalFirst.setText(String.valueOf(characteristics.get(4)));
                idAdditionalSecond.setText(String.valueOf(characteristics.get(5)));

                idAdditionalThird.setText("Not set");
                idAdditionalFourth.setText("Not set");

                idAdditionalThird.setEditable(false);
                idAdditionalFourth.setEditable(false);
                break;
            case 7:
                idAdditionalFirst.setText(String.valueOf(characteristics.get(4)));
                idAdditionalSecond.setText(String.valueOf(characteristics.get(5)));
                idAdditionalThird.setText(String.valueOf(characteristics.get(6)));

                idAdditionalFourth.setText("Not set");

                idAdditionalFourth.setEditable(false);
                break;
            case 8:
                idAdditionalFirst.setText(String.valueOf(characteristics.get(4)));
                idAdditionalSecond.setText(String.valueOf(characteristics.get(5)));
                idAdditionalThird.setText(String.valueOf(characteristics.get(6)));
                idAdditionalFourth.setText(String.valueOf(characteristics.get(7)));
                break;
        }

    }

    public void setDialogStage(Stage editForm) {
        this.editForm = editForm;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    public void handleOk(ActionEvent actionEvent) {

        init();
        int size = characteristics.size();
        characteristics.clear();

        switch (size) {

            case 5:
                characteristics.add(idManufacturer.getText());
                characteristics.add(idModel.getText());
                characteristics.add(Integer.parseInt(idYear.getText()));
                characteristics.add(Integer.parseInt(idPower.getText()));

                idAdditionalSecond.setEditable(false);
                idAdditionalThird.setEditable(false);
                idAdditionalFourth.setEditable(false);
                if(isNumber(idAdditionalFirst.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalFirst.getText()));
                } else {
                    characteristics.add(idAdditionalFirst.getText());
                }

                break;
            case 6:
                characteristics.add(idManufacturer.getText());
                characteristics.add(idModel.getText());
                characteristics.add(Integer.parseInt(idYear.getText()));
                characteristics.add(Integer.parseInt(idPower.getText()));

                idAdditionalThird.setEditable(false);
                idAdditionalFourth.setEditable(false);

                if(isNumber(idAdditionalFirst.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalFirst.getText()));
                } else {
                    characteristics.add(idAdditionalFirst.getText());
                }
                if(isNumber(idAdditionalSecond.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalSecond.getText()));
                } else {
                    characteristics.add(idAdditionalSecond.getText());
                }

                break;
            case 7:
                characteristics.add(idManufacturer.getText());
                characteristics.add(idModel.getText());
                characteristics.add(Integer.parseInt(idYear.getText()));
                characteristics.add(Integer.parseInt(idPower.getText()));

                idAdditionalFourth.setEditable(false);

                if(isNumber(idAdditionalFirst.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalFirst.getText()));
                } else {
                    characteristics.add(idAdditionalFirst.getText());
                }
                if(isNumber(idAdditionalSecond.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalSecond.getText()));
                } else {
                    characteristics.add(idAdditionalSecond.getText());
                }
                if(isNumber(idAdditionalThird.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalThird.getText()));
                } else {
                    characteristics.add(idAdditionalThird.getText());
                }

                break;
            case 8:
                characteristics.add(idManufacturer.getText());
                characteristics.add(idModel.getText());
                characteristics.add(Integer.parseInt(idYear.getText()));
                characteristics.add(Integer.parseInt(idPower.getText()));

                if(isNumber(idAdditionalFirst.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalFirst.getText()));
                } else {
                    characteristics.add(idAdditionalFirst.getText());
                }
                if(isNumber(idAdditionalSecond.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalSecond.getText()));
                } else {
                    characteristics.add(idAdditionalSecond.getText());
                }
                if(isNumber(idAdditionalThird.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalThird.getText()));
                } else {
                    characteristics.add(idAdditionalThird.getText());
                }
                if(isNumber(idAdditionalFourth.getText())) {
                    characteristics.add(Integer.parseInt(idAdditionalFourth.getText()));
                } else {
                    characteristics.add(idAdditionalFourth.getText());
                }
                break;
            default:
                characteristics.add(idManufacturer.getText());
                characteristics.add(idModel.getText());
                characteristics.add(Integer.parseInt(idYear.getText()));
                characteristics.add(Integer.parseInt(idPower.getText()));

                idAdditionalFirst.setEditable(false);
                idAdditionalSecond.setEditable(false);
                idAdditionalThird.setEditable(false);
                idAdditionalFourth.setEditable(false);

                break;

        }

        okClicked = true;
        editForm.close();
    }

    private boolean isNumber(String field) {
        try {
            int number = Integer.parseInt(field);
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }

}
