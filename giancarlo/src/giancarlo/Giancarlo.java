/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giancarlo;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.SocketAddress;
/**
 *
 * @author super
 */
public class Giancarlo {

    /**
     * @param args the command line arguments
     */
     public static ArrayList<utente>persone=new ArrayList();
    public static void main(String[] args) {
         ArrayList<login>log=new ArrayList();
        login acesso;
        try {
            ServerSocket server=new ServerSocket(20);
           // server.bind( 0, "0.0.0.0");
            System.out.println("server attivo");
            acesso=new login();
            log.add(acesso);
            while(true){
                boolean fatto=false;
                 Socket client = server.accept();
                for (int i = 0; i <log.size(); i++) {
                    if(log.get(i).accesso_eseguito()!=true){
                        log.get(i).accedi(client);
                        fatto=true;
                    }
                    if(fatto==false){  
                        login accesso2=new login();
                      log.add(accesso2);
                      log.get(log.size()).accedi(client);
                    }
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Giancarlo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

    
    

