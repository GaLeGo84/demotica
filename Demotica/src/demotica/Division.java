/**
 * Classe que identifica cada divisão da casa
 */
package demotica;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.table.DefaultTableModel;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */
public class Division implements Serializable{

    private int floor;
    private String name;
    private Climate climate;
    private Map<Integer,Light> lights;
    private Map<Integer,Sensor> sensors;
    private Map<Integer,Window> windows;
    private List<Door> doors;

    /**
     * 
     * @param name - identifica o nome da divisão
     * @param floor - identifica qual o andar dentro da casa
     * @param climate - identifica o sistema de climatização
     */
    public Division(String name, int floor, Climate climate){
        this.floor = floor;
        this.name = name;
        this.climate = climate;
        lights = new TreeMap<Integer,Light>();
        sensors = new TreeMap<Integer,Sensor>();
        windows = new TreeMap<Integer,Window>();
        doors = new LinkedList<Door>();
    }

    /**
     * 
     * @return o andar da divisão
     */
    public int getFloor() {
        return floor;
    }

    /**
     * 
     * @return os dados do sistema de climatização
     */
    public Climate getClimate() {
        return climate;
    }
    
    /**
     * 
     * @return o Map das Luzes 
     */
    public Map<Integer,Light> getLights() {
        return lights;
    }

    /**
     * 
     * @return o Map dos sensores 
     */
    public Map<Integer,Sensor> getSensors() {
        return sensors;
    }
    
    /**
     * 
     * @return o nome da divisão 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param floor substitui por outro andar 
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * 
     * @param name substitui o nome da divisão
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public Map<Integer,Window> getWindows() {
        return windows;
    }

    /**
     * 
     * @return uma lista de portas
     */
    public List<Door> getDoors() {
        return doors;
    }
    
    /**
     * Adiciona o sensor ao Map do Sensor
     * 
     * @param sen - identifica o sensor
     */
    public void addSensor(Sensor sen){
        int n=1;
        while(n<=sensors.size()){
            if(sensors.containsKey(n)==false){
                sensors.put(n, sen);
                break;
            }            
        n++;
        }
        
        if(sensors.size()<n)
            sensors.put(sensors.size()+1,sen);
    }
    
    /**
     * Adiciona as luzes ao Map da Luz
     * 
     * @param l - identifica as luzes
     */
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
    
    /**
     * Adiciona a Janela ao Map da Janela
     * 
     * @param w - identifica a janela
     */
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
    
    /**
     * Remove a Luz do Map da Luz
     * 
     * @param key - identifica a chave da Luz
     */
    public void remLight(int key){            
        lights.remove(key);
    }
    
    /**
     * Remove a Luz do Map da Janela
     * 
     * @param key - identifica a chave da Janela
     */
    public void remWindow(int key){          
        windows.remove(key);
    }
    
    /**
     * Remove a Luz da Lista da Porta
     * 
     * @param key - identifica o id da porta
     */
    public void remDoor(Door id){
         doors.remove(id);
    }
    
    /**
     * Remove a Luz do Map do Sensor
     * 
     * @param key - identifica a chave da Sensor
     */
    public void remSensor(int key){
        sensors.remove(key);
    }
    
    /**
     * Adiciona a Porta à Lista
     * 
     * @param dor identifica o objeto porta
     */
    public void addDoor(Door dor){   
        doors.add(dor); 
    }
    
    /**
     * 
     * @return o numero de sensores que tem o map dos sensores
     */
    public int nSensors(){
        return sensors.size();
    }
    
    /**
     * Lista de sensores de Temperatura
     * 
     * @param Obj identifica  objecto DefaultTableModel
     */
    public void listSensorTemperature(DefaultTableModel Obj){
       for(Map.Entry<Integer,Sensor> s:getSensors().entrySet())
           if(s.getValue() instanceof Temperature)
               Obj.addRow(new Object[]{s.getKey(),s.getValue().isStatus(),((Temperature)s.getValue()).getValue()});
   }
    
    /**
     * Lista de sensores de movimento
     * 
     * @param Obj identifica  objecto DefaultTableModel
     */
    public void listSensorMoviment(DefaultTableModel Obj){
       for(Map.Entry<Integer,Sensor> s:getSensors().entrySet())
           if(s.getValue() instanceof Moviment)
               Obj.addRow(new Object[]{s.getKey(),s.getValue().isStatus(),((Moviment)s.getValue()).getInterval(),((Moviment)s.getValue()).isDetection()});
   }
    
