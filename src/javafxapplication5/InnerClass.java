/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class InnerClass extends Application {
    private Circle circulo;
    @Override
    public void start(Stage primaryStage) {
        BorderPane panel = new BorderPane();
        
        Scene scene = new Scene(panel, 400, 350);
        
        // Creamos el circulo y le dejamos con el borde resaltado
        circulo = new Circle(20, Color.web("black", 0.05));
        circulo.setStroke(Color.web("black", 1));
        
        // Centramos el circulo
        panel.setCenter(circulo);
        
        HBox contenedorBotones = new HBox(15);
        panel.setBottom(contenedorBotones);    

        contenedorBotones.setAlignment(Pos.CENTER);
       
        // Creamos los botones
        Button btnMax = new Button("Maximizar");
        btnMax.setOnAction(new MaxHandler());
            
        Button btnMin = new Button("Minimizar");
        btnMin.setOnAction(new MinHandler());
        
        // Los añadimos el contenedor de botones
        contenedorBotones.getChildren().addAll(btnMax, btnMin);
        
        primaryStage.setTitle("InnerClassCirculo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    class MaxHandler implements EventHandler<ActionEvent>
    {
            public void handle(ActionEvent event) {
                circulo.setRadius(circulo.getRadius()+3);
            }
    };
    
    class MinHandler implements EventHandler<ActionEvent>
    {
            public void handle(ActionEvent event) {
                if(circulo.getRadius()>5)
                    circulo.setRadius(circulo.getRadius()-3);
            }
    };
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
