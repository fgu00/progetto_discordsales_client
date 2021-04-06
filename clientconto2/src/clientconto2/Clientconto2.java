/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientconto2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author super
 */
public class Clientconto2 extends Application {
    public static Socket server;
    @Override
    public void start(Stage primaryStage) throws IOException {
         Scanner sc=new Scanner(System.in);
         Button[]lista=new Button[10];
        System.out.println("Apertua connessione");
                server = new Socket("127.0.0.1",5500 );
                PrintWriter pw = new PrintWriter(server.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                String nconti=in.readLine();
                String[]contikey=nconti.split("::");
                for (int i = 0; i < contikey.length; i++) {
                    lista[i].setText(""+i);
                    bottonneconto a=new bottonneconto(lista[i],i);
                     lista[i].setOnAction(a);
                }
                Label key=new Label();
                key.setText("inserire la key del tuo conto");
                String k=sc.next();
                pw.println(k);
                boolean ciclo=true;
                while(ciclo==true){
                System.out.println("che cosa voui fare?");
                System.out.println("1 per versa");
                System.out.println("2 per prelevare");
                System.out.println("3 per avere il saldo");
                System.out.println("4 per uscire");
                int numero=sc.nextInt();
                switch(numero){
                    case 1:
                        System.out.println("inserisci la cifra che vuoi fare");
                        float soldi=sc.nextFloat();
                        versa(soldi);
                        break;
                    case 2:
                        System.out.println("inserisci la cifra che vuoi fare");
                        float soldi1=sc.nextFloat();
                        preleva(soldi1);
                        break;
                    case 3:
                       stampasaldo();
                        break;
                    case 4:
                        pw.println("4:");
                        ciclo=false;
                }
                }
                  StackPane root = new StackPane();
        StackPane l=new StackPane(lista);
        root.getChildren().add(l);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }
    
            
    
    public static void versa(float cifra){
        try {
            PrintWriter pw = new PrintWriter(server.getOutputStream(), true);
            pw.println("1:"+cifra);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            String risposta=in.readLine();
            if(risposta.equals("r")){
                System.out.println("operazione riuscita");
            }
        } catch (IOException ex) {
            Logger.getLogger(Clientconto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void preleva(float cifra){
        try {
            PrintWriter  pw = new PrintWriter(server.getOutputStream(), true);
            pw.println("2:"+cifra);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            String risposta=in.readLine();
            if(risposta.equals("r")){
                System.out.println("operazione riuscita");
            }else{
                System.out.println("operazione fallita");
            } 
        } catch (IOException ex) {
            Logger.getLogger(Clientconto2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void stampasaldo(){
     PrintWriter pw = null;
        try {    
            pw = new PrintWriter(server.getOutputStream(), true);
            pw.println("3:");
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            String risposta=in.readLine();
            System.out.println(risposta);
        } catch (IOException ex) {
            Logger.getLogger(Clientconto2.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }


       
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
