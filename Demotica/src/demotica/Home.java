/**
 * Classe que identifica a casa
 */
package demotica;

import static demotica.Dashboard.home;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */

public class Home implements Serializable{

    private static final long serialVersionUID = 5455238796031916510L;
    private int nFloors;
    private List<Alert> alerts;
    private Map<Integer,Division> divisions;
    private int valueNL;
    private int valueW;
    private Map<Integer,Contact> contacts;

    /**
     * 
     * @param nFloors - identifica o andar da casa. 0- r/c 1..-andar
     * @param valueNL - identifica o valor de luz natural que a casa precisa 
     * @param valueW  - identifica o valor da velocidade do vento que é premitida
     */
    public Home(int nFloors, int valueNL, int valueW) {
        this.nFloors = nFloors;
        this.alerts = new LinkedList<Alert>();
        this.divisions = new TreeMap<Integer,Division>();
        this.valueNL = valueNL;
        this.valueW = valueW;
        this.contacts = new TreeMap<Integer,Contact>();
    }

    /**
     * 
     * @return o valor do andar
     */
    public int getnFloors() {
        return nFloors;
    }

    /**
     * 
     * @return uma lista que alertas
     */
    public List<Alert> getAlerts() {
        return alerts;
    }

    /**
     * 
     * @return um Map de divisões
     */
    public Map<Integer,Division> getDivisions() {
        return divisions;
    }   

    /**
     * 
     * @return o valor de luz natural
     */
    public int getValueNL() {
        return valueNL;
    }

    /**
     * 
     * @return o valor da velocidade do vento
     */
    public int getValueW() {
        return valueW;
    }

    /**
     * 
     * @return um Map de Contactos
     */
    public Map<Integer, Contact> getContacts() {
        return contacts;
    }

    /**
     * 
     * @param name -Identifica o nome da divisão
     * @return o valor chave referido ao nome da divisão
     */
    public int getIntMap(String name){
        int n=0;
        for (Map.Entry<Integer, Division> entry : home.getDivisions().entrySet())
            if (entry.getValue().getName().equals(name))
                n= entry.getKey();
        
        return n;
    }    

    /**
     * 
     * @param nFloors substitui o valor dos andares da casa
     */
    public void setnFloors(int nFloors) {
        this.nFloors = nFloors;
    }
    
    /**
     * 
     * @param l - identifica o contacto
     */
    public void addContact(Contact l){
        int n=1;
        while(n<=contacts.size()){
            if(contacts.containsKey(n)==false){
                contacts.put(n,l);
                break;
            }            
        n++;
        }
        
        if(contacts.size()<n)
            contacts.put(getContacts().size()+1,l);
    }
    
    /**
     * Adiciona a divisão ao Map
     * 
     * @param div - identifica a divisão
     */
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
    
    /**
     * Remove uma divisão ao Map
     * 
     * @param n 
     */
    public void remDivision(int n){
        divisions.remove(n);
    }

    /**
     * Remove o Contacto
     * 
     * @param n - identifica à chave do Map
     */
    public void remContact(int n){
        contacts.remove(n);
    }
    
    /**
     * Substitiu o valor da Luz Natural
     * 
     * @param valueNL - identifica o valor da Luz Natural
     */
    public void setValueNL(int valueNL) {
        this.valueNL = valueNL;
    }

    /**
     * Substitui o valor da itensidade do vento
     * 
     * @param valueW - identifica o valor da itensidade do vento
     */
    public void setValueW(int valueW) {
        this.valueW = valueW;
    }

    /**
     * 
     * @return Lista de sensores de movimento
     */
    public LinkedList<IntruderAlert> listIntruderAlert(){
       LinkedList<IntruderAlert> aux=new LinkedList<>();
       for (Alert a:alerts){
           if(a instanceof IntruderAlert)
                aux.add((IntruderAlert)a);
       }
       return aux;
   }
    
    /**
     * 
     * @return Lista do Alerta Sonoro
     */
    public LinkedList<SoundAlert> listSoundAlert(){
       LinkedList<SoundAlert> aux=new LinkedList<>();
       for (Alert a:alerts){
           if(a instanceof SoundAlert)
                aux.add((SoundAlert)a);
       }
       return aux;
   }
    
    /**
     * Método que fecha todas as portas exteriores caso não aja nenhum movimento durante um determinado periúdo de tempo
     */
    public void MovimentDoorExterior(){        
        for(Division div:divisions.values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Moviment){                    
                    if(((Moviment)s).isDetection()==false){
                        if(nMoviment1()==nMoviment2() )                        
                            if(nDoorsExtern()!=0){
                                lockDoorsExterior();
                            }
                    }
                }
    }
    
    /**
     * 
     * @return a contagem dos sensores de movimento que não estão a detetar 
     */
    public int nMoviment1(){
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
    
    /**
     * 
     * @return a contagem de todos os Sensores de Movimento da divisão
     */
    public int nMoviment2(){
        int count=0;
        for(Division div:divisions.values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Moviment){
                    count+=1;
                }
        return count;
    }
    
    /**
     * 
     * @return numero de todas as portas exteriores
     */
    public int nDoorsExtern(){
        int count=0;
        for(Division div:divisions.values())
                for(Door d:div.getDoors())
                    if(d instanceof ExteriorDoor)
                        count++;

        return count;
    }
    
    /**
     * Tranca todas as portas exteriores
     */
    public void lockDoorsExterior(){
        for(Division div:divisions.values())
            for(Door d:div.getDoors())
            if(d instanceof ExteriorDoor)
                if(d.isStatus()==false){
                    d.setStatus(false);
                    d.setLock(true);
                }
    }

    /**
     * 
     * @return estado de saber se houve tentativa de abertura das janelas
     */
    public boolean tryOpenwindows(){
        for (Division div:divisions.values())
            for(Window w:div.getWindows().values())
                if(w.isStatus()==true) 
                    return true;
                
        return false;
    }
    
    /**
     * 
     * @return estado de saber se houve tentativa de abertura das portas
     */
    public boolean tryOpenDoors(){
        for (Division div:divisions.values())
            for(Door doo:div.getDoors())
                if(doo.isStatus()==true)
                    return true;
                
        return false;
    }
    
    /**
     * Tentativa de abrir a janela e a porta caso a componente de segurança estiver
     * ligada à porta de entrada
     */
    public void alerTryOpenwindowsDoors(){
        for (Division div:divisions.values())
            for(ExteriorEntranceDoor doo:div.listExteriorEntranceDoor())
                if(doo.getSecurity().isStatus()==true && ((tryOpenwindows()==true) || tryOpenDoors()==true)){
                    for(IntruderAlert lia:listIntruderAlert()){
                        lia.setDetection(true);                            
                    }       
                }
     }
    
    /**
     * Método que fecha todas as janelas, caso o valor da itensidade que for capturada é
     * maior do valor especifico
     */
    public void closeWindowsMoreIntensityWind(){
        for(Division div:divisions.values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Wind)
                    if(((Wind)s).getIntensity()>valueW)
                        closeWindows();
    }
    
    /**
     * Fecha todas as Janelas da divisão
     */
    public void closeWindows(){
        for(Division div:divisions.values())
            for(Map.Entry<Integer,Window> w:div.getWindows().entrySet())
                w.getValue().setStatus(false);
    }
    
}