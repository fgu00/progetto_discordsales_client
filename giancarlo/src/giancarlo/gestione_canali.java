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
public class gestione_canali {
    ArrayList<canale>canali;
    private Socket accedi;
    public gestione_canali(){   
    }
    public void accedi(Socket accedi,int indirizzo){
        for (int i = 0; i < canali.size(); i++) {
            if(indirizzo==canali.get(i).getindirizzo()){
                canali.get(i).accedi(accedi);
            }
        }
    }
    public void aggiungi_canali(canale a){
        canali.add(a);
    }
    public void elimina_canale(int i){
        for (int j = 0; j < canali.size(); j++) {
           if(i==canali.get(i).getindirizzo()){
               canali.remove(i);
           } 
        }
    }
    
}
