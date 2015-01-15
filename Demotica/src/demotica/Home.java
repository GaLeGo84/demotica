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

    private static final long serialVersionUID = 5455238796031916510L;
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
    
    public void remDivision(int n){
        divisions.remove(n);
    }

    public void setValueNL(int valueNL) {
        this.valueNL = valueNL;
    }

    public void setValueW(int valueW) {
        this.valueW = valueW;
    }

    
    //Lista de sensores de movimento
    public LinkedList<IntruderAlert> listIntruderAlert(){
       LinkedList<IntruderAlert> aux=new LinkedList<>();
       for (Alert a:alerts){
           if(a instanceof IntruderAlert)
                aux.add((IntruderAlert)a);
       }
       return aux;
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
            for(Door doo:div.getDoors())
                if(doo.isStatus()==true)
                    return true;
                
        return false;
    }
    
    //Tentativa de abrir a janela e a porta
    public void alerTryOpenwindowsDoors(){
        for (Division div:divisions.values())
            for(ExteriorEntranceDoor doo:div.listExteriorEntranceDoor())
                if(doo.getSecurity().isStatus()==true && ((tryOpenwindows()==true) || tryOpenDoors()==true)){
                    for(IntruderAlert lia:listIntruderAlert()){
                        lia.setDetection(true);                            
                    }       
                }
     }
    
    
    //INICIO Fechar todas as portas exteriores caso ñ detetar nenhum movimento durante um determinado periúdo de tempo
    public void MovimentDoorExterior(){        
        for(Division div:divisions.values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Moviment){                    
                    if(((Moviment)s).isDetection()==false){
                        if(countMoviment1()==countMoviment2() )                        
                            if(countDoorsExtern()!=0){
                                lockDoorsExterior();
                            }
                    }
                }
    }
    
    public int countMoviment1(){
        int count=0;
        long timestamp= System.currentTimeMillis();
        boolean n=false;
        for(Division div:divisions.values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Moviment){
                    long limit=((Moviment)s).getTime()+Integer.parseInt(((Moviment)s).getInterval()+"000");
                    if(((Moviment)s).isDetection()==false && timestamp>limit)
                        count+=1;
                }
        return count;
    }
    
    public int countMoviment2(){
        int count=0;
        boolean n=false;
        for(Division div:divisions.values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Moviment){
                    count+=1;
                }
        return count;
    }
    
    public int countDoorsExtern(){
        int count=0;
        for(Division div:divisions.values())
                for(Door d:div.getDoors())
                    if(d instanceof ExteriorDoor)
                        count++;

                return count;
    }
    
    
        //Fechar as portas
    public void lockDoorsExterior(){
        for(Division div:divisions.values())
            for(Door d:div.getDoors())
            if(d instanceof ExteriorDoor)
                if(d.isStatus()==false){
                    d.setStatus(false);
                    d.setLock(true);
                }
    }
    //FIM Fechar todas as portas exteriores caso ñ detetar nenhum movimento durante um determinado periúdo de tempo
    
    public void closeWindowsMoreIntensityWind(){
        for(Division div:divisions.values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Wind)
                    if(((Wind)s).getIntensity()>valueW)
                        closeWindows();
    }
    
    public void closeWindows(){
        for(Division div:divisions.values())
            for(Map.Entry<Integer,Window> w:div.getWindows().entrySet())
                w.getValue().setStatus(false);
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
