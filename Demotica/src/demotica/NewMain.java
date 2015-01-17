/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotica;

import static demotica.Dashboard.home;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Rodolfo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
            Home h = File.loadHome();
            BufferedWriter writer=null;
            try{
                writer=new BufferedWriter(new FileWriter("RSensores.txt"));
                for(Map.Entry<Integer,Division> div:h.getDivisions().entrySet())
                    for(Map.Entry<Integer,Sensor> s:div.getValue().getSensors().entrySet()){
                        writer.write(String.valueOf(s.getValue().isStatus()));
                    }
                       //System.out.println(s.getKey()+" - "+s.getValue().isStatus());
            
            }catch (FileNotFoundException e) {
                System.out.println("Não é possivel criar o ficheiro");
            }writer.close();
        
        
            //for(Contact c:b.getValue())
        /*Home h = File.loadHome();        
        for(Map.Entry<Integer,Sensor> s:h.getDivisions().get(3).getSensors().entrySet())  
           if(s.getValue() instanceof Moviment)
               System.out.println(s.getKey()+" - "+((Moviment)s.getValue()).getInterval());*/
      
        
        /*h.getDivisions().get(1).addWindow(new Window());
         h.getDivisions().get(1).addWindow(new Window());
          h.getDivisions().get(1).addWindow(new Window());
            for(Map.Entry<Integer,Window> w:h.getDivisions().get(1).getWindows().entrySet())
               System.out.println(w.getKey());
            
        System.out.println();   
        h.getDivisions().get(1).remWindow(5); 
        h.getDivisions().get(1).remWindow(4);    
        
        for(Map.Entry<Integer,Window> w:h.getDivisions().get(1).getWindows().entrySet())
               System.out.println(w.getKey());*/
    }
    
        /*public static void saveResults() throws IOException{
            Home h = File.loadHome();
            BufferedWriter writer=null;
            try{
                writer=new BufferedWriter(new FileWriter(f));
                BufferedWriter out = new BufferedWriter(new FileWriter("RSensores.txt"));                
                for(Map.Entry<Integer,Division> div:h.getDivisions().entrySet()){
                    for(Sensor results=div.getValue().getSensors())
                    for (Sensor details: results){
                        writer.newLine();
                        writer.write("++++++++++++");
                        writer.newLine();
                    } 
                }
            }
            catch (FileNotFoundException e) {
            System.out.println("Não é possivel criar o ficheiro");
            }
            writer.close();
        }*/
    
}