    /**
     * Lista de sensores de Luz Natural
     * 
     * @param Obj identifica  objecto DefaultTableModel
     */
    public void listSensorNaturaLight(DefaultTableModel Obj){
       for(Map.Entry<Integer,Sensor> s:getSensors().entrySet())
           if(s.getValue() instanceof NaturaLight)
               Obj.addRow(new Object[]{s.getKey(),s.getValue().isStatus(),((NaturaLight)s.getValue()).getValue()});
   }

    /**
     * Lista de Porta de Entrada
     * 
     * @return uma lista de Porta de Entrada
     */
    public LinkedList<ExteriorEntranceDoor> listExteriorEntranceDoor(){
       LinkedList<ExteriorEntranceDoor> aux=new LinkedList<>();
       for (Door doo:doors){
           if(doo instanceof ExteriorEntranceDoor)
                aux.add((ExteriorEntranceDoor)doo);
       }
       return aux;
   }
    
    /**
     * Lista de Portas Exteriores de Standard
     * 
     * @return uma lista de portas exteriores de Standard
     */
    public LinkedList<ExteriorDoorStandard> listExteriorStandardDoor(){
       LinkedList<ExteriorDoorStandard> aux=new LinkedList<>();
       for (Door doo:doors){
           if(doo instanceof ExteriorDoorStandard)
                aux.add((ExteriorDoorStandard)doo);
       }
       return aux;
   }
    
    /**
     * Lista de sensores de Vento
     * 
     * @param Obj identifica  objecto DefaultTableModel
     */
    public void listSensorWind(DefaultTableModel Obj){
       for(Map.Entry<Integer,Sensor> s:getSensors().entrySet())
           if(s.getValue() instanceof Wind)
               Obj.addRow(new Object[]{s.getKey(),s.getValue().isStatus(),((Wind)s.getValue()).getIntensity()});
   }
    
    /**
     * Lista de sensores de gas
     * 
     * @param Obj identifica  objecto DefaultTableModel
     */
    public void listSensorGas(DefaultTableModel Obj){
       for(Map.Entry<Integer,Sensor> s:getSensors().entrySet())
           if(s.getValue() instanceof Gas)
               Obj.addRow(new Object[]{s.getKey(),s.getValue().isStatus(),((Gas)s.getValue()).isDetection()});
   }
    
    /**
     * Lista de sensores de Smoke
     * 
     * @param Obj identifica  objecto DefaultTableModel
     */
    public void listSensorSmoke(DefaultTableModel Obj){
       for(Map.Entry<Integer,Sensor> s:getSensors().entrySet())
           if(s.getValue() instanceof Smoke)
               Obj.addRow(new Object[]{s.getKey(),s.getValue().isStatus(),((Smoke)s.getValue()).isDetection()});
   }
    
    /**
     * 
     * @return  total de portas
     */
    public int nDoors(){
        return getDoors().size();
    }
    
    /**
     * 
     * @return total de janela 
     */
    public int nWindows(){
        return getWindows().size();
    }
    
    /**
     * 
     * @return total de Luzes
     */
    public int nLights(){
        return getLights().size();
    }
    
    /**
     * 
     * @return total de Portas de entrada
     */
    public int nDoorsEntranceExterior(){
        return listExteriorEntranceDoor().size();
    }
    
    /**
     * 
     * @return total de portas Exteriores Standard
     */
    public int nDoorsExteriorStandard(){
        return listExteriorStandardDoor().size();
    }
    
    /**
     * 
     * @return total de sensores de movimento
     */
    public int nSensorMoviment(){
        int n=0;
        for(Sensor s:sensors.values())
            if(s instanceof Moviment)
                n++;
        
        return n;
    }
    
    /**
     * 
     * @return total de sensores de Luz Natural
     */
    public int nSensorNaturaLight(){
        int n=0;
        for(Sensor s:sensors.values())
            if(s instanceof NaturaLight)
                n++;
        
        return n;
    }
    
    /**
     * 
     * @return total de sensores de Temperatura
     */
    public int nSensorTemperature(){
        int n=0;
        for(Sensor s:sensors.values())
            if(s instanceof Temperature)
                n++;
        
        return n;
    }
    
    /**
     * 
     * @return total de sensores de Vento
     */
    public int nSensorWind(){
        int n=0;
        for(Sensor s:sensors.values())
            if(s instanceof Wind)
                n++;
        
        return n;
    }
    
    /**
     * 
     * @return total de sensores de Gás
     */
    public int nSensorGas(){
        int n=0;
        for(Sensor s:sensors.values())
            if(s instanceof Gas)
                n++;
        
        return n;
    }
    
    /**
     * 
     * @return total de sensores de Fumo
     */
    public int nSensorSmoke(){
        int n=0;
        for(Sensor s:sensors.values())
            if(s instanceof Smoke)
                n++;
        
        return n;
    }
    
    /**
     * 
     * @return média da luz natural da Divisão
     */
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
    
