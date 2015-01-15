/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotica;

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
        int n=1;
        Map<Integer,List<Integer>> a=new TreeMap<Integer,List<Integer>>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(911656898);
        list.add(923454238);
        a.put(a.size()+1, list);
        
        for (Map.Entry<Integer,List<Integer>> b : a.entrySet())
                System.out.println(b.getKey()+" - "+b.getValue().toString());

    }
    
}
