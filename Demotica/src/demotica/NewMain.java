/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotica;

import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Home
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       File fi = new File();
       Home h = fi.loadHome();
        for (Map.Entry<Integer, Sensor> nl : h.getDivisions().get(1).getSensors().entrySet()){
            if(nl.getValue() instanceof NaturaLight)
                System.out.println(nl.getKey()+" "+nl.getValue().toString()+" "+nl.getValue().getSNumber());
        }

    }
    
}
