package demotica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo Melo, Henrique Melo, Xico
 */
public class Dashboard implements Serializable{
 
    private static final long serialVersionUID = -6231719377239289088L;
    static Home home;    

    public static Home getHome() {
        return home;
    }

    public static void setHome(Home home) {
        Dashboard.home = home;
    }
    
    public static void loadData(){
        home = File.loadHome();
    }
    
    public static void saveData(){
        File.saveHome(home);
    }
    
    public static void criarHome(int nFloors, int valueNL, int valueW){
        home = new Home(nFloors, valueNL, valueW);
    }
    
    public static int getIntMap(String name){
        int n=0;
        for (Map.Entry<Integer, Division> entry : home.getDivisions().entrySet())
            if (entry.getValue().getName().equals(name))
                n= entry.getKey();
        
        return n;
    }
    
}