    /**
     * 
     * @return média da Temperatura da Divisão
     */
    public double mediaTemperature(){
        int soma=0, cont=0;
        double media=0;
        for (Sensor snl :sensors.values()){
            if(snl instanceof Temperature){
                soma+=((Temperature)snl).getValue();
                cont+=1;
            }
        }
         if(cont!=0)
           media=soma/cont;
        else
            media=0;
        
        return media;
    }   
    
    //Ativar o Sensor de movimento para quando houver um movimento ligar a luz da divisão
    public void onMovimentSensor(int SNumber){
        long timestamp= System.currentTimeMillis();
        for(Map.Entry<Integer,Sensor> s:getSensors().entrySet())
            if(s.getValue() instanceof Moviment)
                if(s.getKey()==SNumber){
                    ((Moviment)s.getValue()).setDetection(true);
                    ((Moviment)s.getValue()).setTime(timestamp);
                    if(onLight() == true){
                        for (Map.Entry<Integer, Light> l:lights.entrySet())
                            l.getValue().setStatus(true);   
                    }
                    for(Door d:doors)
                        if(d instanceof ExteriorDoor)
                            if(d.isStatus()==true){
                                d.setStatus(false);
                                d.setLock(false);
                            }
                }
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
        for (Map.Entry<Integer,Sensor> s :sensors.entrySet()){
            if(s.getValue() instanceof Moviment){
                if(((Moviment)s.getValue()).isDetection()==true){
                    long limit=((Moviment)s.getValue()).getTime()+Integer.parseInt(((Moviment)s.getValue()).getInterval()+"000");
                    if(timestamp>limit){
                        ((Moviment)s.getValue()).setDetection(false);
                        ((Moviment)s.getValue()).setTime(timestamp);
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
        for (Map.Entry<Integer, Light> li:lights.entrySet()){
            if(li.getValue().getIntensity()==l.getIntensity())
                li.getValue().setIntensity(value);
        }        
    }
    
    //Se não execer o maximo pretendido, se tiver todas as portas abertas fecham e liga o arcondicionado
    public void exceedTemperature(){        
        if(mediaTemperature()>climate.getMAXVALUE()){
            if(windows.size()==verifyAllWindows()){
                for(Map.Entry<Integer,Window> w:windows.entrySet()){        
                    w.getValue().setStatus(false);
                    w.getValue().setLock(false);
                    climate.setAircon(true);
                }
            }else if(climate.isStatus()==true){
                for(Map.Entry<Integer,Window> w:windows.entrySet()){    
                    w.getValue().setStatus(true);
                    w.getValue().setLock(false); 
                    climate.setAircon(false);
                }
            }
        }
    }
    
    public int verifyAllWindows(){
        int count=0;
        for(Map.Entry<Integer,Window> w:windows.entrySet()){
            if(w.getValue().isStatus()==true)
                count++;
        } 
        
        return count;
    }
    
    public void lowerTemperature(){
         if(mediaTemperature()<climate.getMINVALUE()){
            lockWithAirconWindows();
         }
    }
    
    //Fechar as janelas por causa do ar condicionado
    public void lockWithAirconWindows(){
        for (Window w:windows.values()){
            w.setStatus(false);
            climate.setAircon(false);
            climate.setHeating(true);
            w.setLock(true);
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
        for (Door doo:doors){
            doo.setStatus(false);
            doo.setLock(true);
        }
    }
    
    //Ferchar todas as Janelas
    public void lockWindows(){
        for (Window w:windows.values()){
            w.setStatus(false);
            w.setLock(true);
       }
    }
    
        //Fechar as portas
    public void lockDoorsExterior(){
            for(Door d:doors)
            if(d instanceof ExteriorDoor)
                if(d.isStatus()==true)
                    d.setStatus(false);
    }
    
    //Abrir as portas
    public void openDoors(){
        for (Door doo:doors)
            if(doo.isStatus()==false)
                doo.setStatus(true);
    }
    
    
    public void onComponentSegurança(){      
        for(ExteriorEntranceDoor doo:listExteriorEntranceDoor())
            doo.activeSecurity();
        
        lockWindows();
        lockDoors(); 
        for (Sensor snl :sensors.values())
            if(snl instanceof Temperature)
                snl.setStatus(false);
        
        for (Sensor snl:sensors.values())
            if(snl instanceof NaturaLight)
                snl.setStatus(false);
        
         for (Sensor s:sensors.values())
            if(s instanceof Wind)
                s.setStatus(false);

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
    
        public boolean onMovimentSensorAlarm(){
            for (Sensor sm :sensors.values()){
                if(sm instanceof Moviment)
                    if(((Moviment)sm).isDetection()==true)
                        return true;                    
            }

            return false;
        }

}