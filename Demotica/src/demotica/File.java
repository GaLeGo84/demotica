package demotica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

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
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("home2.dat"));
            Home cAluno = (Home) ois.readObject();
            ois.close();
            return cAluno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public static void saveHome(Object home){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("home2.dat"));
            oos.writeObject(home);
            oos.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);      
        }
    }
    
    public static String[] loadRSensores() {
        int i = 0;
        String[] aux = new String[loadRSensores2()];
        try {
            BufferedReader in = new BufferedReader(new FileReader("RSensores.txt"));
            String linha = in.readLine();
            while (linha != null) {
                aux[i] = linha;
                i++;

                linha = in.readLine();
            }

            in.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro inexistente!");

        } catch (IOException ex) {
            System.out.println("Erro de leitura!");

        } finally {
            return aux;
        }
    }
    
    public static int loadRSensores2() {
        int i = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader("RSensores.txt"));
            String linha = in.readLine();
            while (linha != null) {
                i++;

                linha = in.readLine();
            }

            in.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ficheiro inexistente!");

        } catch (IOException ex) {
            System.out.println("Erro de leitura!");

        } finally {
            return i;
        }
    }

    public static void saveRSensores(String[] ag){
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("RSensores.txt",true));
            out.append(String.valueOf(ag[0]+" - "+ag[1]+";"));
            out.newLine();
            
            out.close();
        } catch (IOException ex) {
            System.out.println("Erro de escrita!");
        }
    }
}
