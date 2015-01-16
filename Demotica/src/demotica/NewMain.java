/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotica;

import static demotica.Dashboard.home;
import java.text.SimpleDateFormat;
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
    public static void main(String[] args) {
        
        
            //for(Contact c:b.getValue())
        Home h = File.loadHome();        
        for(Map.Entry<Integer,Sensor> s:h.getDivisions().get(3).getSensors().entrySet())  
           if(s.getValue() instanceof Moviment)
               System.out.println(s.getKey()+" - "+((Moviment)s.getValue()).getInterval());
      
        
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
    
}
