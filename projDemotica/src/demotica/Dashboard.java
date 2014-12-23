package demotica;

import java.io.Serializable;

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

    
    public static Home carregarDados(){
        home = File.loadHome();
        return home;
    }
    
    public static int[] a(){
        int cont[]=null;
        for(int i=0;i<Dashboard.getHome().getnFloors();i++)
            cont[i]=i;
        
        return cont;
    }
}
