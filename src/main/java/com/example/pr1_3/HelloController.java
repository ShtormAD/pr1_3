package com.example.pr1_3;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private RadioButton RB_n;
    @FXML
    private RadioButton RB_e;
    @FXML
    private TextField TF_n;
    @FXML
    private TextField TF_e;
    @FXML
    private TextField TF_x;
    private ToggleGroup toggleGroup;

    @FXML
    public void initialize(){
        toggleGroup = new ToggleGroup();
        RB_n.setToggleGroup(toggleGroup);
        RB_e.setToggleGroup(toggleGroup);
    }
    @FXML
    protected void onHelloButtonClick() {
        if(toggleGroup.getSelectedToggle() == RB_n){
            double x;
            try{
                int n = Integer.parseInt(TF_n.getText());
                if(n<0) throw new Exception("Отрицтательный счетчик!");
                double res = 0;
                x = Double.parseDouble(TF_x.getText().replace(",","."));
                for(int i = 1; i<=n; i++){
                    int fact = 0;
                    for (int ii=1; ii<=2*i+1; ii++)
                        fact+=ii;
                    res+=Math.pow(-1,i)*( (Math.pow(x,2*i+1))/fact);
                }
                welcomeText.setText("Ответ:"+res);
            } catch (Exception e){
                e.printStackTrace();
                ALARM();
            }
        } else {
            welcomeText.setText("E");
        }
    }
    private void ALARM(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Внимание!");
        alert.setHeaderText(null);
        alert.setContentText("Проверьте правильность заполнения полей!");
        alert.showAndWait();
    }
}