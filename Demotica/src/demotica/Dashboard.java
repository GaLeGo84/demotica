package demotica;

import java.io.Serializable;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


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
    
    public static void countNumberWindows(int n){
        int nDivisions = home.getDivisions().size();
        int i=0;
        while(i<n){
            home.getDivisions().get(nDivisions).addWindow(new Window());
            i++;
        }
    }
    
    public static void countNumberLights(int n){
        int nDivisions = home.getDivisions().size();
        int i=0;
        while(i<n){
            home.getDivisions().get(nDivisions).addLight(new Light());
            i++;
        }
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
    
    public static void verifyIfExteriorEntranceDoor(JButton b, JLabel j){
        for(Division div:home.getDivisions().values())
            if(div.listExteriorEntranceDoor().size()!=0){
                b.setEnabled(true);
                j.setVisible(true);
            }
    }
    
    public static void alarm(JButton j, JLabel jl){
        if(j.isEnabled()==true){
            int n = JOptionPane.showConfirmDialog(null,
            "Queres Ligar o Alarme?",
            "Alarme",
            JOptionPane.YES_NO_OPTION);
            if(n==0){
                jl.setText("Ligado");
                for(Division div:home.getDivisions().values())
                    div.onComponentSegurança();
            }
        }
    }
    
}
