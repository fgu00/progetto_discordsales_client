/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancarlo;

import java.net.Socket;
import java.util.Vector;
import java.util.ArrayList;
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

    public canale(String nome) {
        this.nome = nome;
        this.immagine = immagine;
        indirizzo=a.nuovo_canale();
        chat c=new chat("generale");
        chat.add(c);
        immagine=this.nome.charAt(0);
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
}


