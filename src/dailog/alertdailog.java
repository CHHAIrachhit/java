/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dailog;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class alertdailog {
    public static  void display(String tital, String messege){
        Stage windows = new Stage();
        windows.setTitle(tital);
        windows.setMinWidth(300);
        windows.setMinHeight(100);
        
        Label mss = new Label(messege);
        Button btnok = new Button("ok");
        btnok.setOnAction(even -> windows.close());
        
        HBox hb = new HBox(mss,btnok);
        Scene scene = new Scene(hb);
        windows.setScene(scene);
        windows.showAndWait();
        
        
    }
}
