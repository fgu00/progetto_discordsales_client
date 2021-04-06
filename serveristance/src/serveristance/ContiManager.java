/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveristance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author super
 */
public class ContiManager {
     private HashMap<String, ContoCorrente> lista;

    public ContiManager() {
        lista = new HashMap();
        genera();
    }
    
    private void genera(){
        for(int i = 0; i < 10; i++){
            lista.put(""+i, new ContoCorrente(""+i));
        }
    }
    
    public String getListaConti(){
        String l="";
        for(String s : lista.keySet()){
            l = l +"::"+s;
        }
        return l;
    }
    
    public boolean addClient(Socket s, String nconto) throws IOException{
        lista.get(nconto).addClient(s);
        salva();
        return true;
    }
    public void salva() throws IOException{
        File file=new File("C:\\Users\\super\\OneDrive\\Desktop\\banca\\conti.TXT");
        if(!file.exists()){
      File cartella=new File("C:\\Users\\super\\OneDrive\\Desktop\\banca");
             cartella.mkdir();
             try {
                 file.createNewFile();
             } catch (IOException ex) {
                 Logger.getLogger(ServerInstance.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        FileWriter scrivi2 = new FileWriter(file);
         BufferedWriter scrivi=new BufferedWriter(scrivi2);
         for (int i = 0; i < lista.size(); i++) {
             System.out.println(lista.get(i).getId());
                  scrivi.write(lista.get(i).getId());
             scrivi.write(""+(float) lista.get(i).getSaldo());    
             
         }
         scrivi.flush();
         scrivi.close();
    }
        
    
    public void setLista(HashMap<String, ContoCorrente> lista) {
        this.lista = lista;
        }
    }
    

  

