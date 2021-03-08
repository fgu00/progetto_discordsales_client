/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancorlo_progetto_discordsales;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author super
 */
//da fare alla fine
public class login {
    Scanner sc=new Scanner(System.in);
    private Socket accedi;
    private utente a;
    private boolean log ;
    private PrintWriter out;
    private BufferedReader in;

    public login() {
        accedi=new Socket();
        log=false;
        try {
            out=new PrintWriter(accedi.getOutputStream(),true);
            in=new BufferedReader(new InputStreamReader(accedi.getInputStream()));
            String richiesta=in.readLine();
            String[]a=richiesta.split(":");
            
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void accedi(Socket clientsocket){
          accedi=clientsocket;
         System.out.println( accedi.getInetAddress());
          
    }
    public boolean accesso_eseguito(){
        return log;
    }
    
}

