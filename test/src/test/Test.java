/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author super
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
         ArrayList<String>scarto=new ArrayList<String>();
        FileReader a=new FileReader("C:\\Users\\super\\OneDrive\\Desktop\\classifica\\vincitori.TXT");
         BufferedReader leggi=new BufferedReader(a);
     boolean cerca=true;
     while(cerca==true){
     String giocatore = "";
       String nome1=leggi.readLine();
       if(nome1==null){
           break;
       }
         System.out.println(nome1);
      String []n=nome1.split(" ");
      for(int i=0;i<n.length;i++){
          scarto.add(n[i]); 
          
      }
          
           
       }
     for(int p=0;p<scarto.size();p++){
         System.out.println(scarto.get(p));
     }
          
      leggi.close();
    
     }
      
      
    }
        
    
    

