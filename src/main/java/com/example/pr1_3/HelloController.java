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
        double x;
        double res = 0;
        int fact;
        int i = 1;

        //Первые n членов
        if(toggleGroup.getSelectedToggle() == RB_n){
            try{
                int n = Integer.parseInt(TF_n.getText());
                if(n<0) throw new Exception("Отрицтательный счетчик!");
                x = Double.parseDouble(TF_x.getText().replace(",","."));
                for(i = 1; i<=n; i++){
                    fact = 1;
                    for (int ii=1; ii<=2*i+1; ii++)
                        fact=fact*ii;
                    res+=Math.pow(-1,i)*((Math.pow(x,2*i+1))/fact);
                }
                welcomeText.setText("Ответ:"+res);
            } catch (Exception e){
                e.printStackTrace();
                ALARM();
            }
        }
        //Сумма членов 0<e<1
        else {
            try{
                double e = Double.parseDouble(TF_e.getText().replace(",","."));
                if(0<e&&e<1){
                    x = Double.parseDouble(TF_x.getText().replace(",","."));
                    double pr = 0;
                    do{
                        fact = 1;
                        res+= pr;
                        for (int ii=1; ii<=2*i+1; ii++)
                            fact=fact*ii;
                    } while((pr = Math.pow(-1,i)*( (Math.pow(x,2*i+1))/fact)) < e );
                    welcomeText.setText("Ответ:"+res);
                } else {
                    ALARM();
                }
            } catch (Exception e){
                ALARM();
            }
        }
    }
    @FXML
    protected void onSelect(){
        ALARM("Убил несколько часов, не нашел удовлетворяющих x и e, в теории должно работать");
    }

    private void ALARM(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Внимание!");
        alert.setHeaderText(null);
        alert.setContentText("Проверьте правильность заполнения полей!");
        alert.showAndWait();
    }
    private void ALARM(String s){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Внимание!");
        alert.setHeaderText(null);
        alert.setContentText(s);
        alert.showAndWait();
    }
}