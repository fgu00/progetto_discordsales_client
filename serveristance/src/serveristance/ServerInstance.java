/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveristance;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.logging.*;
/**
 *
 * @author super
 */
public class ServerInstance {
 private ServerSocket ss;
    private Socket s;
    private String lista ="";
    private ServerManager sm;
    public static final ContiManager cm = new ContiManager();

    public ServerInstance(int port) {
        try {
            ss = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ServerInstance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void goSever(){
        leggi();
        do{
            try {
                s = ss.accept();
                sm = new ServerManager(s, cm.getListaConti());
                Thread t = new Thread(sm);
                t.start(); 
            } catch (IOException ex) {
                Logger.getLogger(ServerInstance.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(true);   
}
    public void leggi(){
         File file=new File("C:\\Users\\super\\OneDrive\\Desktop\\banca\\conti.TXT");
         if(file.exists()){
             FileReader scrivi2;
             try {
                  HashMap <String, ContoCorrente>prova2 = new HashMap<String, ContoCorrente>();
                  ContoCorrente a;
                 scrivi2 = new FileReader(file);
                 BufferedReader scrivi=new BufferedReader(scrivi2); 
                 String prova=scrivi.readLine();
                 boolean ciclo=true;
                 while(ciclo==true){
                     if(prova!=null){
                      a=new ContoCorrente(prova);
                      String id=prova;
                      prova=scrivi.readLine();
                      a.setSaldo(Float.parseFloat(prova));
                       prova2.put(id, a);
                        prova=scrivi.readLine();
                     }else{
                         ciclo=false;
                     }
                 }
                     cm.setLista(prova2);
                 
             } catch (IOException ex) {
                 Logger.getLogger(ServerInstance.class.getName()).log(Level.SEVERE, null, ex);
             } 
         }
         }
//             File cartella=new File("C:\\Users\\super\\OneDrive\\Desktop\\banca");
//             cartella.mkdir();
//             File file2=new File("C:\\Users\\super\\OneDrive\\Desktop\\banca\\conti.TXT");
//             try {
//                 file2.createNewFile();
//             } catch (IOException ex) {
//                 Logger.getLogger(ServerInstance.class.getName()).log(Level.SEVERE, null, ex);
//             }
//         }
//         FileWriter scrivi2 = new FileWriter(file);
//         BufferedWriter scrivi=new BufferedWriter(scrivi2);
//         HashMap <String, ContoCorrente>prova=cm.salva();
//         for (int i = 0; i < prova.size(); i++) {
//             if(""+(float) prova.get(i).getSaldo()!=null){
//                  scrivi.write(prova.get(i).getId());
//             scrivi.write(""+(float) prova.get(i).getSaldo());    
//             }
//         }
//         scrivi.flush();
//         scrivi.close();
//     } catch (IOException ex) {
//         Logger.getLogger(ServerInstance.class.getName()).log(Level.SEVERE, null, ex);
//     } 
    }


    
