package demotica;

import java.io.Serializable;
import java.util.ArrayList;
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
    
    public static Home criarHome(int nFloors, int valueNL, int valueW){
        return new Home(nFloors, valueNL, valueW);
    }
    
}
