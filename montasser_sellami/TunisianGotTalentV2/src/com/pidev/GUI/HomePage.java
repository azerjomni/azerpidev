/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import static com.pidev.GUI.HomePage.Userconnected ;

import com.pidev.Entite.User;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author House
 */
public class HomePage extends Application {
        private Stage stage;
    private Parent parent;
    static User Userconnected = new User();
    
    @Override
    public void start(Stage primaryStage) {
        try {
            
          
            Parent root1 = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
            primaryStage.setTitle("Authentification");
            Scene scene = new Scene(root1);
                    this.stage = primaryStage;
    //    parent = FXMLLoader.load(getClass().getResource("/TunGotTalent/gui/Authentification.fxml"));
        
        primaryStage.setScene(scene);
        primaryStage.show();
            
            
            
     
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
