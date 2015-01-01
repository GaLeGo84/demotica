package demotica;

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
public class Light implements Serializable{

    private int intensity;   
    private boolean status;

    public Light(){       
        this.intensity = 8; //é entre de 0 a 10
        this.status = false;        
    }

    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Light{intensity=" + intensity + ", status=" + status +'}';
    }
    
    
    
    

}
