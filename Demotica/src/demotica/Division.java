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
    private List<Light> lights;
    private List<Sensor> sensors;
    private Map<Integer,Window> windows;
    private Map<Integer,Door> doors;
    private List<TimeIntervalLight> timeintervallight;

    public Division(String name, int floor, Climate climate){
        this.floor = floor;
        this.name = name;
        this.climate = climate;
        lights = new LinkedList<Light>();
        sensors = new LinkedList<Sensor>();
        windows = new TreeMap<Integer,Window>();
        doors = new TreeMap<Integer,Door>();
        timeintervallight = new LinkedList<TimeIntervalLight>();
    }

    public int getFloor() {
        return floor;
    }

    public Climate getClimate() {
        return climate;
    }
    
    public List<Light> getLights() {
        return lights;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }
    
    public String getName() {
        return name;
    }

    public Map<Integer,Window> getWindows() {
        return windows;
    }

    public Map<Integer,Door> getDoors() {
        return doors;
    }
    
    public void addSensor(Sensor sen){
        sensors.add(sen);
    }
      
    public void addLight(Light l){          
        lights.add(l);
    }
    
    public void addDoor(Door dor){   
        doors.put(doors.size()+1,dor);
    }
    
    public void addWindow(Window w){
         windows.put(windows.size()+1, w);          
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
    public TreeMap<Integer,ExteriorEntranceDoor> listExteriorEntranceDoor(){
       TreeMap<Integer,ExteriorEntranceDoor> aux=new TreeMap<>();
       for (Map.Entry<Integer, Door> doo:doors.entrySet()){
           if(doo instanceof ExteriorEntranceDoor)
                aux.put(doo.getKey(), (ExteriorEntranceDoor)doo);
       }
       return aux;
   }
    
     //Lista de portas exteriores de Standard
    public TreeMap<Integer,ExteriorDoorStandard> listExteriorStandardDoor(){
       TreeMap<Integer,ExteriorDoorStandard> aux=new TreeMap<>();
       for (Map.Entry<Integer, Door> doo:doors.entrySet()){
           if(doo instanceof ExteriorDoorStandard)
                aux.put(doo.getKey(), (ExteriorDoorStandard)doo);
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
                    for (Light l:lights)
                        l.setStatus(true);   
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
                    for (Light l:lights)
                        l.setStatus(false);
                }
            }
        }
    }
    
    //mudar a intensidade da luz
    public void changeLightIntensity(Light l, int value){
        float valor;
        for (Light li:lights){
            if(li.getIntensity()==l.getIntensity())
                li.setIntensity(value);
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
        for (Map.Entry<Integer, Door> doo:doors.entrySet())
            if(doo.getValue().isStatus()== true)
                doo.getValue().setStatus(false);
    }
    
    //Abrir as portas
    public void openDoors(){
        for (Map.Entry<Integer, Door> doo:doors.entrySet())
            if(doo.getValue().isStatus()== false)
                doo.getValue().setStatus(true);
    }
    
    public void onComponentSegurança(){
        //home.onAlertMoviment();
        
        for(Map.Entry<Integer, ExteriorEntranceDoor> doo:listExteriorEntranceDoor().entrySet())
            doo.getValue().activeSecurity();
        
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