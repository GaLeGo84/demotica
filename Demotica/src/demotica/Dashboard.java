package demotica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    
    public static boolean ativeSensorMoviment(){
        boolean status=false;
        for(Division div:home.getDivisions().values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Moviment)
                    if(((Moviment)s).isDetection()==true)
                        status=true;
        
        return status;
    }
    
    public static boolean movimentExteriorDoorOnHome(){
        boolean status=false;
        for(Division div:home.getDivisions().values())
            for(Door d:div.getDoors())
                if(d instanceof ExteriorDoor)
                    if(d.isStatus()==true || d.isLock()==false)
                        status=true;
        
        return status;
    }
    
    public static boolean movimentWindowsOnHome(){
        boolean status=false;
        for(Division div:home.getDivisions().values())
            for(Window w:div.getWindows().values())
                    if(w.isStatus()==true || w.isLock()==false)
                        status=true;
        
        return status;
    }
    
    public static void ativeIntruderAlert(){
        for(IntruderAlert lia:home.listIntruderAlert()){
            lia.setDetection(true);
            //lia.getEmail(); //Fazer a função de enviar email
        }    
    }
    
    public static boolean verifySecurity(){
        boolean status=false;
        for(Division div:home.getDivisions().values())
            for(Door d:div.getDoors())
                if(d instanceof ExteriorEntranceDoor)
                    status=((ExteriorEntranceDoor)d).getSecurity().isStatus();
        
        return status;
    }
    
    public static void acionarAlarmeAndCloseDoorsWindows(){
        if(verifySecurity()==true)
            for (Division div:home.getDivisions().values())
                if(ativeSensorMoviment()==true || movimentExteriorDoorOnHome()==true || movimentWindowsOnHome()==true){
                    ativeIntruderAlert();            
                    JOptionPane.showMessageDialog(null, "Entrada de Intruso");
                }
    }
    
    public static boolean existOnSensorGas(){
        boolean status=false;
        for (Division div:home.getDivisions().values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Gas)
                    if(((Gas)s).isDetection()==true)
                        status=true;
        
        return status;
    }
    
    public static boolean existOnSensorSmoke(){
        boolean status=false;
        for (Division div:home.getDivisions().values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Smoke)
                    if(((Smoke)s).isDetection()==true)
                        status=true;
        
        return status;
    }
    
    public static void ativeSoundAlert(){
        for(SoundAlert lia:home.listSoundAlert()){
            lia.setDetection(true);
            //lia.getEmail(); //Fazer a função de enviar email
        }    
    }
    
    public static void acionarAlarmeGasSmoke(){
        if(verifySecurity()==true)
            for (Division div:home.getDivisions().values())
                if(existOnSensorGas()==true || existOnSensorSmoke()==true){
                    ativeSoundAlert();            
                    JOptionPane.showMessageDialog(null, "Alerta Sonoro");
                }
    }
    
    public static void allDoors(JComboBox j){
        for (Division div:home.getDivisions().values())
            for(Door d:div.getDoors())
                if(d instanceof InteriorDoor)
                    j.addItem(d.getId());
        
    }
    
    public static void toInteger(JTextField str){
        try{
            Integer.parseInt(str.getText());
        }catch(NumberFormatException a){
            JOptionPane.showMessageDialog(null, "O campo tem de ser do tipo numérico");
            str.setText("");
        }
        
    }
    
    
}
