/**
 * Classe que interaje com o utilizador
 */
package demotica;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author Rodolfo Melo, Henrique Melo, Frrancisco Simas
 */
public class Dashboard implements Serializable{
 
    private static final long serialVersionUID = -6231719377239289088L;
    static Home home;    
    static File file;

    /**
     * 
     * @return o objeto Home
     */
    public static Home getHome() {
        return home;
    }
    
    /**
     * 
     * @param n - identifica o numero de vezes que vai criar uma janela
     */
    public static void countNumberWindows(int n){
        int nDivisions = home.getDivisions().size();
        int i=0;
        while(i<n){
            home.getDivisions().get(nDivisions).addWindow(new Window());
            i++;
        }
    }
    
     /**
     * 
     * @param n - identifica o numero de vezes que vai criar uma Lus
     */
    public static void countNumberLights(int n){
        int nDivisions = home.getDivisions().size();
        int i=0;
        while(i<n){
            home.getDivisions().get(nDivisions).addLight(new Light());
            i++;
        }
    }
    
    /**
     * Carrega os dados do Object Home
     */
    public static void loadData(){
        home = file.loadHome();
    }
    
    /**
     * Guarda os dados do Objeto Home e os seus subordinados
     */
    public static void saveData(){
        file.saveHome(home);
    }
    
    /**
     * Cria uma casa
     * 
     * @param nFloors - identifica no n de andares
     * @param valueNL - identifica o valor da Luz Natural
     * @param valueW - identifica o valor da itensidade do vento
     */
    public static void criarHome(int nFloors, int valueNL, int valueW){
        home = new Home(nFloors, valueNL, valueW);
    }
    
    /**
     * Verifica se existe uma porta de entrada
     * 
     * @param b - identifica um botão
     * @param j - identifica uma Label
     */
    public static void verifyIfExteriorEntranceDoor(JButton b, JLabel j){
        for(Division div:home.getDivisions().values())
            if(div.listExteriorEntranceDoor().size()!=0){
                b.setEnabled(true);
                j.setVisible(true);
            }
    }
    
    /**
     * Ativa os sensores de movimento
     * 
     * @return o estado da deteção do sensor do movimento 
     */
    public static boolean ativeSensorMoviment(){
        boolean detected=false;
        for(Division div:home.getDivisions().values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Moviment)
                    if(((Moviment)s).isDetection()==true)
                        detected=true;
        
        return detected;
    }
    
    /**
     * Método que verifica se alguém forçou abrir ou abriu as portas exteriores
     * 
     * @return o estado da porta exterior
     */
    public static boolean movimentExteriorDoorOnHome(){
        boolean status=false;
        for(Division div:home.getDivisions().values())
            for(Door d:div.getDoors())
                if(d instanceof ExteriorDoor)
                    if(((ExteriorDoor)d).isStatus()==true && (((ExteriorDoor)d).isLock()==false || ((ExteriorDoor)d).isLock()==false))
                        status=true;
        
        return status;
    }
    
    /**
     * Método que verifica se alguém forçou abrir ou abriu as janelas
     * 
     * @return o estado da Janela
     */
    public static boolean movimentWindowsOnHome(){
        boolean status=false;
        for(Division div:home.getDivisions().values())
            for(Window w:div.getWindows().values())
                    if(w.isStatus()==true || w.isLock()==false)
                        status=true;
        
        return status;
    }
    
    /**
     * Verifica se a componente de segurança está ligado
     * 
     * @return o estado da componente de segurança
     */
    public static boolean verifySecurity(){
        boolean status=false;
        for(Division div:home.getDivisions().values())
            for(Door d:div.getDoors())
                if(d instanceof ExteriorEntranceDoor)
                    status=((ExteriorEntranceDoor)d).getSecurity().isStatus();
        
        return status;
    }
    
    /**
     * Método que aciona o Alarme e Fecha as Portas exteriores e as Janelas
     */
    public static void acionarAlarmeAndCloseDoorsWindows(){
        if(verifySecurity()==true)
            if(ativeSensorMoviment()==true || movimentExteriorDoorOnHome()==true || movimentWindowsOnHome()==true){         
                sendEmailPolice();
                JOptionPane.showMessageDialog(null, "Entrada de Intruso");
            }
    }
    
