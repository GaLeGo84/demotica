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
    private Map<Integer,Sensor> sensors;
    private Map<Integer,Window> windows;
    private List<Door> doors;
    private List<TimeIntervalLight> timeintervallight;

    public Division(String name, int floor, Climate climate){
        this.floor = floor;
        this.name = name;
        this.climate = climate;
        lights = new TreeMap<Integer,Light>();
        sensors = new TreeMap<Integer,Sensor>();
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

    public Map<Integer,Sensor> getSensors() {
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
        int n=1;
        while(n<=sensors.size()){
            if(sensors.containsKey(n)==false){
                sensors.put(sen.getSNumber(),sen);
                break;
            }            
        n++;
        }
        
        if(sensors.size()<n)
            sensors.put(sensors.size()+1,sen);
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
    public Map<Integer,Temperature> listSensorTemperature(){
       TreeMap<Integer,Temperature> aux=new TreeMap<>();
       for (Map.Entry<Integer, Sensor> s : sensors.entrySet())
           if(s instanceof Temperature)
                aux.put(s.getKey(), (Temperature)s);

       return aux;
   }
    
    //Lista de sensores de movimento
    public  Map<Integer,Moviment> listSensorMoviment(){
       TreeMap<Integer,Moviment> aux=new TreeMap<>();
       for (Map.Entry<Integer, Sensor> s : sensors.entrySet())
           if(s instanceof Moviment)
                aux.put(s.getKey(),(Moviment)s);
       
       return aux;
   }
    
    //Lista de sensores de NaturaLight
    public Map<Integer,NaturaLight> listSensorNaturaLight(){
       TreeMap<Integer,NaturaLight> aux=new TreeMap<>();
       for (Map.Entry<Integer, Sensor> s : sensors.entrySet())
           if(s instanceof NaturaLight)
                aux.put(s.getKey(),(NaturaLight)s);

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
    private Map<Integer,Wind> listSensorWind(){
       TreeMap<Integer,Wind> aux=new TreeMap<>();
       for (Map.Entry<Integer, Sensor> s : sensors.entrySet())
           if(s instanceof Wind)
                aux.put(s.getKey(),(Wind)s);
       return aux;
   }
    
    //Lista de sensores de gas
    private Map<Integer,Gas> listSensorGas(){
       TreeMap<Integer,Gas> aux=new TreeMap<>();
       for (Map.Entry<Integer, Sensor> s : sensors.entrySet())
           if(s instanceof Gas)
                aux.put(s.getKey(),(Gas)s);
       return aux;
   }
    
    //Lista de sensores de Smoke
    private Map<Integer,Smoke> listSensorSmoke(){
       TreeMap<Integer,Smoke> aux=new TreeMap<>();
       for (Map.Entry<Integer, Sensor> s : sensors.entrySet())
           if(s instanceof Smoke)
                aux.put(s.getKey(),(Smoke)s);

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
        for (Map.Entry<Integer, NaturaLight> snl :listSensorNaturaLight().entrySet()){
            soma+=snl.getValue().getValue();
            cont++;            
        }
        
        return media= soma/cont;
    }
    
    //temperatura média
    public float mediaTemperature(){
        int media, soma=0, cont=0;
        for (Map.Entry<Integer, Temperature> snl :listSensorTemperature().entrySet()){
            soma+=snl.getValue().getValue();
            cont++;            
        }
        
        return media= soma/cont;
    }
    
    
    //Ativar o Sensor de movimento para quando houver um movimento ligar a luz da divisão
    public void onMovimentSensor(int SNumber){
        long timestamp= System.currentTimeMillis();
        for (Map.Entry<Integer, Moviment> sm :listSensorMoviment().entrySet()){
            if(sm.getValue().getSNumber()==SNumber){
                sm.getValue().setDetection(true);
                sm.getValue().setTime(timestamp);
                if(onLight() == true){
                    for (Map.Entry<Integer, Light> l:lights.entrySet())
                        l.getValue().setStatus(true);   
                }
            }
        }  
    }
    
    public boolean onMovimentSensorAlarm(){
        long timestamp= System.currentTimeMillis();
        for (Map.Entry<Integer, Moviment> sm :listSensorMoviment().entrySet()){
            if(sm.getValue().isDetection()==true)
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
        for (Map.Entry<Integer, Moviment> sm :listSensorMoviment().entrySet()){
            if(sm.getValue().isDetection()==true){
                long limit=sm.getValue().getTime()+sm.getValue().getInterval();
                if(timestamp>limit){
                    sm.getValue().setDetection(false);
                    sm.getValue().setTime(0);
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
        for (Map.Entry<Integer, Temperature> sm :listSensorTemperature().entrySet())
            sm.getValue().setStatus(false);
        
        for (Map.Entry<Integer, NaturaLight> snl:listSensorNaturaLight().entrySet())
            snl.getValue().setStatus(false);
        
         for (Map.Entry<Integer, Wind> sw:listSensorWind().entrySet())
            sw.getValue().setStatus(false);
        
        //home.alerTryOpenwindowsDoors();
    }
    
    public boolean verifyOnSensorGas(){
        for (Map.Entry<Integer, Gas> g :listSensorGas().entrySet())
            if(g.getValue().isStatus()==true)
                return true;
        
        return false;                
    }
    
    public boolean verifyOnSensorSmoke(){
        for (Map.Entry<Integer, Smoke> s :listSensorSmoke().entrySet())
            if(s.getValue().isStatus()==true)
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