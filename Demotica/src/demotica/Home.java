package demotica;

import static demotica.Dashboard.home;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo Melo, Henrique Melo, Xico
 */
public class Home implements Serializable{

    private static final long serialVersionUID = -6231719377239289088L;
    private int nFloors;
    private List<Alert> alerts;
    private Map<Integer,Division> divisions;
    private int valueNL;
    private int valueW;

    public Home(int nFloors, int valueNL, int valueW) {
        this.nFloors = nFloors;
        this.alerts = new LinkedList<Alert>();
        this.divisions = new TreeMap<Integer,Division>();
        this.valueNL = valueNL;
        this.valueW = valueW;
    }

    public int getnFloors() {
        return nFloors;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public Map<Integer,Division> getDivisions() {
        return divisions;
    }

    public int getValueNL() {
        return valueNL;
    }

    public int getValueW() {
        return valueW;
    }
    
    public int getIntMap(String name){
        int n=0;
        for (Map.Entry<Integer, Division> entry : home.getDivisions().entrySet())
            if (entry.getValue().getName().equals(name))
                n= entry.getKey();
        
        return n;
    }    

    public void setnFloors(int nFloors) {
        this.nFloors = nFloors;
    }

    public void addDivision(Division div){
        int n=1;
        while(n<=divisions.size()){
            if(divisions.containsKey(n)==false){
                divisions.put(n, div);
                break;
            }            
        n++;
        }
        
        if(divisions.size()<n)
            divisions.put(divisions.size()+1,div);
    }

    public void setValueNL(int valueNL) {
        this.valueNL = valueNL;
    }

    public void setValueW(int valueW) {
        this.valueW = valueW;
    }

    
    //Lista de sensores de movimento
    private LinkedList<IntruderAlert> listIntruderAlert(){
       LinkedList<IntruderAlert> aux=new LinkedList<>();
       for (Alert a:alerts){
           if(a instanceof IntruderAlert)
                aux.add((IntruderAlert)a);
       }
       return aux;
   }
    
    public void onAlertMoviment(){
        for (Division div:divisions.values())
            if(div.onMovimentSensorAlarm()==true)
                for(IntruderAlert lia:listIntruderAlert()){
                    lia.setDetection(true);
                    lia.getEmail(); //Fazer a função de enviar email
                }    
    }
    
     //Tentativa de abrir a janela
    public boolean tryOpenwindows(){
        for (Division div:divisions.values())
            for(Window w:div.getWindows().values())
                if(w.isStatus()==true) 
                    return true;
                
        return false;
    }
    
     //Tentativa de abrir a porta
    public boolean tryOpenDoors(){
        for (Division div:divisions.values())
            for(Map.Entry<Integer, Door> doo:div.getDoors().entrySet())
                if(doo.getValue().isStatus()==true)
                    return true;
                
        return false;
    }
    
    //Tentativa de abrir a janela e a porta
    public void alerTryOpenwindowsDoors(){
        for (Division div:divisions.values())
            for(Map.Entry<Integer, ExteriorEntranceDoor> doo:div.listExteriorEntranceDoor().entrySet())
                if(doo.getValue().getSecurity().isStatus()==true && ((tryOpenwindows()==true) || tryOpenDoors()==true)){
                    for(IntruderAlert lia:listIntruderAlert()){
                        lia.setDetection(true);                            
                    }       
                }
     }   
    
    
    
    /*public void onAlertGasSmoke(){
        for (Division div:divisions)
            if(div.verifyOnSensorGas()==true || div.verifyOnSensorSmoke()==true)
                
                
    }*/

    @Override
    public String toString() {
        return "Home{" + "nFloors=" + nFloors + ", alerts=" + alerts + ", divisions=" + divisions + '}';
    }
    
}