    /**
     * Método que envia um Email à policia
     */
    public static void sendEmailPolice(){
        for(Map.Entry<Integer,Contact> c:Dashboard.getHome().getContacts().entrySet())
            if(c.getValue().getType()==0){
                try{
                    Email.sendMail("Hello Email", "Test", c.getValue().getEmail());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }    
    }
    
    /**
     * Método que envia um Email aos Bombeiros
     */
    public static void sendEmailBombeiros(){
        for(Map.Entry<Integer,Contact> c:Dashboard.getHome().getContacts().entrySet())
            if(c.getValue().getType()==1){
                try{
                    Email.sendMail("Hello Email", "Test", c.getValue().getEmail());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }    
    }
    
    /**
     * Método que verifica se o estado da deteção de gas ligou
     * 
     * @return o estado da deteção de gas
     */
    public static boolean existOnSensorGas(){
        boolean status=false;
        for (Division div:home.getDivisions().values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Gas)
                    if(((Gas)s).isDetection()==true)
                        status=true;
        
        return status;
    }
    
    /**
     * Método que verifica se o estado da deteção de fumo ligou
     * 
     * @return o estado da deteção de fumo
     */
    public static boolean existOnSensorSmoke(){
        boolean status=false;
        for (Division div:home.getDivisions().values())
            for(Sensor s:div.getSensors().values())
                if(s instanceof Smoke)
                    if(((Smoke)s).isDetection()==true)
                        status=true;
        
        return status;
    }
    
    /**
     * Método que aciona o Alarme sonoro quando é detetado uma fuga de gas ou de incêndio
     */
    public static void acionarAlarmeGasSmoke(){
            if(existOnSensorGas()==true || existOnSensorSmoke()==true){
                Dashboard.sendEmailBombeiros();
                JOptionPane.showMessageDialog(null, "Alerta Sonoro");
            }
    }
    
    /**
     * Método que pôes todas as portas interiores numa JComboBox
     * 
     * @param j - identifica uma ComboBox
     */
    public static void allDoors(JComboBox j){
        for (Division div:home.getDivisions().values())
            for(Door d:div.getDoors())
                if(d instanceof InteriorDoor)
                    j.addItem(d.getId());
        
    }
    
    /**
     * Exceção caso o TextField não for do tipo inteiro
     * 
     * @param str - Identifica uma TextField
     */
    public static void toInteger(JTextField str){
        try{
            Integer.parseInt(str.getText());
        }catch(NumberFormatException a){
            JOptionPane.showMessageDialog(null, "O campo tem de ser do tipo numérico");
            str.setText("");
        }
        
    }
    
    /**
     * Método que regista os dados do sensor de movimento no ficheiro txt 
     * 
     * @param div -identifica a divisão
     * @param n - identifica o key da divisão
     * @param modelo1 - identifica DefaultTableModel
     * @param jTable3 - identifica JTable
     */
    public static void registoSensorMoviment(int div,int n,DefaultTableModel modelo1,JTable jTable3){
        Date date = new Date(); 
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String[] a=new String[2];
        a[0] = formato.format(date);
        a[1] = ((Moviment)home.getDivisions().get(div).getSensors().get(n)).toString();
        File.saveRSensores(a);
    }
    
    /**
     * Método que regista os dados do sensor de Luz Natural no ficheiro txt 
     * 
     * @param div -identifica a divisão
     * @param n - identifica o key da divisão
     * @param modelo1 - identifica DefaultTableModel
     * @param jTable3 - identifica JTable
     */
    public static void registoSensorNaturaLight(int div,int n,DefaultTableModel modelo1,JTable jTable3){
        Date date = new Date(); 
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String[] a=new String[2];
        a[0] = formato.format(date);
        a[1] = ((NaturaLight)home.getDivisions().get(div).getSensors().get(n)).toString();
        File.saveRSensores(a);
    }
    
    /**
     * Método que regista os dados do sensor de Temperatura no ficheiro txt 
     * 
     * @param div -identifica a divisão
     * @param n - identifica o key da divisão
     * @param modelo1 - identifica DefaultTableModel
     * @param jTable3 - identifica JTable
     */
    public static void registoSensorTemperature(int div,int n,DefaultTableModel modelo1,JTable jTable3){
        Date date = new Date(); 
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String[] a=new String[2];
        a[0] = formato.format(date);
        a[1] = ((Temperature)home.getDivisions().get(div).getSensors().get(n)).toString();
        File.saveRSensores(a);
    }
    
    /**
     * Método que regista os dados do sensor de Vento no ficheiro txt 
     * 
     * @param div -identifica a divisão
     * @param n - identifica o key da divisão
     * @param modelo1 - identifica DefaultTableModel
     * @param jTable3 - identifica JTable
     */
    public static void registoSensorWind(int div,int n,DefaultTableModel modelo1,JTable jTable3){
        Date date = new Date(); 
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String[] a=new String[2];
        a[0] = formato.format(date);
        a[1] = ((Wind)home.getDivisions().get(div).getSensors().get(n)).toString();
        File.saveRSensores(a);
    }
    
    /**
     * Método que regista os dados do sensor de Gas no ficheiro txt 
     * 
     * @param div -identifica a divisão
     * @param n - identifica o key da divisão
     * @param modelo1 - identifica DefaultTableModel
     * @param jTable3 - identifica JTable
     */
    public static void registoSensorGas(int div,int n,DefaultTableModel modelo1,JTable jTable3){
        Date date = new Date(); 
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String[] a=new String[2];
        a[0] = formato.format(date);
        a[1] = ((Gas)home.getDivisions().get(div).getSensors().get(n)).toString();
        File.saveRSensores(a);
    }
    
    /**
     * Método que regista os dados do sensor de Fumo no ficheiro txt 
     * 
     * @param div -identifica a divisão
     * @param n - identifica o key da divisão
     * @param modelo1 - identifica DefaultTableModel
     * @param jTable3 - identifica JTable
     */
    public static void registoSensorSmoke(int div,int n,DefaultTableModel modelo1,JTable jTable3){
        Date date = new Date(); 
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        String[] a=new String[2];
        a[0] = formato.format(date);
        a[1] = ((Smoke)home.getDivisions().get(div).getSensors().get(n)).toString();
        File.saveRSensores(a);
    }
    
    /**
     * Carrrega os registos dos sensores que estão num ficheiro txt
     * 
     * @param a - Identifica a TextArea 
     */
    public static void loadRegisterSensor(JTextArea a){
        a.setText(null);
        String[] loads= File.loadRSensores(); 
        for(String l:loads){
            a.append(l.toString());
            a.append("\n");
        }
    }
    
}