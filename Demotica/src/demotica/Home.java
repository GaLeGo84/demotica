package demotica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


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
    private List<Division> divisions;
    private int valueNL;
    private int valueW;

    public Home(int nFloors, int valueNL, int valueW) {
        this.nFloors = nFloors;
        this.alerts = new LinkedList<Alert>();
        this.divisions = new LinkedList<Division>();
        this.valueNL = valueNL;
        this.valueW = valueW;
    }

    public int getnFloors() {
        return nFloors;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    public int getValueNL() {
        return valueNL;
    }

    public int getValueW() {
        return valueW;
    }

    public void setnFloors(int nFloors) {
        this.nFloors = nFloors;
    }

    public void addDivisoes(Division div){
        divisions.add(div);
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
        for (Division div:divisions)
            if(div.onMovimentSensorAlarm()==true)
                for(IntruderAlert lia:listIntruderAlert()){
                    lia.setDetection(true);
                    lia.getEmail(); //Fazer a função de enviar email
                }    
    }
    
     //Tentativa de abrir a janela
    public boolean tryOpenwindows(){
        for (Division div:divisions)
            for(Window w:div.getWindows())
                if(w.isStatus()==true) 
                    return true;
                
        return false;
    }
    
     //Tentativa de abrir a porta
    public boolean tryOpenDoors(){
        for (Division div:divisions)
            for(Door d:div.getDoors())
                if(d.isStatus()==true)
                    return true;
                
        return false;
    }
    
    //Tentativa de abrir a janela e a porta
    public void alerTryOpenwindowsDoors(){
        for (Division div:divisions)
            for(ExteriorEntranceDoor lsed:div.listExteriorEntranceDoor())
                if(lsed.getSecurity().isStatus()==true && ((tryOpenwindows()==true) || tryOpenDoors()==true)){
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
