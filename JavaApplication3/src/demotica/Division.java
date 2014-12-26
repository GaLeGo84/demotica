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
public class Division implements Serializable{

    private Home home;
    private int floor;
    private String name;
    private Climate climate;
    private List<Light> lights;
    private List<Sensor> sensors;
    private List<Window> windows;
    private List<Door> doors;

    public Division(Home h,String name, int floor, Climate climate){
        this.home=h;
        this.floor = floor;
        this.name = name;
        this.climate = climate;
        lights = new LinkedList<Light>();
        sensors = new LinkedList<Sensor>();
        windows = new LinkedList<Window>();
        doors = new LinkedList<Door>();
    }

    public int getFloor() {
        return floor;
    }

    public Home getHome() {
        return home;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setHome(Home home) {
        this.home = home;
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

    public List<Window> getWindows() {
        return windows;
    }

    public List<Door> getDoors() {
        return doors;
    }
    
    public void addSensor(Sensor sen){
        sensors.add(sen);
    }
      
    public void addLight(Light l){          
        lights.add(l);
    }
    
    public void addDoor(Door dor){   
        doors.add(dor);
    }
    
    public void addWindow(Window w){ 
        windows.add(w);
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
    public LinkedList<ExteriorEntranceDoor> listSensorExteriorEntranceDoor(){
       LinkedList<ExteriorEntranceDoor> aux=new LinkedList<>();
       for (Door doo:doors){
           if(doo instanceof ExteriorEntranceDoor)
                aux.add((ExteriorEntranceDoor)doo);
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
        if(mediaNaturaLight()<home.getValueNL())
            return true;
        else
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
            for(Window w:windows)
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
        for (Window w:windows)
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
        for (Window w:windows)
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
        home.onAlertMoviment();
        
        for(ExteriorEntranceDoor doo:listSensorExteriorEntranceDoor())
            doo.activeSecurity();
        
        lockWindows();
        lockDoors(); 
        
        for (Temperature sm:listSensorTemperature())
            sm.setStatus(false);
        
        for (NaturaLight snl:listSensorNaturaLight())
            snl.setStatus(false);
        
        for (Wind sw:listSensorWind())
            sw.setStatus(false);
        
        home.alerTryOpenwindowsDoors();
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