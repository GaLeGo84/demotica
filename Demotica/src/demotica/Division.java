package demotica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
public class Division implements Serializable{

    private int floor;
    private String name;
    private Climate climate;
    private Map<Integer,Light> lights;
    private List<Sensor> sensors;
    private Map<Integer,Window> windows;
    private List<Door> doors;
    private List<TimeIntervalLight> timeintervallight;

    public Division(String name, int floor, Climate climate){
        this.floor = floor;
        this.name = name;
        this.climate = climate;
        lights = new TreeMap<Integer,Light>();
        sensors = new LinkedList<Sensor>();
        windows = new TreeMap<Integer,Window>();
        doors = new LinkedList<Door>();
        timeintervallight = new LinkedList<TimeIntervalLight>();
    }

    public int getFloor() {
        return floor;
    }

    public Climate getClimate() {
        return climate;
    }
    
    public Map<Integer,Light> getLights() {
        return lights;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }
    
    public String getName() {
        return name;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Map<Integer,Window> getWindows() {
        return windows;
    }

    public List<Door> getDoors() {
        return doors;
    }
    
    public void addSensor(Sensor sen){
        sensors.add(sen);
    }
      
    public void addLight(Light l){
        int n=1;
        while(n<=lights.size()){
            if(lights.containsKey(n)==false){
                lights.put(n, l);
                break;
            }            
        n++;
        }
        
        if(lights.size()<n)
            lights.put(lights.size()+1,l);
    }
    
    public void addWindow(Window w){
        int n=1;
        while(n<=windows.size()){
            if(windows.containsKey(n)==false){
                windows.put(n, w);
                break;
            }            
        n++;
        }
        
        if(windows.size()<n)
            windows.put(windows.size()+1,w);          
    }
    
    public void remLight(int key){          
        lights.remove(key);
    }
    
    public void remWindow(int key){          
        windows.remove(key);
    }
    
    public void remDoor(Door id){
         doors.remove(id);
    }
    
    public void addDoor(Door dor){   
        doors.add(dor); 
    }
    
    
    
    //Lista de sensores de Temperatura
    public LinkedList<Temperature> listSensorTemperature(){
       LinkedList<Temperature> aux=new LinkedList<>();
       for (Sensor s:sensors){
           if(s instanceof Temperature)
                aux.add((Temperature)s);
       }
       return aux;
   }
    
    //Lista de sensores de movimento
    public LinkedList<Moviment> listSensorMoviment(){
       LinkedList<Moviment> aux=new LinkedList<>();
       for (Sensor s:sensors){
           if(s instanceof Moviment)
                aux.add((Moviment)s);
       }
       return aux;
   }
    
    //Lista de sensores de NaturaLight
    public LinkedList<NaturaLight> listSensorNaturaLight(){
       LinkedList<NaturaLight> aux=new LinkedList<>();
       for (Sensor s:sensors){
           if(s instanceof NaturaLight)
                aux.add((NaturaLight)s);
       }
       return aux;
   }
    
    //Lista de portas exteriores de Entrada
    public LinkedList<ExteriorEntranceDoor> listExteriorEntranceDoor(){
       LinkedList<ExteriorEntranceDoor> aux=new LinkedList<>();
       for (Door doo:doors){
           if(doo instanceof ExteriorEntranceDoor)
                aux.add((ExteriorEntranceDoor)doo);
       }
       return aux;
   }
    
     //Lista de portas exteriores de Standard
    public LinkedList<ExteriorDoorStandard> listExteriorStandardDoor(){
       LinkedList<ExteriorDoorStandard> aux=new LinkedList<>();
       for (Door doo:doors){
           if(doo instanceof ExteriorDoorStandard)
                aux.add((ExteriorDoorStandard)doo);
       }
       return aux;
   }
    
    //Lista de sensores de vento
    private LinkedList<Wind> listSensorWind(){
       LinkedList<Wind> aux=new LinkedList<>();
       for (Sensor doo:sensors){
           if(doo instanceof Wind)
                aux.add((Wind)doo);
       }
       return aux;
   }
    
    //Lista de sensores de gas
    private LinkedList<Gas> listSensorGas(){
       LinkedList<Gas> aux=new LinkedList<>();
       for (Sensor doo:sensors){
           if(doo instanceof Gas)
                aux.add((Gas)doo);
       }
       return aux;
   }
    
    //Lista de sensores de Smoke
    private LinkedList<Smoke> listSensorSmoke(){
       LinkedList<Smoke> aux=new LinkedList<>();
       for (Sensor s:sensors){
           if(s instanceof Smoke)
                aux.add((Smoke)s);
       }
       return aux;
   }
    
    public int nDoors(){
        return getDoors().size();
    }
    
    public int nWindows(){
        return getWindows().size();
    }
    
    public int nLights(){
        return getLights().size();
    }
    
    public int nDoorsExterior(){
        return listExteriorEntranceDoor().size();
    }
    
    public int nDoorsExteriorStandard(){
        return listExteriorStandardDoor().size();
    }
    
    //média da luz natural da sala
    public float mediaNaturaLight(){
        int media, soma=0, cont=0;
        for (NaturaLight snl:listSensorNaturaLight()){
            soma+=snl.getValue();
            cont++;            
        }
        
        return media= soma/cont;
    }
    
    //temperatura média
    public float mediaTemperature(){
        int media, soma=0, cont=0;
        for (Temperature lst:listSensorTemperature()){
            soma+=lst.getValue();
            cont++;            
        }
        
        return media= soma/cont;
    }
    
    
    //Ativar o Sensor de movimento para quando houver um movimento ligar a luz da divisão
    public void onMovimentSensor(String SNumber){
        long timestamp= System.currentTimeMillis();
        for (Moviment sm:listSensorMoviment()){
            if(sm.getSNumber().equals(SNumber)){
                sm.setDetection(true);
                sm.setTime(timestamp);
                if(onLight() == true){
                    for (Map.Entry<Integer, Light> l:lights.entrySet())
                        l.getValue().setStatus(true);   
                }
            }
        }  
    }
    
    public boolean onMovimentSensorAlarm(){
        long timestamp= System.currentTimeMillis();
        for (Moviment sm:listSensorMoviment()){
            if(sm.isDetection()==true)
                return true;                    
        }
        
        return false;
    }
    
    //Ligar as luzes da divisão quando a média da luz natural for menor do ke o valor minimo
    public boolean onLight(){
        /*if(mediaNaturaLight()<home.getValueNL())
            return true;
        else*/
            return false;            
    }
    
    //Desligar as luzes sem que haja movimento
    public void offMovimentSensor(){
        long timestamp= System.currentTimeMillis();
        for (Moviment sm:listSensorMoviment()){
            if(sm.isDetection()==true){
                long limit=sm.getTime()+sm.getInterval();
                if(timestamp>limit){
                    sm.setDetection(false);
                    sm.setTime(0);
                    for (Map.Entry<Integer, Light> l:lights.entrySet())
                        l.getValue().setStatus(false);
                }
            }
        }
    }
    
    //mudar a intensidade da luz
    public void changeLightIntensity(Light l, int value){
        float valor;
        for (Map.Entry<Integer, Light> li:lights.entrySet()){
            if(li.getValue().getIntensity()==l.getIntensity())
                li.getValue().setIntensity(value);
        }        
    }
    
    public void exceedTemperature(){
        if(mediaTemperature()>climate.getMAXVALUE()){
            for(Window w:windows.values())
                if(w.isStatus()==false)
                    w.setStatus(true);
                else{
                    w.setStatus(false);
                    climate.setAircon(true);
                }
        }
    }
    
    public void lowerTemperature(){
         if(mediaTemperature()<climate.getMINVALUE())
            lockWindows();
    }
    
    //Fechar as janelas
    public void lockWindows(){
        for (Window w:windows.values())
            if(w.isStatus()== true){
                w.setStatus(false);
                climate.setAircon(false);
                climate.setHeating(true);
            }else{
                climate.setAircon(false);
                climate.setHeating(true);            
            }
    }
    //Abrir as janelas
    public void openWindows(){
        for (Window w:windows.values())
            if(w.isStatus()== false)
                w.setStatus(true);
    }
    
    //Fechar as portas
    public void lockDoors(){
        for (Door doo:doors)
            if(doo.isStatus()== true)
                doo.setStatus(false);
    }
    
    //Abrir as portas
    public void openDoors(){
        for (Door doo:doors)
            if(doo.isStatus()== false)
                doo.setStatus(true);
    }
    
    public void onComponentSegurança(){
        //home.onAlertMoviment();
        
        for(ExteriorEntranceDoor doo:listExteriorEntranceDoor())
            doo.activeSecurity();
        
        lockWindows();
        lockDoors(); 
        
        for (Temperature sm:listSensorTemperature())
            sm.setStatus(false);
        
        for (NaturaLight snl:listSensorNaturaLight())
            snl.setStatus(false);
        
        for (Wind sw:listSensorWind())
            sw.setStatus(false);
        
        //home.alerTryOpenwindowsDoors();
    }
    
    public boolean verifyOnSensorGas(){
        for (Gas g:listSensorGas())
            if(g.isStatus()==true)
                return true;
        
        return false;                
    }
    
    public boolean verifyOnSensorSmoke(){
        for (Smoke s:listSensorSmoke())
            if(s.isStatus()==true)
                return true;
        
        return false;                
    }
    
    public void allDivision(){
        System.out.println("Sensores: "+getSensors()+"\n"
                + "Climate: "+getClimate()+"\n"
                + "Lights: "+getLights()+"\n"
                + "Doors: "+getDoors()+"\n"
                + "Windows: "+getWindows());
    }
}