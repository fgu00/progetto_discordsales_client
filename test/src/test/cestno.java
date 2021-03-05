/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileReader;

/**
 *
 * @author super
 */
public class cestno {
    public void cstino1(){
    // FileReader leggi=new FileReader("C:\\Users\\russo.salvatore\\Desktop\\classifica\\vincitori.txt");
     FileReader leggi=new FileReader("C:\\Users\\super\\OneDrive\\Desktop\\classifica\\vincitori.TXT");
     boolean cerca=true;
     while(cerca==true){
     boolean ciclo=true;
     String giocatore = "";
     while(ciclo==true){
       Integer nome1= leggi.read();
       if(nome1==-1){
           cerca=false;
           ciclo=false;
           break;
       }
       int nome2=nome1;
       if(nome2!=32){
         if(nome2!=-1){
             char nome=(char) nome2;
         giocatore= (giocatore+nome); 
     }else{
           ciclo=false;  
             
         }
       }else{
           scarto.add(giocatore);
           ciclo=false;
           
       }
        
     }    
     
    
     }
      leggi.close();
      cerca();
    }
}

