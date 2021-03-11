/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancorlo_progetto_discordsales;

import static giancorlo_progetto_discordsales.Giancorlo_progetto_discordsales.persone;
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
                
            
            
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void accedi(Socket clientsocket) throws IOException{
          accedi=clientsocket;
         System.out.println( accedi.getInetAddress());
           try {
            out=new PrintWriter(accedi.getOutputStream(),true);
            in=new BufferedReader(new InputStreamReader(accedi.getInputStream()));
             String richiesta=in.readLine();
            String[]a=richiesta.split(":");
            if(a[0]=="-1"){   
                String nome=a[1];
                String password=a[2];
                String mail=a[3];
                this.a=new utente(nome,password,mail,"b");
                
                boolean acesso=false; 
                while(!acesso){
                    //da mettere la mail    
               }
                
            
            }
            persone.add(this.a);
            this.interazioni();
            
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    public void interazioni(){
        try {
            String richiesta=in.readLine();
            String[]m=richiesta.split(":");
            int n=Integer.getInteger(m[0]);
            switch(n){
                case -2:
                    
            }
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public boolean accesso_eseguito(){
        return log;
    }
    public utente getUtente(){
        return a;  
    }
    
}

