/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancorlo_progetto_discordsales;

import java.io.*;
import java.net.*;
import java.util.Scanner;

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

    public login() {
        accedi=new Socket();
        log=false;
        out=new PrintWriter(ClientSocket.getOutputStream(),true);
    }
    public void accedi(Socket clientsocket){
          accedi=clientsocket;
         System.out.println( accedi.getInetAddress());
          
    }
    public boolean accesso_eseguito(){
        return log;
    }
    
}

