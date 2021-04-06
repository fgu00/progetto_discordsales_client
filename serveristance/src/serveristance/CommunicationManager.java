/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveristance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author super
 */
public class CommunicationManager implements Runnable{
    private final ContoCorrente cc;
    private Socket s;
    private PrintWriter pw;
    private BufferedReader in;
    
    public CommunicationManager(Socket s, ContoCorrente cc) {
        this.s = s;
        this.cc = cc;
        try {
            pw= new PrintWriter(this.s.getOutputStream(), true);
            in= new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(CommunicationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            

    
    @Override
    public void run() {
        int primo=0;
        try {
            boolean ciclo=true;
            while(ciclo==true){
            String comando=in.readLine();
            String[]input=comando.split(":");
            primo=Integer.parseInt(input[0]);
            switch(primo){
                case 1:
                     float secondo=Float.parseFloat(input[1]);
                    cc.versa(secondo);
                    //r per riuscita
                    pw.println("r");
                    break;
                case 2:
                  float secondo1=Float.parseFloat(input[1]);
                    boolean l=cc.preleva(secondo1);
                    if(l==true){
                    pw.println("r");
                    }else{
                        //f per fallita
                     pw.println("f");   
                    }
                    break;  
                case 3:
                    String risposta=""+cc.getSaldo();
                    pw.println(risposta);  
                    break;
                case 4:
                    ciclo=false;
                    break;
            }
            }
            //gestione dei messaggio ricevuti dal client e le funzioni del contoCorrente
        } catch (IOException ex) {
            Logger.getLogger(CommunicationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

    

