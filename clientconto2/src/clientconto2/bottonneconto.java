/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconto2;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author super
 */
public class bottonneconto implements EventHandler<ActionEvent>{
    private ArrayList <Rectangle>retta=new ArrayList();
    private static int a;
     private Button btn = new Button();
    public bottonneconto(Button btn,int a) {
      this.btn=btn;
      this.a=a;
    }
    
    @Override
    public void handle(ActionEvent event) {
       getValore();
       }
    public int getValore(){
        return a;
        
    }
    }
    

  

