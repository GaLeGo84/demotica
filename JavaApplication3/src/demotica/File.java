package demotica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo Melo, Henrique Melo, Xico
 */
public class File{
    
    public static Home loadHome() {
       
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("home.dat"));
            Home cAluno = (Home) ois.readObject();
            ois.close();
            return cAluno;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public static void saveHome(Object home){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("home.dat"));
            oos.writeObject(home);
            oos.close();
        }
        catch(Exception e){
            //JOptionPane.showMessageDialog(null, e);      
        }
    }
}
