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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author super
 */
public class chat implements Runnable{
private String nome;
private ArrayList<Object>messaggi;
private int indirizzo;
private ArrayList<String>membri;
private String messaggio;
private Socket accedi;
 private PrintWriter out;
private BufferedReader in;
private int tipologia;


    public chat(String nome) {
        this.nome=nome;
           try {
            out=new PrintWriter(accedi.getOutputStream(),true);
            in=new BufferedReader(new InputStreamReader(accedi.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void accedi_privata(Socket accedi) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(accedi.getInputStream()));
        String indirizzoutente=in.readLine();
        for (int i = 0; i < 10; i++) {
        if(indirizzoutente.equals(membri.get(i)))
        this.accedi=accedi;   
        }
    }
    public void accedi_publica(Socket accedi){
        this.accedi=accedi;  
    }
    public void acesso(Socket accedi){
        if(tipologia==1){
            try {
                this.accedi_privata(accedi);
            } catch (IOException ex) {
                Logger.getLogger(chat.class.getName()).log(Level.SEVERE, null, ex);
            }
         }else{
            this.accedi_publica(accedi);
        }
    }
    public void setTipologia(int a){
      tipologia=a;  
    }

    @Override
    //controlla che ci siano nuovi mesaggi
    public void run() {
     while(true){
         if(messaggio.equals(messaggi.get(messaggi.size()))){
             stampa();
         }
     }
    }
     //serve per stampare tutti i messaggi       
    public void stampa(){
        for (int i = 0; i < 10; i++) {
            out.println(messaggi.get(i));
        }
  
    }
    //serve per scrivere nella chat
    public synchronized void scrivi(){
        try {  
            String messaggio=in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Object> getMessaggi(){
    return null; 
    }
    public void getNome(){
    out.write(nome);
        
    }
    public void getIndirizzo(){
    out.write(indirizzo);  
    }
    public void aggiungi_utente(String a){
      membri.add(a);
    }
    public void elimina_utente(String a){
    membri.remove(a);
    }
    public void getUtente(){
        for (int i = 0; i < 10; i++) {
            System.out.println(membri.get(i));
        }
    }
}
