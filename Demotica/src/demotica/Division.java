package demotica;

import Swing.DashBoardExe;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

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
            sensors.put(sen.getSNumber(),sen);
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
    
    public void remSensor(int key){
        sensors.remove(key);
    }
    
    public void addDoor(Door dor){   
        doors.add(dor); 
    }
    
    
    
    //Lista de sensores de Temperatura
    public void listSensorTemperature(DefaultTableModel Obj){
       for (Sensor s : sensors.values())
           if(s instanceof Temperature)
               Obj.addRow(new Object[]{s.getSNumber(),s.isStatus(),((Temperature)s).getValue()});
   }
    
    //DefaultTableModel de sensores de movimento
    public void listSensorMoviment(DefaultTableModel Obj){
       for (Sensor s : sensors.values())
           if(s instanceof Moviment)
               Obj.addRow(new Object[]{s.getSNumber(),s.isStatus(),((Moviment)s).getInterval(),((Moviment)s).isDetection()});
   }
    
    //Lista de sensores de NaturaLight
    public void listSensorNaturaLight(DefaultTableModel Obj){
       for (Sensor s : sensors.values())
           if(s instanceof NaturaLight)
               Obj.addRow(new Object[]{s.getSNumber(),s.isStatus(),((NaturaLight)s).getValue()});
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
    public void listSensorWind(DefaultTableModel Obj){
       for (Sensor s : sensors.values())
           if(s instanceof Wind)
               Obj.addRow(new Object[]{s.getSNumber(),s.isStatus(),((Wind)s).getIntensity()});
   }
    
    //Lista de sensores de gas
    public void listSensorGas(DefaultTableModel Obj){
       for (Sensor s : sensors.values())
           if(s instanceof Gas)
               Obj.addRow(new Object[]{s.getSNumber(),s.isStatus(),((Gas)s).isDetection()});
   }
    
    //Lista de sensores de Smoke
    public void listSensorSmoke(DefaultTableModel Obj){
       for (Sensor s : sensors.values())
           if(s instanceof Smoke)
               Obj.addRow(new Object[]{s.getSNumber(),s.isStatus(),((Smoke)s).isDetection()});
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
        int media=0, soma=0, cont=0;
        for (Sensor snl :sensors.values()){
            if(snl instanceof NaturaLight){
                soma+=((NaturaLight)snl).getValue();
                cont++;            
            }
        }
        
        return media= soma/cont;
    }
    
    //temperatura média
    public float mediaTemperature(){
        int media, soma=0, cont=0;
        for (Sensor snl :sensors.values()){
            if(snl instanceof Temperature){
                soma+=((Temperature)snl).getValue();
                cont++;
            }
        }
        
        return media= soma/cont;
    }
    
    
    //Ativar o Sensor de movimento para quando houver um movimento ligar a luz da divisão
    public void onMovimentSensor(int SNumber){
        long timestamp= System.currentTimeMillis();
        for (Sensor sm :sensors.values()){
            if(sm instanceof Moviment)
                if(sm.getSNumber()==SNumber){
                    ((Moviment)sm).setDetection(true);
                    ((Moviment)sm).setTime(timestamp);
                    if(onLight() == true){
                        for (Map.Entry<Integer, Light> l:lights.entrySet())
                            l.getValue().setStatus(true);   
                    }
                }
        } 
    }
    
    public boolean onMovimentSensorAlarm(){
        long timestamp= System.currentTimeMillis();
        for (Sensor sm :sensors.values()){
            if(sm instanceof Moviment)
                if(((Moviment)sm).isDetection()==true)
                    return true;                    
        }
        
        return false;
    }
    
    //Ligar as luzes da divisão quando a média da luz natural for menor do ke o valor minimo
    public boolean onLight(){
        if(mediaNaturaLight()<Dashboard.getHome().getValueNL())
            return true;
        else
            return false;            
    }
    
    //Desligar as luzes sem que haja movimento
    public void offMovimentSensor(){
        int i=0;
        long timestamp= System.currentTimeMillis();
        for (Sensor sm :sensors.values()){
            if(sm instanceof Moviment){
                if(((Moviment)sm).isDetection()==true){
                    long limit=((Moviment)sm).getTime()+Integer.parseInt(((Moviment)sm).getInterval()+"000");
                    if(timestamp>limit){
                        ((Moviment)sm).setDetection(false);
                        ((Moviment)sm).setTime(0);
                    }
                    i++;
                }
            }   
        }
        if(i==0)
                for (Map.Entry<Integer, Light> l:lights.entrySet())
                    l.getValue().setStatus(false);
    }
    
    //mudar a intensidade da luz
    public void changeLightIntensity(Light l, int value){
        float valor;
        for (Map.Entry<Integer, Light> li:lights.entrySet()){
            if(li.getValue().getIntensity()==l.getIntensity())
                li.getValue().setIntensity(value);
        }        
    }
    
    public void exceedTemperature(JLabel jl,JLabel jl2){        
        if(mediaTemperature()>climate.getMAXVALUE()){
            for(Window w:windows.values()){
                if(climate.isStatusAircon()==false)
                    if(w.isStatus()==false){
                        w.setStatus(true);
                    }
                
                if(climate.isStatusAircon()==true){
                    w.setStatus(false);
                    climate.setAircon(true);
                    jl.setText("Ligado");
                    jl2.setText("Desligado");   
                } 
            }
        }
    }
    
    public void lowerTemperature(JLabel jl,JLabel jl2){
         if(mediaTemperature()<climate.getMINVALUE()){
            lockWindows(jl,jl2);
         }
    }
    
    //Fechar as janelas
    public void lockWindows(JLabel jl,JLabel jl2){
        for (Window w:windows.values())
            if(w.isStatus()== true){
                w.setStatus(false);
                climate.setAircon(false);
                jl.setText("Desligado");
                climate.setHeating(true);
                jl2.setText("Ligado");
            }else{
                climate.setAircon(false);
                jl.setText("Desligado");
                climate.setHeating(true); 
                jl2.setText("Ligado");
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
    
    public void onComponentSegurança(JLabel lb, JLabel lb2){
        //home.onAlertMoviment();
        
        for(ExteriorEntranceDoor doo:listExteriorEntranceDoor())
            doo.activeSecurity();
        
        lockWindows(lb,lb2);
        lockDoors(); 
        for (Sensor snl :sensors.values())
            if(snl instanceof Temperature)
                snl.setStatus(false);
        
        for (Sensor snl:sensors.values())
            if(snl instanceof NaturaLight)
                ((NaturaLight)snl).setStatus(false);
        
         for (Sensor s:sensors.values())
            if(s instanceof Wind)
                s.setStatus(false);
        
        //home.alerTryOpenwindowsDoors();
    }
    
    public boolean verifyOnSensorGas(){
        for (Sensor s : sensors.values())
          if(s instanceof Gas)
                if(((Gas)s).isDetection()==true)
                    return true;
        
        return false;                
    }
    
    public boolean verifyOnSensorSmoke(){
        for (Sensor s : sensors.values())
           if(s instanceof Smoke)
            if(((Smoke)s).isDetection()==true)
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