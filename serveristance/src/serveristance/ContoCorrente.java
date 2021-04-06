/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveristance;

import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author super
 */
public class ContoCorrente {
    private String id;
    private Vector<CommunicationManager> listaClient;
    private float saldo;
    
    public ContoCorrente(String id) {
        this.id = id;   
        listaClient=new Vector<CommunicationManager>();
    }

    //passo la socket e l'istanza di se stesso
    public void addClient(Socket s){
        listaClient.add(new CommunicationManager(s, this));
        new Thread(listaClient.elementAt(listaClient.size()-1)).start();
    }
    
    public synchronized boolean versa(float cifra){
        saldo=saldo+cifra;
        return true;
    }
    
    public synchronized boolean preleva(float cifra){
        if(saldo>cifra){
            saldo=saldo-cifra;
            return true;
        }
        return false;
    }
    
    public float getSaldo(){
     return saldo;
        
    }
    public String getId(){
        return id; 
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}    

