/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancarlo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author super
 */
public class canale {
        private String nome;
        private int indirizzo;
        private Vector chat=new Vector();
        private Vector categorie=new Vector();
        private ArrayList<utente>persone=new ArrayList<utente>();
        private Object immagine="";
        private indirizzo a=new indirizzo();
        private Socket accedi=new Socket();
        private PrintWriter out;
        private BufferedReader in;

    public canale(String nome) {
        this.nome = nome;
        indirizzo=a.nuovo_canale();
        chat c=new chat("generale");
        chat.add(c);
        immagine=this.nome.charAt(0);
         try {
            out=new PrintWriter(accedi.getOutputStream(),true);
            in=new BufferedReader(new InputStreamReader(accedi.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void nuova_chat(String nome){
        chat c=new chat(nome);
        chat.add(c);
    }
    public void nuova_categoria(String nome){
        categorie ct=new categorie(nome);
        categorie.add(ct);
    }
    public void accedi(Socket s){
      accedi=s;  
    }
    public void accedi_chat(int in){
        for (int i = 0; i < chat.size(); i++) {
            chat v=(chat)chat.get(i);
            if(v.indirizzo()==in){
                v.acesso(accedi);
                    break;
                }
            }
        }
    public int getindirizzo(){
        return indirizzo;
    }
    public void azioni(){
        boolean ciclo=true;
        while(ciclo==true){
            try {
                String comando=in.readLine();
                String []ordini=comando.split(":");
                int azione=Integer.parseInt(ordini[0]);
                switch(azione){
                    case 0: 
                    nome=ordini[1];    
                }
            } catch (IOException ex) {
                Logger.getLogger(canale.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
}


