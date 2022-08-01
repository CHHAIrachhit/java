/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import dailog.alertdailog;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import productmagagement.ProductMagagement;

/**
 * FXML Controller class
 *
 * @author Administrator
 */
public class CategoryViewController implements Initializable  {

    @FXML
    private TextArea description;
    @FXML
    private TextField cname;
    private Connection con = null;
    private PreparedStatement pst = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        con = dbms.dbconnection.productConnection();
        
    }    

    @FXML
    private void insert(ActionEvent event) throws SQLException {
        String sql = "INSERT INTO `categories` ( `cname`, `description`) VALUES (?,?);";
        System.out.println("Add");
        String cnanes = cname.getText();
        String descriptions =  description.getText();
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, cnanes);
            pst.setString(2, descriptions);
            int i = pst .executeUpdate();
            if (i==1){
                alertdailog.display("AddnewCategory","success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            pst.close();
        }
    }
    
    
}
