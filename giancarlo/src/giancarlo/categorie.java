/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancarlo;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class categorie {
     private String nome;
    private ArrayList<chat>chat;
    private Socket accedi;
    
    public categorie(String nome){
     this.nome=nome;
    }
     public String getNome(){
        return nome;
     }
     public void setNome(String nome){
         this.nome=nome;
    }
     public void aggiungi_chat(chat a){
        chat.add(a);
     }
     public void accedi(Socket accedi){
      this.accedi=accedi;       
  }  
}
