/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancorlo_progetto_discordsales;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class chat implements Runnable{
private String nome;
private ArrayList<Object>messaggi;
private int indirizzo;
private ArrayList<utente>membri;
private String messaggio;

    public chat(String nome) {
        this.nome=nome;
    }

    @Override
    //controlla che ci siano nuovi mesaggi
    public void run() {
     while(true){
         if(messaggio==messaggi.get(messaggi.size())){
             stampa();
         }
     }
    }
     //serve per stampare tutti i messaggi       
    public void stampa(){
        for (int i = 0; i < 10; i++) {
            System.out.println(messaggi.get(i));
        }
  
    }
    //serve per scrivere nella chat
    public synchronized void scrivi(String messaggio){
        this.messaggio=messaggio;
    }
    public ArrayList<Object> getMessaggi(){
    return null; 
    }
    public String getNome(){
    return nome;
        
    }
    public int getIndirizzo(){
    return indirizzo;  
    }
    public void aggiungi_utente(utente a){
      membri.add(a);
    }
    public void elimina_utente(utente a){
    membri.remove(a);
    }
    public void getUtente(){
        for (int i = 0; i < 10; i++) {
            System.out.println(membri.get(i));
        }
    }
    
    
    
    
}
